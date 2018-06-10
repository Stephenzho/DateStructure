package Array;

/**
 * @author zhoushuyi
 * @since 2018/6/9
 */
public class ArrayTest {

    public static void main(String[] qwer) {

        Array array = new Array<Short>();

        for (int i=0;i<10;i++){
            array.add(i);
        }

        System.out.println(array);


        for (int i = 0; i < 5; i++) {
            array.add(i << 2);
        }

        System.out.println(array);

        array.removeFirst();
        array.removeLast();
        array.removeLast();
        array.removeLast();

        System.out.println(array);

        System.out.println(100 >> 1);
        System.out.println(100 >> 2);
        System.out.println(1024 >> 2);



    }
}
