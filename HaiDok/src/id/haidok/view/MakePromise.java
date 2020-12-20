package id.haidok.view;

import id.haidok.database.Promise;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class MakePromise extends javax.swing.JFrame {
    private String username = "Anonymous";

    public MakePromise() {
    }

    public void runMakePromise() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        promiseHistory();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tsComplaint = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tsDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        select_room = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        hour = new javax.swing.JComboBox<>();
        minute = new javax.swing.JComboBox<>();
        makePromise = new javax.swing.JButton();
        display_time = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        promise_history = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HaiDok Buat Janji");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Keluhan");

        tsComplaint.setColumns(20);
        tsComplaint.setRows(1);
        jScrollPane1.setViewportView(tsComplaint);

        jLabel2.setText("Pilih Ruangan");

        tsDescription.setColumns(20);
        tsDescription.setRows(5);
        jScrollPane2.setViewportView(tsDescription);

        jLabel3.setText("Deskripsi");

        select_room.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Intensive Care Unit (ICU)", "High Care Unit (HCU)", "Intensive Coronary Care Unit (ICCU)", "Neonatal Intensive Care Unit (NICU)", "Pediatric Intensive Care Unit (PICU)"}));

        jLabel4.setText("Pilih Waktu");

        hour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"08", "09", "10", "11", "12", "13", "14", "15", "16", "17"}));
        hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourActionPerformed();
            }
        });

        minute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"00", "05", "10", "15",
                "20", "25", "30", "35", "40", "45", "50", "55"}));
        minute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minuteActionPerformed();
            }
        });

        makePromise.setText("Buat Janji");
        makePromise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePromiseActionPerformed(evt);
            }
        });

        display_time.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        display_time.setText("08:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addGap(27, 27, 27)
                                                                                .addComponent(select_room, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(43, 43, 43)
                                                                .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41)
                                                                .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(display_time))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(322, 322, 322)
                                                .addComponent(makePromise, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(select_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(display_time)))
                                .addGap(18, 18, 18)
                                .addComponent(makePromise)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("                                       Buat Janji Baru                                          ", jPanel1);

        promise_history.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Keluhan", "Ruangan", "Waktu", "Status"
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
        jScrollPane4.setViewportView(promise_history);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("                                         Riwayat Janji                                       ", jPanel3);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane1)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void promiseHistory() {
        DefaultTableModel model = (DefaultTableModel) promise_history.getModel();
        model.setRowCount(0);

        ArrayList<String[]> data = Promise.getHistoryRoomUser(username);

        if (data != null) {
            for (String[] room : data) {
                String[] dataTable = {room[0], room[1], room[2], room[3]};
                model.addRow(dataTable);
            }
        }
    }

    private void hourActionPerformed() {
        String hourString = Objects.requireNonNull(hour.getSelectedItem()).toString();
        String minuteString = Objects.requireNonNull(minute.getSelectedItem()).toString();

        display_time.setText(hourString + ":" + minuteString);
    }

    private void minuteActionPerformed() {
        String hourString = Objects.requireNonNull(hour.getSelectedItem()).toString();
        String minuteString = Objects.requireNonNull(minute.getSelectedItem()).toString();

        display_time.setText(hourString + ":" + minuteString);
    }

    private void makePromiseActionPerformed(java.awt.event.ActionEvent evt) {
        String complaintUser = tsComplaint.getText();
        String descriptionUser = tsDescription.getText();
        String roomUser = Objects.requireNonNull(select_room.getSelectedItem()).toString();
        String timeUser = display_time.getText();

        int status = Promise.getStatusPromiseUser(username);

        if (status == 1) {
            JOptionPane.showMessageDialog(null, "Janji sebelumnya masih diproses!", "Alert", JOptionPane.ERROR_MESSAGE);
        } else {

            int rowAffected = Promise.makePromise(username, complaintUser, descriptionUser,
                    roomUser, timeUser);

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Pembuatan janji berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal membuat janji!", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
        promiseHistory();
        clearInput();
    }

    private void clearInput() {
        tsComplaint.setText("");
        tsDescription.setText("");
        select_room.setSelectedIndex(0);
        hour.setSelectedIndex(0);
        minute.setSelectedIndex(0);
        display_time.setText("08:00");
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setUsername(username);
        mainMenu.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakePromise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakePromise().setVisible(true);
            }
        });
    }

    private javax.swing.JButton back;
    private javax.swing.JLabel display_time;
    private javax.swing.JComboBox<String> hour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton makePromise;
    private javax.swing.JComboBox<String> minute;
    private javax.swing.JTable promise_history;
    private javax.swing.JComboBox<String> select_room;
    private javax.swing.JTextArea tsComplaint;
    private javax.swing.JTextArea tsDescription;
}
