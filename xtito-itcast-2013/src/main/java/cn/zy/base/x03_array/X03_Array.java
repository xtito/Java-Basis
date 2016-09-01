package cn.zy.base.x03_array;

/**
 * 二维数组
 * @author Zy
 *
 */
public class X03_Array {
	
	public static void main(String[] args) {
		
//		int[][] array = new int[3][];//明确了二维数组的长度，没有明确具体的一维数组。
//		System.out.println(array);//[[I@3e0ebb
//		System.out.println(array[0]);//null
//		System.out.println(array[0][0]);//NullPointerException
		
//		int[][] arr = {{23,17,11},{88,11,33,90}};
//		System.out.println(arr[0][0]);
//		System.out.println(arr[1][0]);
		
		/*
		二维数组的另一种定义方式。
		*/
		int[][] arr = {{23,17,11},{88,11,33,90},{11,78,34}};

		//求和。
		int sum = 0;
		for(int x=0; x<arr.length; x++)//遍历二维数组
		{
			for(int y=0; y<arr[x].length; y++)
			{
				sum+=arr[x][y];
			}
		}

		int[] array = { 23, 17, 11, 88, 11, 33, 90, 11, 78, 34 };
		System.out.println("sum="+sum);
		reverse(array);// 数组反转
		printArray(array);
	}
	
	/*
	对一个给定的数组进行反转。
	{23,14,88,5} ->
	{5,88,14,23}
	*/
	public static void reverse(int[] arr) {
		for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
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
