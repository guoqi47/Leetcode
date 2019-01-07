Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


class Solution:
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 三种方法：1.从中心扩展 2.DP 3.暴力
        # 从中心扩展, self的使用
        # 参考：https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
        # 分奇偶数两种情况
        def helper(self, i, j):
            count=0
            while i-count>=0 and j+count<len(s) and s[i-count]==s[j+count]:
                self.res+=1
                count+=1
             
        self.res=1
        for i in range(len(s)-1):
            helper(self,i,i) #奇数
            helper(self,i,i+1) #偶数 
        return self.res
        
        # DP解 https://leetcode.com/problems/palindromic-substrings/discuss/128581/Easy-to-understand-Python-DP-solution
         #A DP solution to this problem is to build a table with all possible string[start:end] combinations, storing which are palindromes and which are not (True or False). At any given moment, when you're checking if string[i:j] is a palindrome, you only need to know two things:

        # Is string[i] equal to string[j]?
        # Is string[i+1:j-1] a palindrome?
        # For condition (1), a simple check might do, for condition (2), you use the table. If both conditions are met, mark table[i][j] as True and increase your count.
#         n = len(s)
#         count = n
#         table = [[False for i in range(n)] for i in range(n)]
        
#         for i in range(n):
#             table[i][i] = True
#         for i in range(n-1):
#             if s[i]==s[i+1]:
#                 table[i][i+1] = True
#                 count+=1
        
#         # 产生的i,j和下面的一样，但是顺序不一样，应该先产生间隔小的i,j,后产生间隔大的i,j
#         # for i in range(n-2):
#         #     for j in range(i+2,n):
#         #         if s[i]==s[j] and table[i+1][j-1]:
#         #             count+=1
#         #             table[i][j]=True
#         for k in range(3,n+1):
#             for i in range(0,n-k+1):
#                 j = i+k-1
#                 if s[i]==s[j] and table[i+1][j-1]:
#                     count+=1
#                     table[i][j]=True
#         return count
        
        
        
        
        
        
        
        # 暴力解,超内存，改list生成式为generator后可以
        # define a function to get all substring
        # define a funcition to check if it is palindromic string
        # count the number
        
#         def getAllSubString(s):
#             return [s[i:j] for i in range(len(s)) for j in range(i+1,len(s)+1)] 
            
#         y = lambda x:x==x[::-1]
#         res = getAllSubString(s)
#         count=0
#         for i in res:
#             if y(i):
#                 count+=1
#         return count
        