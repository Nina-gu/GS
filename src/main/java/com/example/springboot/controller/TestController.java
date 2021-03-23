package com.example.springboot.controller;

import com.example.springboot.dao.TestDAO;
import com.example.springboot.entity.Palindrome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestDAO testDAO;

    @GetMapping("/{string}")
    @ResponseBody
    public Palindrome longestPalindrome(@PathVariable(value = "string") String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int longest = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
                if(dp[j][i] && longest < i - j + 1) {
                    longest = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        String longestP = s.substring(start, end + 1);
        Palindrome p = null;
        p.setLongest(longestP);
        testDAO.saveLongest(p);
        return p;
    }
}