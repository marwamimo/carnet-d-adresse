/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import modele.Contact;

/*
 * classe réprésentant les différents traitements
 *
 * @author HP
 */
public class Traitement {

    public Traitement() {
    }

    /*
     *verifier si le numero de telephone saisi  existe déja dans jtable
    *@param chaine la chaine à verifier 
    *@param model le modele par défaut du jTable 
     */
    public boolean existPhone(String chaine, DefaultTableModel d) {

        for (int k = 0; k < d.getRowCount(); k++) {
            if (d.getValueAt(k, 2).equals(chaine)) {

                return false;
            }
        }
        return true;

    }

    /*
    * verifier si le numero de tel qui est en train de modification,existe déja dans Jtable
    *@param chaine la nouvelle chaine existe déja 
    *@param j l'indice de la ligne 
    *@param model le modele par defaut di jtable
     */
    public boolean verifierPhoneExistModifié(String chaine, DefaultTableModel d, int j) {
        for (int k = 0; k < d.getRowCount(); k++) {
            if (k != j) {
                if (d.getValueAt(k, 2).equals(chaine)) {

                    return false;
                }
            }
        }
        return true;
    }

    /*
    *vérifier si l email existe déja dans jtable
    *@param chaine la chaine a verifier 
    *@param model le modele par defaut du jtable
     */
    public boolean existMail(String chaine, DefaultTableModel d) {

        for (int k = 0; k < d.getRowCount(); k++) {
            if (d.getValueAt(k, 3).equals(chaine)) {

                return false;
            }
        }
        return true;

    }

    /*
    * au moment de modification,verifier si email existe déja au non
    *@param chaine la chaine a verifier 
    * @param model le modele par defaut du jtable
    *@param j le numero de la ligne a modifier
     */
    public boolean existMailModif(String chaine, DefaultTableModel d, int j) {

        for (int k = 0; k < d.getRowCount(); k++) {
            if (k != j) {
                if (d.getValueAt(k, 3).equals(chaine)) {

                    return false;
                }
            }
        }
        return true;

    }

    /*
    *le numero de tel doit etre numerique 
    *@param monNumero la chaine a verifier 
    *@return de type boolean 
     */
    public boolean numeroEstValide(String monNumero) {

        return monNumero.matches("[0-9]*");

    }

    /*
    *verifier si email est valide ou nn 
    *@param mail la chaine a verifier 
    *@return de type boolean 
     */
    public boolean mailEstValide(String mail) {
        return mail.matches("^(.+)@(.+)$");
    }

}
