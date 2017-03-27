import java.util.*;
public class Queue {
	

	
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		PriorityQueue line = new PriorityQueue();
		List outPut = new ArrayList();
		int inputs, op, x;
		
		try {
		System.out.println("Enter the number of input/s: ");
		inputs = console.nextInt();
		
		for (int i = 0; i < inputs; i++) {
			op = console.nextInt();
			
			switch (op) {
			case 1:
				x = console.nextInt();
				line.offer(x);
				break;
				
			case 2: 
				line.poll();
				break;
				
			case 3:
				outPut.add(line.peek());
				break;
			
			default:
				System.out.println("You can only choose between 1 - 3!");
				System.exit(i);
			}
		}
		
		for (int b = 0; b < outPut.size(); b++){
			System.out.println("\n" +outPut.get(b));
		}
		} catch (InputMismatchException e){
			System.out.println("You can only input an integer!");
		}
	}
}
		
