# 算法与数据结构

| 章节 | 复杂度 | 备注 |
| :--- | :--- | :--- |
| **[一、排序基础](src/main/java/sort/basic)** | | |
| 1-1 [选择排序 - Selection Sort](src/main/java/sort/basic/SelectionSort.java) | O(n^2) | 每轮选出最小的元素 |
| 1-2 [插入排序 - Insertion Sort](src/main/java/sort/basic/InsertionSort.java) | O(n^2) | 无序部分元素逐个插入有序部分<br>对于近似有序的序列，排序效率高 |
| **[二、高级排序](src/main/java/sort/advance)** | | |
| 2-1 [归并排序 - Merge Sort](src/main/java/sort/advance/MergeSort.java) | O(nlogn) | 递归写法 |
| 2-2 [自底向上的归并排序算法](src/main/java/sort/advance/MergeSortBU.java) | O(nlogn) | 滑块写法 |
| 2-3 [快速排序 - Quick Sort](src/main/java/sort/advance/QuickSort.java) | O(nlogn) | 递归进行选标的，分左右 |
| 2-4 [双路快速排序法](src/main/java/sort/advance/QuickSort2.java) | O(nlogn) | 优化：与标的相等的元素划分到两边 |
| 2-5 [三路快速排序法](src/main/java/sort/advance/QuickSort3.java) | O(nlogn) | 优化：划分三块，与标的相等的元素分在中间，下此不再递归处理 |
| **[三、堆和堆排序](src/main/java/sort/advance)** | | |
| 3-1 [堆的简单实现](src/main/java/sort/heap/MaxHeap.java) | 添加,移除: O(logn) | 最大二叉堆，固定容量 |