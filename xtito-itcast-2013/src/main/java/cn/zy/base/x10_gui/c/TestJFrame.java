package cn.zy.base.x10_gui.c;

import cn.zy.base.x10_gui.table.b.CheckHeaderCellRenderer;
import cn.zy.base.x10_gui.table.b.TableModelProxy;
import cn.zy.base.x10_gui.table.b.TableTestFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by [Zy]
 * 2017/4/16 21:33
 */
public class TestJFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {

        TestJFrame frame = new TestJFrame();
        frame.setVisible(true);

    }

    private TestJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CheckBox Table");
        this.setPreferredSize(new Dimension(400, 300));
        this.setVisible(true);
        // setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        initTable();
        pack();
    }

    private void initTable() {
        String[] columnNames = {"name","age", "choose"};
        Object[][] data = {};
        table.setModel(new DefaultTableModel(data, columnNames) {
            @Override
            public Class getColumnClass(int c) {
                Object value = getValueAt(0, c);
                if (value != null) {
                    return value.getClass();
                } else {
                    return super.getClass();
                }
            }
        });

        final MyCheckBoxRenderer check = new MyCheckBoxRenderer();
        table.getColumn("name").setHeaderRenderer(check);


        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(table.getColumnModel().getColumnIndexAtX(e.getX())==0){//如果点击的是第0列，即checkbox这一列
                    JCheckBox Checkbox = (JCheckBox)check;
                    boolean b = !check.isSelected();
                    check.setSelected(b);
                    table.getTableHeader().repaint();
                    for(int i=0;i<table.getRowCount();i++){
                        table.getModel().setValueAt(b, i, 0);//把这一列都设成和表头一样
                    }
                }
            }
        });

    }

    private static class MyCheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        public MyCheckBoxRenderer() {
            this.setBorderPainted(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            // TODO Auto-generated method stub
            return this;
        }
    }

}
