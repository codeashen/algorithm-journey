# 算法与数据结构大纲

| 章节 | 复杂度 | 备注 |
| :--- | :--- | :--- |
| **一、[排序基础](src/main/java/sort/basic)** | | |
| 1-1 [选择排序 - Selection Sort](src/main/java/sort/basic/SelectionSort.java) | O(n^2) | 每轮选出最小的元素 |
| 1-2 [插入排序 - Insertion Sort](src/main/java/sort/basic/InsertionSort.java) | O(n^2) | 无序部分元素逐个插入有序部分<br>对于近似有序的序列，排序效率高 |
| **二、[高级排序](src/main/java/sort/advance)** | | |
| 2-1 [归并排序 - Merge Sort](src/main/java/sort/advance/MergeSort.java) | O(nlogn) | 递归写法 |
| 2-2 [自底向上的归并排序算法](src/main/java/sort/advance/MergeSortBU.java) | O(nlogn) | 滑块写法 |
| 2-3 [快速排序 - Quick Sort](src/main/java/sort/advance/QuickSort.java) | O(nlogn) | 递归进行选标的，分左右 |
| 2-4 [双路快速排序法](src/main/java/sort/advance/QuickSort2.java) | O(nlogn) | 优化：与标的相等的元素划分到两边 |
| 2-5 [三路快速排序法](src/main/java/sort/advance/QuickSort3.java) | O(nlogn) | 优化：划分三块，与标的相等的元素分在中间，下此不再递归处理 |
| **三、[堆和堆排序](src/main/java/heap)** | | |
| 3-1 [堆的简单实现](src/main/java/heap/MaxHeap.java) | 添加,移除: O(logn) | 最大二叉堆，固定容量 |
| 3-2 [基础堆排序](src/main/java/heap/HeapSort2.java) | O(nlogn) | 1.逐个添加，逐个取出<br>2.使用heapify构建对，再逐个取出 |
| 3-3 [优化堆排序 - Heap Sort](src/main/java/heap/HeapSort.java) | O(nlogn) | 不使用而外堆，直接在原数组上进行堆排序<br>注意两个shiftDown的区别 |
| 3-4 [索引堆](src/main/java/heap/IndexMaxHeap.java) |  | 维护原始索引 |
| 3-5 [索引堆优化](src/main/java/heap/IndexMaxHeap2.java) |  | 维护反查索引 |
| **四、[二分搜索树](src/main/java/binarysearchtree)** | | |
| 4-1 [二分查找](src/main/java/binarysearchtree/BinarySearch.java) | O(log2n) | 二分查找循环写法和递归写法 |
| 4-2 [二分搜索树](src/main/java/binarysearchtree/BinarySearchTree.java) |  | 二分搜索树的简单实现 |
| **五、[并查集](src/main/java/unionfind)** | | |
| 5-1 [并查集 - 数组实现](src/main/java/unionfind/UnionFind1.java) | 并: O(n), 查: O(1) | 数组实现的并查集 |
| 5-2 [并查集 - 节点](src/main/java/unionfind/UnionFind2.java) | 并: O(h), 查: O(h) | 使用子节点指向父节点方式实现并查集 |
| 5-3 [并查集 - size优化](src/main/java/unionfind/UnionFind3.java) | 并: O(h), 查: O(h) | 并操作将根据size决定归并方向 |
| 5-4 [并查集 - rank优化](src/main/java/unionfind/UnionFind4.java) | 并: O(h), 查: O(h) | 并操作将根据rank决定归并方向 |
| 5-5 [并查集 - 路径压缩优化(循环)](src/main/java/unionfind/UnionFind5.java) | 并: O(h), 查: O(h) | 查找操作时附带压缩路径，循环 |
| 5-6 [并查集 - 路径压缩优化(递归)](src/main/java/unionfind/UnionFind6.java) | 并: O(h), 查: O(h) | 查找操作时附带压缩路径，递归 |
| **六、[图论基础](src/main/java/graph/basic)** | | |
| 6-1 [稀疏图 - 邻接表](src/main/java/graph/SparseGraph.java) | 深度优先遍历: O(V+E) | 邻接表实现稀疏图 |
| 6-2 [稠密图 - 邻接矩阵](src/main/java/graph/DenseGraph.java) | 深度优先遍历: O(V^2) | 邻接矩阵实现稠密图 |
| 6-3 [求图的连通分量](src/main/java/graph/Components.java) |  | 使用深度优先遍历方式求图的连通分量 |
| 6-4 [求某顶点的连通路径](src/main/java/graph/Path.java) |  | 使用深度优先遍历方式求图中某一顶点到其他顶点的路径 |
| 6-5 [求最短路径](src/main/java/graph/ShortestPath.java) |  | 使用广度度优先遍历方式求图中某一顶点到其他顶点的最短路径 |
| **七、[最小生成树](src/main/java/minspantree)** | | |
| 7-1 [稠密带权图 - 邻接矩阵](src/main/java/minspantree/DenseWeightedGraph.java) |  | 邻接矩阵实现稠密带权图 |
| 7-2 [稀疏带权图 - 邻接表](src/main/java/minspantree/SparseWeightedGraph.java) |  | 邻接表实现稀疏带权图 |
| 7-3 [Lazy Prim 求最小生成树](src/main/java/minspantree/LazyPrimMST.java) | O(E log(E)) | 借助最小堆，逐个访问节点，将临边加入最小堆，然后取出最小的横切边，<br>再访问将横切边中未访问的顶点 |
| 7-4 [优化 Prim 求最小生成树](src/main/java/minspantree/PrimMST.java) | O(E log(V)) | 借助最小索引堆，逐个访问节点，将临边中权重最小者的权重和另一顶点存入索引堆，并记录边，<br>然后取出最小的索引，取出记录的边，再继续访问这个边的另一顶点 |
| 7-5 [Kruskal 求最小生成树](src/main/java/minspantree/KruskalMST.java) | O(E log(E)) | 将所有边排序，从小到大取边，只要边不成环，就将改边加入最小生成树，否则丢弃，到了有 V-1 条边最小生成树就构建完成 |
| **八、[最短路径](src/main/java/shortestpath)** | | |
| 8-1 [Dijkstra 算法求最短路径](src/main/java/shortestpath/Dijkstra.java) | O(E log(V)) | 前提：图中不能有负权边 |
| 8-2 [Bellman Ford 算法求最短路径](src/main/java/shortestpath/BellmanFord.java) | O(EV) | 前提：图中不能有负权环<br>如果一个图没有负权环，从一点到另外一点的最短路径，最多经过所有的 V 个顶点，有 V-1 条边，否则，存在顶点经过了两次，既存在负权环 |

