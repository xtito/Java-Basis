package cn.zy.base.x09_io;

/**
 * Created by [Zy]
 * 2016/3/2 12:59
 */
public class ReadMe {


    /**
    【代码清单】
    cn.itcast.api.a.date
    |--DateDemo.java：将毫秒值转成本地格式。Date DateFormat
    |--DateDemo2.java：获取日期中的指定日期信息比如获取年，月，日Calendar。
            |--DateTest.java：练习2 ："2012-3-17"转成日期对象。
            |--DateTest2.java：练习3："2013-4-25"到"2013年7月29日"到底有多少天？
            |--DateTest3.java：练习4：获取给定年份的2月有多少天？【面试题】
    cn.itcast.io.a.file
    |--FileDemo.java：演示File的构造函数，分隔符。
            |--FileMethodDemo.java：演示File类的获取功能涉及的方法，其中有将最后修改时间毫秒值转成本地格式字符串。
            |--FileMethodDemo2.java：对文件以及文件夹进行增createNewFile,mkdir 删判 delete,判断exists存在的操作。
            |--FileMethodDemo3.java：对给定的目录获取内部的内容。list方法。listFiles();
    |--FileMethodDemo4.java：讲解文件名过滤器，其中有listFiles(filenamefilter)方法的源码注解。
            |--FileMethodDemo5.java：讲解文件过滤器。FileFilter
    cn.itcast.io.b.filter
    |--FileFilterByDir.java：用于过滤文件的过滤器。
            |--FilenameFilterByJava.java：用于过滤.java扩展名文件的过滤器。
            |--FilenameFilterBySuffix.java：用于过滤指定扩展名文件的过滤器。

            【第22天 总结】
            【阶段一】
            【目标：对日期时间的操作】
            1，开发时，经常会使用日期和时间。
    自己动手查API。解决如下问题：★★★★★
    日期的简单使用。java.util.Date,通过System.currentTimeMillis()的另请参见。
            2，获取的毫秒值怎么转成我们习惯的日期时间格式呢？
    Date，DateForamt。
            3，转换
    3.1 毫秒值time--new Date(time) ,  date.setTime(time)-->日期对象date。
            3.2 日期对象date--date.getTime()-->毫秒值time
    3.3 格式化：日期对象date --DateFormat.getDateInstance(style).format(date)-->文本
    3.4 解析：文本 --DateFormat.getDateInstance(style).parse(文本)-->日期对象date
    4，获取DateFormat对象的几种方式。style: FULL LONG MEDIUM SHORT
    4.1 getDateInstance(datestyle);
    4.2 getDateTimeInstance(datestyle,timestyle);
    4.3 new SimpleDateFormat(pattern)。
            5，获取日期中的具体的字段。年 月 日 等。
            5.1 使用Calendar对象。
            5.2 get set add(对指定字段进行偏移 )
    【学习结果】
            1，实际开发中，如何查找到Date DateFormat  Calendar 必须会。查询新对象解决问题的能力一定要会。
    技巧：1，索引指定类或者接口。2，另请参见。3，阅读文档描述。
            2，将日期涉及练习做完。动手写。
            2.1,将毫秒值转成 指定的日期的格式   xxxx年xx月xx日   hh:mm:ss
    步骤：
    //1,毫秒值time--->Date
    Date date = new Date(time);
    //2,通过日期时间格式器对象DateFormat对日期对象进行格式化(日期--->文本字符串)
    DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
    String str_time = format.format(date);
    System.out.println(str_time);
    2.2,"2012/3/17"转成日期对象。
            2.3,"2013-4-25"到"2013年7月29日"到底有多少天？
            2.4,获取给定年份的2月有多少天？【面试题】
            ------------------------
            【阶段二】
            【目标：了解输入输出技术】
            1，数据都在内存中，想要把数据持久化，需要使用系统中的一些输入和输出技术。
            2，Java程序调用jvm，jvm调用所在系统的输入和输出内容完成Java程序的输入和输出。
            3，简单理解：内容数据持久化到硬盘：输出。将硬盘数据读取到内容运算：输入。后面还有很多的设备。
            4，输入和输出结束；解决的问题是操作设备上的数据。
            5，java中的输入输出技术相关的对象都定义在java.io包。
            【学习结果】
            1，必须明白输入和输出方向。 输入：读数据。输出：写数据。
            2，IO技术解决的问题。
            ------------------------
            【阶段三】
            【目标：IO技术中的File对象】
            1，描述文件和文件夹的对象。
            2，提供了和系统平台相关的分隔符  File.separator
    3，提供了一些用于操作文件的方法。
            3.1 获取操作：getXXX.获取文件大小，名称，目录，修改时间....
            3.2 增加 createNewFile():创建文件，mkdir():创建目录 mkdirs():创建多级目录。
    删除delete()，判断存在exists()。
            3.3 注意:创建文件：文件已存在不创建，不存在则创建，该方法抛IOException。
    删除文件：文件不存在，以及文件存在正在被使用，删除都为false。
    删除目录：目录内容为空，可以直接删除，目录内容不为空，删除不了，必须从里往外删。
            3.4 获取目录中的内容。
    String[] list():获取目录中的文件和文件夹名称。
    File[] listFiles():获取目录中的所有的文件和文件File对象。
    File[] listFiles(FileFilter)：根据指定的文件过滤器进行获取。
    File[] listFiles(FilenameFilter)：根据指定的文件名称过滤器进行获取。
            【学习结果】
            1，对File类中的常见方法有所了解，便于开发使用。
            2，对过滤器必须理解，可以参阅源码。
            3，有关File类的练习要求必须会。

            ------------------------


            ---------------------------------------
    已学习过的API常见对象解决的问题：

    字符串String--操作文本数据。
    字符串缓冲区---容器，可以存储很多的任意类型的数据--字符串。

    基本数据类型包装类---解决了字符串和基本数据类型的之间的转换 "123"--parseInt--123。同时给基本数据提供更多的操作。--toBinaryString()

    集合框架--对象多了，便于存储后操作。 add put  Collection--Iterator  Map-Set-Iterator

    Math:解决数学操作。随机数。
    System:获取系统属性信息。可以获取系统的分隔符。

    Date，DateFormat ，Calendar: 解决日期和时间的问题。

    想要对这些数据进行持久化等操作。需要一些技术完成其他设备上数据的操作。
    这时就需要用到IO技术。Java中提供了IO技术的操作方式(最终依赖于操作系统)。

    数据最终持久化到硬盘上，体现就是文件。
    对文件进行了解。



            --------------------

            【作业】

            1：获取指定目录中的指定条件(隐藏文件，.java文件)的文件。

    预习作业：
            1，listFiles只能列出当前目录的下的文件和文件夹，能不能列出当前目录下的文件夹中所有的子目录中的内容呢？

            2，请删除一个带有内容的目录。

            3，获取指定目录下所有的.java文件(包含子目录中的)。
    */


}
