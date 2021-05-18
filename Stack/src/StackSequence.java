import java.util.Scanner;
import java.util.Stack;

public class StackSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int size = in.nextInt();
		int[] arr = new int[size];
		StringBuilder answer = new StringBuilder();//push, pop을 했을 때마다 기록하는 StringBuilder문
		
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		int idx = 0;
		//1부터 입력받은 숫자까지 for문을 이용해 반복한다.
		//일단 숫자를하나 스택에 넣은 후 스택에 맨 위 숫자와 탐색하려는 배열의 수와 비교를해 같다면 스택에서 빼준다
		for(int i = 1; i <= size; i++) {
			stack.push(i);
			answer.append('+' + "\n");
			while(!stack.empty() && stack.peek() == arr[idx]) {
				stack.pop();
				answer.append('-' + "\n");
				idx++;
			}
		}
		
		//이 과정을 모두 거치면 자연스럽게 스택 안에 데이터가 남거나 없을것이다.
		//없으면 원하는 수열을 만들어 낸 것이고 그렇지 않으면 원하는 수열을 만들지 못한 것이다.
		if(stack.empty()) {
			//그리고 수열을 만들었으면 push, pop했을때마다 기록한 answer를 출력한다.
			System.out.println(answer.toString());
		}else {
			System.out.println("NO");
		}
		
	}

}
