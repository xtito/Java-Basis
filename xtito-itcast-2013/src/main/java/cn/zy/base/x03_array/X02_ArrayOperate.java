package cn.zy.base.x03_array;

/**
 * 数组排序
 * @author Zy
 *
 */
public class X02_ArrayOperate {
	
	public static void main(String[] args) {
//		int[] array = new int[]{1,5,50,12,35,103,3,45,9,4,55};
//		bubbleSort(array);
//		printArray(array);
		
		int[] arr = {9,12,15,24,36,41,59,68};
		int index = binarySearch1(arr,35);
		System.out.println("index="+index);
	}
	
	/**
	 * 数组排序---选择排序
	 * @param arr 传入要排序的数组
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/**
	 * 数组排序---冒泡排序
	 * @param arr 传入要排序的数组
	 */
	public static void bubbleSort1(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	/**
	 * 二分查找。前提：数组必须是有序的。
	 * 思路：
	 * 1，通过角标先获取中间角标上元素。
	 * 2，让该元素和要找的数据比较。
	 * 3，如果要找的数大了，缩小范围，要找的范围应该是 中间的角标+1---尾角标。
	 * 	如果要找的数小了，要找的范围 头角标---中间角标-1；
	 * 4，不断如此重复，就可以找到元素对应的角标。
	 */
	public static int binarySearch(int[] arr, int key) {
		// 1,定义三个变量，记录头角标，尾角标，中间角标。
		int max, min, mid;
		min = 0;
		max = arr.length - 1;
		mid = (max + min) >> 1;

		while (arr[mid] != key) {
			if (key > arr[mid])
				min = mid + 1;
			else if (key < arr[mid])
				max = mid - 1;

			// 判断元素是否存在。
			if (max < min)
				return -1;

			mid = (max + min) >> 1;
		}

		return mid;
	}

	public static int binarySearch1(int[] arr, int key) {
		// 1,定义三个变量，记录头角标，尾角标，中间角标。
		int max, min, mid;
		min = 0;
		max = arr.length - 1;

		while (min <= max) {
			mid = (min + max) >> 1;

			if (key > arr[mid])
				min = mid + 1;
			else if (key < arr[mid])
				max = mid - 1;
			else
				return mid;
		}
		return -1;
	}
	
	/**
	 * 查找。
	 * 需求；查找一个元素在数组中的第一次出现的位置。
	 */
	public static int searchKey(int[] arr, int key) {
		// 遍历查找。
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] == key)
				return x;
		}
		return -1;// -1,代表的是角标不存在的情况。
	}
	
	/**
	 * 打印数组的方法。
	 * @param arr 传入要打印的数组
	 */
	public static void printArray(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			if (x != arr.length - 1)
				System.out.print(arr[x] + ",");
			else
				System.out.println(arr[x]);
		}
	}
	
	
	
}
