

import java.util.Stack;

public class KakaoBracket {
	
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {
		KakaoBracket b = new KakaoBracket();
		String p = "(()())()";
		
		System.out.println(b.solution(p));
	}
	
	public String solution(String p) {
		String answer = "";
		
		if(!p.equals("")) {
			answer = search(p);
		}
		
		return answer;
	}
	
	public static String search(String p) {//���������� ��� ���ڿ��� ������ Ȯ���ϴ� �Լ�, ���ȣ���� �Ͼ�� �Լ�
		KakaoBracket b = new KakaoBracket();
		String str = "";
		
		if(!p.equals("")) {
			String u = b.set_u(p);//�켱 �������� ���ڿ��� �����
			String v = p.substring(u.length(), p.length());
			
			if(b.corret_Bracket(u)) {//�ùٸ� ��ȣ ���ڿ����� Ȯ���Ѵ�
				stack.clear();
				str = u + search(v);
			}else {
				stack.clear();
				StringBuilder sb = new StringBuilder();
				sb.append('(');
				sb.append(search(v));
				sb.append(')');
				
				StringBuilder new_u = new StringBuilder(u);
				new_u.deleteCharAt(0);
				new_u.deleteCharAt(new_u.length() - 1);
				sb.append(b.change_u(new_u.toString()));//u�� ù��°, ������ ���ڸ� �����ϰ� ��ȣ�� ������ �� ���ڿ��� ���δ�
				
				str = sb.toString();
			}
		}
		
		return str;
	}
	
	public String change_u(String u) {//���ο� u�� ����� ���� �޼ҵ�
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < u.length(); i++) {
			if(u.charAt(i) == ')') {
				sb.append('(');
			}else {
				sb.append(')');
			}
		}
		
		return sb.toString();
	}
	
	public String set_u(String p) {//�������� ���ڿ��� ����� �޼ҵ�
		StringBuilder sb = new StringBuilder();
		sb.append(p.charAt(0));
		stack.push(p.charAt(0));
		
		for(int i = 1; i < p.length(); i++) {
			if(p.charAt(i) == '(' && stack.peek() == ')') {
				sb.append(p.charAt(i));
				stack.pop();
			}else if(p.charAt(i) == ')' && stack.peek() == '(') {
				sb.append(p.charAt(i));
				stack.pop();
			}else {
				sb.append(p.charAt(i));
				stack.push(p.charAt(i));
			}
			
			if(stack.empty()) {
				break;
			}
		}
		
		stack.clear();
		return sb.toString();
	}
	
	public boolean corret_Bracket(String u) {//�ùٸ� ��ȣ���� Ȯ���ϴ� �޼ҵ�
		stack.push(u.charAt(0));
		
		for(int i = 1; i < u.length(); i++) {
			if(u.charAt(i) == ')' && stack.peek() == '(') {
				stack.pop();
			}else {
				stack.push(u.charAt(i));
			}
		}
		
		if(stack.empty()) {
			return true;
		}else {
			return false;
		}
	}
	
}
