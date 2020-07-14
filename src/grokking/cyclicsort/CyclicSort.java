package grokking.cyclicsort;

public class CyclicSort
{
    public static void sort(int[] nums) {
        // TODO: Write your code here
        int i =0;
        while(i<nums.length){
            if(nums[i]!=i+1){
                // swap to actual place
                int index = nums[i];
                int temp = nums[index-1];
                nums[index-1] = index;
                nums[i] = temp;

            }else {
                i++;
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
