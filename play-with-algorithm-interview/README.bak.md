# 玩转算法面试

| 章节 | 代码 | 备注 |
| :--- | :--- | :--- |
| **一、复杂度分析** |  | |
| 1-1 什么是大 O | [无代码] |  |
| 1-2 数据规模测试 | [Java源码](src/main/java/time_complexity/Basic.java) | 统计每个数量级数据规模的处理速度 |
| 1-3 常见复杂度实例 | [Java源码](src/main/java/time_complexity/CommonTimeComplexity.java) |  |
| 1-4 递归算法时间复杂度 | [Java源码](src/main/java/time_complexity/Recursion.java) |  |
| **二、数组**           |                                                              | |
| 2-1 二分查找法 | [Java源码](src/main/java/array/binarysearch/BinarySearch.java) | |
| 2-2 移除元素问题 | [Java源码](src/main/java/array/leetcode/remove_element) | |
| 2-3 排序分类问题 | [Java源码](src/main/java/array/leetcode/sort) | |
| 2-4 指针对撞问题 | [Java源码](src/main/java/array/leetcode/collision_pointer) | |
| 2-5 滑动窗口问题 | [Java源码](src/main/java/array/leetcode/sliding_window) | |
|                                                   |                                                              |                                  |
|                                                   |                                                              |                                  |
|                                                   |                                                              | |


# 一、复杂度分析

## 1-1 什么是大 O

- n表示数据规模
- O(f(n)) 表示运行算法所需要执行的指令数，和 f(n) 成正比。

| 常见算法 | 时间复杂度 | 所需指令数 |
| :---: | :---: | :---: |
| 二分查找法 | O(logn) | a*logn |
| 寻找数组中的最大/最小值 | O(n) | b*n |
| 归并排序算法 | O(nlogn) | c*nlogn |
| 选择排序法 | O(n^2) | d*n^2 |

## 1-2 数据规模

如果要想在 1s 之内解决问题：

- O(n2) 的算法可以处理大约 10^4 级别的数据
- O(n) 的算法可以处理大约 10^8 级别的数据
- O(nlogn) 的算法可以处理大约 10^7 级别的数据

## 1-4 递归算法时间复杂度

如果递归函数中，只进行一次递归调用，递归深度为 depth；在每个递归函数中，时间复杂度为 T；则总体的时间复杂度为 O(T*depth)



![image-20210816183211569](https://z3.ax1x.com/2021/08/16/fWXd5n.png)