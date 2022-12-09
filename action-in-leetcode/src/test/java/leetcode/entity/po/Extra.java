package leetcode.entity.po;

import lombok.Data;

import java.util.List;

@Data
public class Extra {
    private int companyTagNum;
    private boolean hasVideoSolution;
    private List<TopCompanyTags> topCompanyTags;
    private String __typename;
}