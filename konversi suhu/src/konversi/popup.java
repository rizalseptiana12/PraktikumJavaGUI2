package konversi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 
 */
public class popup extends JTextField{
    
    JPopupMenu popup = new JPopupMenu();
    JTextField text = this;
    UndoManager manager = new UndoManager(); 
    JMenuItem menuCut = new JMenuItem("Cut");
    JMenuItem menuCopy = new JMenuItem("Copy");
    JMenuItem menuPaste = new JMenuItem("Paste");
    JMenuItem menuUndo = new JMenuItem("Undo");
    JMenuItem menuRedo = new JMenuItem("Redo");

    public popup() {
        super();
        initAksi();
        initPopup();
    }
    
    private void initPopup(){
        this.setComponentPopupMenu(popup);
        popup.add(menuCut);
        popup.add(menuCopy);
        popup.add(menuPaste);
        JSeparator separator = new JSeparator();
        popup.add(separator);
        popup.add(menuUndo);
        popup.add(menuRedo);
    }
        
    private void initAksi(){
        menuCut.setIcon(new ImageIcon(getClass().getResource("/konversi/icon/cut-icon.png")));
        menuCut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                text.cut();
            }
        });
        
        menuCopy.setIcon(new ImageIcon(getClass().getResource("/konversi/icon/Copy-icon.png")));
        menuCopy.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                text.copy();
            }
        });
        
        menuPaste.setIcon(new ImageIcon(getClass().getResource("/konversi/icon/Paste-icon.png")));
        menuPaste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                text.paste();
            }
        });
        
        text.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });
        
        menuUndo.setIcon(new ImageIcon(getClass().getResource("/konversi/icon//Undo-icon.png")));
        menuUndo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.undo();
                } catch (CannotUndoException cannotUndoException) {
                    System.err.println(cannotUndoException);
                }
            }
        });
        
        menuRedo.setIcon(new ImageIcon(getClass().getResource("/konversi/icon/Redo-icon.png")));
        menuRedo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.redo();
                } catch (CannotRedoException cannotRedoException) {
                    System.err.println(cannotRedoException);
                }
            }
        });
    }
}
