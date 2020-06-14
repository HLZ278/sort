package 排序;

/**
 * @author 96916
 * 
 * 平均O(nlogn)，最好O(nlogn)，最坏O(n^2)，空间复杂度O(1)
 * 操作的是数组，但逻辑上为堆
 * 
 * 大根堆定义：每个节点都大于它的子节点
 * 小根堆相反
 * 
 * 升序排序
 * 分两个步骤
 * 步骤一：大根堆构建
 * 第一遍：找到第一个非根叶节点，
 * 然后与其父节点（现在也是根节点使用公式：父节点下标=(i-1)/2）进行比较，
 * 如果大于的进行交换（如果两个都大于直接先交换左子节点）:
 *     4			    6
 *   6   8     => 	  4	  8   		
 * 5   9		    5   9
 * 
 * [4,6,8,5,9]	   [6,4,8,5,9]
 * 第二遍，找到第二个非根节点，重复以上步骤
 *     6			   8	
 *   4	 8   =>		 4   6	
 * 5   9		   5   9	
 * 
 * [6,4,8,5,9]	   [8,4,6,5,9] 
 * 第三遍，找到第三个非根节点，重复以上步骤后发现第三个非根节点有父节点
 * 所以进行回溯比较
 *     8			8			  8	
 *   4   6	 =>	  5	  6    =>   5   6
 * 5   9		4	9		  4	  9
 * [8,4,6,5,9]  [8,5,6,4,9]  [8,5,6,4,9] 
 * 第四遍，找到第四个非根节点，重复以上步骤后发现第四个非根节点有父节点
 * 所以进行回溯比较
 *     8			8			  9	
 *   5   6	 =>	  9	  6    =>   8   6
 * 4   9		4	5		  4	  5
 * [8,5,6,4,9]  [8,9,6,4,5]  [9,8,6,4,5] 
 * 
 * 步骤二：
 * 
 * 将堆顶元素与末尾元素交换，使末尾元素最大，然后重构堆
 * 重构规则：节点与其子节点中最大的交换，交换完后继续递归
 * 使得除了堆尾元素的其他元素变成大根堆，
 * 这样堆顶又是个最大（第二大）的元素
 * 然后与倒数第二个元素交换，如此反复即可一点点的从大到小的顺序将
 * 元素放到数组尾部。 以下交换用A表示，重构用B表示
 * 
 * 		9	  A		  5		 B		|8|		A	    4		B	   |6|		 A		4	   B	    |5|		 A		4		B	  |4| 
 * 	  8	  6	  =>    8   6    =>	  |5___6|   =>    5   6     =>	 |5___4|     =>   5	  6    =>    |4|    6    =>   5   6    	=>	 5	 6	 
 * 	4   5		  4   9			|4|  9 		    8   9			8   9 			8	9 			8	 9			8	9		   8   9
 * 
 * [9,6,8,4,5]   [5,8,6,4,9]    [8,5,6,4,9]     [4,5,6,8,9]  	  [6,5,4,8,9]	[4,5,6,8,9]	 	[5,4,6,8,9]		[4,5,6,8,9]	   [4,5,6,8,9]
 */


//可以打开打印注释，但是打印耗时，最好把数量级设非常少
public class 堆排序 {
	
    private static void sortArray(int[] nums) {
    	//步骤一
		heapify(nums);
//		System.out.print("步骤一:");
//		for (int i : nums) {
//			System.out.print(i);
//		}
//		System.out.println();
		//步骤二
		
		for (int i = nums.length - 1, j = 1; i >= 1; i--, j++) {
			//根顶与数组末尾元素交换
			swap(nums, 0, i);
//			System.out.print("步骤二---第"+j+"次交换:");
//			for (int n : nums) {
//				System.out.print("=>"+n);
//			}
//			System.out.println();
			rebuildHeap(nums, 0, i-1);
//			System.out.print("步骤二---第"+j+"次重构:");
//			for (int n : nums) {
//				System.out.print("=>"+n);
//			}
//			System.out.println();
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
	//步骤一：建堆
	private static void heapify(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			//获取父节点: 父节点 = （子节点-1）/ 2
			int parent = (i-1)>>1;
			int child = i;
			//不单单比较交换一次，还需要回溯比较交换，一直比较交换到根节点处
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
//		int[] a= //{4,6,8,5,9};
//			{-74,48,-20,2,10,
//					-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,
//					-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,
//					10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,
//					-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,
//					92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,
//					-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,
//					85,-63,56,55,12,-85,77,-39};
		int[] arr = new int[ 8000000] ;
		for (int n = 0; n < 8000000; n++) {
			arr[n] = (int) (Math.random() * 8000000) ;
		}
		sortArray(arr);
	}
}
