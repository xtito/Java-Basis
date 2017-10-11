package com.core.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * MAC可用于局域网验证，提高安全性。
 * 获取本机Mac地址
 *
 * Created by [Zy]
 * 2017/10/11 11:19
 */
public class MacAddressUtil {

    public static void main(String[] args) throws UnknownHostException, SocketException {

        // TODO Auto-generated method stub



        //得到IP，输出PC-201309011313/122.206.73.83

       /* InetAddress ia = InetAddress.getLocalHost();

        System.out.println(ia);

        getLocalMac(ia);*/

        System.out.println(getRandomAddress());
        System.out.println(randomMac());
        System.out.println(randomMacWithOui(new Integer[] {1,2,3,4,5,6,7,8,9}));
        System.out.println("randomMac4Qemu: " + randomMac4Qemu());
        System.out.println(randomMac4Xen());
        System.out.println(randomMac4Apple());
        System.out.println(randomMac4Huawei());

    }

    public static String getRandomAddress() {
        Random random = new Random();
        // 随机获取MAC地址
        String[] adrArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String adrStr = "";

        for (int i=1; i<=12; i++) {
            int index = 0;
            if (i != 2) {
                index = random.nextInt(adrArray.length - 1);
            } else {
                // 第二位只能是偶数
                Integer[] array = {0, 2, 4, 6, 8};
                index = array[random.nextInt(array.length - 1)];
            }
            adrStr += adrArray[index];
        }

        return adrStr;
    }


    private static void getLocalMac(InetAddress ia) throws SocketException {

        // TODO Auto-generated method stub

        //获取网卡，获取地址

        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

        System.out.println("mac数组长度："+mac.length);

        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<mac.length; i++) {

            if(i!=0) {

                sb.append("-");

            }

            //字节转换为整数

            int temp = mac[i]&0xff;

            String str = Integer.toHexString(temp);

            System.out.println("每8位:"+str);

            if(str.length()==1) {

                sb.append("0").append(str);

            }else {

                sb.append(str);

            }

        }

        System.out.println("本机MAC地址:"+sb.toString().toUpperCase());

    }


    private static String SEPARATOR_OF_MAC = ":";

    /**
     * Generate a random MAC address.
     * Every fields are random, range from 0 to 255
     *
     * @return MAC address string
     */
    public static String randomMac() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }

    /**
     * Generate a random MAC address with oui.
     * The OUI list is available at http://standards.ieee.org/regauth/oui/oui.txt.
     * The remaining 3 fields are random,  range from 0 to 255
     *
     * @param oui string[] like {52, 54, 00}
     * @return MAC address string
     */
    public static String randomMacWithOui(Integer[] oui) {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", oui[0]),
                String.format("%02x", oui[1]),
                String.format("%02x", oui[2]),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }

    /**
     * Generate a random MAC address for qemu/kvm
     * 52-54-00 used by qemu/kvm
     * The remaining 3 fields are random,  range from 0 to 255
     *
     * @return MAC address string
     */
    public static String randomMac4Qemu() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", 0x52),
                String.format("%02x", 0x54),
                String.format("%02x", 0x00),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }

    /**
     * Generate a random MAC address for xen
     * 00-16-3E allocated to xensource
     * The remaining 3 fields are random,  range from 0 to 255
     *
     * @return MAC address string
     */
    public static String randomMac4Xen() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", 0x00),
                String.format("%02x", 0x16),
                String.format("%02x", 0x3e),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }

    /**
     * Generate a random MAC address for Apple
     * 00-cd-fe allocated to Apple
     * The remaining 3 fields are random,  range from 0 to 255
     *
     * @return MAC address string
     */
    public static String randomMac4Apple() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", 0x00),
                String.format("%02x", 0xcd),
                String.format("%02x", 0xfe),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }

    /**
     * Generate a random MAC address for Huawei
     * 00-cd-fe used by Huawei
     * The remaining 3 fields are random,  range from 0 to 255
     *
     * @return MAC address string
     */
    public static String randomMac4Huawei() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", 0x48),
                String.format("%02x", 0xad),
                String.format("%02x", 0x08),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }


}
