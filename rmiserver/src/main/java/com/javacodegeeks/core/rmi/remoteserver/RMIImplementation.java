package com.javacodegeeks.core.rmi.remoteserver;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import com.javacodegeeks.core.rmi.rminterface.RemoteInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIImplementation extends UnicastRemoteObject implements RemoteInterface {

    protected RMIImplementation() throws RemoteException {
        super( Configuration.getRemotePort() );
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String capitalize(String str) throws RemoteException {
        return str.toUpperCase();
    }

}
