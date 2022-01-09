package me.gicheol.algorithm.baekjoon._220109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

출력
첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.

예제 입력 1
10 11 12
예제 출력 1
4
 */
public class _03_1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long solution = solution(a, b, c);
        System.out.println("solution = " + solution);
    }

    private static long solution(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long temp = solution(a, (b / 2), c);


        if ((b & 1) == 1) {
            return (temp * temp % c) * a % c;
        }

        
        return temp * temp % c;
    }

}
