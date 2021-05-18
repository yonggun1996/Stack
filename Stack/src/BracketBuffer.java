import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BracketBuffer {
	
	public static void main(String[] args) throws IOException {
		BracketBuffer b = new BracketBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String count_str = br.readLine();
		int count = Integer.parseInt(count_str);
		
		StringTokenizer st;
		for(int i = 0; i < count; i++) {
			st  = new StringTokenizer(br.readLine());
			String str = st.nextToken();
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
