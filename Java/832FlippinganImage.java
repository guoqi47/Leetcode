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