package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;
import entity.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends  Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane pnl_model;
    private JButton btn_logout;
    private JPanel pnl_brands;
    private JScrollPane scl_brand;
    private JTable tbl_brands;
    private JScrollPane scl_model;
    private JTable tbl_model;
    private JLabel lbl_brand_search;
    private JLabel lbl_type_search;
    private JLabel lbl_fuel_search;
    private JLabel lbl__gear_search;
    private JComboBox <ComboItem>cmb_s_model_brand;
    private JComboBox <Model.Type>cmb_s_model_type;
    private JComboBox <Model.Fuel>cmb_s_model_fuel;
    private JComboBox <Model.Gear>cmb_s_model_gear;
    private JButton btn_search;
    private JButton btn_cncl_model;
    private  User user;

    private Object[] col_model;

    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();

    private BrandManager brandManager;

    private ModelManager modelManager;

    private JPopupMenu brandMenu;

    private JPopupMenu modelMenu;

    public AdminView(User user){
        this.brandManager= new BrandManager();
        this.modelManager= new ModelManager();
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user=user;

        if (this.user == null){
            dispose();

        }

        this.lbl_welcome.setText("Welcome  " + this.user.getUsername()+" ! ");

        loadBrandTable();
        loadBrandComponent();

        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        this.tbl_brands.setComponentPopupMenu(brandMenu);


    }



    public void loadBrandComponent(){
        tableRowSelected(this.tbl_brands);
        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("New").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
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
                    loadModelTable(null);
                    loadModelFilterBrand();
                }
            });

        });
        this.brandMenu.add("Delete").addActionListener(e -> {
            if(Helper.confirm("sure")) {
                int selectBrandId = this.getTableSelectedRow(tbl_brands, 0);
                if(this.brandManager.delete(selectBrandId)){
                    Helper.showMsg("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                }else {
                    Helper.showMsg("error");
                }
            }

        });
        this.tbl_brands.setComponentPopupMenu(brandMenu);


    }
    public void loadModelComponent(){
        tableRowSelected(this.tbl_model);
        this.modelMenu = new JPopupMenu();
        this.modelMenu.add("New").addActionListener(e -> {
            ModelView modelView= new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.modelMenu.add("Update").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_model,0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });

        });
        this.modelMenu.add("Delete").addActionListener(e -> {
            if(Helper.confirm("sure")) {
                int selectModelId = this.getTableSelectedRow(tbl_model, 0);
                if(this.modelManager.delete(selectModelId)){
                    Helper.showMsg("done");
                    loadModelTable(null);
                }else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_model.setComponentPopupMenu(modelMenu);

        this.btn_search.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId = 0;
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );

            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });

        this.btn_cncl_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
        });

    }
    public void loadModelTable(ArrayList<Object[]> modelList){
        this.col_model = new Object[]{" Model ID", "Brand", "Model Name", "Type", "Year", "Fuel Type", "Gear"};
        if(modelList == null) {
            modelList = this.modelManager.getForTable(col_model.length, this.modelManager.findAll());
        }
        createTable(this.tmdl_model,this.tbl_model,col_model,modelList);

    }

    public  void loadBrandTable(){
        Object [] col_brand = { "Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList= this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brands,col_brand,brandList);

    }

    public  void loadModelFilter(){
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        this.cmb_s_model_brand.removeAllItems();
        loadModelFilterBrand();

    }

    public  void loadModelFilterBrand(){
        this.cmb_s_model_brand.removeAllItems();
        for(Brand obj : brandManager.findAll()){
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(),obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);

    }

}
