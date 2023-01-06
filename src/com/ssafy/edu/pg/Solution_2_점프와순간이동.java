package com.ssafy.edu.pg;

import java.util.*;

class Solution_2_점프와순간이동 {

    public class Solution {
        public int solution(int n) {
            int ans = 1;
            while (n > 1) {
                if (n % 2 == 1) ans++;
                n /= 2;
            }
            return ans;
        }
    }
}