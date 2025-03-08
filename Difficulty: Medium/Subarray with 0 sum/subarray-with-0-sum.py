#User function Template for python3

class Solution:
    # Function to check whether there is a subarray present with 0-sum or not.
    def subArrayExists(self, arr):
        prefix_sum_set = set()
        sum = 0

        for num in arr:
            sum += num  # Update running sum

            # If sum becomes 0 or already exists in the set, subarray with sum 0 exists
            if sum == 0 or sum in prefix_sum_set or num == 0:
                return True

            # Store the prefix sum in the set
            prefix_sum_set.add(sum)

        return False


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():
    T = int(input())
    while (T > 0):

        arr = [int(x) for x in input().strip().split()]
        if (Solution().subArrayExists(arr)):
            print("true")
        else:
            print("false")

        T -= 1
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends