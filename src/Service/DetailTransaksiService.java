/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.DetailTransaksiModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author User
 */
public interface DetailTransaksiService extends Remote {
    public boolean insert(DetailTransaksiModel detailTransaksi) throws RemoteException;
    public List<DetailTransaksiModel> getAll(String idTransaksi) throws RemoteException;
    public long getTotalHargaById(String idTransaksi) throws RemoteException;
}
