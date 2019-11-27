package com.javacodegeeks.core.rmi.remoteclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import com.javacodegeeks.core.rmi.rminterface.RemoteInterface;

public class RemoteClient {

	public static void main(String[] args) throws NotBoundException {
		Registry reg;
		try {
			reg = LocateRegistry.getRegistry(Configuration.REMOTE_HOST, Configuration.REMOTE_PORT);

			RemoteInterface rmiInterface = (RemoteInterface) reg.lookup(Configuration.REMOTE_ID);

			String str = "javacodegeeks rock!";
			System.out.println("RMI returns:" + rmiInterface.capitalize(str));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
