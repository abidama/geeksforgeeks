//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

import java.util.HashMap;

class Solution {
    // Function to count the number of subarrays which add to the given sum.
    static int subArraySum(int arr[], int tar) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0, sum = 0;

        // Initialize with sum 0 occurring once (important for subarrays starting at index 0)
        prefixSumMap.put(0, 1);

        for (int num : arr) {
            sum += num; // Update running sum

            // If (sum - tar) exists, it means there's a subarray with sum = tar
            if (prefixSumMap.containsKey(sum - tar)) {
                count += prefixSumMap.get(sum - tar);
            }

            // Store sum occurrences in HashMap
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends