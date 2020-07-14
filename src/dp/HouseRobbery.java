package dp;

public class HouseRobbery
{
    public static void main(String[] args)
    {
        rob(new int[]{1,2,3,1});
    }
    static int rob(int[] nums) {

        if(nums.length == 0)
            return 0;

        if(nums.length==1)
            return nums[0];
        int mem[] = new int[nums.length];
        mem[0] = nums[0];
        mem[1] = Math.max(nums[1], nums[0]);

        for(int i =2;i<nums.length;i++){

            mem[i] = Math.max(mem[i-1], mem[i]+mem[i-2]);

        }

        return mem[nums.length-1];

    }
}
