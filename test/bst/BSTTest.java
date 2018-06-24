package bst;

import org.junit.Test;

import java.util.Random;

/**
 * @author zhoushuyi
 * @since 2018/6/24
 */
public class BSTTest {



    @Test
    public void test() {

        Random random =  new Random(100);


        BST<Integer> bst = new BST<>();


        for (int i = 0; i < 10; i++) {
            int next = random.nextInt(100);
            System.out.println(next);

            bst.add(next);
        }


        System.out.println(bst.size());

    }


}
