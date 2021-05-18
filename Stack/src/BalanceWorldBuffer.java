import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalanceWorldBuffer {
	
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) throws IOException {
		BalanceWorldBuffer b = new BalanceWorldBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String flag = br.readLine();
			
			if(flag.equals(".")) {
				break;
			}
			
			bw.write(b.search(flag) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public String search(String str) {
		for(int i = 0; i < str.length(); i++) {
			
			//'('나 '['는 일단 스택에 넣는다
			//')'나 ']'의 경우는 조금 다르다
			//만약 스택 맨 위 데이터가 각 괄호의 여는 괄호일 경우에만 스택에 데이터를 꺼내고
			//그렇지 않으면 괄호를 넣는다
			//그리고 스택이 비어있으면 일단 넣어야 한다
			if(str.charAt(i) == '(') {
				stack.push('(');
			}else if(str.charAt(i) == '[') {
				stack.push('[');
			}else if(str.charAt(i) == ')') {
				if(stack.empty() || stack.peek() != '('){
					stack.push(')');
				}else if(stack.peek() == '(') {
					stack.pop();
				}
			}else if(str.charAt(i) == ']') {
				if(stack.empty() || stack.peek() != '['){
					stack.push(']');
				}else if(stack.peek() == '[') {
					stack.pop();
				}
			}
		}
		

		String result = "";
		
		if(stack.empty()) {
			result = "yes";
		}else {
			result = "no";
		}
		stack.clear();
		
		return result;
	}

}
