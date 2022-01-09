package me.gicheol.algorithm.baekjoon._220109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다.

출력
1로 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력한다.

예제 입력 1
3
7
9901
예제 출력 1
3
6
12
 */
public class _04_4375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = null;



        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int cnt = 1;
            int ret = 1;

            while (true) {
                if (cnt % n == 0) {
                    System.out.println(ret);
                    break;
                } else {
                    cnt = (cnt * 10) + 1;
                    cnt %= n;
                    ret++;
                }
            }
        }
    }

}
