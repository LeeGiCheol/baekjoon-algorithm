package me.gicheol.algorithm.baekjoon._220101;

import java.util.Scanner;

/*
문제
임한수와 임문빈은 서로 사랑하는 사이이다.

임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.

임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.

임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.

입력
첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.

출력
첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.

예제 입력 1
AABB
예제 출력 1
ABBA
예제 입력 2
AAABB
예제 출력 2
ABABA
예제 입력 3
ABACABA
예제 출력 3
AABCBAA
예제 입력 4
ABCD
예제 출력 4
I'm Sorry Hansoo
*/
public class _04_1213 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] palindrome = new int[26];

        int oddCnt = 0;
        int oddNum = -1;

        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            int number = str.charAt(i) - 65;
            palindrome[number]++;
        }


        for (int i = 0; i < 26; i++) {
            if ((palindrome[i] & 1) == 1) {
                oddCnt++;
                oddNum = i;
            }
        }

        if (oddCnt >= 2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < palindrome.length; i++) {
            for (int j = 0; j < palindrome[i] / 2; j++) {
                System.out.printf("%c", i + 65);
            }
        }
        if (oddNum != -1) {
            System.out.printf("%c", oddNum + 65);
        }

        for (int i = palindrome.length - 1; i >= 0; i--) {
            for (int j = 0; j < palindrome[i] / 2; j++) {
                System.out.printf("%c", i + 65);
            }
        }
    }

}
