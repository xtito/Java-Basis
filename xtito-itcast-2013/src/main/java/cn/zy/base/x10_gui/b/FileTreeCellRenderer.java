package cn.zy.base.x10_gui.b;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by [Zy]
 * 2017/4/15 20:41
 */
public class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    /**
     * File system view.
     */
    protected static FileSystemView fsv = FileSystemView.getFileSystemView();

    /**
     * Icon cache to speed the rendering.
     */
    private Map<String, Icon> iconCache = new HashMap<String, Icon>();
    /**
     * Root name cache to speed the rendering.
     */
    private Map<File, String> rootNameCache = new HashMap<File, String>();
    /*
    * (non-Javadoc)
    *
    * @see javax.swing.tree.DefaultTreeCellRenderer#getTreeCellRendererComponent(javax.swing.JTree,
    *      java.lang.Object, boolean, boolean, boolean, int, boolean)
    */
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean sel, boolean expanded, boolean leaf, int row,
                                                  boolean hasFocus) {
        FileTreeNode ftn = (FileTreeNode) value;
        File file = ftn.getFile();
        String filename = "";
        if (file != null) {
            if (ftn.getIsFileSystemRoot()) {
                // long start = System.currentTimeMillis();
                filename = this.rootNameCache.get(file);
                if (filename == null) {
                    filename = fsv.getSystemDisplayName(file);
                    this.rootNameCache.put(file, filename);
                }
                // long end = System.currentTimeMillis();
                // System.out.println(filename + ":" + (end - start));
            } else {
                filename = file.getName();
            }
        }
        JLabel result = (JLabel) super.getTreeCellRendererComponent(tree,
                filename, sel, expanded, leaf, row, hasFocus);
        if (file != null) {
            Icon icon = this.iconCache.get(filename);
            if (icon == null) {
                // System.out.println("Getting icon of " + filename);
                icon = fsv.getSystemIcon(file);
                this.iconCache.put(filename, icon);
            }
            result.setIcon(icon);
        }
        return result;
    }

}
