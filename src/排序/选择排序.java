package 排序;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import sun.tools.jar.resources.jar;
//每趟取出最小元素放到前面
//时间复杂度：
public class 选择排序 {
	public static void main(String[] args) {
		int[] a= {5,2,3,6,1,4,1,10,-8,3,8,7,9,2,1};
		//{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
		sortArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	private static void sortArray(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j]<a[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(a, minIndex, i);
			}
		}
	}

	private static void swap(int[] nums, int low, int high) {
		int tem = nums[low];
		nums[low] = nums[high];
		nums[high] = tem;
	}
}
