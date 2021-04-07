/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.TransaksiModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Maria
 */
public interface TransaksiService extends Remote {
    public boolean insert(TransaksiModel transaksi) throws RemoteException;
    public boolean delete(String idTransaksi) throws RemoteException;
    public boolean update(TransaksiModel transaksi)throws RemoteException;
    public List<TransaksiModel> getAll()throws RemoteException;
    public int getTotalBarangById(String idTransaksi) throws RemoteException;
}
