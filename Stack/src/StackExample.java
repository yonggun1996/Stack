import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackExample {
	
	static Stack<Integer> stack = new Stack<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("pop")) {
				pop();
			}else if(str.equals("size")) {
				size();
			}else if(str.equals("empty")) {
				empty();
			}else if(str.equals("top")) {
				top();
			}else {
				int num = Integer.parseInt(st.nextToken());
				push(num);
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void pop() {
		if(stack.empty()) {
			//System.out.println(-1);
			sb.append(-1);
			sb.append("\n");
		}else {
			//System.out.println(stack.pop());
			sb.append(stack.pop());
			sb.append("\n");
		}
	}
	
	public static void size() {
		//System.out.println(stack.size());
		sb.append(stack.size());
		sb.append("\n");
	}
	
	public static void empty() {
		if(stack.empty()) {
			//System.out.println(1);
			sb.append(1);
			sb.append("\n");
		}else {
			//System.out.println(0);
			sb.append(0);
			sb.append("\n");
		}
	}
	
	public static void top() {
		if(stack.empty()) {
			//System.out.println(-1);
			sb.append(-1);
			sb.append("\n");
		}else {
			//System.out.println(stack.peek());
			sb.append(stack.peek());
			sb.append("\n");
		}
	}
	
	public static void push(int num) {
		stack.push(num);
	}

}
