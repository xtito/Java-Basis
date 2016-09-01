package cn.zy.base.x03_array;

public class X01_ArrayOperate {
	public static void main(String[] args) {
//		int[] array = new int[]{1,5,50,12,35,103,3,45,9,4,55};
//		System.out.println(toSytring(array));
//		System.out.println(getWeek(2));
		
		int num = 60;
		System.out.println("十进制转二进制：    " + toBinary1(num));
		System.out.println("十进制转八进制：    " + toOctal1(num));
		System.out.println("十进制转十六进制：" + toHex1(num));
		
		System.out.println("Integer十进制转  二  进制：" + Integer.toBinaryString(60));
		System.out.println("Integer十进制转  八  进制：" + Integer.toOctalString(60));
		System.out.println("Integer十进制转十六进制：" + Integer.toHexString(60));
	}
	
	
	/**
	 * 需求：获取多个整数中最大值
	 * 思路：
	 * 		1、数据多了为了便于操作，先存储起来，需要容器，用数组
	 * 		2、多个数组需要进行比较，每次都有较大的数据，需要刻录下来和下一个数比较
	 * 		3、将数组中的元素都比一遍，最后，就有了最大值
	 * 步骤：
	 * 		1、需要数组
	 * 		2、定义一个变量刻录较大的数
	 * 		3、对数组进行遍历，让元素和较大的值进行比较
	 * 			如果元素大于较大的数，用变量记录该元素
	 * 		4、遍历完成后，变量中就是最大值
	 */
	public static int getMax(int[] array) {
		// 定义变量，初始化为数组中的任意一个元素
		int max = array[0];
		// 遍历数组
		for (int i=0; i<array.length; i++) {
			// 遍历的元素只要比max大，就用max记录下来，遍历到最后 max中记录的就是最大值
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	public static int getMax_2(int[] array) {
		int max = 0;// 初始化数组中的任意一个角标
		for (int i=1;  i<array.length; i++) {
			if (array[i] > array[max]) {
				max = i;
			}
		}
		return array[max];
	}
	
	/**
	 * 九九乘法表
	 */
	public static void print99() {
		for (int i=1; i<=9; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print(j + "*" + i + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 需求：定义功能，将{34,12,67}数组中的元素转换成字符串"[32,12,67]"
	 * 思路：简单的方式就是利用了字符串和任何数据相加都是相连接
	 */
	public static String toSytring(int[] array) {
		// 定义字符串变量
		String temp = "[";
		// 遍历数组，将每一个数组的元素和字符串相连接
		for (int i=0; i<array.length; i++) {
			// 判断，不是最后一个元素，后面连接逗号，是最后一个元素，后面不连接逗号
			if (i != array.length -1) {
				temp = temp + array[i] + ",";
			} else {
				temp = temp+array[i] + "]";
			}
		}
		// 将连接后 字符串返回
		return temp;
	}
	
	/**
	 * 查表法：
	 * 定义一个功能，根据给定的数据获取对应的星期
	 */
	public static String getWeek(int num) {
		if (num > 7 || num < 1) {
			// throw new RuntimeException(num + "没有对应的星期");
			return num + "没有对应的星期";
		}
		// 定义一个数组，存储固定的星期数据
		String[] weeks = {"", "星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		return weeks[num];
	}
	
	
	/**
	 * 将十进转转成十六进制---数组版
	 * 需求：十进制-->十六进制。
	 * &15  >>>4  循环
	 * 遇到问题：
	 * 1，顺序反了。2，去除多余的0.
	 * 
	 * 解决方式：
	 * 1，每运算出一位，不要打印，先存储。需要容器。
	 */
	public static String toHex(int num) {
		//1,定义容器。存储的是字符，长度为8.一个整数最多8个16进制位。
		char[] chs = new char[8];
		//2,定义一个用于操作数组的索引。
		int index = chs.length-1;

		for(int x=0; x<8; x++) {
			int temp = num & 15;
			if(temp > 9) {
				chs[index] = ((char)(temp-10+'A'));
			} else {
				chs[index] = ((char)(temp+'0'));
			}
			index--;
			num = num >>> 4;
		}
		return "0x"+toString(chs);
	}
	
	/**
	 * 定义一个功能，将字符数组转成字符串。
	 */
	public static String toString(char[] arr) {
		String temp = "";
		for(int x=0; x<arr.length; x++) {
			temp = temp + arr[x];
		}
		return temp;
	}
	
	/**
	 * 将十进转转成十六进制---去零版
	 * 需求：十进制-->十六进制。
	 * &15  >>>4  循环  
     * 
	 * 遇到问题：
	 * 1，顺序反了。2，去除多余的0.
     * 
	 * 解决方式：
	 * 1，每运算出一位，不要打印，先存储。需要容器。
     * 
	 * 2,去除零？需要转换的数据会不断的右移，如果右移后剩余的二进制都是0，也就是没有有效位，
	 * 就不需要进行&运算了。也就是不需要在往数组中存储了。
	 */
	public static String toHexs(int num) {

		// 1,定义容器。存储的是字符，长度为8.一个整数最多8个16进制位。
		char[] chs = new char[8];
		// 2,定义一个用于操作数组的索引。
		int index = chs.length;

		while (num != 0) {
			int temp = num & 15;

			if (temp > 9)
				chs[--index] = ((char) (temp - 10 + 'A'));
			else
				chs[--index] = ((char) (temp + '0'));

			num = num >>> 4;
		}
//		System.out.println("index=" + index);
		return "0x" + toString(chs, index);
	}
	
	/**
	 * 将十进转转成十六进制---查表版
	 * 需求；十进制-->十六进制，终结版。
	 * 思路：
	 * 十进制转成十六进制的每一位都是十六进制元素中的某一个。
	 * 十六进制的元素有很多固定个数。而且还有对应的编号。
	 * 所以可以使用传说中的 查表法！
	 */
	public static String toHexFindTable(int num) {
		// 1,建立表。
		char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		// 2,创建临时容器。
		char[] arr = new char[8];

		// 3,创建操作临时容器的角标。
		int index = arr.length;

		// 4,通过循环对num进行& >>等运算。
		while (num != 0) {
			// 5,对num进行&运算。
			int temp = num & 15;
			// 6,根据&运算后的结果作为角标查表，获取对应的字符。并将字符存储到临时容器中。
			arr[--index] = chs[temp];
			// 7,对num进行右移。
			num = num >>> 4;
		}

		return "0x" + toString(arr, index);
	}
	
	/**
	 * 十进制转二进制--通用版
	 */
	public static String toBinary(int num) {
		// 1,建立表。
		char[] chs = { '0', '1'};
		// 2,创建临时容器。
		char[] arr = new char[32];

		// 3,创建操作临时容器的角标。
		int index = arr.length;

		// 4,通过循环对num进行& >>等运算。
		while (num != 0) {
			// 5,对num进行&运算。
			int temp = num & 1;
			// 6,根据&运算后的结果作为角标查表，获取对应的字符。并将字符存储到临时容器中。
			arr[--index] = chs[temp];
			// 7,对num进行右移。
			num = num >>> 1;
		}

		return toString(arr, index);
	}
	
	//定义一个功能，将字符数组转成字符串。
	public static String toString(char[] arr, int index) {
		String temp = "";
		for (int x = index; x < arr.length; x++) {
			temp = temp + arr[x];
		}
		return temp;
	}
	
	/**
	 * 用于二进制、八进制、十进制转换。
	 * @param num 要转换的十进制数
	 * @param base 进制转换 & 数 --(转二进制 & 1, 转八进制 & 7, 转十六进制 & 15)
	 * @param offset 进制转换右移位数 --(转二进制右移 1, 转八进制右移 3, 转十六进制右移 4)
	 * @return 转换后的进制结果
	 */
	public static String trans(int num, int base, int offset) {

		if (num == 0)
			return "0";
		// 1,建立表。
		char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', 
				'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// 2,创建临时容器。
		char[] arr = new char[32];

		// 3,创建操作临时容器的角标。
		int index = arr.length;

		// 4,通过循环对num进行& >>等运算。
		while (num != 0) {
			// 5,对num进行&运算。
			int temp = num & base;

			// 6,根据&运算后的结果作为角标查表，获取对应的字符。并将字符存储到临时容器中。
			arr[--index] = chs[temp];

			// 7,对num进行右移。
			num = num >>> offset;
		}
		return toString(arr, index);
	}
	
	/**
	 * 十进制-->二进制。
	 */
	public static String toBinary1(int num) {
		return trans(num, 1, 1);
	}
	
	/**
	 * 十进制-->八进制。
	 */
	public static String toOctal1(int num) {
		return "0" + trans(num, 7, 3);
	}

	/**
	 * 十进制-->十六进制。
	 */
	public static String toHex1(int num) {
		return "0x" + trans(num, 15, 4);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
