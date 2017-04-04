package cn.zy.base.x10_gui.a;

import java.awt.*;
import java.awt.event.*;

/**
 * GUI小窗体
 * Created by [Zy]
 * 2016/11/22 22:30
 */
public class FrameDemo {

    /**
     * 事件源：是被操作的
     * 事件：发生的事，活动的事
     * 监听器：监控某些动作
     * 事件处理（事件触发后的处理）
     */
    public static void main(String[] args) {

        // 1、创建一个窗体 Frame（默认布局是边界式布局）
        Frame frame = new Frame("my frame");

        // 2、对窗体进行基本设置
        // 设置窗体默认大小
        frame.setSize(500, 400);
        // 设置窗体距离屏幕左边和上边的距离
        frame.setLocation(400, 200);
        // 设置布局
        frame.setLayout(new FlowLayout());

        // 给窗体添加组件
        Button but = new Button("my button");
        // 加入一个文本框组件，并指定长度
        TextField tf = new TextField(40);

        // 将组件添加到窗体中
        frame.add(but);
        frame.add(tf);

        /*
         * 需求：想要点击按钮有效果，比如打印一句话。
         * 思路：
         * 1、确定事件源，按钮
         * 2、确定监听器，按钮添加监听器，按钮对象最清楚，到按钮对象中查找
         * 3、定义处理方式
         *
         * 定义的规范：XXXLinstener:XXX监听器。 --对应的XXXEvent事件。
         */
        but.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被触发了...." + e);
//                System.exit(0);
                /*for (int i=0; i<4; i++) {
                    for (int j=0; j<5; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }*/
            }
        });


        /*
         * 需求：想要实现点击窗体的X就可以实现窗体的关闭
         * 思路：
         * 1、事件源：窗体。
         * 2、监听器：通过窗口对象去查
         * 3、事件处理
         *
         * 到底哪些监听接口有适配器类？
         * 只要监听接口中的方法在2个以内，都没有适配器类。适配器的出现只为了方便创建监听对象。
         * 但是一般监听接口都有适配器。
         */
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("一开始就做的事，孔雀开屏...");
            }

            public void windowClosing(WindowEvent e) {
                System.out.println("window closing");
                System.exit(0);
            }
        });


        /*
         * 演示鼠标监听
         * 按钮事件源
         * 鼠标监听器注册到按钮上
         *
         *
         * 组件.addXXXListener(new XXXAdapter() {
         *    public void methodName(XXXEvent e){}
         * });
         */
        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*
                 * 想要对鼠标双击进行处理。应该找鼠标事件对象。
                 * 因为事件对象一产生，内部必然封闭事件源以及事件相关内容。
                 *
                 * 要查找MouseEvent对象
                 */
                if (e.getClickCount() == 1) {
                    System.out.println("鼠标单击开始...");
                }
                if (e.getClickCount() == 2) {
                    System.out.println("鼠标双击开始...");
                }
            }
        });


        /*
         * 需求：文本框中只能出入数字
         * 事件源：文本框
         * 文本框注册键盘监听。
         * 事件处理
         */
        tf.addKeyListener(new KeyAdapter() {
            // 按下触发
            @Override
            public void keyPressed(KeyEvent e) {
                // 1、如何获取录入的内容。通过键盘事件对象获取
                char key = e.getKeyChar();
                int code = e.getKeyCode();
                System.out.println(code + "...." + KeyEvent.getKeyText(code));

//                int code = e.getKeyCode();
//                if (!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
//                    System.out.println("必须是0-9数字");
//                    e.consume();// 直接取消默认处理方式。
//                }

                // 组合键，Ctrl+回车
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("enter run");
                }
            }
        });

        // 显示窗体，不然不会显示
        frame.setVisible(true);
    }
}

























