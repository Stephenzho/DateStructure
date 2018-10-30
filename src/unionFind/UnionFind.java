package unionFind;

/**
 * 基于数组实现的并查集
 *
 * @author zhoushuyi
 * @since 2018/10/29
 */
public class UnionFind implements UF {

    private int[] parent;

    // rank[i]表示以i为根的集合所表示的树的层数
    private int[] rank;

    public UnionFind(int[] parent) {
        this.parent = parent;
    }

    public UnionFind(int size) {
        this.parent = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 找q的根节点
     * @param q
     * @return
     */
    private int find(int q) {
        if (q < 0 || q >= parent.length) {
            throw new IllegalArgumentException("非法参数");
        }

        while (parent[q] != q) {
            parent[q] = parent[parent[q]];
            q = parent[q];
        }

        return parent[q];
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     *  合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pid = find(p);
        int qid = find(q);

        if (pid == qid) {
            return;
        }

        /* 根据两个元素所在树的rank不同判断合并方向
            将rank低的集合合并到rank高的集合上
         */
        if (rank[pid] > rank[qid]) {
            parent[qid] = pid;

        } else if (rank[qid] > rank[pid]) {
            parent[pid] = qid;

        } else {
            parent[qid] = pid;
            rank[pid] += 1;
        }

    }
}
