package leetcode.enums;

import java.util.ArrayList;
import java.util.List;

public enum MarkStatusEnum {
    INIT("INIT", "—"),
    PASS("PASS", "√"),
    NOT_PASS("NOT_PASS", "×");

    private String name;
    private String mark;

    MarkStatusEnum(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    public String mark() {
        return mark;
    }

    public static List<String> othersMark(MarkStatusEnum value) {
        List<String> res = new ArrayList<>();
        for (MarkStatusEnum item : MarkStatusEnum.values()) {
            if (!item.equals(value)) {
                res.add(item.mark);
            }
        }
        return res;
    }
}
