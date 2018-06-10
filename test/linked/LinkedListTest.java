package linked;


/**
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class LinkedListTest {

    public static void main(String[] weq) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i=0; i<5;i++){


            linkedList.addLast(i);
        }

        System.out.println(linkedList);

        System.out.println(linkedList.get(4));



    }
}

