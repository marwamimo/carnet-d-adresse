/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.Contact;
import utils.Traitement;
import vue.Carnet;

/**
 *classe  contenant main
 * @author HP
 */
public class CtrApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Traitement tr = new Traitement();
        File file= new File("contact.txt");
        Carnet fen = new Carnet(tr,file);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);

    }

}
