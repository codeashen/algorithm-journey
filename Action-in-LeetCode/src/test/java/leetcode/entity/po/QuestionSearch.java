package leetcode.entity.po;

import lombok.Data;

import java.util.List;

@Data
public class QuestionSearch {
    private String __typename;
    private double acRate;
    private String difficulty;
    private int freqBar;
    private boolean paidOnly;
    private String status;
    private String frontendQuestionId;
    private boolean isFavor;
    private int solutionNum;
    private String title;
    private String titleCn;
    private String titleSlug;
    private List<TopicTags> topicTags;
    private Extra extra;
}