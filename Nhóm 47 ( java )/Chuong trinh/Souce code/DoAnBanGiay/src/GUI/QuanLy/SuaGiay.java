/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.QuanLy;

import BUS.GiayBUS;
import BUS.LoaiGiayBUS;
import BUS.NhaSanXuatBUS;
import DTO.Giay;
import DTO.LoaiGiay;
import DTO.NhaSanXuat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SuaGiay extends javax.swing.JFrame {

    NhaSanXuatBUS nsxbus = new NhaSanXuatBUS();
    LoaiGiayBUS loaibus = new LoaiGiayBUS();
    GiayBUS giaybus = new GiayBUS();
    

    /**
     * Creates new form SuaGiay
     */
    public SuaGiay() {
        initComponents();
        initialization();
        performEvent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        name = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        nsx = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        color = new javax.swing.JTextField();
        size = new javax.swing.JTextField();
        Size = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Tên Giày :");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        type.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 400, -1));

        name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 164, 400, -1));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        update.setForeground(new java.awt.Color(0, 204, 0));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/tick_box_32px.png"))); // NOI18N
        update.setText("Cập Nhật");
        background.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sửa Giày");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 608, 77));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Mã Loại :");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        id.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 111, 400, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Mã Giày :");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 114, -1, -1));

        nsx.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(nsx, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 400, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Mã NSX :");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Màu Sắc");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        color.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 400, -1));

        size.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 400, -1));

        Size.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Size.setText("Size");
        background.add(Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Giá");
        background.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 400, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Trạng Thái");
        background.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        status.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 400, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuaGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaGiay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Size;
    private javax.swing.JPanel background;
    private javax.swing.JTextField color;
    private javax.swing.JComboBox<String> id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> nsx;
    private javax.swing.JTextField price;
    private javax.swing.JTextField size;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    private void initialization() {
        setLocationRelativeTo(null);
        loadConboBox();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void performEvent() {
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id.getSelectedIndex() <= 0) {
                    reset();
                }

                Giay g = giaybus.getGiayById(String.valueOf(id.getSelectedItem()));
                setValue(g);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id.getSelectedIndex() <= 0) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn Giày để sửa");
                    return;
                }
                if (name.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tên không được để trống");
                    return;
                }
                if (size.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Size không được để trống");
                    return;
                }
                try {
                    if (Double.valueOf(size.getText()) < 0) {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Size phải là số > 0");
                    return;
                }
                if (color.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Màu không được để trống");
                    return;
                }
                if (price.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Giá không được để trống");
                    return;
                }

                try {
                    if (Integer.valueOf(price.getText()) < 1000) {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Giá phải lớn hơn bằng 1.000");
                    return;
                }
                
                Giay giay = new Giay(
                        String.valueOf(id.getSelectedItem()),
                        name.getText(),
                        String.valueOf(nsx.getSelectedItem()),
                        String.valueOf(type.getSelectedItem()),
                        size.getText(),
                        color.getText(),
                        Integer.valueOf(price.getText()),
                        status.getSelectedIndex() == 0 ? true:false
                );
                if(giaybus.update(giay)){
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    reset();
                    return;
                }
                
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
            }
        });
    }

    private void loadConboBox() {
        ArrayList<NhaSanXuat> dataNSX = nsxbus.getAllData();
        ArrayList<LoaiGiay> dataLoaiGiay = loaibus.getAllData();
        ArrayList<Giay> dataGiay = giaybus.getAllData();

        for (NhaSanXuat nsxD : dataNSX) {
            nsx.addItem(nsxD.getMaNSX());
        }
        for (LoaiGiay loai : dataLoaiGiay) {
            type.addItem(loai.getMaLoai());
        }

        id.addItem("[Lựa Chọn]");
        for (Giay g : dataGiay) {
            id.addItem(g.getMaGiay());
        }
        
        status.addItem("Đang Bán");
        status.addItem("Khóa");
    }

    private void reset() {
        name.setText("");
        nsx.setSelectedIndex(0);
        type.setSelectedIndex(0);
        size.setText("");
        color.setText("");
        price.setText("");
    }

    private void setValue(Giay g) {
        name.setText(g.getTenGiay());
        nsx.setSelectedItem(g.getMaNSX());
        type.setSelectedItem(g.getMaLoai());
        size.setText(g.getSize());
        color.setText(g.getMauSac());
        price.setText(String.valueOf(g.getGiaThanh()));
        status.setSelectedIndex(g.isTrangThai() ? 0:1);
    }
}
