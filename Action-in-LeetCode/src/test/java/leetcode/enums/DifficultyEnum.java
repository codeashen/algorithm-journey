package leetcode.enums;

public enum DifficultyEnum {
    EASY("EASY", "<span style=\"padding: 0 7px;margin: 0 7px;border: 1px solid #d9d9d9;border-radius: 2px;color: #389e0d;background: #f6ffed;border-color: #b7eb8f;\">简单</span>"),
    MEDIUM("MEDIUM", "<span style=\"padding: 0 7px;margin: 0 7px;border: 1px solid #d9d9d9;border-radius: 2px;color: #d46b08;background: #fff7e6;border-color: #ffd591;\">中等</span>"),
    HARD("HARD", "<span style=\"padding: 0 7px;margin: 0 7px;border: 1px solid #d9d9d9;border-radius: 2px;color: #cf1322;background: #fff1f0;border-color: #ffa39e;\">困难</span>");

    private String name;
    private String markdown;

    DifficultyEnum(String name, String markdown) {
        this.name = name;
        this.markdown = markdown;
    }

    public static String markdown(String name) {
        DifficultyEnum difficultyEnum = DifficultyEnum.valueOf(name.toUpperCase());
        return difficultyEnum.markdown;
    }
}
