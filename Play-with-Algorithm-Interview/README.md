# 玩转算法面试

| 章节 | 代码 | 备注 |
| :--- | :--- | :--- |
| [**一、复杂度分析**](#一、复杂度分析) | [章节代码](src/main/java/timecomplexity) | |
| [1.1 什么是大 O](#1.1 什么是大 O) | [无代码] |  |
| [1.2 数据规模测试](#1.2 数据规模) | [Java代码](src/main/java/timecomplexity/Basic.java) | 统计每个数量级数据规模的处理速度 |
| 1.3 常见复杂度实例 | [Java代码](src/main/java/timecomplexity/CommonTimeComplexity.java) |  |
| 1.4 [递归算法时间复杂度](#1.4 递归算法时间复杂度) | [Java代码](src/main/java/timecomplexity/Recursion.java) |  |
| **二、数组** | [章节代码](src/main/java/array) | |
| 2.1 二分搜索 | [Java代码](src/main/java/array/binarysearch/BinarySearch.java) | |
| [2.2 移动零](https://leetcode-cn.com/problems/move-zeroes/) | [Java代码](src/main/java/array/leetcode/MoveZeroes.java) | leetcode 283 |
| [2.3 移除元素](https://leetcode-cn.com/problems/remove-element/) | [Java代码](src/main/java/array/leetcode/MoveZeroes.java) | leetcode 27 |
| [2.4 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) | [Java代码](src/main/java/array/leetcode/MoveZeroes.java) | leetcode 26 |
| [2.5 删除有序数组中的重复项 II](https://leetcode-cn.com/problems/move-zeroes/) | [Java代码](src/main/java/array/leetcode/MoveZeroes.java) | |
| [2.6 移动零](https://leetcode-cn.com/problems/move-zeroes/) | [Java代码](src/main/java/array/leetcode/MoveZeroes.java) | |
| [2.7 移动零](https://leetcode-cn.com/problems/move-zeroes/) | [Java代码](src/main/java/array/leetcode/MoveZeroes.java) | |


## 一、复杂度分析

### 1.1 什么是大 O

- n表示数据规模
- O(f(n)) 表示运行算法所需要执行的指令数，和 f(n) 成正比。

| 常见算法 | 时间复杂度 | 所需指令数 |
| :---: | :---: | :---: |
| 二分查找法 | O(logn) | a*logn |
| 寻找数组中的最大/最小值 | O(n) | b*n | 
| 归并排序算法 | O(nlogn) | c*nlogn | 
| 选择排序法 | O(n^2) | d*n^2 |

### 1.2 数据规模

如果要想在 1s 之内解决问题：

- O(n2) 的算法可以处理大约 10^4 级别的数据
- O(n) 的算法可以处理大约 10^8 级别的数据
- O(nlogn) 的算法可以处理大约 10^7 级别的数据

### 1.4 递归算法时间复杂度

如果递归函数中，只进行一次递归调用，递归深度为 depth；在每个递归函数中，时间复杂度为 T；则总体的时间复杂度为 O(T*depth)
