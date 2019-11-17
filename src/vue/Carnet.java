/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import modele.*;
import utils.ManipFichier;
import utils.Traitement;

/**
 * classe réprésentant l'interface de l application
 *
 * @author HP
 */
public class Carnet extends JFrame {

    private File file;
    private DefaultTableModel model = new DefaultTableModel();
    private int selectedRow;
    private Traitement tr;
    private boolean modif;

    /*
     * Creates new form Carnet
    *@param tr de type Traitement (classe)
    *@param file le fichier texte 
     */
    public Carnet(Traitement tr, File file) {
        this.tr = tr;
        this.file = file;
        initComponents();
        initDefaultFunction();

    }

    /*
    permet d'initialiser l'interface 
     */
    private void initDefaultFunction() {
        model = (DefaultTableModel) jtable.getModel();
        //recuperer les contacts existants dans le fichier
        ManipFichier.lireFichier(model, file);
        jtable.setOpaque(true);
        //desactiver des boutons 
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        afficherColonnePrecises(model, jtable);
    }

    /*
     * afficher les 3 premieres colonnes de jtable et cacher les autres
     *@param model le modele par defaut du Jtable
     * @param jtable de type JTable
     */
    private void afficherColonnePrecises(DefaultTableModel model, JTable jtable) {

        JTableHeader header = jtable.getTableHeader();
        for (int i = 0; i < 4; i++) {
            TableColumn column = jtable.getColumnModel().getColumn(i);
            header.setResizingColumn(column);
            column.setMinWidth(189);
            column.setWidth(189);
        }
        for (int i = 3; i < model.getColumnCount(); i++) {
            TableColumn column = jtable.getColumnModel().getColumn(i);
            header.setResizingColumn(column);
            column.setMinWidth(0);
            column.setWidth(0);
        }
    }

    /*
    *rendre les jtextfields editable
    @param j1...j9 de type JtextField
     */
    private void modifierJTextFields(JTextField j1, JTextField j2, JTextField j3,
            JTextField j4, JTextField j5, JTextField j6, JTextField j7, JTextField j8, JTextField j9) {
        j1.setEditable(true);
        j2.setEditable(true);
        j3.setEditable(true);
        j4.setEditable(true);
        j5.setEditable(true);
        j6.setEditable(true);
        j7.setEditable(true);
        j8.setEditable(true);
        j9.setEditable(true);
    }

    /*
    *ajouter nouveau contact dans Jtable
    *@param item de type Classe Contact
    *@param d le modle par defaut du JTable
     */
    private void ajouterContactDansJTable(Contact item, DefaultTableModel d) {
        String[] contactModel = {item.getNom(), item.getPrenom(), item.getTel(),
            item.getMail(), item.getNumeroAppartement(), item.getRue(),
            item.getCity(), item.getState(), item.getZip()};
        d.addRow(contactModel);
    }

    /*
       *permet de supprimer une ligne du jtable
       *@param selectedRow la ligne selectionnée
       *@param d le modele par defaut du jtable
     */
    private void supprimerLigne(int selectedRow, DefaultTableModel d) {
        d.removeRow(selectedRow);
    }

    /*
    *permet de rechercher une chaine dans JTable dynamiquement
    *@param chaine la chaine à chercher 
    *@param model le modele par defauts du jTable
    *@param jtable le nom d'un JTable
     */
    private void rechercher(String chaine, DefaultTableModel model, JTable jtable) {
        TableRowSorter tableRechercher = new TableRowSorter(model);
        jtable.setRowSorter(tableRechercher);
        tableRechercher.setRowFilter(RowFilter.regexFilter(chaine));

    }

    /*
      *rendre les JtextFields non editable
     */
    private void unmodifierJTextFields(JTextField j1, JTextField j2, JTextField j3,
            JTextField j4, JTextField j5, JTextField j6, JTextField j7, JTextField j8, JTextField j9) {
        j1.setEditable(false);
        j2.setEditable(false);
        j3.setEditable(false);
        j4.setEditable(false);
        j5.setEditable(false);
        j6.setEditable(false);
        j7.setEditable(false);
        j8.setEditable(false);
        j9.setEditable(false);
    }

    /*
     *initialiser les jtextFields
     */
    private void initialiserJTextFields(JTextField j1, JTextField j2, JTextField j3,
            JTextField j4, JTextField j5, JTextField j6, JTextField j7, JTextField j8, JTextField j9) {
        j1.setText("Last Name");
        j2.setText("First Name");
        j3.setText("Phone");
        j4.setText("Email");
        j5.setText("House number");
        j6.setText(" Street address");
        j7.setText("City");
        j8.setText("State");
        j9.setText("Zip");
    }

