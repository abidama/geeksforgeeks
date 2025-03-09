//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        // Transform string with boundaries to handle even-length cases
        String t = preprocess(s);
        int n = t.length();
        int[] P = new int[n];  // Array to store palindrome radii
        int C = 0, R = 0;      // Center and Right boundary
        
        int maxLen = 0, centerIndex = 0;
        
        for (int i = 0; i < n; i++) {
            int mirror = 2 * C - i;  // Mirror index of i around center C
            
            // Use previously computed palindrome information
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }
            
            // Expand palindrome centered at i
            while (i + P[i] + 1 < n && i - P[i] - 1 >= 0 &&
                   t.charAt(i + P[i] + 1) == t.charAt(i - P[i] - 1)) {
                P[i]++;
            }
            
            // Update center and right boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
            
            // Keep track of longest palindrome found
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        
        // Extract original substring
        int start = (centerIndex - maxLen) / 2;  // Convert back to original indices
        return s.substring(start, start + maxLen);
    }
    
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        return sb.toString();
    }
}

