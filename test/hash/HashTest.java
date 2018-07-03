package hash;


/**
 * @author zhoushuyi
 * @since 2018/7/3
 */
public class HashTest {

    public static void main(String[] strings) {

        HashTables hashTables = new HashTables();

        hashTables.put("12", 12);
        hashTables.put("22", 22);
        hashTables.put("sdfa", 121);


        System.out.println(hashTables.toString());
    }
}
