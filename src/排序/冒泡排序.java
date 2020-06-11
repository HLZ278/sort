package 排序;

import jdk.nashorn.internal.ir.Flags;

//每趟排序比较相邻的两个数，并进行交换，排序n-1躺后完成  
//最坏复杂度O(n^2), 平均O(n^2), 最好O(n), 空间复杂度O(1) 稳定

public class 冒泡排序 { // O(n*n)

	public static void main(String[] args) {
		int[] a= {5,2,3,6,1,4,1,10,-8,3,8,7,9,2,1};
		//{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
		sortArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private static void sortArray(int[] a) {
		boolean flag = false;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j]>a[j+1]) {
					flag = true;
					swap(a, j, j+1);
				}
			}
			if (flag == false) {
				break;
			}else {
				flag = false;
			}
		}
	}
	private static void swap(int[] nums, int low, int high) {
		int tem = nums[low];
		nums[low] = nums[high];
		nums[high] = tem;
	}
}
