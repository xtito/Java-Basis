package cn.zy.base.utils.constant;

/**
 * 正则规则常量
 * Created by [Zy]
 * 2016/3/30 9:56
 */
public class RegexConstant {

    private RegexConstant () {

    }

    /**
     * ids, 用于sql IN(5645，6,55)语句
     */
    public static final String IDS_REGEX = "^[0-9]+$|^([0-9]+,)+[0-9]+$";

    /**
     * 判断是否为数字
     */
    public static final String ID_NUM = "^[0-9]+$";


    /**
     * 判断是否为数字或（数字-数字）,号隔开
     * 1,2,3,4-6,9,20,15-30,355,340-500,6,7-9
     */
    public static final String NUM_D_NUM = "^((([0-9]+-[0-9]+)|[0-9]+),?)+$";


    /**
     * 判断数字是否为（数字-数字）
     * 1-2  24-36  502-520
     */
    public static final String NUM_G_NUM = "^[0-9]+-[0-9]+$";


    /**
     * 判断是期是否合法
     * 格式：yyyy-MM-dd
     */
    public static final String DATE_YYYY_MM_DD = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";


    /**
     * 判断特检号是否合法，特检号格式：T0001  或 0001  或 1
     * 可以是以 T 开头，也可以是纯数字
     */
    public static final String T_ID = "^T[0-9]+|[0-9]+$";
}
