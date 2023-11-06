class Solution {
    public int hIndex(int[] citations) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        if(citations.length<2 && citations[0] > 0){
            return 1;
        }
        else if(citations.length<2 && citations[0] == 0){
            return 0;
        }
        Arrays.sort(citations);
        for(int i = 0; i<citations.length; i++){
            if(citations[i] == 0){
             count++;
            }
        }
        if( count==citations.length){
            return 0;
        }
        for(int i=0; i<citations.length; i++){
            min = Math.min(citations[i], min);//4
            if(citations[i] == citations.length-i){
             return citations[i];
            }
            if(citations[i] > citations.length-i){
                return citations.length-i;
            }
        }
        return Math.min(citations.length,min);
    }
}
//1,4,7,9
//0,1,3,5,6 
//0,0,4,4