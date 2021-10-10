package NO_0341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class NestedIterator implements Iterator<Integer> {

    private LinkedList<Integer> data;

    public NestedIterator(List<NestedInteger> nestedList) {
        data = new LinkedList<>();
        this.dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                data.add(item.getInteger());
            } else {
                dfs(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return data.pop();
    }

    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }
}
