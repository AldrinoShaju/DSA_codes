package leetcode.Blind75.HeapPriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle
 * value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual
 * answer will be accepted.
 */
public class FindMedianfromDataStream {

    Queue<Integer> smallHeap;
    Queue<Integer> largeHeap;

    public FindMedianfromDataStream() {
        smallHeap = new PriorityQueue<>((a, b)->b-a);
        largeHeap = new PriorityQueue<>((a,b)->a-b);
    }

    public void addNum(int num) {
        smallHeap.add(num);
        if(smallHeap.size() - largeHeap.size() > 1||
                !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size() - smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
        }

    }

    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()){
            return (double)(smallHeap.peek() + largeHeap.peek())/2;
        }else if(smallHeap.size()>largeHeap.size()){
            return (double)smallHeap.peek();
        }else{
            return (double)largeHeap.peek();
        }
    }
}
