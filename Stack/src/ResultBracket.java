package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ResultBracket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if(correct(s)){//올바른 괄호 문자열이라면
            Stack<String> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(' || s.charAt(i) == '['){//여는 괄호일 경우 일단 스택에 데이터를 삽입한다
                    stack.push("" + s.charAt(i));
                }else{//닫는 괄호일 경우
                    if(stack.peek().equals("(")){//()인 경우 스택에 값을 2로 바꾼다
                        stack.pop();
                        stack.push("2");
                    }else if(stack.peek().equals("[")){//[]일 경우 스택의 값을 3으로 바꾼다
                        stack.pop();
                        stack.push("3");
                    }else{//괄호 안에 숫자가 있는 경우
                        int count = 0;

                        while(true){
                            String str = stack.pop();

                            if(str.equals("(")){//')'가 들어와 '('까지 탐색한 경우 기존에 더한 값에 2를 곱해준다
                                count *= 2;
                                stack.push("" + count);
                                break;
                            }

                            if(str.equals("[")){//']'가 들어와 '['까지 탐색한 경우 기존에 더한 값에 3을 곱해준다
                                count *= 3;
                                stack.push("" + count);
                                break;
                            }

                            //숫자가 계속 이어지는 경우 count에 값을 누적한다
                            count += Integer.parseInt(str);
                        }
                    }
                }
            }

            int answer = 0;
            //답은 스택에 쌓여있는 숫자들을 모두 더한 값이 된다.
            while(!stack.isEmpty()){
                answer += Integer.parseInt(stack.pop());
            }

            System.out.println(answer);
        }else{//올바른 괄호 문자열이 아니라면
            System.out.println("0");
        }
    }

    //올바른 괄호 문자열인지 판독하는 메서드
    public static boolean correct(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(s.charAt(i) == ']' && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
