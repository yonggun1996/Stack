package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class AlienGuitar {

    /*
    스택을 리스트를 이용해서 6개를 만든다
    각 라인의 스택을 참고로 제일 큰 값이 나오면 스택에 쌓고
    그렇지 않으면 프렛값보다 더 작은 값이 나올 때 까지 스택에서 빼고 카운팅을 한다
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Stack<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            //기타의 라인 별로 스택을 선언한다
            list.add(new Stack<>());
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int n_num = Integer.parseInt(st.nextToken());
            int p_num = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = list.get(n_num - 1);
            if(stack.isEmpty() || stack.peek() < p_num){//스택이 비었거나 프렛이 크면 바로 스택에 넣는다
                stack.push(p_num);
                count++;
            }else if(stack.peek() > p_num){
                while(true){//스택의 최근 값이 프렛보다 작으면 기존 값들 중 프렛 값보다 작은 값이 나오기 전까지 계속 뺀다
                    if(stack.isEmpty()){
                        stack.push(p_num);
                        count++;
                        break;
                    }

                    int max_num = stack.pop();
                    if(max_num > p_num){
                        count++;
                    }else if(max_num < p_num){
                        stack.push(max_num);
                        stack.push(p_num);
                        count++;
                        break;
                    }else{//그 와중에 같은 값이 오면 프렛 값만 삽입한다.
                        stack.push(p_num);
                        break;
                    }
                }
            }
            //최근값과 프렛값이 같을 경우 카운팅을 하지 않는다
        }

        System.out.println(count);
    }

}
