package id.haidok.view;

import id.haidok.database.Drug;
import id.haidok.database.Promise;
import id.haidok.database.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class Admin extends javax.swing.JFrame {
    ArrayList<String> listRoom = new ArrayList<>();
    ArrayList<String> listOrder = new ArrayList<>();

    public Admin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        renderListDrugOrderToTable();
        renderListPromiseRoomToTable();
        renderHistoryOrder();
        renderHistoryPromise();
        renderListDrugToTable();
        table_room.setEnabled(false);
        table_drug.setEnabled(false);
        table_order.setEnabled(false);
        complaint_display.setEditable(false);
        description_display.setEditable(false);
    }

    private void renderListDrugToTable() {
        DefaultTableModel model = (DefaultTableModel) table_drug.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Drug.getListDrug();
        comboDrug.removeAllItems();

        if (data != null) {
            for (String[] drug : data) {
                comboDrug.addItem(drug[0]);
                String[] dataTable = {drug[0], drug[1]};
                model.addRow(dataTable);
            }
        }
    }

    private void renderHistoryOrder() {
        DefaultTableModel model = (DefaultTableModel) history_order.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Transaction.getHistoryOrder();

        if (data != null) {
            for (String[] order : data) {
                String[] dataTable = {order[0], order[1], order[2]};
                model.addRow(dataTable);
            }
        }
    }

    private void renderHistoryPromise() {
        DefaultTableModel model = (DefaultTableModel) history_room.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Promise.getHistoryRoom();

        if (data != null) {
            for (String[] room : data) {
                String[] dataTable = {room[0], room[1], room[2], room[3]};
                model.addRow(dataTable);
            }
        }
    }

    private void renderListDrugOrderToTable() {
        DefaultTableModel model = (DefaultTableModel) table_order.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Transaction.getPendingOrder();
        comboOrder.removeAllItems();

        if (data != null) {
            for (String[] drug : data) {
                comboOrder.addItem(drug[0]);
                String[] dataTable = {drug[0], drug[1]};
                model.addRow(dataTable);
            }
        }
    }

    private void renderListPromiseRoomToTable() {
        DefaultTableModel model = (DefaultTableModel) table_room.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Promise.getPendingRoom();
        comboRoom.removeAllItems();

        if (data != null) {
            for (String[] room : data) {
                comboRoom.addItem(room[0]);
                String[] dataTable = {room[0], room[1], room[2]};
                model.addRow(dataTable);
            }
        }
    }

    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_room = new javax.swing.JTable();
        comboRoom = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        acceptRoom = new javax.swing.JButton();
        rejectRoom = new javax.swing.JButton();
        detailRoom = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        complaint_display = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        description_display = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_order = new javax.swing.JTable();
        comboOrder = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        sendOrder = new javax.swing.JButton();
        rejectOrder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        history_room = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        history_order = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        comboDrug = new javax.swing.JComboBox<>();
        buttonDelete = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        tfDrugName = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        scroll_drug = new javax.swing.JScrollPane();
        table_drug = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HaiDok Admin");

        table_room.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Nama", "Ruangan", "Waktu"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_room);

        jLabel1.setText("Nama");

        acceptRoom.setText("Terima");
        acceptRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptRoomActionPerformed();
            }
        });

        rejectRoom.setText("Tolak");
        rejectRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectRoomActionPerformed();
            }
        });

        detailRoom.setText("Detail");
        detailRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailRoomActionPerformed();
            }
        });

        complaint_display.setColumns(20);
        complaint_display.setRows(2);
        complaint_display.setText("Keluhan");
        jScrollPane3.setViewportView(complaint_display);

        description_display.setColumns(20);
        description_display.setRows(5);
        description_display.setText("Deskripsi");
        jScrollPane7.setViewportView(description_display);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(acceptRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rejectRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(detailRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(comboRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane7)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(acceptRoom)
                                                        .addComponent(rejectRoom)
                                                        .addComponent(detailRoom))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        jTabbedPane2.addTab("     Permintaan Ruangan     ", jPanel1);

        table_order.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Nama", "Obat"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_order);

        jLabel3.setText("Nama");

        sendOrder.setText("Kirim");
        sendOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendOrderActionPerformed();
            }
        });

        rejectOrder.setText("Tolak");
        rejectOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectOrderActionPerformed();
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(sendOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(rejectOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(comboOrder, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sendOrder)
                                        .addComponent(rejectOrder))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("     Pemesanan Obat     ", jPanel4);

        history_room.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "User", "Room", "Time", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane4.setViewportView(history_room);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("     Riwayat Ruangan     ", jPanel2);

        history_order.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "User", "Obat", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane5.setViewportView(history_order);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("     Riwayat Pemesanan Obat     ", jPanel3);

        buttonDelete.setText("Hapus");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed();
            }
        });

        buttonAdd.setText("Tambah");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed();
            }
        });

        tfPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPriceKeyTyped(evt);
            }
        });

        jLabel4.setText("Tambah Obat Baru");

        jLabel5.setText("Hapus Obat");

        jLabel6.setText("Nama");

        jLabel7.setText("Harga");

        table_drug.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
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
        scroll_drug.setViewportView(table_drug);

        jLabel8.setText("Daftar Obat");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(comboDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfDrugName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jLabel4))))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addGap(53, 53, 53)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scroll_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfDrugName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addGap(16, 16, 16)
                                                .addComponent(buttonAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(comboDrug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonDelete))
                                        .addComponent(scroll_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(28, 28, 28))
        );

        jTabbedPane2.addTab("     Kelola Obat     ", jPanel5);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Admin");

        logout.setText("Keluar");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(logout))
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("Kelola Data");

        pack();
    }

    private void logoutActionPerformed() {
        new Landing().setVisible(true);
        this.setVisible(false);
    }

    private void acceptRoomActionPerformed() {
        String username = Objects.requireNonNull(comboRoom.getSelectedItem()).toString();

        int rowAffected = Promise.acceptRoom(username);

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Berhasil menerima pasien!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menerima pasien!", "Alert", JOptionPane.ERROR_MESSAGE);
        }

        renderListPromiseRoomToTable();
        renderHistoryPromise();
    }

    private void rejectRoomActionPerformed() {
        String username = Objects.requireNonNull(comboRoom.getSelectedItem()).toString();

        int rowAffected = Promise.rejectRoom(username);

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Berhasil menolak pasien!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menolak pasien!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        renderListPromiseRoomToTable();
        renderHistoryPromise();
    }

    private void detailRoomActionPerformed() {
        String username = Objects.requireNonNull(comboRoom.getSelectedItem()).toString();

        String[] dataRoom = Promise.getDetailRoom(username);

        if (dataRoom != null) {
            complaint_display.setText(dataRoom[0]);
            description_display.setText(dataRoom[1]);
        }
    }

    private void sendOrderActionPerformed() {
        String username = Objects.requireNonNull(comboOrder.getSelectedItem()).toString();

        int rowAffected = Drug.sendOrder(username);

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Pemesanan obat diterima!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menerima pesanan!", "Alert", JOptionPane.ERROR_MESSAGE);
        }

        renderListDrugOrderToTable();
        renderHistoryOrder();
    }

    private void rejectOrderActionPerformed() {
        String username = Objects.requireNonNull(comboOrder.getSelectedItem()).toString();

        int rowAffected = Drug.rejectOrder(username);

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Berhasil menolak pesanan!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menolak pesanan!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        renderListDrugOrderToTable();
        renderHistoryOrder();
    }


    private void tfPriceKeyTyped(java.awt.event.KeyEvent evt) {
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }

    private void buttonAddActionPerformed() {
        String name = tfDrugName.getText();
        String price = tfPrice.getText();

        int status = Drug.getDrugByName(name);

        if (status == 1) {
            JOptionPane.showMessageDialog(null, "Obat Sudah Ada!", "Alert", JOptionPane.ERROR_MESSAGE);
        } else {
            int rowAffected = Drug.addDrug(name, price);

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Tambah Obat Berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Tambah Obat Gagal!", "Alert", JOptionPane.ERROR_MESSAGE);
            }
            renderListDrugToTable();
        }
    }

    private void buttonDeleteActionPerformed() {
        String drugName = Objects.requireNonNull(comboDrug.getSelectedItem()).toString();

        int rowAffected = Drug.deleteDrug(drugName);

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Berhasil menghapus obat!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menghapus obat!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        renderListDrugToTable();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    private javax.swing.JButton acceptRoom;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JComboBox<String> comboDrug;
    private javax.swing.JComboBox<String> comboOrder;
    private javax.swing.JComboBox<String> comboRoom;
    private javax.swing.JTextArea complaint_display;
    private javax.swing.JTextArea description_display;
    private javax.swing.JButton detailRoom;
    private javax.swing.JTable history_order;
    private javax.swing.JTable history_room;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton logout;
    private javax.swing.JButton rejectOrder;
    private javax.swing.JButton rejectRoom;
    private javax.swing.JScrollPane scroll_drug;
    private javax.swing.JButton sendOrder;
    private javax.swing.JTable table_drug;
    private javax.swing.JTable table_order;
    private javax.swing.JTable table_room;
    private javax.swing.JTextField tfDrugName;
    private javax.swing.JTextField tfPrice;
}
