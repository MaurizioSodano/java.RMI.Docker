package com.javacodegeeks.core.rmi.remoteclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import com.javacodegeeks.core.rmi.rminterface.RemoteInterface;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class RemoteClient {

	static Registry reg;

	public static void main(String[] args) throws NotBoundException {
		try {
			val remoteHost = Configuration.getRemoteHost();

			log.info("Locating Registry: remoteHost:{} port:{}",remoteHost, Configuration.getRemotePort());
			reg = LocateRegistry.getRegistry(remoteHost, Configuration.getRemotePort());

			log.info("Lookup Interface: remoteID:{}",Configuration.REMOTE_ID);
			RemoteInterface rmiInterface = (RemoteInterface) reg.lookup(Configuration.REMOTE_ID);

			String str = "javacodegeeks rock!";
			log.info("RMI returns:{}" , rmiInterface.capitalize(str));

		} catch (RemoteException e) {
			log.error(e.getMessage(),e);
		}
	}
}
