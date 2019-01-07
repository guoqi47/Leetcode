Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: int
        """
        # m, n = len(s1), len(s2)
        # dp = [[[0] for i in range(n+1)] for j in range(m+1)] # m,n 的顺序,此处n是列数，m是行数
        dp = [[0]*(len(s2)+1) for _ in range(len(s1)+1)] #这句比上两句快
        # //这里申请二维数组大小为[s1.length()+1][s2.length()+1]
        # //原因是要记录一个字符串为空,另一个非空的情况
        # //若申请空间为[s1.length()][s2.length()]
        # //则dp[0][x]是第一个字符串有一个字符的情况下计算所得，不是空的情况
        for i in range(m+1):
            for j in range(n+1):
                if i==0 or j==0:
                    dp[i][j] = max(sum([ord(a) for a in s1[:i]]), sum([ord(a) for a in s2[:j]])) 
                    #ord() Get the ASCII number of a character
                elif s1[i-1]==s2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j]+ord(s1[i-1]), dp[i][j-1]+ord(s2[j-1]))
        return dp[m][n]
                
                