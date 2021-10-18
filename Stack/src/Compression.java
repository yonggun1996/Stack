package com.company;

import java.io.*;
import java.util.*;

/*
기존에는 스택에 문자, 문자열을 넣었지만 메모리 초과 발생
스택에 문자의 길이를 넣는 방식으로 변경
0 ~ 9가 오면 길이를 늘린다
'('가 오면 길이를 줄이고 길이 스택에 값을 넣는다. 그리고 '('이전의 숫자를 count 스택에 넣는다
')'가 오면 count스택을 꺼내 기존 길이와 곱하고 length 스택을 꺼내 기존 값과 더한다
 */

public class Compression {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> len_stack = new Stack<>();
        Stack<Integer> cnt_stack = new Stack<>();

        int length = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                length++;
            }else if(s.charAt(i) == '('){
                length--;
                len_stack.push(length);
                cnt_stack.push(s.charAt(i - 1) - '0');
                length = 0;
            }else{
                length *= cnt_stack.pop();
                length += len_stack.pop();
            }
        }

        System.out.println(length);
    }
}
