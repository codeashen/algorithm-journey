package leetcode.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import leetcode.entity.common.DataResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {

    public static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    public static <T> T post(String query, TypeReference<DataResult<T>> typeReference) throws IOException, HttpException {
        //1、创建 CloseableHttpClient 同步请求对象
        // CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 2、HttpPost(final String uri)：创建 http post 请求对象, 设置请求头信息
        String url = "https://leetcode-cn.com/graphql/";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 3、设置 post 请求正文参数
        httpPost.setEntity(new StringEntity(query, "UTF-8"));

        // 4、CloseableHttpResponse execute(final HttpUriRequest request)：执行请求
        // 如果连接不上服务器，则抛出:java.net.ConnectException: Connection refused: connect
        HttpResponse httpResponse = httpClient.execute(httpPost);

        // 5、获取响应结果, 状态码 200 表示请求成功
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new HttpException("请求失败");
        }

        HttpEntity httpEntity = httpResponse.getEntity();
        // 使用指定的字符编码解析响应消息实体
        String json = EntityUtils.toString(httpEntity, "UTF-8");
        DataResult<T> response = JSONObject.parseObject(json, typeReference);
        return response.getData();
    }
}
