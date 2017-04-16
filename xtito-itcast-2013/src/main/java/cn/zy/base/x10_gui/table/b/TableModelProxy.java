package cn.zy.base.x10_gui.table.b;

import javax.swing.table.AbstractTableModel;

/**
 * Created by [Zy]
 * 2017/4/16 19:28
 */
public class TableModelProxy extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = -3295581072864170310L;
    private String[] columnNames;

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }


    public void setData(Object[][] data) {
        this.data = data;
    }

    private Object[][] data;

    public TableModelProxy(String[] columnNames, Object[][] data) {
        // TODO Auto-generated constructor stub
        this.columnNames = columnNames;
        this.data = data;
    }


    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return columnNames[column];
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // TODO Auto-generated method stub
        return getValueAt(0, columnIndex).getClass();
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        // Only the last column can be edit.
        return rowIndex >= columnNames.length - 1;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }


    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return data[rowIndex][columnIndex];
    }

    public void selectAllOrNull(boolean value){
        // Select All. The last column
        for(int index = 0; index < getRowCount(); index ++){
            this.setValueAt(value, index, getColumnCount() - 1);
        }
    }

}
