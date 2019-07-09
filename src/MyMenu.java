import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/*
 * This class exists solely to show you what menus look like.
 * It has no menu-related event handling.
 * @author Hephaest
 * @since 28/04/2019
 */
public class MyMenu {
    JPanel contentPane;
    JFrame frame;
    JToolBar viewbar;
    JToolBar toolbar;

    public MyMenu(JFrame frame){
        this.frame = frame;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        ImageIcon icon;
        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the file menu.
        menu = new JMenu("File");

        //a group of JMenuItems
        JMenuItem newItem = new JMenuItem("New");
        menu.add(newItem);

        //a submenu
        icon = new ImageIcon("src/images/folder-open.png");
        submenu = new JMenu("Open");
        submenu.setIcon(icon);

        JMenuItem fileItem = new JMenuItem("File");
        submenu.add(fileItem);

        JMenuItem copyItem = new JMenuItem("Copy of File");
        submenu.add(copyItem);

        JMenuItem mailItem = new JMenuItem("Mail");
        submenu.add(mailItem);

        menu.add(submenu);

        menuItem = new JMenuItem("Close File");
        menu.add(menuItem);

        menu.addSeparator();
        icon = new ImageIcon("src/images/seting.png");
        menuItem = new JMenuItem("Preferences",icon);
        menu.add(menuItem);

        menu.addSeparator();
        icon = new ImageIcon("src/images/mail.png");
        menuItem = new JMenuItem("Send Mail",icon);
        menu.add(menuItem);

        menu.addSeparator();
        icon = new ImageIcon("src/images/save.png");
        menuItem = new JMenuItem("Save",icon);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menu.add(menuItem);

        menuItem = new JMenuItem("Save As");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK + ActionEvent.CTRL_MASK));
        menu.add(menuItem);

        menu.addSeparator();

        icon = new ImageIcon("src/images/print.png");
        submenu = new JMenu("Print");
        submenu.setIcon(icon);

        menuItem = new JMenuItem("Print review");
        submenu.add(menuItem);

        menu.add(submenu);

        menu.addSeparator();
        menuItem = new JMenuItem("Quit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menu.add(menuItem);

        menuBar.add(menu);

        //Build the general menu.
        menu = new JMenu("General");
        menu.addMenuListener(new MenuListener() {
            JMenuItem toolItem;
            ImageIcon icon;
            public void menuSelected(MenuEvent e) {
                if(viewbar != null ) {
                    viewbar.setVisible(false);
                    frame.remove(viewbar);
                }

                if(toolbar == null) {
                    toolbar = new JToolBar();
                    JMenuBar menuBar = new JMenuBar();
                    // Font
                    ImageIcon fontIcon = new ImageIcon("src/images/font.png");
                    JMenu font = new JMenu("");
                    font.setIcon(fontIcon);

                    icon = new ImageIcon("src/images/eraser.png");
                    toolItem = new JMenuItem("Plain Text",icon);
                    font.add(toolItem);

                    icon = new ImageIcon("src/images/bold.png");
                    toolItem = new JMenuItem("Bold Text",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
                    font.add(toolItem);

                    icon = new ImageIcon("src/images/Italics.png");
                    toolItem = new JMenuItem("Italic Text",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
                    font.add(toolItem);

                    icon = new ImageIcon("src/images/underline.png");
                    toolItem = new JMenuItem("Underline Text",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
                    font.add(toolItem);

                    font.addSeparator();

                    toolItem = new JMenuItem("Change Font");
                    font.add(toolItem);

                    icon = new ImageIcon("src/images/font_size_up.png");
                    toolItem = new JMenuItem("Increase Point Size",icon);
                    font.add(toolItem);

                    icon = new ImageIcon("src/images/font_size_down.png");
                    toolItem = new JMenuItem("Decrease Point Size",icon);
                    font.add(toolItem);

                    font.addSeparator();
                    icon = new ImageIcon("src/images/character.png");
                    toolItem = new JMenuItem("Character Style",icon);
                    font.add(toolItem);

                    toolItem = new JMenuItem("Format Paragraph");
                    font.add(toolItem);

                    menuBar.add(font);

                    // Clipboard
                    ImageIcon clipIcon = new ImageIcon("src/images/clipboard.png");
                    JMenu clipboard = new JMenu("");
                    clipboard.setIcon(clipIcon);

                    icon = new ImageIcon("src/images/cut.png");
                    toolItem = new JMenuItem("Cut",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                    clipboard.add(toolItem);

                    icon = new ImageIcon("src/images/copy.png");
                    toolItem = new JMenuItem("Copy",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
                    clipboard.add(toolItem);

                    icon = new ImageIcon("src/images/paste.png");
                    toolItem = new JMenuItem("Paste",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
                    clipboard.add(toolItem);

                    icon = new ImageIcon("src/images/clear.png");
                    toolItem = new JMenuItem("Clear", icon);
                    clipboard.add(toolItem);
                    menuBar.add(clipboard);

                    // Edit
                    ImageIcon editIcon = new ImageIcon("src/images/edit.png");
                    JMenu editbtn = new JMenu("");
                    editbtn.setIcon(editIcon);

                    icon = new ImageIcon("src/images/undo.png");
                    toolItem = new JMenuItem("Undo",icon);
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
                    editbtn.add(toolItem);

                    icon = new ImageIcon("src/images/repeat.png");
                    toolItem = new JMenuItem("Repeat Edit",icon);
                    editbtn.add(toolItem);

                    editbtn.addSeparator();

                    JMenu design = new JMenu("Design");
                    icon = new ImageIcon("src/images/renumber.png");
                    toolItem = new JMenuItem("Renumber Pages",icon);
                    design.add(toolItem);
                    toolItem = new JMenuItem("Repaginate");
                    design.add(toolItem);
                    editbtn.add(design);

                    editbtn.addSeparator();

                    icon = new ImageIcon("src/images/find.png");
                    JMenu search = new JMenu("Find word");
                    toolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
                    search.setIcon(icon);
                    toolItem = new JMenuItem("Go To");
                    search.add(toolItem);
                    toolItem = new JMenuItem("Go Back");
                    search.add(toolItem);
                    editbtn.add(search);

                    icon = new ImageIcon("src/images/replace.png");
                    toolItem = new JMenuItem("Change Word",icon);
                    editbtn.add(toolItem);

                    editbtn.addSeparator();

                    toolItem = new JMenuItem("Delete");
                    toolItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
                    editbtn.add(toolItem);

                    menuBar.add(editbtn);

                    toolbar.add(menuBar);
                }
                frame.add(toolbar, BorderLayout.PAGE_START);
                toolbar.setVisible(true);
                frame.setVisible(true);
            }

            public void menuDeselected(MenuEvent e) {
                //do nothing
            }

            public void menuCanceled(MenuEvent e) {
                // do nothing
            }
        });
        menuBar.add(menu);

        //Build the insert menu.
        menu = new JMenu("Insert");
        icon = new ImageIcon("src/images/picture.png");
        menuItem = new JMenuItem("Graphic",icon);
        menu.add(menuItem);
        icon = new ImageIcon("src/images/table.png");
        menuItem = new JMenuItem("Table",icon);
        menu.add(menuItem);
        icon = new ImageIcon("src/images/page-break.png");
        menuItem = new JMenuItem("Page Break",icon);
        menu.add(menuItem);
        menuBar.add(menu);

        //Build the layout menu.
        menu = new JMenu("Layout");
        menuItem = new JMenuItem("Page setup");
        menu.add(menuItem);
        icon = new ImageIcon("src/images/document.png");
        menuItem = new JMenuItem("Document",icon);
        menu.add(menuItem);
        menuBar.add(menu);

        //Build the references menu.
        menu = new JMenu("References");
        icon = new ImageIcon("src/images/contents.png");
        menuItem = new JMenuItem("Table of contents",icon);
        menu.add(menuItem);

        icon = new ImageIcon("src/images/footnote.png");
        menuItem = new JMenuItem("Add Footnote",icon);
        menu.add(menuItem);

        menuItem = new JMenuItem("Insert Index");
        menu.add(menuItem);

        menuItem = new JMenuItem("View Index");
        menu.add(menuItem);
        menuBar.add(menu);

        //Build the references menu.
        menu = new JMenu("Review");
        icon = new ImageIcon("src/images/check.png");
        menuItem = new JMenuItem("Check Spelling",icon);
        menu.add(menuItem);

        icon = new ImageIcon("src/images/count.png");
        menuItem = new JMenuItem("Count Words",icon);
        menu.add(menuItem);

        icon = new ImageIcon("src/images/dictionary.png");
        menuItem = new JMenuItem("Glossary",icon);
        menu.add(menuItem);

        menuBar.add(menu);

        //Build the view menu.
        menu = new JMenu("View");
        menu.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                if(toolbar != null) {
                    toolbar.setVisible(false);
                    frame.remove(toolbar);
                }
                if(viewbar == null) {
                    viewbar = new JToolBar();
                    JMenuBar menuBar = new JMenuBar();
                    // Page
                    ImageIcon pageIcon = new ImageIcon("src/images/page.png");
                    JMenu page = new JMenu("View Page");
                    page.setIcon(pageIcon);
                    menuBar.add(page);

                    // Position on page
                    ImageIcon posIcon = new ImageIcon("src/images/position.png");
                    JMenu position = new JMenu("Position");
                    position.setIcon(posIcon);
                    menuBar.add(position);

                    // Show document
                    ImageIcon docIcon = new ImageIcon("src/images/documents.png");
                    JMenu document= new JMenu("Alternative Document");
                    document.setIcon(docIcon);
                    menuBar.add(document);

                    viewbar.add(menuBar);
                }
                frame.add(viewbar, BorderLayout.PAGE_START);
                viewbar.setVisible(true);
                frame.setVisible(true);
            }

            public void menuDeselected(MenuEvent e) {
            }

            public void menuCanceled(MenuEvent e) {
                // do nothing
            }
        });
        menuBar.add(menu);

        //Build the Assistant menu.
        menu = new JMenu("Assistant");
        icon = new ImageIcon("src/images/help.png");
        menuItem = new JMenuItem("Help",icon);
        menu.add(menuItem);
        menuBar.add(menu);

        return menuBar;
    }

    public Container createContentPane() {
        //Create the content-pane-to-be.
        contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a text area.
        JTextField text = new JTextField();
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setText("Copyright © 2019 Group Tau. All Rights Reserved.");
        contentPane.add(text);
        text.setEditable(false);
        text.setVisible(true);

        return contentPane;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Paper-based System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MyMenu demo = new MyMenu(frame);
        Image im = Toolkit.getDefaultToolkit().getImage("src/images/logo.png");
        frame.setIconImage(im);
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.setSize(450, 360);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
