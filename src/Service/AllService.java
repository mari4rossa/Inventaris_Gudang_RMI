/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import Model.UserModel;
import Model.BarangModel;
import Model.GudangModel;
    
/**
 *
 * @author Matius Andreatna
 */
public interface AllService extends Remote {
    //USER
    public UserModel loadUser(UserModel userModel) throws RemoteException;
   
    //BARANG
    public List<String[]> loadBarang() throws RemoteException;
    public boolean insertBarang(BarangModel dataIn) throws RemoteException;
    public List<String[]> cariBarang(String dataCari) throws RemoteException;
    public List<String[]> sortBarang(String by) throws RemoteException;
    public String idBarang() throws RemoteException;
    public boolean updateBarang(BarangModel update) throws RemoteException;
    public boolean deleteBarang(BarangModel id) throws RemoteException;
    
    //GUDANG
    public List<String[]> loadGudang() throws RemoteException;
    public boolean insertGudang(GudangModel dataIn) throws RemoteException;
    public List<String[]> cariGudang(String dataCari) throws RemoteException;
    public List<String[]> sortGudang(String by) throws RemoteException;
    public String idGudang() throws RemoteException;
    public boolean updateGudang(GudangModel update) throws RemoteException;
    public boolean deleteGudang(GudangModel id) throws RemoteException;
}
