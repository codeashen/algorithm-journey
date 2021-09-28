package leetcode;

import leetcode.entity.po.Question;
import leetcode.enums.MarkStatusEnum;
import leetcode.util.CodeUtil;
import leetcode.util.MarkdownUtil;
import leetcode.util.QuestionUtil;
import org.apache.http.HttpException;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Generator {

    @Test
    public void generate() throws IOException, HttpException {
        List<Integer> ids = Arrays.asList(149);
        List<Question> questions = QuestionUtil.questionList(ids);
        CodeUtil.generate(questions);
        MarkdownUtil.insertLine(questions);
        // MarkdownUtil.mark(MarkStatusEnum.PASS, ids);
    }

    @Test
    public void mark() throws IOException {
        List<Integer> ids = Arrays.asList(80);
        MarkdownUtil.mark(MarkStatusEnum.PASS, ids);
    }
}
