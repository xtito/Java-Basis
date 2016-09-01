package cn.zy.base.x09_io.z03_char_stream;

/**
 * Created by [Zy]
 * 2016/6/30 10:59
 */
public class A_Char_Code_Doc {

    /*

【代码清单】
cn.itcast.domain
	|--Student.java
cn.itcast.io.a.charstream
	|--CharStreamDemo.java:一篇文章中出现了多少个好字。读取数据，使用了字符流。FileReader
	|--FileWriterDemo.java：演示FileWriter。
cn.itcast.io.b.transstream
	|--TransStreamDemo.java:演示转换流，和子类的区别。★★★★★
cn.itcast.io.c.charstream.buffercopy
	|--CharStreamBufferedTest.java：字符流缓冲区对象的使用。
cn.itcast.io.c.charstream.copy
	|--CopyTextFileTest.java：通过字符流复制文件。
cn.itcast.io.test
	|--FileFilterBySuffix.java：文件后缀名过滤器。
	|--SeparatorTool.java:分隔符工具类。
	|--Test2.java：请删除一个带有内容的目录。
	|--Test4.java：将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序，★★★★★
					并将姓名和从高到低总分写入文件中。
	|--Test5.java：建立一个java文件清单列表。★★★★★

【第24天 总结】
	【阶段一目标：综合练习】
			练习1：请删除一个带有内容的目录。
			练习2：获取指定目录下所有的.java文件(包含子目录中的)。
			练习3：将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序，并将姓名和从高到低总分写入文件中。
			练习4：获取指定目录下所有的.java文件(包含子目录中的)，并将这些java文件的绝路路径写入到一个文件中。
			建立一个java文件清单列表。
			要求：
				1，明确思路。
				2，明确步骤。
				3，代码体现。

		【学习结果】
			要求四个练习必须写的出来。
	------------------------
	【阶段二目标：字符流】
			1，需求：读取一个中文。
				发现字节流可以读取就是麻烦。
				通过api FileReader，从而了解父类Reader。

				提到了编码表。★★★★
				编码表：其实就是生活中文件和计算机二进制的对应关系表。
				1，ascii： 一个字节中的7位就可以表示。对应的字节都是正数。0-xxxxxxx
				2，iso8859-1:拉丁码表 latin，用了一个字节用的8位。1-xxxxxxx  负数。
				3，GB2312:简体中文码表。6,7仟的中文和符号。用两个字节表示。两个字节都是开头为1 两个字节都是负数。
				   GBK:目前最常用的中文码表，2万的中文和符号。用两个字节表示，一部分文字，第一个字节开头是1，第二字节开头是0
				   GB18030：
				4， unicode：国际标准码表:无论是什么文字，都用两个字节存储。Java中的char类型用的就是这个码表。char c = 'a';占两个字节。
							在Java中，字符串是按照系统默认码表来解析的。简体中文版 字符串默认的码表是GBK。
				5，UTF-8:基于unicode，一个字节就可以存储数据，不要用两个字节存储，而且这个码表更加的标准化，在每一个字节头加入了
							编码信息(后期到api中查找)。

				能识别中文的码表：GBK  UTF-8  正因为识别中文码表不唯一，涉及到了编码解码问题。
				对于我们开发而言；常见的编码 GBK  UTF-8  ISO8859-1
				文字--->二进制(数字) ：编码。
				二进制(数字)--->文字  : 解码。

			2，演示FileReader。
			3，演示FileWriter。
			4，如果要指定具体的编码。
				需要使用转换流。
			5，转换流和子类的区别。
				OutputStreamWriter和InputStreamReader是字符和字节的桥梁：也可以称之为字符转换流。
				字符转换流原理：字节流+编码表。

				FileWriter和FileReader：作为子类，仅作为操作字符文件的便捷类存在。
				当操作的字符文件，使用的是默认编码表时可以不用父类，而直接用子类就完成操作了，简化了代码。

				InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));//默认字符集。
				InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"GBK");//指定GBK字符集。
				FileReader fr = new FileReader("a.txt");
				这三句代码的功能是一样的，其中第三句最为便捷。

				注意：一旦要指定其他编码时，绝对不能用子类，必须使用字符转换流。
				什么时候用子类呢？
				条件：
				1，操作的是文件。
				2，使用默认编码。

				字节--->字符 ： 看不懂的--->看的懂的。  需要读。输入流。 InputStreamReader
				字符--->字节 ： 看的懂的--->看不懂的。  需要写。输出流。 OutputStreamWriter
			6，练习：读取一个已有的中文文件(GBK)，将数据转成UTF-8写入到另一个文件中。★★★★★
		【学习结果】
			1，如何通过api中找打所需的对象。一定要自己学会查找动作。★★★★★
			2，编码中的细节：常用的码表有哪个？常用码表编码的特点。★★★★★
			3，转换流和子类的区别？★★★★★
			4，把转换流的案例代码体现出来。
			5，动手完成练习。

	------------------------
	【阶段三】
		【目标：字符流的缓冲区对象】
			1，自定义字符数数组作为缓冲区是可以的，之所以使用体系给定的缓冲区对象是因为该对象中提供了操作缓冲区的方法。
			如果不需要使用这些方法，完成可以通过自定义的缓冲区提高效率。
			2，BufferedReader: readLine();
			   BufferedWriter: newLine();
			3，通过缓冲区进行文件的复制。
			4，思考题；字符流可以复制图片吗？

		【学习结果】
			1，使用缓冲区复制文本文件。
			2，readLine方法的原理。

	------------------------




练习：
1，listFiles只能列出当前目录的下的文件和文件夹，能不能列出当前目录下的文件夹中所有的子目录中的内容呢？

2，请删除一个带有内容的目录。

3，获取指定目录下所有的.java文件(包含子目录中的)。

4，将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序，并将姓名和从高到低总分写入文件中。

5，获取指定目录下所有的.java文件(包含子目录中的)，并将这些java文件的绝路路径写入到一个文件中。
	建立一个java文件清单列表。

--------------------------------------------
【课上笔记】

熟悉了字节流 输入(InputStream)和输出(OutputStream)，
解决文件的操作(FileInputStream,FileOutputStream)，
同时还提高了效率（BufferedInputStream,BufferedOutputStream）。

-------
在操作数据过程中，字节流可以操作所有数据，现在有一个新的需求。
比如；一篇文章中出现了多少个好字。读取数据。判断好字并计数。


编码表：其实就是生活中文件和计算机二进制的对应关系表。
	1，ascii： 一个字节中的7位就可以表示。对应的字节都是正数。0-xxxxxxx
	2，iso8859-1:拉丁码表 latin，用了一个字节用的8位。1-xxxxxxx  负数。
	3，GB2312:简体中文码表。6,7仟的中文和符号。用两个字节表示。两个字节都是开头为1 两个字节都是负数。
	   GBK:目前最常用的中文码表，2万的中文和符号。用两个字节表示，一部分文字，第一个字节开头是1，第二字节开头是0
	   GB18030：
	4， unicode：国际标准码表:无论是什么文字，都用两个字节存储。Java中的char类型用的就是这个码表。char c = 'a';占两个字节。
				在Java中，字符串是按照系统默认码表来解析的。简体中文版 字符串默认的码表是GBK。
	5，UTF-8:基于unicode，一个字节就可以存储数据，不要用两个字节存储，而且这个码表更加的标准化，在每一个字节头加入了
				编码信息(后期到api中查找)。

	能识别中文的码表：GBK  UTF-8  正因为识别中文码表不唯一，涉及到了编码解码问题。

对于我们开发而言；常见的编码 GBK  UTF-8  ISO8859-1

文字--->二进制(数字) ：编码。

二进制(数字)--->文字  : 解码。


了解到操作文字数据是需要-编码表配合。

查阅FileInputStream api说明中是否有相关的提示呢？发现一个新名词。
字符流:之前用的都是字节流，用于操作的都是字节数据，字符流，专门用于操作字符数据的流对象。

索引了api中的提到的 FileReader对象。发现这个对象是一个操作字符文件的便捷类，内部类使用默认的字符集解码+默认的字节缓冲区。
	其中，提到了一个如果需要修改这些值(指定码表，或者缓冲区等)需要查阅InputStreamReader。
	目前为了解决当前问题，不需要，只需要使用默认即可。

	使用FileReader时，了解它的功能，看它所属的体系顶层。Reader。
	Reader：读取字符流的抽象超类。read():读取单个字符并返回， read(char[]):将数据读取到数组中，并返回读取的个数。

FileReader : 字节读取流+默认编码表。

字符流：为了便于操作数据中的字符数据。原理： 字节流+编码表。
字符流的两个基类。

	Reader：read()读取字符。
		|-

	Writer(Reader的另请参见)：写入字符。
		|-

字节流操作的是字节数组；字符流操作的是字符数组。


【作业】

1，将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序，并将姓名和从高到低总分写入文件中。

2，获取指定目录下所有的.java文件(包含子目录中的)，并将这些java文件的绝路路径写入到一个文件中。
	建立一个java文件清单列表。

3，通过字符流缓冲区复制文件。★★★★★

4，读取一个已有的中文文件(GBK)，将数据转成UTF-8写入到另一个文件中。★★★★★

5，获取一篇文章中 "传智播客" 出现的次数。★★★★★


     */
}
