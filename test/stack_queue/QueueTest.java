package stack_queue;

/**
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class QueueTest {

    public static void main(String[] weq) {

        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue);


        queue.dequeue();

        System.out.println(queue);

        System.out.println(queue.getFront());




    }

}
