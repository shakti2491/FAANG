package grokking.BitwiseXOR;

public class ComplementBase10
{
    public static int bitwiseComplement(int num) {
        // TODO: Write your code here
        int bitCount = 0;
        int n = num;
        while(n>0){
            bitCount++;
            n = n>>1;
        }
        int all_bits_set = (int)Math.pow(2,bitCount)-1;
        return  num^all_bits_set;
    }


}
