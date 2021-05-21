import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBiggest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] answer = new int[N];
		Arrays.fill(answer, -1);
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(stack.empty()) {
				stack.add(i);
			}else {
				while(!stack.empty()) {
					int idx = stack.peek();
					
					if(arr[idx] < arr[i]) {
						answer[idx] = arr[i];
						stack.pop();
					}else {
						break;
					}
				}
				
				stack.push(i);
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
	}

}
