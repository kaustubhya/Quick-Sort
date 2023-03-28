import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
         int [] arr = {5,4,3,2,1};
         quickSort(arr, 0, arr.length - 1);
         System.out.println(Arrays.toString(arr));

// Using internal sorting algorighm here as an alternative
        int[] arr2 = {10,9,8,7,6};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // Base Condition

        // here we're not returning anything because
        //  we're not creating a new array, we're just updating the original one

        int start = low;
        int end = high;
        int mid = start + (end-start)/2;
        int pivot = nums[mid];
        // Choosing the center element as the pivot

        // Also a reason why it's already sorted and will never swap
        while (start <= end) {
            while(nums[start] < pivot){
                start++;
            }

            while(nums[end] > pivot) {
                end--;
            }
            // Updating the pointers (start and end)
            /*  if both elements do not satisfy the both conditions i.e. lhs should have
              elements smaller than pivot and rhs should have elements bigger than pivot */

            //   if both the elements match the 2 conditions then swap them
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                // update the start and end index too after swapping
                start++;
                end--;
            }

            // Now we've placed the pivot at the right position, hence time to sort the lhs and rhs subarrays
            // by choosing a new pivot and repeating the same steps
            quickSort(nums, low, end);
            quickSort(nums, start, high);
            
        }




    }
}