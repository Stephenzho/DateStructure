package unionFind;

/**
 * @author zhoushuyi
 * @since 2018/10/29
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}