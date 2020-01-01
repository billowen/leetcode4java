package queue;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    private int head = -1;
    private int tail = -1;
    private int[] data;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = 0;
        }

        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (tail == head) {
            tail = -1;
            head = -1;
        } else {
            head = (head + 1) % size;
        }

        return true;
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(30);
        int[] array = new int[] {71,32, 1,32,8,6,8,3,56,41,14,6,25,44,84,59};
        for (int a : array) {
            queue.enQueue(a);
        }

        queue.deQueue();
        queue.enQueue(4);
        queue.enQueue(40);
        queue.enQueue(11);
        queue.deQueue();

        queue.enQueue(94);
        queue.enQueue(72);
        queue.deQueue();

        queue.enQueue(19);
        queue.enQueue(20);

        queue.deQueue();
        queue.enQueue(58);
        queue.enQueue(54);
        queue.deQueue();
        queue.enQueue(65);
        queue.deQueue();
        queue.enQueue(59);
        queue.enQueue(26);
        queue.enQueue(10);
        queue.deQueue();
        queue.enQueue(14);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(37);


    }
}
