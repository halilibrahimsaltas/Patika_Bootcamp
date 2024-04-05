package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane pnl_cars;
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
    private JComboBox<ComboItem> cmb_s_model_brand;
    private JComboBox<Model.Type> cmb_s_model_type;
    private JComboBox<Model.Fuel> cmb_s_model_fuel;
    private JComboBox<Model.Gear> cmb_s_model_gear;
    private JButton btn_search;
    private JButton btn_cncl_model;
    private JPanel pnl_car_list;
    private JScrollPane scl_car;
    private JTable tbl_cars;
    private JPanel pnl_booking_search;
    private JScrollPane scl_booking;
    private JTable tbl_booking;
    private JLabel lbl_start_date;
    private JLabel lbl_finish_date;
    private JLabel lbl_booking_gear;
    private JLabel lbl_booking_fuel;
    private JLabel lbl_booking_type;
    private JTextField fld_strt_date;
    private JTextField fld_fnsh_date;
    private JComboBox <Model.Gear>cmb_booking_gear;
    private JComboBox <Model.Fuel>cmb_booking_fuel;
    private JComboBox <Model.Type> cmb_booking_type;
    private JButton btn_booking_search;
    private User user;

    private Object[] col_model;

    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();

    private DefaultTableModel tmdl_car = new DefaultTableModel();

    private DefaultTableModel tmdl_booking = new DefaultTableModel();

    private BrandManager brandManager;

    private ModelManager modelManager;

    private CarManager carManager;

    private JPopupMenu brand_menu;

    private JPopupMenu model_menu;

    private JPopupMenu car_menu;

    private JPopupMenu booking_menu;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();
        this.add(container);
        this.guiInitilaze(1000, 500);
        this.user = user;

        if (this.user == null) {
            dispose();

        }

        this.lbl_welcome.setText("Welcome  " + this.user.getUsername() + " ! ");

        loadBrandTable();
        loadBrandComponent();

        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        //Car Tab Menu
        loadCarTable();
        loadCarComponent();


        //Booking Menu
        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();

        btn_booking_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_strt_date.getText(),
                    fld_fnsh_date.getText(),
                    (Model.Type) cmb_booking_type.getSelectedItem(),
                    (Model.Gear) cmb_booking_gear.getSelectedItem(),
                    (Model.Fuel) cmb_booking_fuel.getSelectedItem()
            );

        });


    }


    private void loadBookingFilter() {
        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);
    }

    private void loadBookingComponent() {
        tableRowSelected(this.tbl_booking);
        this.booking_menu = new JPopupMenu();
        this.booking_menu.add("Make a Reservation").addActionListener(e -> {

        });
        this.tbl_booking.setComponentPopupMenu(booking_menu);

    }

    private void loadBookingTable(ArrayList<Object[]> carList) {
        Object[] col_booking_list = {" ID", "Brand", "Model", "Plate", "Color", "KM", "Year", "Type", "Fuel Type", "Gear"};
        createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carList);

    }

    private void loadCarTable() {
        Object[] col_car = {" ID", "Brand", "Model", "Plate", "Color", "KM", "Year", "Type", "Fuel Type", "Gear"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.findAll());
        createTable(this.tmdl_car, this.tbl_cars, col_car, carList);

    }

    private void loadCarComponent() {
        tableRowSelected(this.tbl_cars);
        this.car_menu = new JPopupMenu();
        this.car_menu.add("New").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });

        });
        this.car_menu.add("Update").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_cars, 0);
            CarView carView = new CarView(this.carManager.getById(selectModelId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")){
                int selectCarId = this.getTableSelectedRow(tbl_cars,0);
                if (this.carManager.delete(selectCarId)){
                    Helper.showMsg("done");
                    loadCarTable();
                }else{
                    Helper.showMsg("error");
                }
            }
        });

        this.tbl_cars.setComponentPopupMenu(car_menu);
    }


    public void loadBrandComponent() {
        tableRowSelected(this.tbl_brands);
        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("New").addActionListener(e -> {
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
        this.brand_menu.add("Update").addActionListener(e -> {
            int selectBrandId = this.getTableSelectedRow(tbl_brands, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                }
            });

        });
        this.brand_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBrandId = this.getTableSelectedRow(tbl_brands, 0);
                if (this.brandManager.delete(selectBrandId)) {
                    Helper.showMsg("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }

        });
        this.tbl_brands.setComponentPopupMenu(brand_menu);


    }

    public void loadModelComponent() {
        tableRowSelected(this.tbl_model);
        this.model_menu = new JPopupMenu();
        this.model_menu.add("New").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_menu.add("Update").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadCarTable();
                }
            });

        });
        this.model_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectModelId = this.getTableSelectedRow(tbl_model, 0);
                if (this.modelManager.delete(selectModelId)) {
                    Helper.showMsg("done");
                    loadModelTable(null);
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_model.setComponentPopupMenu(model_menu);

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
            loadModelTable(null);
        });

    }

    public void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{" Model ID", "Brand", "Model Name", "Type", "Year", "Fuel Type", "Gear"};
        if (modelList == null) {
            modelList = this.modelManager.getForTable(col_model.length, this.modelManager.findAll());
        }
        createTable(this.tmdl_model, this.tbl_model, col_model, modelList);

    }

    public void loadBrandTable() {
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brands, col_brand, brandList);

    }

    public void loadModelFilter() {
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        this.cmb_s_model_brand.removeAllItems();
        loadModelFilterBrand();

    }

    public void loadModelFilterBrand() {
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()) {
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);

    }

}
