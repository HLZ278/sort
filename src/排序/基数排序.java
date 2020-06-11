package 排序;
//先排个位，再排十位，依次类推，每排一次将结果更新到数组中，并且把桶清空。
public class 基数排序 {
	public static void main(String[] args) {
		int[] a= {5,2,3,6,1,4,1,10,8,3,8,7,9,2,1};
//		int[] arr = new int[ 80000000] ;
//		for (int n = 0; n < 80000000; n++) {
//			arr[n] = (int) (Math.random() * 8000000) ;
//		}
		//{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
		sortArray(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private static void sortArray(int[] a) {
		//获取最大位数
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max) {
				max = a[i];
			}
		}
		int maxLength = (max+"").length();
		// 定义二维数组表示10个桶
		int [][] bucket = new int[10][a.length];
		//记录每个同存放多少个数
		int []	bucketElementCounts = new int[10];
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			for (int j = 0; j < a.length; j++) {
				//取每个元素的个位数,放入对应桶，并将记录数组++
				bucket[a[j] / n % 10][bucketElementCounts[a[j] / n % 10]++] = a[j];
			}
			int index = 0;
			//将桶中数据放会数组
			for (int k = 0; k < bucketElementCounts.length; k++) {
				if (bucketElementCounts[k]!=0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						a[index++] = bucket[k][l];
					}
				}
				//处理后将对应同桶清空,这里只需将记录数组清零
				bucketElementCounts[k] = 0;
			}
		}
		
	}
}
