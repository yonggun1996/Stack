import java.util.Scanner;
import java.util.Stack;

public class Zero {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int k = in.nextInt();
		
		for(int i = 0; i < k; i++) {
			int num = in.nextInt();
			
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		}
		
		int answer = 0;
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		System.out.println(answer);
	}

}
