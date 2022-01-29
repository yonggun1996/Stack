import java.util.Scanner;
import java.util.Stack;

public class NGE {
	
	static int[] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		
		int size = in.nextInt();
		arr = new int[size];
		int[] answer = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		stack.push(arr[0]);
		index.push(0);
		int idx = 0;
		for(int i = 1; i < size; i++) {
			if(arr[i] < stack.peek()) {
				stack.push(arr[i]);
				index.push(i);
				idx++;
			}else {
				while(!stack.empty()) {
					if(stack.peek() < arr[i]) {
						stack.pop();
						answer[idx] = arr[i];
						//answer.add(arr[i]);
						idx--;
						index.pop();
					}else {
						break;
					}
				}
				stack.push(arr[i]);
				index.push(i);
				idx = i;
			}
		}
		
		while(!index.empty()) {
			int i = index.pop();
			answer[i] = -1;
		}
		
		for(int i : answer) {
			System.out.println(i);
		}
	}

}
