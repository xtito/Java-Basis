/*
 * Created by JFormDesigner on Tue Apr 04 12:06:50 CST 2017
 */

package cn.zy.base.x10_gui.b;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * @author ZhangYuan
 */
public class FileRenameFrame extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openMenu;
    private JMenuItem outMenu;
    private JMenu otherMenu;
    private JPanel mainPanel;
    private JLabel pathLab;
    private JTextField pathField;
    private JButton pathBut;
    private JScrollPane pathScrollPane;
    private JTree pathTree;
    private JPanel conPanel;
    private JTabbedPane conTabbedPane;
    private JPanel addPanel;
    private JLabel addLabel1;
    private JTextField addTextField1;
    private JButton addViewBut;
    private JLabel addLabel2;
    private JTextField addTextField2;
    private JButton addBut;
    private JPanel numPanel2;
    private JLabel numLabel;
    private JTextField numTextField1;
    private JRadioButton autoRadio1;
    private JRadioButton autoRadio2;
    private JTextField numTextField2;
    private JButton numViewBut1;
    private JButton numViewBut2;
    private JPanel replacePanel;
    private JLabel replaceLabel1;
    private JTextField replaceTextField1;
    private JButton replaceViewBut;
    private JLabel replaceLabel2;
    private JTextField replaceTextField2;
    private JButton replaceBut;
    private JPanel removePanel;
    private JLabel delLabel;
    private JTextField delTextField;
    private JButton removeBut;
    private JPanel rnamePanel;
    private JLabel reLabel;
    private JTextField reTextField;
    private JButton renameBut;
    private JPanel listPanel;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public FileRenameFrame() {
        initComponents();
    }

    private void pathFieldKeyPressed(KeyEvent e) {
        // 判断是否是回车键
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println(pathField.getText());
        }
    }

    /**
     * 窗口关闭事件
     */
    private void thisWindowClosing(WindowEvent e) {
        System.exit(0);
    }

    /**
     * 点击转到按钮触发
     */
    private void pathButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
            getTableData("a");
        }
    }


    /**
     * 点击添加中的预览触发
     */
    private void addViewButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击添加中的执行触发
     */
    private void addButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击序号中的预览触发
     */
    private void numViewBut1MouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击序号中的执行触发
     */
    private void numViewBut2MouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击替换中的预览触发
     */
    private void replaceViewButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击替换中的执行触发
     */
    private void replaceButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击删除中的执行触发
     */
    private void removeButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }


    /**
     * 点击重命名中的执行触发
     */
    private void renameButMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.out.println("鼠标单击开始...");
        }
    }

    /**
     * 点击文件菜单中的退出执行触发
     */
    private void outMenuMousePressed(MouseEvent e) {
        if (e.getClickCount() == 1) {
            System.exit(0);// 关闭程序
        }
    }

    private void getTableData(String path) {
        if (path != null && !"".equals(path.trim())) {
            TableColumn col1 = new TableColumn();
            col1.setHeaderValue("abc");
            table1.addColumn(col1);
        }
    }

    private void getRootPath() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("计算机");

        File[] files = File.listRoots();
        if (files != null && files.length > 0) {
            for (File file : files) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file);
                top.add(childNode);

                File[] childFiles = file.listFiles();
                if (childFiles != null && childFiles.length > 0) {
                    for (File childFile : childFiles) {
                        if (childFile.isDirectory()) {
                            DefaultMutableTreeNode childChildNode = new DefaultMutableTreeNode(childFile);
                            childNode.add(childChildNode);
                        }
                    }
                }
            }
        }

        pathTree.setModel(new DefaultTreeModel(top));
    }

    private void thisWindowOpened(WindowEvent e) {
        getRootPath();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        openMenu = new JMenuItem();
        outMenu = new JMenuItem();
        otherMenu = new JMenu();
        mainPanel = new JPanel();
        pathLab = new JLabel();
        pathField = new JTextField();
        pathBut = new JButton();
        pathScrollPane = new JScrollPane();
        pathTree = new JTree();
        conPanel = new JPanel();
        conTabbedPane = new JTabbedPane();
        addPanel = new JPanel();
        addLabel1 = new JLabel();
        addTextField1 = new JTextField();
        addViewBut = new JButton();
        addLabel2 = new JLabel();
        addTextField2 = new JTextField();
        addBut = new JButton();
        numPanel2 = new JPanel();
        numLabel = new JLabel();
        numTextField1 = new JTextField();
        autoRadio1 = new JRadioButton();
        autoRadio2 = new JRadioButton();
        numTextField2 = new JTextField();
        numViewBut1 = new JButton();
        numViewBut2 = new JButton();
        replacePanel = new JPanel();
        replaceLabel1 = new JLabel();
        replaceTextField1 = new JTextField();
        replaceViewBut = new JButton();
        replaceLabel2 = new JLabel();
        replaceTextField2 = new JTextField();
        replaceBut = new JButton();
        removePanel = new JPanel();
        delLabel = new JLabel();
        delTextField = new JTextField();
        removeBut = new JButton();
        rnamePanel = new JPanel();
        reLabel = new JLabel();
        reTextField = new JTextField();
        renameBut = new JButton();
        listPanel = new JPanel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setMinimumSize(new Dimension(900, 600));
        setBackground(Color.white);
        setTitle("\u6279\u91cf\u4fee\u6539\u6587\u4ef6\u540d");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== menuBar ========
        {
            menuBar.setMinimumSize(new Dimension(2, 30));
            menuBar.setPreferredSize(new Dimension(74, 30));
            menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

            //======== fileMenu ========
            {
                fileMenu.setText("\u6587\u4ef6");
                fileMenu.setActionCommand("text");

                //---- openMenu ----
                openMenu.setText("\u6253\u5f00");
                fileMenu.add(openMenu);
                fileMenu.addSeparator();

                //---- outMenu ----
                outMenu.setText("\u9000\u51fa");
                outMenu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        outMenuMousePressed(e);
                    }
                });
                fileMenu.add(outMenu);
            }
            menuBar.add(fileMenu);

            //======== otherMenu ========
            {
                otherMenu.setText("\u5907\u7528");
            }
            menuBar.add(otherMenu);
        }
        setJMenuBar(menuBar);

        //======== mainPanel ========
        {
            mainPanel.setMinimumSize(new Dimension(884, 531));
            mainPanel.setBackground(new Color(246, 246, 246));
            mainPanel.setLayout(new TableLayout(new double[][] {
                {16, 168, 10, 566, 10, 70, 28, 16},
                {16, TableLayout.PREFERRED, 10, 132, 6, 317, 16}}));

            //---- pathLab ----
            pathLab.setText("\u6587\u4ef6\u5939\u8def\u5f84\uff1a");
            pathLab.setMaximumSize(new Dimension(120, 30));
            pathLab.setMinimumSize(new Dimension(120, 30));
            pathLab.setPreferredSize(new Dimension(120, 30));
            pathLab.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            pathLab.setHorizontalAlignment(SwingConstants.RIGHT);
            mainPanel.add(pathLab, new TableLayoutConstraints(1, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));

            //---- pathField ----
            pathField.setPreferredSize(new Dimension(180, 34));
            pathField.setMinimumSize(new Dimension(180, 34));
            pathField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            pathField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    pathFieldKeyPressed(e);
                }
            });
            mainPanel.add(pathField, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));

            //---- pathBut ----
            pathBut.setText("\u8f6c\u5230");
            pathBut.setPreferredSize(new Dimension(60, 34));
            pathBut.setMaximumSize(new Dimension(60, 34));
            pathBut.setMinimumSize(new Dimension(60, 34));
            pathBut.setHorizontalTextPosition(SwingConstants.LEFT);
            pathBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            pathBut.setBackground(new Color(246, 246, 246));
            pathBut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pathButMouseClicked(e);
                }
            });
            mainPanel.add(pathBut, new TableLayoutConstraints(5, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.CENTER));

            //======== pathScrollPane ========
            {
                pathScrollPane.setViewportView(pathTree);
            }
            mainPanel.add(pathScrollPane, new TableLayoutConstraints(1, 3, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //======== conPanel ========
            {
                conPanel.setBackground(new Color(246, 246, 246));
                conPanel.setLayout(new GridLayout());

                //======== conTabbedPane ========
                {
                    conTabbedPane.setBackground(new Color(246, 246, 246));
                    conTabbedPane.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

                    //======== addPanel ========
                    {
                        addPanel.setBackground(Color.white);
                        addPanel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        addPanel.setLayout(new TableLayout(new double[][] {
                            {16, TableLayout.PREFERRED, TableLayout.PREFERRED, 70, TableLayout.PREFERRED},
                            {10, TableLayout.PREFERRED, TableLayout.PREFERRED, 10}}));
                        ((TableLayout)addPanel.getLayout()).setHGap(5);
                        ((TableLayout)addPanel.getLayout()).setVGap(5);

                        //---- addLabel1 ----
                        addLabel1.setText("\u5728\u6587\u4ef6\u540d\u524d\u6dfb\u52a0\uff1a");
                        addLabel1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        addLabel1.setMinimumSize(new Dimension(150, 30));
                        addLabel1.setMaximumSize(new Dimension(150, 30));
                        addLabel1.setPreferredSize(new Dimension(150, 30));
                        addLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
                        addPanel.add(addLabel1, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- addTextField1 ----
                        addTextField1.setMinimumSize(new Dimension(300, 30));
                        addTextField1.setPreferredSize(new Dimension(300, 30));
                        addPanel.add(addTextField1, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- addViewBut ----
                        addViewBut.setText("\u9884\u89c8");
                        addViewBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        addViewBut.setBackground(Color.white);
                        addViewBut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                addViewButMouseClicked(e);
                            }
                        });
                        addPanel.add(addViewBut, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- addLabel2 ----
                        addLabel2.setText("\u5728\u6587\u4ef6\u540d\u540e\u6dfb\u52a0\uff1a");
                        addLabel2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        addLabel2.setMinimumSize(new Dimension(150, 30));
                        addLabel2.setMaximumSize(new Dimension(150, 30));
                        addLabel2.setPreferredSize(new Dimension(150, 30));
                        addLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
                        addPanel.add(addLabel2, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- addTextField2 ----
                        addTextField2.setMinimumSize(new Dimension(300, 30));
                        addTextField2.setPreferredSize(new Dimension(300, 30));
                        addPanel.add(addTextField2, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- addBut ----
                        addBut.setText("\u6267\u884c");
                        addBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        addBut.setBackground(Color.white);
                        addBut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                addButMouseClicked(e);
                            }
                        });
                        addPanel.add(addBut, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    conTabbedPane.addTab("\u6dfb\u52a0", addPanel);

                    //======== numPanel2 ========
                    {
                        numPanel2.setBackground(Color.white);
                        numPanel2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        numPanel2.setLayout(new TableLayout(new double[][] {
                            {16, 90, 70, 10, TableLayout.PREFERRED, 10, TableLayout.PREFERRED, 70, 70, 70, TableLayout.PREFERRED},
                            {30, TableLayout.PREFERRED, 30}}));
                        ((TableLayout)numPanel2.getLayout()).setHGap(5);
                        ((TableLayout)numPanel2.getLayout()).setVGap(5);

                        //---- numLabel ----
                        numLabel.setText("\u8d77\u59cb\u5e8f\u53f7\uff1a");
                        numLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        numLabel.setMinimumSize(new Dimension(150, 30));
                        numLabel.setMaximumSize(new Dimension(150, 30));
                        numLabel.setPreferredSize(new Dimension(150, 30));
                        numLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                        numPanel2.add(numLabel, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- numTextField1 ----
                        numTextField1.setMinimumSize(new Dimension(300, 30));
                        numTextField1.setPreferredSize(new Dimension(300, 30));
                        numPanel2.add(numTextField1, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- autoRadio1 ----
                        autoRadio1.setText("\u81ea\u52a8\u8865\u96f6");
                        autoRadio1.setBackground(Color.white);
                        autoRadio1.setSelected(true);
                        numPanel2.add(autoRadio1, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- autoRadio2 ----
                        autoRadio2.setText("\u81ea\u5b9a\u4e49\u8865\u96f6");
                        autoRadio2.setBackground(Color.white);
                        autoRadio2.setSelected(true);
                        numPanel2.add(autoRadio2, new TableLayoutConstraints(6, 1, 6, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- numTextField2 ----
                        numTextField2.setMinimumSize(new Dimension(300, 30));
                        numTextField2.setPreferredSize(new Dimension(300, 30));
                        numPanel2.add(numTextField2, new TableLayoutConstraints(7, 1, 7, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- numViewBut1 ----
                        numViewBut1.setText("\u9884\u89c8");
                        numViewBut1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        numViewBut1.setBackground(Color.white);
                        numViewBut1.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                numViewBut1MouseClicked(e);
                            }
                        });
                        numPanel2.add(numViewBut1, new TableLayoutConstraints(8, 1, 8, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- numViewBut2 ----
                        numViewBut2.setText("\u6267\u884c");
                        numViewBut2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        numViewBut2.setBackground(Color.white);
                        numViewBut2.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                numViewBut2MouseClicked(e);
                            }
                        });
                        numPanel2.add(numViewBut2, new TableLayoutConstraints(9, 1, 9, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    conTabbedPane.addTab("\u5e8f\u53f7", numPanel2);

                    //======== replacePanel ========
                    {
                        replacePanel.setBackground(Color.white);
                        replacePanel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        replacePanel.setLayout(new TableLayout(new double[][] {
                            {16, TableLayout.PREFERRED, TableLayout.PREFERRED, 70, TableLayout.PREFERRED},
                            {10, TableLayout.PREFERRED, TableLayout.PREFERRED, 10}}));
                        ((TableLayout)replacePanel.getLayout()).setHGap(5);
                        ((TableLayout)replacePanel.getLayout()).setVGap(5);

                        //---- replaceLabel1 ----
                        replaceLabel1.setText("\u66ff\u6362\u6587\u4ef6\u4e2d\u7684\uff1a");
                        replaceLabel1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        replaceLabel1.setMinimumSize(new Dimension(150, 30));
                        replaceLabel1.setMaximumSize(new Dimension(150, 30));
                        replaceLabel1.setPreferredSize(new Dimension(150, 30));
                        replaceLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
                        replacePanel.add(replaceLabel1, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- replaceTextField1 ----
                        replaceTextField1.setMinimumSize(new Dimension(300, 30));
                        replaceTextField1.setPreferredSize(new Dimension(300, 30));
                        replacePanel.add(replaceTextField1, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- replaceViewBut ----
                        replaceViewBut.setText("\u9884\u89c8");
                        replaceViewBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        replaceViewBut.setBackground(Color.white);
                        replaceViewBut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                replaceViewButMouseClicked(e);
                            }
                        });
                        replacePanel.add(replaceViewBut, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- replaceLabel2 ----
                        replaceLabel2.setText("\u66ff\u6362\u4e3a\uff1a");
                        replaceLabel2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        replaceLabel2.setMinimumSize(new Dimension(150, 30));
                        replaceLabel2.setMaximumSize(new Dimension(150, 30));
                        replaceLabel2.setPreferredSize(new Dimension(150, 30));
                        replaceLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
                        replacePanel.add(replaceLabel2, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- replaceTextField2 ----
                        replaceTextField2.setMinimumSize(new Dimension(300, 30));
                        replaceTextField2.setPreferredSize(new Dimension(300, 30));
                        replacePanel.add(replaceTextField2, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- replaceBut ----
                        replaceBut.setText("\u6267\u884c");
                        replaceBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        replaceBut.setBackground(Color.white);
                        replaceBut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                replaceButMouseClicked(e);
                            }
                        });
                        replacePanel.add(replaceBut, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    conTabbedPane.addTab("\u66ff\u6362", replacePanel);

                    //======== removePanel ========
                    {
                        removePanel.setBackground(Color.white);
                        removePanel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        removePanel.setLayout(new TableLayout(new double[][] {
                            {16, TableLayout.PREFERRED, TableLayout.PREFERRED, 70, TableLayout.PREFERRED},
                            {30, TableLayout.PREFERRED, 30}}));
                        ((TableLayout)removePanel.getLayout()).setHGap(5);
                        ((TableLayout)removePanel.getLayout()).setVGap(5);

                        //---- delLabel ----
                        delLabel.setText("\u5220\u9664\u6587\u4ef6\u540d\u4e2d\u7684\uff1a");
                        delLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        delLabel.setMinimumSize(new Dimension(150, 30));
                        delLabel.setMaximumSize(new Dimension(150, 30));
                        delLabel.setPreferredSize(new Dimension(150, 30));
                        delLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                        removePanel.add(delLabel, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- delTextField ----
                        delTextField.setMinimumSize(new Dimension(300, 30));
                        delTextField.setPreferredSize(new Dimension(300, 30));
                        removePanel.add(delTextField, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- removeBut ----
                        removeBut.setText("\u6267\u884c");
                        removeBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        removeBut.setBackground(Color.white);
                        removeBut.setActionCommand("\u6267\u884c");
                        removeBut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                removeButMouseClicked(e);
                            }
                        });
                        removePanel.add(removeBut, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    conTabbedPane.addTab("\u5220\u9664", removePanel);

                    //======== rnamePanel ========
                    {
                        rnamePanel.setBackground(Color.white);
                        rnamePanel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        rnamePanel.setLayout(new TableLayout(new double[][] {
                            {16, TableLayout.PREFERRED, TableLayout.PREFERRED, 70, TableLayout.PREFERRED},
                            {30, TableLayout.PREFERRED, 30}}));
                        ((TableLayout)rnamePanel.getLayout()).setHGap(5);
                        ((TableLayout)rnamePanel.getLayout()).setVGap(5);

                        //---- reLabel ----
                        reLabel.setText("\u5168\u90e8\u547d\u540d\u4e3a\uff1a");
                        reLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        reLabel.setMinimumSize(new Dimension(150, 30));
                        reLabel.setMaximumSize(new Dimension(150, 30));
                        reLabel.setPreferredSize(new Dimension(150, 30));
                        reLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                        rnamePanel.add(reLabel, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- reTextField ----
                        reTextField.setMinimumSize(new Dimension(300, 30));
                        reTextField.setPreferredSize(new Dimension(300, 30));
                        rnamePanel.add(reTextField, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- renameBut ----
                        renameBut.setText("\u6267\u884c");
                        renameBut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                        renameBut.setBackground(Color.white);
                        renameBut.setActionCommand("\u6267\u884c");
                        renameBut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                renameButMouseClicked(e);
                            }
                        });
                        rnamePanel.add(renameBut, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    conTabbedPane.addTab("\u91cd\u547d\u540d", rnamePanel);
                }
                conPanel.add(conTabbedPane);
            }
            mainPanel.add(conPanel, new TableLayoutConstraints(3, 3, 6, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //======== listPanel ========
            {
                listPanel.setBackground(Color.white);
                listPanel.setLayout(new GridLayout());

                //======== panel1 ========
                {
                    panel1.setLayout(new GridLayout());

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(table1);
                    }
                    panel1.add(scrollPane1);
                }
                listPanel.add(panel1);
            }
            mainPanel.add(listPanel, new TableLayoutConstraints(3, 5, 6, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        contentPane.add(mainPanel);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

//        try {
//            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            FileRenameFrame ff = new FileRenameFrame();




//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }

    }
}
