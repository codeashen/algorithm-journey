package leetcode.util;

import javafx.util.Pair;
import leetcode.FileAppender;
import leetcode.entity.po.Question;
import leetcode.entity.po.QuestionSearch;
import leetcode.entity.po.TopicTags;
import leetcode.enums.DifficultyEnum;
import org.apache.http.HttpException;

import java.io.*;
import java.util.List;
import java.util.TreeMap;

public class MarkdownUtil {

    public static String difficultyTag(String difficulty) {
        return DifficultyEnum.markdown(difficulty);
    }

    public static String questionLink(String title, String translatedTitle, String titleSlug) {
        String pattern = "[%s<br>%s](https://leetcode-cn.com/problems/%s/)";
        return String.format(pattern, title, translatedTitle, titleSlug);
    }

    public static String codePath(String questionFrontendId, String title) {
        String pattern = "[Java](src/main/java/%s/)";
        String packageName = "NO_" + String.format("%04d", Integer.valueOf(questionFrontendId)) + "_" + title.replaceAll(" ", "_");
        return String.format(pattern, packageName);
    }

    public static Pair<Integer, String> lineOfId(Integer id) throws IOException, HttpException {
        QuestionSearch question = QuestionUtil.searchQuestion(id);
        String questionFrontendId = question.getFrontendQuestionId();
        String title = question.getTitle();
        String translatedTitle = question.getTitleCn();
        String difficulty = question.getDifficulty();
        List<TopicTags> topicTags = question.getTopicTags();
        String rowPattern = "| %s | %s | %s | %s | %s | %s |";
        String rowData = String.format(rowPattern,
                questionFrontendId,
                MarkdownUtil.questionLink(title, translatedTitle, question.getTitleSlug()),
                MarkdownUtil.difficultyTag(difficulty),
                MarkdownUtil.codePath(questionFrontendId, title),
                "",
                topicTags.stream().map(TopicTags::getNameTranslated).reduce((o1, o2) -> o1 + ", " + o2).orElse("")
        );
        return new Pair<>(Integer.valueOf(questionFrontendId), rowData);
    }

    public static Pair<Integer, String> lineOfTitleSlug(String titleSlug) throws IOException, HttpException {
        Question question = QuestionUtil.queryByTitleSlug(titleSlug);
        String questionFrontendId = question.getQuestionFrontendId();
        String title = question.getTitle();
        String translatedTitle = question.getTranslatedTitle();
        String difficulty = question.getDifficulty();
        List<TopicTags> topicTags = question.getTopicTags();
        String rowPattern = "| %s | %s | %s | %s | %s | %s |";
        String rowData = String.format(rowPattern,
                questionFrontendId,
                MarkdownUtil.questionLink(title, translatedTitle, titleSlug),
                MarkdownUtil.difficultyTag(difficulty),
                MarkdownUtil.codePath(questionFrontendId, title),
                "",
                topicTags.stream().map(TopicTags::getTranslatedName).reduce((o1, o2) -> o1 + ", " + o2).orElse("")
        );
        return new Pair<>(Integer.valueOf(questionFrontendId), rowData);
    }

    public static void insertLine(String titleSlug) throws IOException, HttpException {
        StringBuilder sb = new StringBuilder();

        String path = FileAppender.class.getResource("/").getPath();
        String filePath = path.substring(0, path.indexOf("target")) + "README.md";
        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
            if (line.contains("---")) {
                break;
            }
        }

        TreeMap<Integer, String> map = new TreeMap<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains("| ")) {
                int questionId = 0;
                for (int i = 0; i < 10; i++) {
                    char c = line.charAt(i);
                    if (c >= '0' && c <= '9') {
                        questionId = questionId * 10 + (c - '0');
                    }
                }
                if (questionId > 0) {
                    map.put(questionId, line);
                }
            }
        }

        Pair<Integer, String> pair = MarkdownUtil.lineOfTitleSlug(titleSlug);
        map.put(pair.getKey(), pair.getValue());

        map.forEach((k, v) -> sb.append(v).append("\n"));

        String content = sb.toString();

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(content);
        fileWriter.close();
    }

    public static void insertLine(Integer id) throws IOException, HttpException {
        StringBuilder sb = new StringBuilder();

        String path = FileAppender.class.getResource("/").getPath();
        String filePath = path.substring(0, path.indexOf("target")) + "README.md";
        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
            if (line.contains("---")) {
                break;
            }
        }

        TreeMap<Integer, String> map = new TreeMap<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains("| ")) {
                int questionId = 0;
                for (int i = 0; i < 10; i++) {
                    char c = line.charAt(i);
                    if (c >= '0' && c <= '9') {
                        questionId = questionId * 10 + (c - '0');
                    }
                }
                if (questionId > 0) {
                    map.put(questionId, line);
                }
            }
        }

        Pair<Integer, String> pair = MarkdownUtil.lineOfId(id);
        map.put(pair.getKey(), pair.getValue());

        map.forEach((k, v) -> sb.append(v).append("\n"));

        String content = sb.toString();

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(content);
        fileWriter.close();
    }

}
