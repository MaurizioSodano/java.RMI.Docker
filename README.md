# java RMI in Docker Container

This is a simple example to test rmi functionalities with docker containers

The code is inspired by this post by Nikos Maravitsas
[link](https://examples.javacodegeeks.com/core-java/rmi/remoteexception/java-rmi-remoteexception-how-to-solve-remoteexception/)

#Compile

    mvn clean install
    
#Execute

    docker-compose  up -d 
    
#Result
You should be able to see two containers RMI_SERVER and RMI_CLIENT with the following logs:
1. 15:35:53.639 [main] INFO com.javacodegeeks.core.rmi.remoteserver.RemoteServer - Bindid  id:RMI_EXAMPLE port:8888
2. 15:35:54.362 [main] INFO com.javacodegeeks.core.rmi.remoteclient.RemoteClient - RMI returns:JAVACODEGEEKS ROCK!