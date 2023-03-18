
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

public class PanelQLKhuyenMai extends javax.swing.JPanel {

    public PanelQLKhuyenMai() {
        initComponents();
        panel_View.removeAll();
        pnkm.setBackground(new Color(148,124,176));
        pnctkm.setBackground(new Color(1,50,67));
        panel_View.setLayout(new BorderLayout());
        panel_View.add(new PanelKhuyenMai());
        panel_View.validate();
        panel_View.repaint();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_tieude = new javax.swing.JPanel();
        pnkm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnctkm = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel_View = new javax.swing.JPanel();

        pn_all.setBackground(new java.awt.Color(0, 204, 204));

        pn_tieude.setBackground(new java.awt.Color(1, 50, 67));

        pnkm.setBackground(new java.awt.Color(1, 50, 67));
        pnkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnkmMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách khuyến mãi");

        javax.swing.GroupLayout pnkmLayout = new javax.swing.GroupLayout(pnkm);
        pnkm.setLayout(pnkmLayout);
        pnkmLayout.setHorizontalGroup(
            pnkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        pnkmLayout.setVerticalGroup(
            pnkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnctkm.setBackground(new java.awt.Color(1, 50, 67));
        pnctkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnctkmMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh sách chi tiết khuyến mãi");

        javax.swing.GroupLayout pnctkmLayout = new javax.swing.GroupLayout(pnctkm);
        pnctkm.setLayout(pnctkmLayout);
        pnctkmLayout.setHorizontalGroup(
            pnctkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        pnctkmLayout.setVerticalGroup(
            pnctkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_tieudeLayout = new javax.swing.GroupLayout(pn_tieude);
        pn_tieude.setLayout(pn_tieudeLayout);
        pn_tieudeLayout.setHorizontalGroup(
            pn_tieudeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tieudeLayout.createSequentialGroup()
                .addComponent(pnkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(pnctkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pn_tieudeLayout.setVerticalGroup(
            pn_tieudeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_tieudeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnctkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_View.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_ViewLayout = new javax.swing.GroupLayout(panel_View);
        panel_View.setLayout(panel_ViewLayout);
        panel_ViewLayout.setHorizontalGroup(
            panel_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_ViewLayout.setVerticalGroup(
            panel_ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pn_tieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_View, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_tieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_View, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnkmMouseClicked
        panel_View.removeAll();
        pnkm.setBackground(new Color(148,124,176));
        pnctkm.setBackground(new Color(1,50,67));
        panel_View.setLayout(new BorderLayout());
        panel_View.add(new PanelKhuyenMai());
        panel_View.validate();
        panel_View.repaint();
    }//GEN-LAST:event_pnkmMouseClicked

    private void pnctkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnctkmMouseClicked
        panel_View.removeAll();
        pnctkm.setBackground(new Color(148,124,176));
        pnkm.setBackground(new Color(1,50,67));
        panel_View.setLayout(new BorderLayout());
        panel_View.add(new PanelChiTietKhuyenMai());
        panel_View.validate();
        panel_View.repaint();
    }//GEN-LAST:event_pnctkmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panel_View;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_tieude;
    private javax.swing.JPanel pnctkm;
    private javax.swing.JPanel pnkm;
    // End of variables declaration//GEN-END:variables
}
