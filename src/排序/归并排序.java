package ����;

/**
 * @author 96916
 * ʱ�临�Ӷ��Ϲ鲢�����ܹ��ȶ���O(nlogn)��ˮƽ��
 * ��ÿһ���ĺϲ���������������ܵĲ���������n��
 * �ܵĲ㼶����logn����˵õ����Ľ������O(nlogn)��
 * ���O(nlogn), ����O(nlogn),�ռ临�Ӷ�O(n),�ȶ���
 * �ȷֺ��Ρ�
 */
public class �鲢���� {
	
    private static void mergeSort(int[] nums, int left, int right) {
		if (left >= right) {//�ֵ�ֻ��һ��Ԫ��ʱ����
			return;
		}
	   int mid = left + (right-left)/2;
	   mergeSort(nums, left, mid);
	   mergeSort(nums, mid+1, right);
	   
	   int[] temp = new int[right - left + 1]; // ��ʱ�����źϲ����
	   int i = left, j = mid + 1;//������ĵ�һλ�������������һλ����
	   int cur = 0;//temp������λ��
	   while (i<=mid && j<=right) {// ��ʼ�ϲ�����
		   if (nums[i]>nums[j]) {
			   temp[cur++] = nums[j++];
		   }else {
			   temp[cur++] = nums[i++];
		   }
	   }
	   //��ʣ��Ԫ����ӵ�temp��
	   while (i<=mid) temp[cur++] = nums[i++];
	   while (j<=right) temp[cur++] = nums[j++];
	   for (int k = 0; k < temp.length; k++) {             // �ϲ�������ɣ�������ԭ����������
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
