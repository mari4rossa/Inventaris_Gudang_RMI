/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import Model.BarangModel;
import Model.GudangModel;
import Model.UserModel;
/**
 *
 * @author Matius Andreatna
 */
public class AllServer extends UnicastRemoteObject implements Service.AllService  {

    public AllServer() throws RemoteException {
        super();
    }
    
    //UserDAO
    @Override
    public UserModel loadUser(UserModel userModel) throws RemoteException {
        UserModel result = null;
        try {            
            result = DAO.UserDao.loadUser(userModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    //BarangDAO
    @Override
    public List<String[]> loadBarang() throws RemoteException {
        List result = null;
        try {            
            result = DAO.BarangDao.loadBarang();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean insertBarang(BarangModel dataIn) throws RemoteException {
        boolean result = false;
        try {            
            result = DAO.BarangDao.insertBarang(dataIn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    @Override
    public List<String[]> cariBarang(String dataCari) throws RemoteException {
        List<String[]> result = null;
        try {            
            result = DAO.BarangDao.cariBarang(dataCari);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    @Override
    public List<String[]> sortBarang(String by) throws RemoteException {
        List<String[]> result = null;
        try {            
            result = DAO.BarangDao.sortBarang(by);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    @Override
    public String idBarang() throws RemoteException {
        String result = null;
        try {            
            result = DAO.BarangDao.IdBarang();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean updateBarang(BarangModel update) throws RemoteException {
        boolean result = false;
        try {            
            result = DAO.BarangDao.updateData(update);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    
    @Override
    public boolean deleteBarang(BarangModel id) throws RemoteException {
        boolean result = false;
        try {            
            result = DAO.BarangDao.deleteData(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    //GudangDAO
    @Override
    public List<String[]> loadGudang() throws RemoteException {
        List result = null;
        try {            
            result = DAO.GudangDao.loadGudang();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean insertGudang(GudangModel dataIn) throws RemoteException {
        boolean result = false;
        try {            
            result = DAO.GudangDao.insertGudang(dataIn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String[]> cariGudang(String dataCari) throws RemoteException {
        List result = null;
        try {            
            result = DAO.GudangDao.cariGudang(dataCari);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String[]> sortGudang(String by) throws RemoteException {
        List result = null;
        try {            
            result = DAO.GudangDao.sortGudang(by);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public String idGudang() throws RemoteException {
        String result = null;
        try {            
            result = DAO.GudangDao.IdGudang();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateGudang(GudangModel update) throws RemoteException {
        boolean result = false;
        try {            
            result = DAO.GudangDao.updateData(update);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteGudang(GudangModel id) throws RemoteException {
        boolean result = false;
        try {            
            result = DAO.GudangDao.deleteData(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1234);
        registry.rebind("allService", new AllServer());
        System.out.println("Server started..");
    }

    

    

}
