package com.javacodegeeks.core.rmi.remoteserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class RemoteServer {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		val rmiImplementation = new RMIImplementation();

		val registry = LocateRegistry.createRegistry(Configuration.getRemotePort());

		registry.bind(Configuration.REMOTE_ID, rmiImplementation);

		log.info("Binded  id:{} port:{}",Configuration.REMOTE_ID,Configuration.getRemotePort() );

	}

}
