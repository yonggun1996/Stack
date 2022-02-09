package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/*
후위표기식을 토대로 계산을 하는 문제
먼저 각 알파벳에 따른 수를 맵에 저장한다
스택에는 알파벳만 들어갈 수 있고 연산자의 경우는 두 수를 스택에서 빼서 값을 구한 후 스택에 넣는다
이 때 계산을 할 때 제일 나중에 나온 수를 기준으로 연산을 한다.
그렇게 스택에 남은 수를 소수점 둘째자리까지 출력하면 정답이 되는 문제
 */

public class No1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        HashMap<Character, Double> map = new HashMap<>();
        char key = 'A';
        for(int i = 1; i <= n; i++, key++){
            double num = Double.parseDouble(br.readLine());
            map.put(key, num);
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                stack.push(map.get(s.charAt(i)));
            }else{
                double n1 = stack.pop();
                double n2 = stack.pop();
                stack.push(operation(s.charAt(i), n1, n2));
            }
        }

        System.out.printf("%.2f", stack.peek());
    }

    static double operation(char op, double num1, double num2){
        double result = 0;
        switch (op){
            case '+' :
                result = num2 + num1;
                break;

            case '-' :
                result = num2 - num1;
                break;

            case '*' :
                result = num2 * num1;
                break;

            case '/' :
                result = num2 / num1;
                break;
        }

        return result;
    }
}