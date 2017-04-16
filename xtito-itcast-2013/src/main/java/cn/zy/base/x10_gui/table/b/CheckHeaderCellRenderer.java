package cn.zy.base.x10_gui.table.b;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by [Zy]
 * 2017/4/16 19:29
 */
public class CheckHeaderCellRenderer implements TableCellRenderer {

    TableModelProxy tableModel;
    JTableHeader tableHeader;
    final JCheckBox selectBox;

    public CheckHeaderCellRenderer(final JTable table) {
        this.tableModel = (TableModelProxy) table.getModel();
        this.tableHeader = table.getTableHeader();
        selectBox = new JCheckBox(tableModel.getColumnName(table.getColumnCount() - 1));
        selectBox.setSelected(false);
        tableHeader.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    // 获得选中列
                    int selectColumn = tableHeader.columnAtPoint(e.getPoint());
                    if (selectColumn == table.getColumnCount() - 1) {
                        boolean value = !selectBox.isSelected();
                        selectBox.setSelected(value);
                        tableModel.selectAllOrNull(value);
                        tableHeader.repaint();
                    }
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // TODO Auto-generated method stub
        String valueStr = (String) value;
        JLabel label = new JLabel(valueStr);
        label.setHorizontalAlignment(SwingConstants.CENTER); // 表头标签剧中
        selectBox.setHorizontalAlignment(SwingConstants.CENTER);// 表头标签剧中
        selectBox.setBorderPainted(true);
        JComponent component = (column == table.getColumnCount() - 1) ? selectBox : label;

        component.setForeground(tableHeader.getForeground());
        component.setBackground(tableHeader.getBackground());
        component.setFont(tableHeader.getFont());
        component.setBorder(UIManager.getBorder("TableHeader.cellBorder"));

        return component;
    }

}
