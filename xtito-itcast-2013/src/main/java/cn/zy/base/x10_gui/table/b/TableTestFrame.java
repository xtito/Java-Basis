package cn.zy.base.x10_gui.table.b;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by [Zy]
 * 2017/4/16 19:47
 */
public class TableTestFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableTestFrame frame = new TableTestFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TableTestFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CheckBox Table");
        this.setPreferredSize(new Dimension(400, 300));
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
        Object[][] data = this.getData();
        TableModelProxy tableModel = new TableModelProxy(columnNames, data);
        table.setModel(tableModel);
        table.getTableHeader().setDefaultRenderer(new CheckHeaderCellRenderer(table));
    }

    /**
     * 获得数据
     *
     * @return
     */
    private Object[][] getData() {
        Object[][] data = {
                { "Kathy", 5, new Boolean(false) },
                { "John", 15, new Boolean(true) },
                { "Sue", 16, new Boolean(false) },
                { "Jane",17, new Boolean(true) },
                { "Joe", 18, new Boolean(false) } };
        return data;
    }
}