# 二、高级排序

## 2.2 快速排序

### 单路快排

快速排序每次从数组中选择一个元素作为基点，然后将该元素移动到指定位置，使得基点的左侧都是小于几点的元素，右侧都是大于基点的元素，此操作称之为 partition。然后再对左右两部分数组递归进行 partition 操作。

![image-20210813194451592](https://z3.ax1x.com/2021/08/13/frL1vq.png)

下面详解 partition 操作步骤，先解释步骤图中的元素：

| 索引 | 含义                                | 初始值 |
| ---- | ----------------------------------- | ------ |
| l    | 基准点，标的 v 索引，选择最左边元素 | l      |
| i    | 待考察元素，从左向右遍历            | l + 1  |
| j    | 小区间有边界                        | l      |

![image-20210813195326592](https://z3.ax1x.com/2021/08/13/frOXTO.png)

通常选择数组的第一个索引位 l 处的元素 v 作为标的，指定 j=l，i=l+1，开始从左往右遍历元素 e。

- 如果 e > v，则直接将元素放到大区间尾部，继续遍历下一个元素（对应代码里啥都不用做）。
- 如果 e < v，则将元素 e 和 j+1 指向的元素交换，然后 j++，继续遍历下一元素（对用代码里，swap(arr, ++p, i)）。

![image-20210813201737320](https://z3.ax1x.com/2021/08/13/frzNa6.png)

遍历完成后数组被分成三部分，首部基点元素 v，小区间和大区间。最后只需要将 l 和 j 下标的元素交换，此时 partition 操作完成，基点 v 分隔了小区间和大区间。

![image-20210813201556298](https://z3.ax1x.com/2021/08/13/frzVrn.png)

### 存在问题和优化方案

**问题一：不好的标的导致递归树不平衡**

快速排序不同与归并排序，递归过程中每次将数组平均分为两份。而快速排序使用标的元素将数组分成两份，再左右递归。这种分隔方式得到的两部分数组长度会不一致，导致递归树不平衡，极端情况下退化成下图所示链表情况，所有元素都大于标的元素，比如近乎有序的数组，从而导致递归树过深，时间复杂度退化为 O(n^2)。

![image-20210813224027360](https://z3.ax1x.com/2021/08/13/fstI1K.png)

为了优化这种情况，可以随机选择一个元素作为标的元素，然后将标的元素和数组开头元素交换，接下来的步骤不变。这样随机选择标的元素，再进行快速排序的时间复杂度的数学期望是 O(nlogn) 的。

**问题二：大量重复元素导致递归不平衡**

其实以上 partition 操作是忽略了与标的 v 相等的元素，将其放在了数组同一侧，如下图。在存在大量重复元素的情况下，如果存在大量和标的相等的元素，会导致递归不平衡，极端情况下时间复杂度退化为 O(n^2)。

![image-20210813225924984](https://z3.ax1x.com/2021/08/13/fsaDpt.png)

### 双路快排

单路快排中将小区间和大区间都放在数据的一端，从左到右遍历完整个数组。双路快排将小区间和大区间放在数组的两端，使用 i 记录左边遍历的元素索引，j 记录右边遍历的元素索引。

| 索引 | 含义                                      | 初始值 |
| ---- | ----------------------------------------- | ------ |
| i    | 左侧待考察元素，从左向右，小区间右边界 +1 | l + 1  |
| j    | 右侧待考察元素，从右向左，大区间左边界 -1 | r      |

![image-20210813232216352](https://z3.ax1x.com/2021/08/13/fsBWrV.png)

- i 从左向右遍历，遇到小于 v 的元素跳过继续，遇到大于等于 v 的元素停止。
- j 从右向左遍历，遇到大于 v 的元素跳过继续，遇到小于等于 v 的元素停止。
- 然后将 i 和 j 处的元素交换，i++，j--，继续上述遍历，直到 i 和 j 重合遍历完成。

![image-20210813232618137](https://z3.ax1x.com/2021/08/13/fsDFMt.png)

最后实现的效果其实是等于 v 的元素被分配到了数组的两端，最后 i 和 j 重合的时候和 v 交换即可。

![image-20210813233133397](https://z3.ax1x.com/2021/08/13/fsrpwT.png)

### 三路快排

双路快排的方式下，将等于标的 v 的元素分配到了两边，可不可以将等于 v 的元素放在中间，下次 partition 操作的时候只需要处理完全小于 v 的区间和完全大于 v 的区间呢？这就用到了三路快排。

如下图所示，三路快排将待考察元素分为小区间、大区间和等值区间。

| 索引 | 含义         | 初始值 |
| ---- | ------------ | ------ |
| lt   | 小区间右边界 | l      |
| gt   | 大区间左边界 | r + 1  |
| i    | 待考察元素   | l + 1  |

![image-20210814000410216](https://z3.ax1x.com/2021/08/14/fs6wtO.png)

- 如果 e 等于 v，跳过继续遍历
- 如果 e 小于 v，交换 i 和 lt+1 处元素，lt++，i++
- 如果 e 大于 v，交换 i 和 gt-1 处元素，gt--（不用 i++，因为换来了一个未考察的元素）

最后效果如下图，现在只需要交换 l 和 lt 处元素即可。

![image-20210814002014103](https://z3.ax1x.com/2021/08/14/fscc24.png)

交换后得到下图效果，现在只需要分别对左半部分和右半部分递归操作即可。

![image-20210814002140940](https://z3.ax1x.com/2021/08/14/fscfq1.png)

# 六、图论基础

## 6.1 图的分类和性质

**1. 有向性**

- 无向图：边不区分指向
- 有向图：边由一个顶点指向另一个顶点

![image-20210511171035644](https://z3.ax1x.com/2021/08/13/frHsr8.png)

**2. 权重**

- 无权图：图的边没有权重
- 有权图：图的边带权重

![image-20210511171219876](https://z3.ax1x.com/2021/08/13/frHgaQ.png)

**3. 图的连通性**

- 完全连通：图中所有顶点都互相可达（下图不完全连通）
- 连通分量：连通分量表示图中有几组互相连通的顶点。以下图为例，该图的连通分量为 3。

![image-20210511171815750](https://z3.ax1x.com/2021/08/13/frHWPs.png)

**4. 图的边**

- 自环边：顶点自己连通自己的边
- 平行边：两个顶点中连通的多个边

![image-20210511171648162](https://z3.ax1x.com/2021/08/13/frHfGn.png)

## 6.2 图的表示

**1. 邻接矩阵**

- 邻接矩阵表示无向图

![image-20210511172040174](https://z3.ax1x.com/2021/08/13/frHh2q.png)

- 邻接矩阵表示有效图

![image-20210511172201619](https://z3.ax1x.com/2021/08/13/frH4x0.png)

**2. 邻接表**

- 邻接表表示无向图

![image-20210511172227303](https://z3.ax1x.com/2021/08/13/frHorT.png)

- 邻接表表示有向图

![image-20210511172243624](https://z3.ax1x.com/2021/08/13/frHHZF.png)

> - 邻接表适合表示稀疏图（Sparse Graph）
> - 邻接矩阵适合表示稠密图（Dense Graph）

# 七、最小生成树

## 7.1 最小生成树问题

![image-20210526011423463](https://z3.ax1x.com/2021/08/13/frHba4.png)

对于一个由 n 个节点的完全连通的带权无向图，选出其中 n-1 条边，这 n-1 条边连通了所有节点，并且这些边的权重和最小，这就是最小生成树，如上图所示。

最小生成树应用：电缆布线、电路设计、网络设计

## 7.2 最小生成树算法

这里需要介绍切分定理，在此之前先介绍几个概念：

**切分（Cut）**：把图中的顶点分为两部分，成为一个*切分。*

![image-20210526012329827](https://z3.ax1x.com/2021/08/13/frHOi9.png)

**横切边（Cross Edge）**：如果一条边的两个顶点，属于*切分*不同的两边，这个边成为*横切边*。

![image-20210526012828744](https://z3.ax1x.com/2021/08/13/frHjR1.png)

**切分定理**：给定任意*切分*，*横切边*中权值最小的边必然属于最小生成树。

![image-20210526013021203](https://z3.ax1x.com/2021/08/13/frHvxx.png)

有了切分定理，就可以求出最小生成树了。