package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
'<' 가 있으면 '<'를 포함해 문자를 정방향으로 입력
반대의 경우는 ' '가 나오기 전까지 문자를 역방향으로 바꾼다.
전자는 queue를 후자는 stack를 이용한다.
 */

public class No17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        boolean breaket = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '<'){//'<'가 나온 경우 스택에 담긴 문자를 answer에 붙인다
                while (!stack.empty()){
                    answer.append(stack.pop());
                }
                breaket = true;
                queue.offer(s.charAt(i));
            }else if(s.charAt(i) == '>'){//'>'가 나온 경우 큐에 있는 모든 값들을 answer에 붙인다
                while(!queue.isEmpty()){
                    answer.append(queue.poll());
                }
                answer.append('>');//마지막에 '>'도 붙여야 한다.
                breaket = false;
            }else if(s.charAt(i) != ' ' && !breaket){//띄어쓰기 외의 문자가 나오면서 괄호가 없는 경우 경우 스택에 넣는다.
                stack.push(s.charAt(i));
            }else if(s.charAt(i) != ' ' && breaket){//괄호가 있는 경우는 큐에 넣는다
                queue.offer(s.charAt(i));
            }else if(s.charAt(i) == ' ' && !breaket){//띄어쓰기가 나오고 괄호가 없는 경우 스택의 문자들을 꺼내 붙인다.
                while(!stack.empty()){
                    answer.append(stack.pop());
                }
                answer.append(' ');//띄어쓴 부분도 붙여야 한다.
            }else if(s.charAt(i) == ' ' && breaket){//띄어쓰기가 나오면서 괄호가 아직 안닫혔으면 큐에 문자를 넣는다.
                queue.offer(s.charAt(i));
            }
        }

        if(!stack.empty()){//스택에 남은 문자를 붙인다.
            while (!stack.empty()){
                answer.append(stack.pop());
            }
        }

        if(!queue.isEmpty()){//큐에 남은 문자를 붙인다.
            while (!queue.isEmpty()){
                answer.append(queue.poll());
            }
        }

        System.out.println(answer);
    }
}
