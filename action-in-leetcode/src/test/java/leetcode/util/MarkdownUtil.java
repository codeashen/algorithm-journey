package leetcode.util;

import leetcode.Generator;
import leetcode.entity.po.Question;
import leetcode.entity.po.TopicTags;
import leetcode.enums.DifficultyEnum;
import leetcode.enums.MarkStatusEnum;

import java.io.*;
import java.util.List;
import java.util.TreeMap;

public class MarkdownUtil {

    private static final String ROW_PATTERN = "| %s | %s | %s | %s | %s | %s |";
    private static final String LINK_PATTERN = "[%s<br>%s](https://leetcode-cn.com/problems/%s/)";
    private static final String PACKAGE_PATTERN = "[Java](src/main/java/NO_%04d_%s/)";

    /**
     * 将题目插入到 README 目录中
     */
    public static void insertLine(List<Question> questions) throws IOException {
        if (questions == null || questions.size() == 0) {
            return;
        }
        String path = Generator.class.getResource("/").getPath();
        String filePath = path.substring(0, path.indexOf("target")) + "README.md";
        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
            if (line.contains("---")) {
                break;
            }
        }
        TreeMap<Integer, String> map = new TreeMap<>();
        while ((line = reader.readLine()) != null && line.contains("| ")) {
            int questionId = StringUtil.getInt(line);
            if (questionId > 0) {
                map.put(questionId, line);
            }
        }
        for (Question item : questions) {
            map.put(Integer.valueOf(StringUtil.getNotNull(item.getFrontendQuestionId(), item.getQuestionFrontendId())), getRow(item));
            System.out.format("这是你的第 %d 题，继续加油\n", map.size());
        }
        map.forEach((k, v) -> sb.append(v).append("\n"));

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(sb.toString());
        fileWriter.close();
        System.out.println("README 插入行成功");
    }

    /**
     * 获取题目对应的 README 表格行
     */
    private static String getRow(Question question) {
        String questionFrontendId = question.getFrontendQuestionId() != null ? question.getFrontendQuestionId() : question.getQuestionFrontendId();
        String title = question.getTitle();
        String translatedTitle = question.getTitleCn() != null ? question.getTitleCn() : question.getTranslatedTitle();
        String difficulty = question.getDifficulty();
        List<TopicTags> topicTags = question.getTopicTags();
        return String.format(ROW_PATTERN,
                questionFrontendId,
                String.format(LINK_PATTERN, title, translatedTitle, question.getTitleSlug()),
                DifficultyEnum.markdown(difficulty),
                String.format(PACKAGE_PATTERN, Integer.valueOf(questionFrontendId), title.replaceAll(" ", "_")),
                MarkStatusEnum.INIT.mark(),
                topicTags.stream().map(TopicTags::getNameTranslated).reduce((o1, o2) -> o1 + ", " + o2).orElse("")
        );
    }

    /**
     * 将题目状态标记为完成
     */
    public static void mark(MarkStatusEnum markStatusEnum, List<Integer> ids) throws IOException {
        if (ids == null || ids.size() == 0) {
            return;
        }
        
        String path = Generator.class.getResource("/").getPath();
        String filePath = path.substring(0, path.indexOf("target")) + "README.md";
        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (line.contains("| ")) {
                int questionId = StringUtil.getInt(line);
                if (ids.contains(questionId)) {
                    for (String otherMark : MarkStatusEnum.othersMark(markStatusEnum)) {
                        line = line.replace(otherMark, markStatusEnum.mark());
                    }
                }
            }
            sb.append(line).append("\n");
        }

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(sb.toString());
        fileWriter.close();
        System.out.println("更新状态成功");
    }
}
