package 排序;

/**
 * @author 96916
 * 平均O(nlogn)，最好O(nlogn)，最坏O(n^2)，空间复杂度O(1)
 */
public class 堆排序 {
	
    private static void sortArray(int[] nums) {
		heapify(nums);
		for (int i = nums.length - 1; i >= 1; i--) {
			swap(nums, 0, i);
			rebuildHeap(nums, 0, i-1);
		}
    }

	private static void rebuildHeap(int[] nums, int parent, int last) {
		int left = 2 * parent + 1;  	//左子节点
		int right = 2 * parent + 2;		//右子节点
		int maxIndex = left;
		
		if (right <= last && nums[right] > nums[left]) {
			
			maxIndex = right;  	//找到最大子节点
			
		}
		if (left <= last && nums[parent] < nums[maxIndex]) {
			swap(nums, parent, maxIndex);			//互换为最大子节点
			rebuildHeap(nums, maxIndex, last);  	//继续重建
		}
	}

	private static void heapify(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int parent = (i-1)>>1;
			int child = i;
			while (child > 0 && nums[parent] < nums[child]) {
				swap(nums, parent, child);
				child = parent;
				parent = (parent-1)>>1;
			}
		}
	}
	
	private static void swap(int[] nums, int low, int high) {
		int tem = nums[low];
		nums[low] = nums[high];
		nums[high] = tem;
	}
	
	public static void main(String[] args) {
		int[] a= {2,10,3,6,1,4,1,10,-8,3,8,7,9,2,1};
//			{-74,48,-20,2,10,
//					-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,
//					-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,
//					10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,
//					-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,
//					92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,
//					-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,
//					85,-63,56,55,12,-85,77,-39};
		sortArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
