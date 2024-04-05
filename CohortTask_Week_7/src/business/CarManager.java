package business;

import core.Helper;
import dao.CarDao;
import entity.Model;
import entity.Car;

import java.util.ArrayList;

public class CarManager {

    private final CarDao carDao = new CarDao();

    public Car getById(int id) { return this.carDao.getById(id);}
    public ArrayList<Car> findAll() { return this.carDao.findAll();}

    public ArrayList<Object[]> getForTable(int size,ArrayList<Car> carList) {
        ArrayList<Object[]> carObjList = new ArrayList<>();
        for (Car car : carList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = car.getId();
            rowObject[i++] = car.getModel().getBrand().getName();
            rowObject[i++] = car.getModel().getName();
            rowObject[i++] = car.getPlate();
            rowObject[i++] = car.getColor();
            rowObject[i++] = car.getKm();
            rowObject[i++] = car.getModel().getYear();
            rowObject[i++] = car.getModel().getType();
            rowObject[i++] = car.getModel().getFuel();
            rowObject[i++] = car.getModel().getGear();
            carObjList.add(rowObject);
        }
        return carObjList;
    }
    public  boolean save (Car car){
        if( car.getId() != 0){
            Helper.showMsg("error");
        }
        return this.carDao.save(car);
    }
    public  boolean update(Car car){
        if (this.getById(car.getId())== null){
            Helper.showMsg("notFound");
        }
        return this.carDao.update(car);
    }

    public  boolean delete(int id){
        if(this.getById(id)== null){
            Helper.showMsg("notFound");
            return false;
        }

        return  this.carDao.delete(id);
    }

   /* public  ArrayList<Model> searchForTable(int brandId, Model.Fuel fuel, Model.Gear gear, Model.Type type){
        String select = "SELECT * FROM public.\"Model\" ";
        ArrayList<String> whereList = new ArrayList<>();

        if (brandId != 0) {
            whereList.add("model_brand_id= "+ brandId);
        }
        if (fuel != null) {
            whereList.add("model_fuel =' "+ fuel.toString()+"'");
        }
        if (gear != null) {
            whereList.add("model_gear =' "+gear.toString()+"'");
        }
        if (type != null) {
            whereList.add("model_type= '"+ type.toString()+"'");
        }

        String whereStr = String.join(" AND ", whereList);
        String query = select;
        if (!whereStr.isEmpty()){
            query+= " WHERE "+ whereStr;
        }

        return  this.carDao.selectByQuery(query);
    }

    */


}
