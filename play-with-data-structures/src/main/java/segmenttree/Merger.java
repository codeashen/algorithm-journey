package segmenttree;

/**
 * 融合器
 *
 * @param <E>
 */
public interface Merger<E> {

    /**
     * 综合 a 和 b，返回结果值
     *
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}
