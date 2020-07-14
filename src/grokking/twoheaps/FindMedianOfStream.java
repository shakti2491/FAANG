package grokking.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianOfStream
{


    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a,b) -> a-b
    );
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b)-> b-a
    );
    double median;
    /** initialize your data structure here. */
    public FindMedianOfStream() {
        minHeap = new PriorityQueue<>((a,b)->a-b);
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        median = -1;
    }

    public void addNum(int num) {

        if(minHeap.size()==0 && maxHeap.size() == 0){
            minHeap.add(num);
            median = num;
        }

        else if(minHeap.size() == maxHeap.size()){

            if(num>=maxHeap.peek()){
                minHeap.offer(num);
                median = minHeap.peek();
            }
            else
            {
                maxHeap.offer(num);
                median = maxHeap.peek();
            }

        }
        else if(minHeap.size()>maxHeap.size()){

            if(num<=minHeap.peek())
                maxHeap.offer(num);

            else{
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            median = (maxHeap.peek()+minHeap.peek())/2;



        }
        else{

            if(num>=maxHeap.peek())
                minHeap.offer(num);
            else{
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
            median = (maxHeap.peek()+minHeap.peek())/2;


        }


    }

    public double findMedian() {

        return median;

    }

    public static void main(String[] args)
    {
        FindMedianOfStream fms = new FindMedianOfStream();
        int a =2;
        int b =3;
        double d = (a+b)/2.0;
        fms.addNum(1);
        fms.addNum(2);
        fms.findMedian();
    }
}
