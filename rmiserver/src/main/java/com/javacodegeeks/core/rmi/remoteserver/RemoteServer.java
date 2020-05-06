package com.javacodegeeks.core.rmi.remoteserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoteServer {
	static Registry registry;

	static {
		try {
			registry = LocateRegistry.createRegistry(Configuration.REMOTE_PORT);
		} catch (RemoteException e) {
			log.error(e.getMessage());
		}
	}

	public static void main(String[] args) throws RemoteException {
		
		RMIImplementation rmiImplementation = new RMIImplementation();
		//Registry registry = LocateRegistry.createRegistry(Configuration.REMOTE_PORT);
		registry.rebind(Configuration.REMOTE_ID, rmiImplementation);
		log.info("Binded  id:{} port:{}",Configuration.REMOTE_ID,Configuration.REMOTE_PORT );

	}

}
