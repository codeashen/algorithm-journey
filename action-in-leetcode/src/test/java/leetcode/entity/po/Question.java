package leetcode.entity.po;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private String questionId;
    private String questionFrontendId;
    private String categoryTitle;
    private int boundTopicId;
    private String title;
    private String titleSlug;
    private String content;
    private String translatedTitle;
    private String translatedContent;
    private boolean isPaidOnly;
    private String difficulty;
    private int likes;
    private int dislikes;
    private String isLiked;
    private String similarQuestions;
    private List<String> contributors;
    private String langToValidPlayground;
    private List<TopicTags> topicTags;
    private String companyTagStats;
    private List<CodeSnippets> codeSnippets;
    private String stats;
    private List<String> hints;
    private String solution;
    private String status;
    private String sampleTestCase;
    private String metaData;
    private boolean judgerAvailable;
    private String judgeType;
    private List<String> mysqlSchemas;
    private boolean enableRunCode;
    private String envInfo;
    private String book;
    private boolean isSubscribed;
    private boolean isDailyQuestion;
    private String dailyRecordStatus;
    private String editorType;
    private String ugcQuestionId;
    private String style;
    private String exampleTestcases;
    private String __typename;

    private double acRate;
    private int freqBar;
    private boolean paidOnly;
    private String frontendQuestionId;
    private boolean isFavor;
    private int solutionNum;
    private String titleCn;
    private Extra extra;
}