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


        Integer[] data = {5,3,6,8,4,2};

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {


            bst.add(data[i]);
        }


        System.out.println(bst);

    }


}
