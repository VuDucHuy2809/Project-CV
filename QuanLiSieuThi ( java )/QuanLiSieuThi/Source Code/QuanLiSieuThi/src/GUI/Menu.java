
package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import untils.CatchEvent;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        int check = Login.check;
        this.setLocationRelativeTo(null);
        CatchEvent catchEvent = new CatchEvent(pn_view);
        ArrayList<Danhmuc> menu = new ArrayList<Danhmuc>();
        menu = initMenu(check);
        catchEvent.setMenu(menu); 
        lbl_chao.setText("Xin chào "+Login.username);
        pn_view.removeAll();        
        pn_view.setLayout(new BorderLayout());
        pn_view.add(new PanelTrangChu());
        pn_view.validate();
        pn_view.repaint();
    }

    public ArrayList<Danhmuc> initMenu(int n){
        ArrayList<Danhmuc> menu = new ArrayList<Danhmuc>();
        if (n==1){
        menu.add(new Danhmuc("trangchu", pn_trangchu, lb_trangchu));            
        menu.add(new Danhmuc("book", pn_product, lb_product));
        menu.add(new Danhmuc("employees", pn_nv, lb_nv));
        menu.add(new Danhmuc("member", pn_kh, lb_kh));
        menu.add(new Danhmuc("qlphieunhap", pn_pn, lb_pn));
        menu.add(new Danhmuc("bill", pn_hd, lb_hd));
        menu.add(new Danhmuc("khuyenmai", pn_km, lb_km));  
        menu.add(new Danhmuc("thongke", pn_tk, lb_tk));}
        else{
        menu.add(new Danhmuc("trangchu", pn_trangchu, lb_trangchu));             
        menu.add(new Danhmuc("book", pn_product, lb_product));
        menu.add(new Danhmuc("member", pn_kh, lb_kh));
        menu.add(new Danhmuc("qlphieunhap", pn_pn, lb_pn));
        menu.add(new Danhmuc("bill", pn_hd, lb_hd));
        menu.add(new Danhmuc("khuyenmai", pn_km, lb_km));  
        pn_tk.setVisible(false);
        pn_nv.setVisible(false);}
        return menu;
}    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_menu = new javax.swing.JPanel();
        pn_inmenu = new javax.swing.JPanel();
        pn_tieude = new javax.swing.JPanel();
        lb_tieude = new javax.swing.JLabel();
        pn_product = new javax.swing.JPanel();
        lb_product = new javax.swing.JLabel();
        lb_2 = new javax.swing.JLabel();
        pn_nv = new javax.swing.JPanel();
        lb_nv = new javax.swing.JLabel();
        lb_4 = new javax.swing.JLabel();
        pn_kh = new javax.swing.JPanel();
        lb_kh = new javax.swing.JLabel();
        lb_6 = new javax.swing.JLabel();
        pn_tk = new javax.swing.JPanel();
        lb_tk = new javax.swing.JLabel();
        lb_8 = new javax.swing.JLabel();
        pn_pn = new javax.swing.JPanel();
        lb_pn = new javax.swing.JLabel();
        lb_12 = new javax.swing.JLabel();
        pn_hd = new javax.swing.JPanel();
        lb_hd = new javax.swing.JLabel();
        lb_14 = new javax.swing.JLabel();
        pn_km = new javax.swing.JPanel();
        lb_km = new javax.swing.JLabel();
        lb_15 = new javax.swing.JLabel();
        pn_trangchu = new javax.swing.JPanel();
        lb_trangchu = new javax.swing.JLabel();
        lb_3 = new javax.swing.JLabel();
        pn_view = new javax.swing.JPanel();
        pn_exit = new javax.swing.JPanel();
        lb_exit = new javax.swing.JLabel();
        lbl_chao = new javax.swing.JLabel();
        btn_doiMK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalExclusionType(null);
        setUndecorated(true);

        pn_all.setBackground(new java.awt.Color(204, 255, 204));

        pn_menu.setBackground(new java.awt.Color(204, 153, 255));

        pn_inmenu.setBackground(new java.awt.Color(0, 204, 204));

        pn_tieude.setBackground(new java.awt.Color(255, 255, 102));

        lb_tieude.setBackground(new java.awt.Color(0, 0, 204));
        lb_tieude.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lb_tieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tieude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/house.png"))); // NOI18N
        lb_tieude.setText("Siêu Thị ");

        javax.swing.GroupLayout pn_tieudeLayout = new javax.swing.GroupLayout(pn_tieude);
        pn_tieude.setLayout(pn_tieudeLayout);
        pn_tieudeLayout.setHorizontalGroup(
            pn_tieudeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tieudeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lb_tieude, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        pn_tieudeLayout.setVerticalGroup(
            pn_tieudeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tieudeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_tieude, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        pn_product.setBackground(new java.awt.Color(255, 204, 0));
        pn_product.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_product.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_product.setForeground(new java.awt.Color(255, 255, 255));
        lb_product.setText("Quản lý sản phẩm");
        lb_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_productMouseClicked(evt);
            }
        });

        lb_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stand.png"))); // NOI18N

        javax.swing.GroupLayout pn_productLayout = new javax.swing.GroupLayout(pn_product);
        pn_product.setLayout(pn_productLayout);
        pn_productLayout.setHorizontalGroup(
            pn_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_productLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_product)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_productLayout.setVerticalGroup(
            pn_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        pn_nv.setBackground(new java.awt.Color(255, 204, 0));
        pn_nv.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_nv.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_nv.setForeground(new java.awt.Color(255, 255, 255));
        lb_nv.setText("Quản lý nhân viên");

        lb_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N

        javax.swing.GroupLayout pn_nvLayout = new javax.swing.GroupLayout(pn_nv);
        pn_nv.setLayout(pn_nvLayout);
        pn_nvLayout.setHorizontalGroup(
            pn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_nvLayout.setVerticalGroup(
            pn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        pn_kh.setBackground(new java.awt.Color(255, 204, 0));
        pn_kh.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_kh.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_kh.setForeground(new java.awt.Color(255, 255, 255));
        lb_kh.setText("Quản lý khách hàng");

        lb_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/target.png"))); // NOI18N

        javax.swing.GroupLayout pn_khLayout = new javax.swing.GroupLayout(pn_kh);
        pn_kh.setLayout(pn_khLayout);
        pn_khLayout.setHorizontalGroup(
            pn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_khLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_khLayout.setVerticalGroup(
            pn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_khLayout.createSequentialGroup()
                .addComponent(lb_kh, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lb_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_tk.setBackground(new java.awt.Color(255, 204, 0));
        pn_tk.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_tk.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_tk.setForeground(new java.awt.Color(255, 255, 255));
        lb_tk.setText("Thống kê");

        lb_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pie-chart.png"))); // NOI18N

        javax.swing.GroupLayout pn_tkLayout = new javax.swing.GroupLayout(pn_tk);
        pn_tk.setLayout(pn_tkLayout);
        pn_tkLayout.setHorizontalGroup(
            pn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_tk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_tkLayout.setVerticalGroup(
            pn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_tk, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(lb_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_pn.setBackground(new java.awt.Color(255, 204, 0));
        pn_pn.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_pn.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_pn.setForeground(new java.awt.Color(255, 255, 255));
        lb_pn.setText("Quản lý phiếu nhập");

        lb_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pnhap.png"))); // NOI18N

        javax.swing.GroupLayout pn_pnLayout = new javax.swing.GroupLayout(pn_pn);
        pn_pn.setLayout(pn_pnLayout);
        pn_pnLayout.setHorizontalGroup(
            pn_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_pnLayout.setVerticalGroup(
            pn_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_hd.setBackground(new java.awt.Color(255, 204, 0));
        pn_hd.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_hd.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_hd.setForeground(new java.awt.Color(255, 255, 255));
        lb_hd.setText("Quản lý hóa đơn");

        lb_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bill.png"))); // NOI18N

        javax.swing.GroupLayout pn_hdLayout = new javax.swing.GroupLayout(pn_hd);
        pn_hd.setLayout(pn_hdLayout);
        pn_hdLayout.setHorizontalGroup(
            pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_hdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_hdLayout.setVerticalGroup(
            pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_14, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(lb_hd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_km.setBackground(new java.awt.Color(255, 204, 0));
        pn_km.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_km.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_km.setForeground(new java.awt.Color(255, 255, 255));
        lb_km.setText("Khuyến mãi");

        lb_15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/coupon.png"))); // NOI18N

        javax.swing.GroupLayout pn_kmLayout = new javax.swing.GroupLayout(pn_km);
        pn_km.setLayout(pn_kmLayout);
        pn_kmLayout.setHorizontalGroup(
            pn_kmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_km, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_kmLayout.setVerticalGroup(
            pn_kmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_15, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(lb_km, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_trangchu.setBackground(new java.awt.Color(255, 204, 0));
        pn_trangchu.setPreferredSize(new java.awt.Dimension(246, 60));

        lb_trangchu.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lb_trangchu.setForeground(new java.awt.Color(255, 255, 255));
        lb_trangchu.setText("Trang chủ");

        lb_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/house.png"))); // NOI18N

        javax.swing.GroupLayout pn_trangchuLayout = new javax.swing.GroupLayout(pn_trangchu);
        pn_trangchu.setLayout(pn_trangchuLayout);
        pn_trangchuLayout.setHorizontalGroup(
            pn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_trangchuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_trangchu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_trangchuLayout.setVerticalGroup(
            pn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_trangchu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_3, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_inmenuLayout = new javax.swing.GroupLayout(pn_inmenu);
        pn_inmenu.setLayout(pn_inmenuLayout);
        pn_inmenuLayout.setHorizontalGroup(
            pn_inmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_tieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_trangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_product, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_kh, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_pn, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_hd, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_km, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addComponent(pn_tk, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );
        pn_inmenuLayout.setVerticalGroup(
            pn_inmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_inmenuLayout.createSequentialGroup()
                .addComponent(pn_tieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_trangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_km, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(pn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_menuLayout = new javax.swing.GroupLayout(pn_menu);
        pn_menu.setLayout(pn_menuLayout);
        pn_menuLayout.setHorizontalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_inmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pn_menuLayout.setVerticalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_inmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_view.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pn_viewLayout.setVerticalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pn_exit.setBackground(new java.awt.Color(0, 204, 204));

        lb_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit1.png"))); // NOI18N
        lb_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_exitMouseClicked(evt);
            }
        });

        lbl_chao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_chao.setForeground(new java.awt.Color(255, 255, 255));
        lbl_chao.setText("Xin chào");

        btn_doiMK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_doiMK.setText("Đổi mật khẩu");
        btn_doiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_doiMKMouseClicked(evt);
            }
        });
        btn_doiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doiMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_exitLayout = new javax.swing.GroupLayout(pn_exit);
        pn_exit.setLayout(pn_exitLayout);
        pn_exitLayout.setHorizontalGroup(
            pn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_exitLayout.createSequentialGroup()
                .addGap(0, 495, Short.MAX_VALUE)
                .addComponent(lbl_chao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btn_doiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(lb_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pn_exitLayout.setVerticalGroup(
            pn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_exitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_doiMK)
                    .addComponent(lbl_chao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addComponent(pn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addComponent(pn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addComponent(pn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pn_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lb_exitMouseClicked

    private void btn_doiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_doiMKMouseClicked
        pn_view.removeAll();
        pn_view.setLayout(new BorderLayout());
        pn_view.add(new PanelDoiPass());
        pn_view.validate();
        pn_view.repaint();
    }//GEN-LAST:event_btn_doiMKMouseClicked

    private void btn_doiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doiMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_doiMKActionPerformed

    private void lb_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_productMouseClicked
//        pn_view.removeAll();
//        pn_view.setLayout(new BorderLayout());
//        pn_view.add(new PanelSanPham());
//        pn_view.validate();
//        pn_view.repaint();
    }//GEN-LAST:event_lb_productMouseClicked


    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_doiMK;
    private javax.swing.JLabel lb_12;
    private javax.swing.JLabel lb_14;
    private javax.swing.JLabel lb_15;
    private javax.swing.JLabel lb_2;
    private javax.swing.JLabel lb_3;
    private javax.swing.JLabel lb_4;
    private javax.swing.JLabel lb_6;
    private javax.swing.JLabel lb_8;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_hd;
    private javax.swing.JLabel lb_kh;
    private javax.swing.JLabel lb_km;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_pn;
    private javax.swing.JLabel lb_product;
    private javax.swing.JLabel lb_tieude;
    private javax.swing.JLabel lb_tk;
    private javax.swing.JLabel lb_trangchu;
    private javax.swing.JLabel lbl_chao;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_exit;
    private javax.swing.JPanel pn_hd;
    private javax.swing.JPanel pn_inmenu;
    private javax.swing.JPanel pn_kh;
    private javax.swing.JPanel pn_km;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_nv;
    private javax.swing.JPanel pn_pn;
    private javax.swing.JPanel pn_product;
    private javax.swing.JPanel pn_tieude;
    private javax.swing.JPanel pn_tk;
    private javax.swing.JPanel pn_trangchu;
    private javax.swing.JPanel pn_view;
    // End of variables declaration//GEN-END:variables
}
