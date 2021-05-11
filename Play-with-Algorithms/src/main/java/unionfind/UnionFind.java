package unionfind;

/**
 * 并查集接口
 */
public interface UnionFind {

    int size();

    /**
     * p,q 索引对应的两个元素是否相连
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 将 p,q 索引对应的两个元素并在一起
     *
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}
