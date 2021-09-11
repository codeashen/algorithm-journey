package leetcode.util;

import com.alibaba.fastjson.TypeReference;
import leetcode.entity.common.DataResult;
import leetcode.entity.po.ProblemsetQuestionList;
import leetcode.entity.po.Question;
import leetcode.entity.po.QuestionSearch;
import leetcode.entity.response.ProblemsetQuestionData;
import leetcode.entity.response.QuestionData;
import org.apache.http.HttpException;

import java.io.IOException;

public class QuestionUtil {

    public static Question queryByTitleSlug(String titleSlug) throws HttpException, IOException {
        final String query = "{\n" +
                "  \"operationName\":\"questionData\",\n" +
                "  \"variables\":{\n" +
                "    \"titleSlug\":\"" + titleSlug + "\"\n" +
                "  },\n" +
                "  \"query\":\"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    categoryTitle\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n    __typename\\n  }\\n}\\n\"\n" +
                "}";

        QuestionData data = HttpUtil.post(query, new TypeReference<DataResult<QuestionData>>() {
        });
        return data.getQuestion();
    }

    public static QuestionSearch searchQuestion(Integer id) throws HttpException, IOException {
        final String query = "{\n" +
                "    \"query\": \"\\n    query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {\\n  problemsetQuestionList(\\n    categorySlug: $categorySlug\\n    limit: $limit\\n    skip: $skip\\n    filters: $filters\\n  ) {\\n    hasMore\\n    total\\n    questions {\\n      acRate\\n      difficulty\\n      freqBar\\n      frontendQuestionId\\n      isFavor\\n      paidOnly\\n      solutionNum\\n      status\\n      title\\n      titleCn\\n      titleSlug\\n      topicTags {\\n        name\\n        nameTranslated\\n        id\\n        slug\\n      }\\n      extra {\\n        hasVideoSolution\\n        topCompanyTags {\\n          imgUrl\\n          slug\\n          numSubscribed\\n        }\\n      }\\n    }\\n  }\\n}\\n    \",\n" +
                "    \"variables\": {\n" +
                "        \"categorySlug\": \"\",\n" +
                "        \"skip\": 0,\n" +
                "        \"limit\": 50,\n" +
                "        \"filters\": {\n" +
                "            \"searchKeywords\": \"" + id + "\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"operationName\": \"problemsetQuestionList\"\n" +
                "}";
        ProblemsetQuestionData data = HttpUtil.post(query, new TypeReference<DataResult<ProblemsetQuestionData>>() {
        });
        ProblemsetQuestionList questionList = data.getProblemsetQuestionList();
        QuestionSearch question = questionList.getQuestions().stream().filter(e -> e.getFrontendQuestionId().equals(id.toString())).findFirst().orElse(null);
        if (question == null) {
            throw new RuntimeException("未找到指定 id 的题目");
        }
        return question;
    }
}
