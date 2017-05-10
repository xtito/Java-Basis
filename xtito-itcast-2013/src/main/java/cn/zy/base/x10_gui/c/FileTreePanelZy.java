package cn.zy.base.x10_gui.c;

import cn.zy.base.x10_gui.b.FileTreeCellRenderer;
import cn.zy.base.x10_gui.b.FileTreeNode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

/**
 * Created by [Zy]
 * 2017/5/10 14:30
 */
public class FileTreePanelZy extends JPanel {

    private JTree tree;

    public FileTreePanelZy() {
        this.setLayout(new BorderLayout());
        File[] roots = File.listRoots();
        FileTreeNode rootTreeNode = new FileTreeNode(roots);
        this.tree = new JTree(rootTreeNode);
        this.tree.setCellRenderer(new FileTreeCellRenderer());
        this.tree.setRootVisible(false);
        final JScrollPane jsp = new JScrollPane(this.tree);
        jsp.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.add(jsp, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("File tree");
                frame.setSize(500, 400);
                frame.setLocationRelativeTo(null);
                frame.add(new FileTreePanelZy());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        System.out.println("a");
    }

}
