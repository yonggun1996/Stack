import java.util.Scanner;
import java.util.Stack;

public class BalanceWorld {
	
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {
		BalanceWorld b = new BalanceWorld();
		Scanner in = new Scanner(System.in);
		
		while(true) {
			String flag = in.nextLine();
			
			if(flag.equals(".")) {
				break;
			}
			
			System.out.println(b.search(flag));
		}
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
