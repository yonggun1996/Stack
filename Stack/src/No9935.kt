package String

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str1 = br.readLine()
    val str2 = br.readLine()

    val stack = Stack<Char>()
    for(i in str1.indices){
        stack.push(str1[i])//입력받은 문자열중 하나의 문자를 스택에 삽입

        val stack2 = Stack<Char>()
        if(stack.size >= str2.length){//폭발 문자열을 비교 가능하다면
            var check = true
            for(j in str2.length - 1 downTo 0){//스택의 값을 꺼내서 각각의 문자열과 맞는지 확인
                val c = stack.pop()
                stack2.push(c)
                if(c != str2[j]){//틀린 부분이 있으면 탐색 중단
                    check = false
                    break
                }
            }

            if(!check){//틀린 부분이 있었다면
                while(stack2.isNotEmpty()){
                    //스택 원위치
                    stack.push(stack2.pop())
                }
            }
        }
    }

    if(stack.isEmpty()){//문자열이 모두 폭발했다면 문자열 출력
        println("FRULA")
    }else{
        val answer = StringBuilder()
        while(stack.isNotEmpty()){//스택에 있는 문자들을 이어 붙인다
            answer.append(stack.pop())
        }
        println(answer.reverse())//이어 붙인 문자열을 뒤집어서 출력한다
    }
}