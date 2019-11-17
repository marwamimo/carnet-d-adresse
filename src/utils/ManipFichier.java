/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modele.Contact;


/**
 * une classe qui permet de manipuler un fichier texte
 * @author HP
 */
public class ManipFichier {
    /*
    *ecrire un contact dans un fichier texte 
    *@param contact  de type Contact
    *@param file le fichier cible 
    */
    public static void ecrireContactFichier(Contact contact, File file) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        String ligne;
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            ligne = formerLigneCsv(contact);
            bw.write(ligne);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    *former une ligne contenant les différentes informations d'un contact 
    *@param item de type Contact(classe)
    @return une ligne 
    */
    public static String formerLigneCsv(Contact item) {
        return item.getNom() + " " + item.getPrenom() + " " + item.getTel()
                + " " + item.getMail()
                + " " + item.getNumeroAppartement() + " " + item.getRue()
                + " " + item.getCity() + " " + item.getState() + " " + item.getZip() + "\n";
    }
    /*
    *permet de mettre a jour le contenu d'un fichier texte au moment de la suppression ou la modification
    *@param model le modele par défaut du jtable 
    */
    public static void mettreJourFichier(DefaultTableModel model) {
        File file = new File("contact.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        String ligne;
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            for (int k = 0; k < model.getRowCount(); k++) {
                ligne = model.getValueAt(k, 0).toString() + " " + model.getValueAt(k, 1).toString() + " "
                        + model.getValueAt(k, 2).toString() + " " + model.getValueAt(k, 3).toString() + " "
                        + model.getValueAt(k, 4).toString() + " " + model.getValueAt(k, 5).toString() + " "
                        + model.getValueAt(k, 6).toString() + " " + model.getValueAt(k, 7).toString() + " "
                        + model.getValueAt(k, 8).toString() + "\n";
                bw.write(ligne);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    *permet de lire un fichier texte 
    *@param model le modele par defauts du Jtable
    *@param file le fichier texte a lire 
    */
      public static void lireFichier(DefaultTableModel model,File file) {

        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNext()) {//tant qu'il y a des choses à lire 
                StringTokenizer token = new StringTokenizer(sc.nextLine(), " ");
                Vector<String> rowData = new Vector<String>();
                while (token.hasMoreTokens()) {
                    rowData.add(token.nextToken());
                }
                model.addRow(rowData);
            }
            sc.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
}
