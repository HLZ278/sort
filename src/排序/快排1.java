package ����;

/**
 * @author 96916
 *��������(Quicksort) �Ƕ�ð�������һ�ָĽ�������˼����:ͨ��һ������
��Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ����� ���ݶ�������һ����
���������ݶ�ҪС��Ȼ���ٰ��˷����������������ݷֱ���п�����������
������̿��Եݹ���У��Դ˴ﵽ�������ݱ����������
*ʱ�临�Ӷ�  ƽ��O(nlogn)��O(nlogn)��O(n^2)��O(logn)  ���ȶ�
 */
public class ����1 {//˫ָ��ͬʱ�ƶ�
	public static void sortArray(int[] nums, int left, int right) {
		int low = left + 1;
		int high = right;
		if (low >= high) {
			return; 
		}
		while(true) {
			while (low<=high&&nums[low]<nums[left]) {
				low++;
			}
			while (left<=high&&nums[high]>nums[left]) {
				high--;
			}
			
			if (low>high) {
				break;
			}
			swap(nums, low, high);
			low++;
			high--;
		}
		swap(nums, left, high);//��׼ֵ����
		sortArray(nums, left, high-1);
		sortArray(nums, high+1, right);
		return;
	}
	
	private static void swap(int[] nums, int low, int high) {
		int tem = nums[low];
		nums[low] = nums[high];
		nums[high] = tem;
	}

	public static void main(String[] args) {
		int[] a= //{5,2,3,6,1,4,1,10,-8,3,8,7,9,2,1};
		{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
		sortArray(a, 0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
