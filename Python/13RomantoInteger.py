class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        #My Straightforward Python Solution
        
        
        #Acc
        count=0
        while 'IV' in s or 'IX' in s or 'XL' in s or 'XC' in s or 'CD' in s or 'CM' in s :
            if 'IV' in s:
                count+=4
                s = s.replace('IV','')
            elif 'IX' in s:
                count+=9
                s = s.replace('IX','')
            elif 'XL' in s:
                count+=40
                s = s.replace('XL','')
            elif 'XC' in s:
                count+=90
                s = s.replace('XC','')
            elif 'CD' in s:
                count+=400
                s = s.replace('CD','')
            else:
                count+=900
                s = s.replace('CM','')
        for i in s:
            if i=='I':
                count+=1
            elif i=='V':
                count+=5
            elif i=='X':
                count+=10
            elif i=='L':
                count+=50
            elif i=='C':
                count+=100
            elif i=='D':
                count+=500
            else:
                count+=1000
        return count
                    
