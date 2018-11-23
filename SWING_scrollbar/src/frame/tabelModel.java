/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RIZAL
 */
public class tabelModel extends AbstractTableModel {
ArrayList<data> fil = new ArrayList<>();
private String[] header = {"Nama","Pekerjaan","Hobby","Alamat","E-mail","Tentang"};
public data getData(int index){
    return fil.get(index);
}
public void insert(data d){
    fil.add(d);
    fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
}

    @Override
    public int getRowCount() {
        return fil.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return fil.get(rowIndex).getNama();
            case 1:
                return fil.get(rowIndex).getPekerjaan();
            case 2:
                return fil.get(rowIndex).getHobby();
            case 3:
                return fil.get(rowIndex).getAlamat();
            case 4:
                return fil.get(rowIndex).getEmail();
            case 5:
                return fil.get(rowIndex).getTentang();
            default:
                return null;
        }
    }
    public String getColumnName(int column){
        switch(column){
            case 0:
                return("Nama");
            case 1:
                return("Pekerjaan");
            case 2:
                return("Hobby");
            case 3:
                return("Alamat");
            case 4:
                return("E-mail");
            case 5:
                return("Tentang");
            default:
                return null;
        }
    }
    
}
