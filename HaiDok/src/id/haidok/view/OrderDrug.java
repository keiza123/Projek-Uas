package id.haidok.view;

import id.haidok.database.Drug;
import id.haidok.database.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Objects;

public class OrderDrug extends javax.swing.JFrame {
    private ArrayList<String> list_drug = new ArrayList<>();
    private ArrayList<Integer> list_price = new ArrayList<>();
    private String username = "Anonymous";

    OrderDrug() {

    }

    void runOrderDrug() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        renderListDrugToTable();
        renderOrderHistoryToTable();
        drug_table.setEnabled(false);
    }

    void setUsername(String username) {
        this.username = username;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        order_history = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        select_drug = new javax.swing.JComboBox<>();
        order = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        drug_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BackToMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HaiDok Pesan Obat");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        order_history.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Nama", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(order_history);
        if (order_history.getColumnModel().getColumnCount() > 0) {
            order_history.getColumnModel().getColumn(0).setResizable(false);
            order_history.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Pilih Obat");

        price.setBackground(new java.awt.Color(0, 0, 0));
        price.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        price.setForeground(new java.awt.Color(0, 0, 0));
        price.setText("Harga :");

        select_drug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_drugActionPerformed();
            }
        });

        order.setText("Pesan");
        order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderActionPerformed();
            }
        });

        drug_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null}
                },
                new String[]{
                        "Nama", "Harga"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        drug_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(drug_table);
        if (drug_table.getColumnModel().getColumnCount() > 0) {
            drug_table.getColumnModel().getColumn(0).setResizable(false);
            drug_table.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Riwayat Pemesanan");

        BackToMainMenu.setText("Back");
        BackToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMainMenuActionPerformed();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(418, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(select_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(price)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(BackToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(399, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(BackToMainMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(select_drug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(price)
                                .addGap(46, 46, 46)
                                .addComponent(order)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(66, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void orderActionPerformed() {
        String drug = Objects.requireNonNull(select_drug.getSelectedItem()).toString();

        int status = Transaction.getStatusTransactionUser(username);

        if (status == 1) {
            JOptionPane.showMessageDialog(null, "Transaksi sebelumnya masih aktif!", "Alert", JOptionPane.ERROR_MESSAGE);
        } else {

            int rowAffected = Transaction.orderDrug(username, drug);

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Pemesanan berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Pendaftaran gagal!", "Alert", JOptionPane.ERROR_MESSAGE);
            }
            renderOrderHistoryToTable();
        }
    }

    private void select_drugActionPerformed() {
        int index = list_drug.indexOf(Objects.requireNonNull(select_drug.getSelectedItem()).toString());
        Integer priceDrug = list_price.get(index);

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        price.setText(kursIndonesia.format(priceDrug));
    }

    private void BackToMainMenuActionPerformed() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        mainMenu.setUsername(username);
        this.setVisible(false);
    }

    private void renderListDrugToTable() {
        DefaultTableModel model = (DefaultTableModel) drug_table.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Drug.getListDrug();
        select_drug.removeAllItems();

        if (data != null) {
            for (String[] drug : data) {
                list_drug.add(drug[0]);
                list_price.add(Integer.valueOf(drug[1]));
                select_drug.addItem(drug[0]);
                String[] dataTable = {drug[0], drug[1]};
                model.addRow(dataTable);
            }
        }

        int index = list_drug.indexOf(Objects.requireNonNull(select_drug.getSelectedItem()).toString());
        Integer priceDrug = list_price.get(index);

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        price.setText(kursIndonesia.format(priceDrug));
    }

    private void renderOrderHistoryToTable() {
        DefaultTableModel model = (DefaultTableModel) order_history.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Transaction.getHistoryOrderUser(username);

        if (data != null) {
            for (String[] order : data) {
                String[] dataTable = {order[0], order[1]};
                model.addRow(dataTable);
            }
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDrug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDrug().setVisible(true);
            }
        });
    }

    private javax.swing.JButton BackToMainMenu;
    private javax.swing.JTable drug_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton order;
    private javax.swing.JTable order_history;
    private javax.swing.JLabel price;
    private javax.swing.JComboBox<String> select_drug;
}
