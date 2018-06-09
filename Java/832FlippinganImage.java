Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]


//原始解法
// class Solution {
//     public int[][] flipAndInvertImage(int[][] A) {
//         for(int[] rows:A){
//             int N = rows.length;
//             for(int i=0;i<=N/2;i++){
//                 if(i==N/2){
//                     if(N%2==1){
//                         rows[i] = 1-rows[i];
//                     }
//                     else{
//                         break;
//                     }
//                 }
//                 else if(rows[i]==rows[N-1-i]){
//                     rows[i]=1-rows[i];
//                     rows[N-1-i] = 1-rows[N-1-i];
//                 } 
//             }
//         }
//         return A;
//     }
// }

//new
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] rows:A){
            int N = rows.length;
            for(int i=0;i*2<N;i++){
                if(rows[i]==rows[N-1-i]){
                    rows[i]=rows[N-1-i]^=1;
                } 
            }
        }
        return A;
    }
}
