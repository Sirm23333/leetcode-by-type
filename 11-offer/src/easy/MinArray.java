package easy;

public class MinArray {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        int mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(numbers[mid] > numbers[right]){
                left = mid;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else {
                right--;
            }
        }
        return left;
    }
}
