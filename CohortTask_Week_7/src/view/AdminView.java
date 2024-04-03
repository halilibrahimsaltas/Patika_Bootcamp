package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.BrandManager;
import entity.Brand;
import entity.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("New").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
        });
        this.brandMenu.add("Update").addActionListener(e -> {
            int selectBrandId = Integer.parseInt(tbl_brands.getValueAt(tbl_brands.getSelectedRow(),0).toString());
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));

        });
        this.brandMenu.add("Delete");

        this.tbl_brands.setComponentPopupMenu(brandMenu);


    }


    public  void loadBrandTable(){
        Object [] col_brand = { "Brand ID", "Brand Name"};
        ArrayList<Brand> brandList= this.brandManager.findAll();
        this.tmdl_brand.setColumnIdentifiers(col_brand);
        for (Brand brand : brandList){
            Object[] obj = { brand.getId(),brand.getName()};
            tmdl_brand.addRow(obj);
        }


        tbl_brands.setModel(tmdl_brand);
        tbl_brands.getTableHeader().setReorderingAllowed(false);
        tbl_brands.setEnabled(false);

        this.tbl_brands.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_brands.rowAtPoint(e.getPoint());
                tbl_brands.setRowSelectionInterval(selected_row,selected_row);
            }
        });

    }





}
