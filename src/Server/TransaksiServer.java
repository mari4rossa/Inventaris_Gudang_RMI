/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.TransaksiModel;
import Service.TransaksiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author User
 */
public class TransaksiServer extends UnicastRemoteObject implements TransaksiService{
    public TransaksiServer() throws RemoteException {
        super();
    }

    @Override
    public boolean insert(TransaksiModel transaksi) throws RemoteException {
        boolean result = false;
        try {
            result = DAO.TransaksiDAO.insert(transaksi);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String idTransaksi) throws RemoteException {
        boolean result = false;
        try {
            result = DAO.TransaksiDAO.delete(idTransaksi);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(TransaksiModel transaksi) throws RemoteException {
        boolean result = false;
        try {
            result = DAO.TransaksiDAO.update(transaksi);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TransaksiModel> getAll() throws RemoteException {
       List result = null;
       try {
           result = DAO.TransaksiDAO.getAll();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return result;
    }


    @Override
    public int getTotalBarangById(String idTransaksi) throws RemoteException {
        int result = 0;
        try {
            result = DAO.TransaksiDAO.getTotalBarangById(idTransaksi);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
