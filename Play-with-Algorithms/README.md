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
| **[三、堆和堆排序](src/main/java/heap)** | | |
| 3-1 [堆的简单实现](src/main/java/heap/MaxHeap.java) | 添加,移除: O(logn) | 最大二叉堆，固定容量 |
| 3-2 [基础堆排序](src/main/java/heap/HeapSort2.java) | O(nlogn) | 1.逐个添加，逐个取出<br>2.使用heapify构建对，再逐个取出 |
| 3-3 [优化堆排序 - Heap Sort](src/main/java/heap/HeapSort.java) | O(nlogn) | 不使用而外堆，直接在原数组上进行堆排序<br>注意两个shiftDown的区别 |
| 3-4 [索引堆](src/main/java/heap/IndexMaxHeap.java) |  | 维护原始索引 |
| 3-5 [索引堆优化](src/main/java/heap/IndexMaxHeap2.java) |  | 维护反查索引 |


