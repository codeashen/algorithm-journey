package common.util;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ArrayUtil {

    public static int[] arrayFromFile(String jsonFile) throws IOException {
        InputStream ins = ArrayUtil.class.getClassLoader().getResourceAsStream("data.json");
        InputStreamReader reader = new InputStreamReader(ins);
        int c = -1;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        List<Integer> list = JSONObject.parseArray(sb.toString(), Integer.class);
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
