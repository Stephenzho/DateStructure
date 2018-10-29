package unionFind;

/**
 * @author zhoushuyi
 * @since 2018/10/29
 */
public class UnionFind implements UF {

    private int[] parent;

    public UnionFind(int[] parent) {
        this.parent = parent;
    }

    public UnionFind(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private int find(int q) {
        if (q < 0 || q >= parent.length) {
            throw new IllegalArgumentException("非法参数");
        }

        while (parent[q] != q) {
            q = parent[q];
        }

        return parent[q];
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pid = find(p);
        int qid = find(q);

        if (pid == qid) {
            return;
        }

        for (int i = 0; i < parent.length; i++) {
            if (find(i) == qid) {
                parent[i] = qid;
            }
        }

    }
}
