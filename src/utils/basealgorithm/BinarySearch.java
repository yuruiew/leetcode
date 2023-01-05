package utils.basealgorithm;

public class BinarySearch {

    /**
     * 二分查找
     * @param array
     * @param target
     * @return
     */
    public static boolean searchInArray(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (target < array[mid]){
                right = mid - 1;
            }else if (target > array[mid]){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
