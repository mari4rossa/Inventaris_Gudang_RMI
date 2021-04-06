/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.DetailTransaksiModel;
import Service.DetailTransaksiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author User
 */
public class DetailTransaksiServer extends UnicastRemoteObject implements DetailTransaksiService {
    public DetailTransaksiServer() throws RemoteException {
        super();
    }

    @Override
    public boolean insert(DetailTransaksiModel detailTransaksi) throws RemoteException {
        boolean result = false;
        try {
            result = DAO.DetailTransaksiDAO.insert(detailTransaksi);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DetailTransaksiModel> getAll() throws RemoteException {
       List result = null;
       try {
           result = DAO.DetailTransaksiDAO.getAll();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return result;
    }
}