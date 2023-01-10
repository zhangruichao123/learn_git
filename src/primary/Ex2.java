package primary;
//简单运算
public class Ex2 {
	//插入排序
	public static void insertionSort2(int[] arr) {
		System.out.println("insertionSort2");
		if(arr == null || arr.length<2) {
			return;
		}
//		0~0完成
//		0~1
//		0~2
//		0~3
//		0~n-1
		for(int end=1;end<arr.length;end++) {
			for(int preNum=end-1;preNum>=0&&arr[preNum]>arr[preNum+1];preNum--) {
				swap(arr,preNum,preNum+1);
			}
		}
	}
	//插入排序
	public static void insertionSort1(int[] arr) {
		System.out.println("insertionSort1");
		if(arr == null || arr.length<2) {
			return;
		}
//		0~0完成
//		0~1
//		0~2
//		0~3
//		0~n-1
		for(int end=1;end<arr.length;end++) {
			int newIndexNum=end;
			while(newIndexNum-1>=0&&arr[newIndexNum-1]>arr[newIndexNum]) {
				swap(arr,newIndexNum-1,newIndexNum);
				newIndexNum--;
			}
		}
	}
	//冒泡排序
	public static void bubbleSort(int[] arr) {
		System.out.println("bubbleSort");
		if(arr == null || arr.length<2) {
			return;
		}
//		0~n-1
//		0~n-2
//		0~n-3
		for(int end=arr.length-1;end>=0;end--) {
			for(int second=1;second<=end;second++) {
				if(arr[second-1]>arr[second]) {
					swap(arr,second-1,second);
				}
			}
		}
	}
	//选择排序
	public static void selectionSort(int[] arr) {
		System.out.println("selectionSort");
		if(arr == null || arr.length<2) {
			return;
		}
//		0~n-1
//		1~n-1
//		2~n-1
		for(int i=0;i<arr.length;i++) {
			int minNum=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minNum]>arr[j]) {
					minNum=j;
				}
			}
			swap(arr,i,minNum);
		}
	}
	//交换
	public static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	//输出
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
/*		int[] arr= {3,9,2,1,5,4};
		printArray(arr);
//		selectionSort(arr);
//		bubbleSort(arr);
//		insertionSort1(arr);
		insertionSort2(arr);
		printArray(arr);*/

		//对数器测试，大样本随机测试
		int maxLen=50;
		int maxVal=1000;
		int testTime=1000;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Comp.randomArr(maxLen, maxVal);
			insertionSort2(arr);
			if (!Comp.isSort(arr))
				System.out.println("排序出错了");
		}
	}

}
