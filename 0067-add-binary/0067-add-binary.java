class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            return addBinary(b,a) ;
        }
        int i = a.length() - 1 , j = b.length() - 1 ;
        StringBuilder sb = new StringBuilder() ;
        int carry = 0 ;
        while( j != -1 ){
            int ch1 = b.charAt(j) - '0' ;
            int ch2 = a.charAt(i) - '0' ;
            sb.insert(0,(ch1^ch2^carry)+"") ;
            carry = (ch1+ch2+carry) /2 ;
            j--;
            i-- ;
        }
        while(i!=-1){
            int ch = a.charAt(i)-'0';
            sb.insert(0,(ch^carry) + "");
            carry = (carry+ch )/2 ;
            i--;
        }
        if(carry == 1){
            sb.insert(0,"1");
        }
        return sb.toString() ;
    }
}