package ����;
//���Ÿ�λ������ʮλ���������ƣ�ÿ��һ�ν�������µ������У����Ұ�Ͱ��ա�
public class �������� {
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
		//��ȡ���λ��
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max) {
				max = a[i];
			}
		}
		int maxLength = (max+"").length();
		// �����ά�����ʾ10��Ͱ
		int [][] bucket = new int[10][a.length];
		//��¼ÿ��ͬ��Ŷ��ٸ���
		int []	bucketElementCounts = new int[10];
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			for (int j = 0; j < a.length; j++) {
				//ȡÿ��Ԫ�صĸ�λ��,�����ӦͰ��������¼����++
				bucket[a[j] / n % 10][bucketElementCounts[a[j] / n % 10]++] = a[j];
			}
			int index = 0;
			//��Ͱ�����ݷŻ�����
			for (int k = 0; k < bucketElementCounts.length; k++) {
				if (bucketElementCounts[k]!=0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						a[index++] = bucket[k][l];
					}
				}
				//����󽫶�ӦͬͰ���,����ֻ�轫��¼��������
				bucketElementCounts[k] = 0;
			}
		}
		
	}
}
