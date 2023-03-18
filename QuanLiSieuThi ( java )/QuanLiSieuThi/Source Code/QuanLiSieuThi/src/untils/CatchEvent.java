
package untils;
import GUI.Danhmuc;
import GUI.PanelQLHoaDon;
import GUI.PanelKhachHang;
import GUI.PanelQLKhuyenMai;
import GUI.PanelNhanVien;
import GUI.PanelQLPhieuNhap;
import GUI.PanelSanPham;
import GUI.PanelThongKe;
import GUI.PanelTrangChu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CatchEvent {
    private JPanel pnRoot;
    private String selectedScreen = "";    
    private ArrayList<Danhmuc> menu = null;

    public CatchEvent(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void setMenu(ArrayList<Danhmuc> menu) {
        this.menu = menu;
        for (Danhmuc danhmuc : menu) {
             danhmuc.getPnName().addMouseListener(new Events(danhmuc.getKindOfScreen(), danhmuc.getPnName(), danhmuc.getLbName()));
        }
    }
    class Events implements MouseListener {

        private JPanel pnNode;
        private String kind;
        private JPanel pnName;
        private JLabel lbName;

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "trangchu":
                    pnNode = new PanelTrangChu();
                    break;                
                case "book":
                    pnNode = new PanelSanPham();
                    break;
                case "employees":
                    pnNode = new PanelNhanVien();
                    break;
                case "member":
                    pnNode = new PanelKhachHang();
                    break;
                case "qlphieunhap":
                    pnNode = new PanelQLPhieuNhap();
                    break;
                case "bill":
                    pnNode = new PanelQLHoaDon();
                    break;
                case "khuyenmai":
                    pnNode = new PanelQLKhuyenMai();
                    break;                    
                case "thongke":
                    pnNode = new PanelThongKe();
                    break;                    
                default:
                    break;
        }
            pnRoot.removeAll();
            pnRoot.setLayout(new BorderLayout());
            pnRoot.add(pnNode);
            pnRoot.validate();
            pnRoot.repaint();
            setBackgroudSeclect(kind);            
        }

        public Events(String kind, JPanel pnName, JLabel lbName) {
            this.kind = kind;
            this.pnName = pnName;
            this.lbName = lbName;
        }    

        @Override
        public void mousePressed(MouseEvent e) {
            selectedScreen = kind;
            pnName.setBackground(new Color(44,62,80));            
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
    
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
        }
    }
    private void setBackgroudSeclect(String select){
       for(Danhmuc danhmuc : menu) {
           if(!danhmuc.getKindOfScreen().equalsIgnoreCase(select)) {
               danhmuc.getPnName().setBackground(new Color(1,50,67));
               danhmuc.getLbName().setBackground(new Color(1,50,67));
           } else {
               danhmuc.getLbName().setBackground(new Color(148,124,176));
               danhmuc.getPnName().setBackground(new Color(148,124,176));
           }
       }
    }
}
