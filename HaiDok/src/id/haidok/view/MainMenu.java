package id.haidok.view;

import javax.swing.*;

public class MainMenu extends javax.swing.JFrame {
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void setUsername(String username){
        display_username.setText(username);
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        display_username = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        create_promise = new javax.swing.JButton();
        order_drug = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HaiDok Main Menu");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        display_username.setBackground(new java.awt.Color(0, 0, 0));
        display_username.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        display_username.setForeground(new java.awt.Color(0, 0, 0));
        display_username.setText("Username");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Selamat Datang, ");

        logout.setBackground(new java.awt.Color(255, 0, 51));
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Keluar");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        create_promise.setBackground(new java.awt.Color(255, 204, 204));
        create_promise.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/mail" +
                "-send (1).png"))); // NOI18N
        create_promise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_promise.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        create_promise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_promiseActionPerformed(evt);
            }
        });

        order_drug.setBackground(new java.awt.Color(255, 204, 204));
        order_drug.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        order_drug.setForeground(new java.awt.Color(0, 0, 0));
        order_drug.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/medicine " +
                "(2).png"))); // NOI18N
        order_drug.setToolTipText("");
        order_drug.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        order_drug.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        order_drug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_drugActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Pesan Obat");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Buat Janji");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(display_username)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(order_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(create_promise, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(display_username)
                                        .addComponent(logout))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(create_promise, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(order_drug, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
        new Landing().setVisible(true);
        this.setVisible(false);
    }

    private void create_promiseActionPerformed(java.awt.event.ActionEvent evt) {
        MakePromise buatJanji = new MakePromise();
        buatJanji.setUsername(display_username.getText());
        buatJanji.runMakePromise();
        buatJanji.setVisible(true);
        this.setVisible(false);
    }

    private void order_drugActionPerformed(java.awt.event.ActionEvent evt) {
        OrderDrug pesanObat = new OrderDrug();
        pesanObat.setUsername(display_username.getText());
        pesanObat.runOrderDrug();
        pesanObat.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    private javax.swing.JButton create_promise;
    private javax.swing.JLabel display_username;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton order_drug;
}
