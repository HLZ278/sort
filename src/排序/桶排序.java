package 排序;

import java.util.ArrayList;
import java.util.List;

public class 桶排序 {
	private static void bucketSort(int[] nums) {
	    int INTERVAL = 100;               // 定义桶的大小
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    for (int num : nums) {            // 找到数组元素的范围
	        min = Math.min(min, num);
	        max = Math.max(max, num);
	    }
	    int count = (max - min + 1);      // 计算出桶的数量
	    int bucketSize = (count % INTERVAL == 0) ?( count / INTERVAL) : (count / INTERVAL+1);
	    List<Integer>[] buckets = new List[bucketSize];
	    for (int num : nums) {            // 把所有元素放入对应的桶里面
	        int quotient = (num-min) / INTERVAL;
	        if (buckets[quotient] == null) buckets[quotient] = new ArrayList<>();
	        buckets[quotient].add(num);
	    }
	    int cur = 0;
	    for (List<Integer> bucket : buckets) {
	        if (bucket != null) {
	            bucket.sort(null);       // 对每个桶进行排序
	            for (Integer integer : bucket) {  // 还原桶里面的元素到原数组
	                nums[cur++] = integer;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] a= //{5,2,3,6,1,4,1,10,-8,3,8,7,9,2,1};
		{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
		bucketSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
