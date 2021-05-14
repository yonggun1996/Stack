import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class ZeroBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		}
		
		int answer = 0;
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
	}

}
