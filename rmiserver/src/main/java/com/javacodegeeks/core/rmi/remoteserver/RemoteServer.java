package com.javacodegeeks.core.rmi.remoteserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoteServer {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		RMIImplementation rmiImplementation = new RMIImplementation();
		Registry registry = LocateRegistry.createRegistry(Configuration.REMOTE_PORT);
		registry.bind(Configuration.REMOTE_ID, rmiImplementation);
		log.info("Bindid  id:{} port:{}",Configuration.REMOTE_ID,Configuration.REMOTE_PORT );

	}

}
