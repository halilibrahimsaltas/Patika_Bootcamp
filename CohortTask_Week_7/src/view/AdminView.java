package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.BrandManager;
import core.Helper;
import entity.Brand;
import entity.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends  Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brands;
    private JScrollPane scl_brand;
    private JTable tbl_brands;
    private  User user;

    private DefaultTableModel tmdl_brand = new DefaultTableModel();

    private BrandManager brandManager;

    private JPopupMenu brandMenu;

    public AdminView(User user){
        this.brandManager= new BrandManager();
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user=user;

        if (this.user == null){
            dispose();

        }

        this.lbl_welcome.setText("Welcome  " + this.user.getUsername()+" ! ");

        loadBrandTable();
        loadBrandComponent();

        this.tbl_brands.setComponentPopupMenu(brandMenu);

    }

    public void loadBrandComponent(){
        this.tbl_brands.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_brands.rowAtPoint(e.getPoint());
                tbl_brands.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("New").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        this.brandMenu.add("Update").addActionListener(e -> {
            int selectBrandId = this.getTableSelectedRow(tbl_brands,0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });

        });
        this.brandMenu.add("Delete").addActionListener(e -> {
            if(Helper.confirm("sure")) {
                int selectBrandId = this.getTableSelectedRow(tbl_brands, 0);
                if(this.brandManager.delete(selectBrandId)){
                    Helper.showMsg("done");
                    loadBrandTable();
                }else {
                    Helper.showMsg("error");
                }

            }


        });

    }

    public  void loadBrandTable(){
        Object [] col_brand = { "Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList= this.brandManager.getForTable(col_brand.length);

        this.createTable(this.tmdl_brand, this.tbl_brands,col_brand,brandList);

    }

}
