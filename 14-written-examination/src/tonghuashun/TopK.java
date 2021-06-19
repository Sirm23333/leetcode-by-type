package tonghuashun;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {
    public static void printTopK(int k, int[] arr){
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int a : arr){
            queue.add(a);
            if(queue.size() > k){
                queue.poll();
            }
        }
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        printTopK(4,arr);
    }
}
