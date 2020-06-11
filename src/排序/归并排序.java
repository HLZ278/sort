package 排序;

/**
 * @author 96916
 * 时间复杂度上归并排序能够稳定在O(nlogn)的水平，
 * 在每一级的合并排序数组过程中总的操作次数是n，
 * 总的层级数是logn，相乘得到最后的结果就是O(nlogn)。
 * 最好O(nlogn), 最坏情况O(nlogn),空间复杂度O(n),稳定。
 * 先分后治。
 */
public class 归并排序 {
	
    private static void mergeSort(int[] nums, int left, int right) {
		if (left >= right) {//分到只有一个元素时返回
			return;
		}
	   int mid = left + (right-left)/2;
	   mergeSort(nums, left, mid);
	   mergeSort(nums, mid+1, right);
	   
	   int[] temp = new int[right - left + 1]; // 临时数组存放合并结果
	   int i = left, j = mid + 1;//左数组的第一位索引，和右组第一位索引
	   int cur = 0;//temp的索引位置
	   while (i<=mid && j<=right) {// 开始合并数组
		   if (nums[i]>nums[j]) {
			   temp[cur++] = nums[j++];
		   }else {
			   temp[cur++] = nums[i++];
		   }
	   }
	   //将剩余元素添加到temp后
	   while (i<=mid) temp[cur++] = nums[i++];
	   while (j<=right) temp[cur++] = nums[j++];
	   for (int k = 0; k < temp.length; k++) {             // 合并数组完成，拷贝到原来的数组中
	        nums[left+k] = temp[k];
	    }
    }

	public static void main(String[] args) {
		int[] a= //{5,2,3,6,1,4,1,10,-8,3,8,7,9,2,1};
			{-74,48,-20,2,10,
					-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,
					-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,
					10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,
					-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,
					92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,
					-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,
					85,-63,56,55,12,-85,77,-39};
		 mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
