package com.javacodegeeks.core.rmi.rminterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{

	String capitalize(String str) throws RemoteException;
}
