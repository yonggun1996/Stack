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
			
			//'('�� '['�� �ϴ� ���ÿ� �ִ´�
			//')'�� ']'�� ���� ���� �ٸ���
			//���� ���� �� �� �����Ͱ� �� ��ȣ�� ���� ��ȣ�� ��쿡�� ���ÿ� �����͸� ������
			//�׷��� ������ ��ȣ�� �ִ´�
			//�׸��� ������ ��������� �ϴ� �־�� �Ѵ�
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
