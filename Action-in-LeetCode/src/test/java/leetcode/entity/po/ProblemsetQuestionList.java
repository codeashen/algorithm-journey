package leetcode.entity.po;

import lombok.Data;

import java.util.List;

@Data
public class ProblemsetQuestionList {
    private String __typename;
    private List<Question> questions;
    private boolean hasMore;
    private int total;
}