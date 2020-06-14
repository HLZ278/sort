package 排序;
//没排一次将整数组基于基准值划分为两个部分，其中左部分的元素都是比右部分小
public class 快排2 {//双指针单个移动
	public static void sortArray(int[] nums, int left, int right) {
		int low = left+1;
		int hi = right;
		if (low>hi) {
			return;
		}
		while(low<=hi) {
			if (nums[low]>nums[left]) { // 交换元素确保左侧指针指向元素小于分界点元素
				swap(nums, low, hi);
				hi--;
			}else {
				low++;
			}
		}
		low--; // 回到小于分界点元素数组的最右侧
		swap(nums, left, low);          // 将分界点元素移到左侧数组最右侧
		sortArray(nums, left, low-1);
		sortArray(nums, low+1, right);
		
	}
	
	private static void swap(int[] nums, int low, int high) {
		int tem = nums[low];
		nums[low] = nums[high];
		nums[high] = tem;
	}

//	public static void main(String[] args) {
//		int[] a= {5,2,3,6,1,4,1,10,-8,3,8,7,9,2,1};
//		//{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
//		sortArray(a, 0, a.length-1);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
//	}
}