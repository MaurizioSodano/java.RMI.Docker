package com.javacodegeeks.core.rmi.remoteclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;
import com.javacodegeeks.core.rmi.rminterface.RemoteInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoteClient {

	public static void main(String[] args) throws NotBoundException {
		Registry reg;
		try {
			Thread.sleep(1000);
			String remoteHost = System.getenv("REMOTE_HOST");
			remoteHost=remoteHost==null?Configuration.REMOTE_HOST:remoteHost;

			log.info("Locating Registry: remoteHost:{} port:{}",remoteHost, Configuration.REMOTE_PORT);
			reg = LocateRegistry.getRegistry(remoteHost, Configuration.REMOTE_PORT);

			log.info("Lookup Interface: remoteID:{}",Configuration.REMOTE_ID);
			RemoteInterface rmiInterface = (RemoteInterface) reg.lookup(Configuration.REMOTE_ID);

			String str = "javacodegeeks rock!";
			log.info("RMI returns:{}" , rmiInterface.capitalize(str));

		} catch (RemoteException | InterruptedException e) {
			log.error(e.getMessage(),e);
		}
	}
}
