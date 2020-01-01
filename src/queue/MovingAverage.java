package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class MovingAverage {
    private Queue<Integer> queue = new LinkedList<>();
    private int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            queue.poll();
        }
        queue.offer(val);
        int sum = 0;
        int cnt = 0;
        for (Integer i : queue) {
            sum += i;
            cnt += 1;
        }

        return sum / (double) cnt;
    }
}
