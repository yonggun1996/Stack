import java.util.Scanner;
import java.util.Stack;

public class StackSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int size = in.nextInt();
		int[] arr = new int[size];
		StringBuilder answer = new StringBuilder();//push, pop�� ���� ������ ����ϴ� StringBuilder��
		
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		int idx = 0;
		//1���� �Է¹��� ���ڱ��� for���� �̿��� �ݺ��Ѵ�.
		//�ϴ� ���ڸ��ϳ� ���ÿ� ���� �� ���ÿ� �� �� ���ڿ� Ž���Ϸ��� �迭�� ���� �񱳸��� ���ٸ� ���ÿ��� ���ش�
		for(int i = 1; i <= size; i++) {
			stack.push(i);
			answer.append('+' + "\n");
			while(!stack.empty() && stack.peek() == arr[idx]) {
				stack.pop();
				answer.append('-' + "\n");
				idx++;
			}
		}
		
		//�� ������ ��� ��ġ�� �ڿ������� ���� �ȿ� �����Ͱ� ���ų� �������̴�.
		//������ ���ϴ� ������ ����� �� ���̰� �׷��� ������ ���ϴ� ������ ������ ���� ���̴�.
		if(stack.empty()) {
			//�׸��� ������ ��������� push, pop���������� ����� answer�� ����Ѵ�.
			System.out.println(answer.toString());
		}else {
			System.out.println("NO");
		}
		
	}

}
