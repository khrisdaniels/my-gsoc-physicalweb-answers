import java.util.*;
public class runningMedian {
	
	public static void addNum(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
		if (minHeap.size() == 0 || num < minHeap.peek()) {
			minHeap.add(num);
		} else {
			maxHeap.add(num);
		}
	}
	
	public static void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
		PriorityQueue<Integer> bigHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
		if (bigHeap.size() - smallHeap.size() >=  2) {
			smallHeap.add(bigHeap.poll());
		}
	}
	
	public static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
		PriorityQueue<Integer> bigHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
		if (bigHeap.size() == smallHeap.size()) {
			return ((double)bigHeap.peek() + smallHeap.peek()/2);
		} else {
			return bigHeap.peek();
		}
	}
	
	public static double[] getMedian(int array[]) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		double[] middle = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			addNum(num, minHeap, maxHeap);
			balance(minHeap, maxHeap);
			middle[i] = getMedian(minHeap, maxHeap);
		}
		return middle;
	}
	
	public static void main(String[] args) {

	}
}
