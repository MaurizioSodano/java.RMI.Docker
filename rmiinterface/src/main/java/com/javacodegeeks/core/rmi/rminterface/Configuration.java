package com.javacodegeeks.core.rmi.rminterface;

import static java.lang.String.format;

public interface Configuration {
	
	String REMOTE_ID = "RMI_EXAMPLE";

	static int getRemotePort( ) {
		final String key = "RMI_REMOTE_PORT";

		final String port = System.getenv(key);

		if( port == null ) throw new IllegalStateException(format( "env var [%s] is not set!", key ));

		return Integer.valueOf(port);
	}

	static String getRemoteHost( ) {
		final String key = "RMI_REMOTE_HOST";
		final String host = System.getenv(key);

		if( host == null ) throw new IllegalStateException(format( "env var [%s] is not set!", key ));

		return host;
	}
}
