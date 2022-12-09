package leetcode.util;

import leetcode.entity.po.Question;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class CodeUtil {

    private static final String TEMPLATE_FILE = "SolutionTemplate.txt";
    private static final String SOURCE_PATH = "src/main/java/";
    private static final String SOLUTION_NAME = "/Solution.java";
    private static final String PACKAGE_PATTERN = "NO_%04d_%s";
    private static final String TITLE_PATTERN = "%04d. %s";
    private static final String LINK_PATTERN = "https://leetcode-cn.com/problems/%s/";

    public static void generate(List<Question> questions) {
        for (Question question : questions) {
            // 获取题目信息
            String questionFrontendId = question.getFrontendQuestionId() != null ? question.getFrontendQuestionId() : question.getQuestionFrontendId();
            String title = question.getTitle();
            String translatedTitle = question.getTitleCn() != null ? question.getTitleCn() : question.getTranslatedTitle();
            String packageName = String.format(PACKAGE_PATTERN, Integer.valueOf(questionFrontendId), title.replaceAll("[ |-]", "_"));
            System.out.println("开始处理题目: " + questionFrontendId);

            // 获取模板路径和将要生成的包路径
            String templatePath = CodeUtil.class.getClassLoader().getResource(TEMPLATE_FILE).getPath();
            String basePath = templatePath.substring(0, templatePath.indexOf("target"));

            // 创建包
            File pack = new File(basePath + SOURCE_PATH + packageName);
            if (pack.exists()) {
                System.err.println("包已经存在");
                continue;
            } else if (pack.mkdir()) {
                System.out.println("创建包成功");
            } else {
                System.err.println("创建包失败");
                continue;
            }

            // 创建 Java 文件
            try (InputStream ins = new FileInputStream(templatePath);
                 FileWriter fileWriter = new FileWriter(basePath + SOURCE_PATH + packageName + SOLUTION_NAME)) {
                // 读取模板内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
                String template = reader.lines().reduce((s1, s2) -> s1 + "\r\n" + s2).orElse("");
                // 组装模板
                HashMap<String, String> context = new HashMap<>();
                context.put("package", packageName);
                context.put("questionTitle", String.format(TITLE_PATTERN, Integer.valueOf(questionFrontendId), translatedTitle));
                context.put("questionLink", String.format(LINK_PATTERN, question.getTitleSlug()));
                String javaContent = TemplateUtil.render(template, context);
                // 写出组装后的内容
                fileWriter.write(javaContent);
                System.out.println("创建 Java 文件成功");
            } catch (IOException e) {
                System.err.println("创建 Java 文件失败: " + questionFrontendId);
                e.printStackTrace();
            }
        }
    }

}
