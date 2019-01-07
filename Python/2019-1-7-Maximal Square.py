Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


class Solution:
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # DP思想 https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-Dynamic-Programming
        # 画图可知，对于dp[i][j]，dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]可将上一情况（边长-1）的其他点全覆盖
        # 代码实现 https://leetcode.com/problems/maximal-square/discuss/61935/6-lines-Visual-Explanation-O(mn)
        
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                matrix[i][j] = int( matrix[i][j])
                if matrix[i][j] and i and j:
                    matrix[i][j] = min(matrix[i][j-1],matrix[i-1][j],matrix[i-1][j-1])+1
        return len(matrix) and max(map(max,matrix))**2 #求矩阵matrix中的最大元素
        # return小技巧：全为and，如果都为真，则返回最后一个变量值；如果为假，则返回第一个假值
        
        
        