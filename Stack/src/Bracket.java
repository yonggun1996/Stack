import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	
	public static void main(String[] args) {
		Bracket b = new Bracket();
		Scanner in = new Scanner(System.in);
		
		String count_str = in.next();
		int count = Integer.parseInt(count_str);
		
		for(int i = 0; i < count; i++) {
			String str = in.next();
			b.search(str);
		}
	}
	
	public void search(String str) {
		Stack<Character> stack = new Stack<Character>();

		if(str.length() % 2 != 0) {//�켱 �⺻������ ���ڿ��� ���̰� Ȧ���� �Ǹ� ������ ��ȣ ���ڿ��� �� �� ����.
			System.out.println("NO");
		}else {
			for(int i = 0; i < str.length(); i++) {
				if(stack.empty()) {//������ ��������� �ϴ� ���� �߰�
					stack.push(str.charAt(i));
				}else {
					if(str.charAt(i) == '(') {//'('�� ������ ������ �߰�
						stack.push('(');
					}else if(stack.peek() == '(' && str.charAt(i) == ')'){
						//')'�� ���� ���� ������ �غ��� �Ѵ�
						//������ '('�� ���԰� ')'�� ���� ���ÿ� �ִ� ���ڸ� ������
						stack.pop();
					}else {
						//�׷��� ���� ��� ')'�� �׳� ���ÿ� �ִ´�
						stack.push(str.charAt(i));
					}
				}
			}
			
			if(stack.empty()) {//������ ����ִٴ� ���� ��� ��ȣ ���ڸ� ����ٴ� ��
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
	}

}
