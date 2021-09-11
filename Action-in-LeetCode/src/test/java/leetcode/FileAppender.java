package leetcode;

import leetcode.util.MarkdownUtil;
import org.apache.http.HttpException;

import java.io.IOException;

public class FileAppender {
    public static void main(String[] args) throws IOException, HttpException {
        MarkdownUtil.insertLine(1);
        MarkdownUtil.insertLine(111);
        MarkdownUtil.insertLine(120);
        MarkdownUtil.insertLine(1221);
        MarkdownUtil.insertLine(1894);
    }
}