    /*
     * desactiver les JtextFields
     */
    private void desactiverJTextFields(JTextField j1, JTextField j2, JTextField j3,
            JTextField j4, JTextField j5, JTextField j6, JTextField j7, JTextField j8, JTextField j9) {
        j1.setEnabled(false);
        j2.setEnabled(false);
        j3.setEnabled(false);
        j4.setEnabled(false);
        j5.setEnabled(false);
        j6.setEnabled(false);
        j7.setEnabled(false);
        j8.setEnabled(false);
        j9.setEnabled(false);
    }

    /*
     *activer les JtextFields
     */
    private void activerJTextFields(JTextField j1, JTextField j2, JTextField j3,
            JTextField j4, JTextField j5, JTextField j6, JTextField j7, JTextField j8, JTextField j9) {
        j1.setEnabled(true);
        j2.setEnabled(true);
        j3.setEnabled(true);
        j4.setEnabled(true);
        j5.setEnabled(true);
        j6.setEnabled(true);
        j7.setEnabled(true);
        j8.setEnabled(true);
        j9.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panFormulaire = new javax.swing.JPanel();
        txtFirst = new javax.swing.JTextField();
        txtLast = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtPhone1 = new javax.swing.JTextField();
        txtHousNumber = new javax.swing.JTextField();
        txtStreetAdress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        txtZip = new javax.swing.JTextField();
        fermer = new javax.swing.JLabel();
        reduire = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        txtRechercher = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carnet.png"))); // NOI18N
        jLabel7.setText("Adress Book");

        panFormulaire.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102)));

        txtFirst.setText("First Name");
        txtFirst.setEnabled(false);
        txtFirst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstFocusLost(evt);
            }
        });

        txtLast.setText("Last Name");
        txtLast.setEnabled(false);
        txtLast.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLastFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastFocusLost(evt);
            }
        });

        txtMail.setText("Email");
        txtMail.setEnabled(false);
        txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMailFocusLost(evt);
            }
        });

        txtPhone1.setText("Phone");
        txtPhone1.setEnabled(false);
        txtPhone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhone1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhone1FocusLost(evt);
            }
        });

        txtHousNumber.setText("House number");
        txtHousNumber.setEnabled(false);
        txtHousNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHousNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHousNumberFocusLost(evt);
            }
        });

        txtStreetAdress.setText(" Street address");
        txtStreetAdress.setEnabled(false);
        txtStreetAdress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStreetAdressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStreetAdressFocusLost(evt);
            }
        });

        txtCity.setText("City");
        txtCity.setEnabled(false);
        txtCity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCityFocusLost(evt);
            }
        });

        txtState.setText("State");
        txtState.setEnabled(false);
        txtState.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStateFocusLost(evt);
            }
        });

        txtZip.setText("Zip");
        txtZip.setEnabled(false);
        txtZip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtZipFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtZipFocusLost(evt);
            }
        });

        javax.swing.GroupLayout panFormulaireLayout = new javax.swing.GroupLayout(panFormulaire);
        panFormulaire.setLayout(panFormulaireLayout);
        panFormulaireLayout.setHorizontalGroup(
            panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormulaireLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panFormulaireLayout.createSequentialGroup()
                            .addComponent(txtHousNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtStreetAdress))
                        .addComponent(txtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhone1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormulaireLayout.createSequentialGroup()
                            .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panFormulaireLayout.createSequentialGroup()
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtState)))
                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        panFormulaireLayout.setVerticalGroup(
            panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormulaireLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHousNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStreetAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panFormulaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtState))
                .addGap(18, 18, 18)
                .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        fermer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fermer.setForeground(new java.awt.Color(255, 255, 255));
        fermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fermer.png"))); // NOI18N
        fermer.setText(" X");
        fermer.setToolTipText("Close");
        fermer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fermer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fermerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fermerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fermerMouseExited(evt);
            }
        });

        reduire.setBackground(new java.awt.Color(0, 0, 0));
        reduire.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        reduire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/moins.png"))); // NOI18N
        reduire.setText(" -");
        reduire.setToolTipText("Reduce");
        reduire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reduire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reduireMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reduireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reduireMouseExited(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajouter.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sauvgarder.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supprimer.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modifier.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/effacer.png"))); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jtable.setAutoCreateRowSorter(true);
        jtable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102)));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last name", "First Name", "Phone", "Email", "House number", "Street adress", "City", "State", "Zip"
            }
        ));
        jtable.setEditingColumn(0);
        jtable.setEditingRow(0);
        jtable.setSelectionBackground(new java.awt.Color(255, 204, 102));
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtable);

        txtRechercher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRechercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRechercherKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rechercher.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reduire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(panFormulaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fermer)
                        .addComponent(reduire)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panFormulaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRechercher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reduireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMouseEntered
        Border brReduire = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        reduire.setBorder(brReduire);
    }//GEN-LAST:event_reduireMouseEntered

    private void reduireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMouseExited
        Border brReduire = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        reduire.setBorder(brReduire);
    }//GEN-LAST:event_reduireMouseExited

    private void fermerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseEntered
        Border brfermer = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        fermer.setBorder(brfermer);
    }//GEN-LAST:event_fermerMouseEntered

    private void fermerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseExited
        Border brfermer = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        fermer.setBorder(brfermer);
    }//GEN-LAST:event_fermerMouseExited

    private void reduireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_reduireMouseClicked

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
        this.dispose();
    }//GEN-LAST:event_fermerMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        activerJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
        modifierJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        btnNew.setEnabled(false);

    }//GEN-LAST:event_btnNewActionPerformed

    private void txtLastFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastFocusGained
        if (txtLast.getText().trim().equals("Last Name")) {
            txtLast.setText("");
            //default border 
            txtLast.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtLastFocusGained

    private void txtLastFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastFocusLost
        if (txtLast.getText().trim().equals("")) {
            txtLast.setText("Last Name");
        }
    }//GEN-LAST:event_txtLastFocusLost

    private void txtFirstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstFocusGained
        if (txtFirst.getText().trim().equals("First Name")) {
            txtFirst.setText("");
            //default border 
            txtFirst.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtFirstFocusGained

    private void txtFirstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstFocusLost
        if (txtFirst.getText().trim().equals("")) {
            txtFirst.setText("First Name");
        }
    }//GEN-LAST:event_txtFirstFocusLost

    private void txtPhone1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhone1FocusGained
        if (txtPhone1.getText().trim().equals("Phone")) {
            txtPhone1.setText("");
            //default border 
            txtPhone1.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtPhone1FocusGained

    private void txtPhone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhone1FocusLost
        if (txtPhone1.getText().trim().equals("")) {
            txtPhone1.setText("Phone");
        }
    }//GEN-LAST:event_txtPhone1FocusLost

    private void txtMailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMailFocusGained
        if (txtMail.getText().trim().equals("Email")) {
            txtMail.setText("");
            //default border 
            txtMail.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtMailFocusGained

    private void txtMailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMailFocusLost
        if (txtMail.getText().trim().equals("")) {
            txtMail.setText("Email");
        }
    }//GEN-LAST:event_txtMailFocusLost

    private void txtHousNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHousNumberFocusGained
        if (txtHousNumber.getText().trim().equals("House number")) {
            txtHousNumber.setText("");
            //default border 
            txtHousNumber.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtHousNumberFocusGained

    private void txtHousNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHousNumberFocusLost
        if (txtHousNumber.getText().trim().equals("")) {
            txtHousNumber.setText("House number");
        }
    }//GEN-LAST:event_txtHousNumberFocusLost

    private void txtStreetAdressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStreetAdressFocusGained
        if (txtStreetAdress.getText().trim().equals("Street address")) {
            txtStreetAdress.setText("");
            //default border 
            txtStreetAdress.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtStreetAdressFocusGained

    private void txtStreetAdressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStreetAdressFocusLost
        if (txtStreetAdress.getText().trim().equals("")) {
            txtStreetAdress.setText("Street address");
        }
    }//GEN-LAST:event_txtStreetAdressFocusLost

    private void txtCityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCityFocusGained
        if (txtCity.getText().trim().equals("City")) {
            txtCity.setText("");
            //default border 
            txtCity.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtCityFocusGained

    private void txtCityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCityFocusLost
        if (txtCity.getText().trim().equals("")) {
            txtCity.setText("City");
        }
    }//GEN-LAST:event_txtCityFocusLost

    private void txtStateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStateFocusGained
        if (txtState.getText().trim().equals("State")) {
            txtState.setText("");
            //default border 
            txtState.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtStateFocusGained

    private void txtStateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStateFocusLost
        if (txtState.getText().trim().equals("")) {
            txtState.setText("State");
        }
    }//GEN-LAST:event_txtStateFocusLost

    private void txtZipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtZipFocusGained
        if (txtZip.getText().trim().equals("Zip")) {
            txtZip.setText("");
            //default border 
            txtZip.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_txtZipFocusGained

    private void txtZipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtZipFocusLost
        if (txtZip.getText().trim().equals("")) {
            txtZip.setText("State");
        }
    }//GEN-LAST:event_txtZipFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (modif == false) {
            if (txtLast.getText().equals("Last Name")) {
                txtLast.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "this field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (txtFirst.getText().equals("First Name")) {
                txtFirst.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "this field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if ((txtPhone1.getText().equals("Phone"))) {
                txtPhone1.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "this field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (txtMail.getText().equals("Email")) {
                txtMail.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "this field is required !!"
                        + "! ", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            } else if (txtHousNumber.getText().equals("House number")) {
                txtHousNumber.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "This field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (txtStreetAdress.getText().equals(" Street address")) {
                txtStreetAdress.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " This field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (txtCity.getText().equals("City")) {
                txtCity.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " This field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (txtState.getText().equals("State")) {
                txtState.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " This field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (txtZip.getText().equals("Zip")) {
                txtZip.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " This field is required !!",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.existPhone(txtPhone1.getText(), model)) {
                txtPhone1.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " This phone number already exists! ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.numeroEstValide(txtPhone1.getText())) {
                txtPhone1.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " The phone number format is incorrect!! the phone number must be numeric",
                        "Typing error", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.existMail(txtMail.getText(), model)) {
                txtMail.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " this email already exists!!  ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.mailEstValide(txtMail.getText())) {
                txtMail.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " This email format is incorrect !!  the mail must be contained @ ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, " Successfully added !! ",
                        "Add the contact", JOptionPane.INFORMATION_MESSAGE);

                Contact contact = new Contact(txtLast.getText(), txtFirst.getText(), txtPhone1.getText(), txtMail.getText(), txtHousNumber.getText(),
                        txtStreetAdress.getText(), txtCity.getText(), txtState.getText(),
                        txtZip.getText());
                //ajouter dans JTable
                ajouterContactDansJTable(contact, model);
                //ajouter dans fichier
                ManipFichier.ecrireContactFichier(contact, file);
                initialiserJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                        txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
                desactiverJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                        txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
                txtPhone1.setBorder(new JTextField().getBorder());
                txtMail.setBorder(new JTextField().getBorder());
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
                btnNew.setEnabled(true);
            }
        }
        if (modif == true) {

            if (!tr.verifierPhoneExistModifié(txtPhone1.getText(), model, selectedRow)) {
                txtPhone1.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "this phone number already exists!! ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.numeroEstValide(txtPhone1.getText())) {
                txtPhone1.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "the phone number format is incorrect!! ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.existMailModif(txtMail.getText(), model, selectedRow)) {
                txtMail.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, " this email already exists! ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else if (!tr.mailEstValide(txtMail.getText())) {
                txtMail.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "the email format is incorrect ",
                        "Typing error ", JOptionPane.ERROR_MESSAGE);
            } else {
                jtable.getModel().setValueAt(txtLast.getText(), selectedRow, 0);
                jtable.getModel().setValueAt(txtFirst.getText(), selectedRow, 1);
                jtable.getModel().setValueAt(txtPhone1.getText(), selectedRow, 2);
                jtable.getModel().setValueAt(txtMail.getText(), selectedRow, 3);
                jtable.getModel().setValueAt(txtHousNumber.getText(), selectedRow, 4);
                jtable.getModel().setValueAt(txtStreetAdress.getText(), selectedRow, 5);
                jtable.getModel().setValueAt(txtState.getText(), selectedRow, 6);
                jtable.getModel().setValueAt(txtCity.getText(), selectedRow, 7);
                jtable.getModel().setValueAt(txtZip.getText(), selectedRow, 8);
                JOptionPane.showMessageDialog(null, "Successful modification ",
                        "Edit the contact", JOptionPane.INFORMATION_MESSAGE);
                file.delete();
                ManipFichier.mettreJourFichier(model);
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
                btnNew.setEnabled(true);

                initialiserJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                        txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);

                desactiverJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                        txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        initialiserJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);

        desactiverJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);

        txtLast.setBorder(new JTextField().getBorder());
        txtFirst.setBorder(new JTextField().getBorder());
        txtPhone1.setBorder(new JTextField().getBorder());
        txtMail.setBorder(new JTextField().getBorder());
        txtHousNumber.setBorder(new JTextField().getBorder());
        txtStreetAdress.setBorder(new JTextField().getBorder());
        txtCity.setBorder(new JTextField().getBorder());
        txtState.setBorder(new JTextField().getBorder());
        txtZip.setBorder(new JTextField().getBorder());

        btnNew.setEnabled(true);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);


    }//GEN-LAST:event_btnCancelActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked

        btnNew.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
        btnEdit.setEnabled(true);
        btnCancel.setEnabled(true);

        selectedRow = jtable.getSelectedRow();

        unmodifierJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);

        txtLast.setText(jtable.getModel().getValueAt(selectedRow, 0).toString());
        txtFirst.setText(jtable.getModel().getValueAt(selectedRow, 1).toString());
        txtPhone1.setText(jtable.getModel().getValueAt(selectedRow, 2).toString());
        txtMail.setText(jtable.getModel().getValueAt(selectedRow, 3).toString());
        txtHousNumber.setText(jtable.getModel().getValueAt(selectedRow, 4).toString());
        txtStreetAdress.setText(jtable.getModel().getValueAt(selectedRow, 5).toString());
        txtCity.setText(jtable.getModel().getValueAt(selectedRow, 6).toString());
        txtState.setText(jtable.getModel().getValueAt(selectedRow, 7).toString());
        txtZip.setText(jtable.getModel().getValueAt(selectedRow, 8).toString());
    }//GEN-LAST:event_jtableMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//       JOptionPane d = new JOptionPane(); 
