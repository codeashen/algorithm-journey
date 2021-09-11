package leetcode.entity.request;

import lombok.Data;

import java.util.Map;

@Data
public class LeetCodeRequest {
    private String operationName;
    private Map<String, String> variables;
    private String query;
}
