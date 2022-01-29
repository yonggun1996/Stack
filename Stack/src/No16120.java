package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
스택을 이용해 PPAP 문자열인지 확인하는 방법
1. 'P'는 스택에 바로 넣는다
2. 'A'이면서 i가 마지막 부근이라면 스택에 넣는다
3. 이 두 경우를 다 피해가면 스택에 2개의 문자를 꺼낸다 이 때 에러가 발생할 수 있기 때문에 스택 사이즈가 2 이상일 때만 확인한다
4. 두 문자가 'P'이고 다음 문자도 'P'이면 i를 늘린 다음에 'P'를 삽입한다
5. 4번의 경우가 틀릴 경우 문자열 2개와 'A'를 넣는다
6. 스택 사이즈가 1이고 해당 문자열이 'P'면 "PPAP" 출력 그렇지 않으면 "NP" 출력
 */

public class No16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("P")){//P도 PPAP 문자열이기 때문에 PPAP를 출력한다
            System.out.println("PPAP");
            return;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'P'){
                stack.push(str.charAt(i));
            }else if(str.charAt(i) == 'A' && i < str.length() - 1){
                if(stack.size() >= 2){
                    char c1 = stack.pop();
                    char c2 = stack.pop();

                    if(c1 == 'P' && c2 == 'P' && str.charAt(i + 1) == 'P'){
                        i++;
                        stack.push('P');
                    }else{
                        stack.push(c2);
                        stack.push(c1);
                        stack.push(str.charAt(i));
                    }
                }else{
                    stack.push(str.charAt(i));
                }
            }else{
                stack.push(str.charAt(i));
            }
        }

        if(stack.size() == 1 && stack.peek() == 'P'){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }
}
