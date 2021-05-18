import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackSequenceBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		StringBuilder answer = new StringBuilder();//push, pop�� ���� ������ ����ϴ� StringBuilder��
		
		StringTokenizer st;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
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