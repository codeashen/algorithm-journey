package leetcode;

import leetcode.entity.po.Question;
import leetcode.enums.MarkStatusEnum;
import leetcode.util.CodeUtil;
import leetcode.util.MarkdownUtil;
import leetcode.util.QuestionUtil;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.List;

public class Generator {
    public static void main(String[] args) throws IOException, HttpException {
        List<Question> questions = QuestionUtil.questionList(2, 111, 120, 1221, 1894);
        CodeUtil.generate(questions);
        MarkdownUtil.insertLine(questions);

        MarkdownUtil.mark(MarkStatusEnum.PASS, 2, 111, 120, 1221, 1894);
    }
}