//       int retour = JOptionPane.showConfirmDialog(this,
//             "OK - Annuler", 
//             "titre",
//             JOptionPane.OK_CANCEL_OPTION);
//        String choix[]={ "yes", "no"};
        int option = JOptionPane.showConfirmDialog(this, "are you sure to delete this contact?",
                "Delete the Contact", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            supprimerLigne(selectedRow, model);
            initialiserJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                    txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
            desactiverJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                    txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
            JOptionPane.showMessageDialog(null, "this contact is deleted!",
                    "Delete the contact", JOptionPane.INFORMATION_MESSAGE);
            file.delete();
            ManipFichier.mettreJourFichier(model);

        } else if (option == JOptionPane.NO_OPTION) {
            initialiserJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                    txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
            desactiverJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                    txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
        }
        btnNew.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnCancel.setEnabled(false);

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        modif = true;
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(true);
        btnNew.setEnabled(false);
        btnEdit.setEnabled(false);

        activerJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);

        modifierJTextFields(txtLast, txtFirst, txtPhone1, txtMail,
                txtHousNumber, txtStreetAdress, txtCity, txtState, txtZip);
        String nom, prenom, tel, mail, numeroApp, adresse, state, city, zip;

        if ((evt.getSource() == btnSave) && (modif == true)) {
            file.delete();
            ManipFichier.mettreJourFichier(model);

        } else if ((evt.getSource() == btnCancel) && (modif == true)) {

            nom = jtable.getModel().getValueAt(selectedRow, 0).toString();
            prenom = jtable.getModel().getValueAt(selectedRow, 1).toString();
            tel = jtable.getModel().getValueAt(selectedRow, 2).toString();
            mail = jtable.getModel().getValueAt(selectedRow, 3).toString();
            numeroApp = jtable.getModel().getValueAt(selectedRow, 4).toString();
            adresse = jtable.getModel().getValueAt(selectedRow, 5).toString();
            city = jtable.getModel().getValueAt(selectedRow, 6).toString();
            state = jtable.getModel().getValueAt(selectedRow, 7).toString();
            zip = jtable.getModel().getValueAt(selectedRow, 8).toString();
            JOptionPane.showMessageDialog(null, "the change is canceled ",
                    "Cancel the change ", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtRechercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRechercherKeyReleased

        String chaine = txtRechercher.getText().toLowerCase();
        rechercher(chaine, model, jtable);
    }//GEN-LAST:event_txtRechercherKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable;
    private javax.swing.JPanel panFormulaire;
    private javax.swing.JLabel reduire;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JTextField txtHousNumber;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtRechercher;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreetAdress;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables

}
