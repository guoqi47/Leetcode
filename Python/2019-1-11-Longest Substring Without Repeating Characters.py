Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 字节跳动面试题
        # 不知道那个时候为啥没有想到两个指针
        i, j = 0, 1
        maxNum = 0
        while j<=len(s): # 注意这里有等号
            if j-i == len(set(s[i:j])):
                maxNum = max(maxNum,j-i)
            else:
                i = j-s[:j-1][::-1].index(s[j-1])-1
            j+=1
        return maxNum 