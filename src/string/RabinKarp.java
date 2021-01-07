package string;

public class RabinKarp
{
    public static void main(String[] args)
    {
        strStr("GEEKS FOR GEEKS","GEEK");
    }

    public  static void strStr(String main, String sub){
        int L = sub.length(), n=main.length();

        if(L>n) return ;

        int a =26;

        long modulus = Integer.MAX_VALUE;


        long hash = 0, refHash =0;
        for(int i=0;i<L;i++){
            refHash = (refHash*a+sub.charAt(i))%modulus;
            hash = (hash*a+main.charAt(i))%modulus;
        }
        if(refHash == hash)
            System.out.println("Index found at -->0");

        long cons = 1;
        for(int i=0;i<L;i++)
            cons = (cons*a)%modulus;
        for(int i=1;i<n-L+1;i++){
            // rolling hash
            hash = ((hash*a - (main.charAt(i-1))*cons)
                                + main.charAt(i+L-1))%modulus;
            if(hash == refHash)
                System.out.println("index found--> at "+i);
        }

        return ;

    }
}
