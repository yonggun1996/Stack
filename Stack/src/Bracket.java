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

		if(str.length() % 2 != 0) {//우선 기본적으로 문자열의 길이가 홀수가 되면 완전한 괄호 문자열이 될 수 없다.
			System.out.println("NO");
		}else {
			for(int i = 0; i < str.length(); i++) {
				if(stack.empty()) {//스택이 비어있으면 일단 문자 추가
					stack.push(str.charAt(i));
				}else {
					if(str.charAt(i) == '(') {//'('가 들어오면 무조건 추가
						stack.push('(');
					}else if(stack.peek() == '(' && str.charAt(i) == ')'){
						//')'가 들어올 경우는 생각을 해봐야 한다
						//이전에 '('가 들어왔고 ')'가 오면 스택에 있는 문자를 빼내고
						stack.pop();
					}else {
						//그렇지 않을 경우 ')'를 그냥 스택에 넣는다
						stack.push(str.charAt(i));
					}
				}
			}
			
			if(stack.empty()) {//스택이 비어있다는 뜻은 모든 괄호 문자를 맞췄다는 뜻
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
	}

}
