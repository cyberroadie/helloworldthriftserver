package com.robotmotel.server;

import com.robotmotel.hello.HelloWorld;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerTransport;

/**
 * User: cyberroadie
 * Date: 10/09/2013
 */
public class HelloWorldSSLServer {

    public static HelloWorldHandler handler;
    public static HelloWorld.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new HelloWorldHandler();
            processor = new HelloWorld.Processor(handler);
            TServerTransport transport = TSSLTransportFactory.getServerSocket(4242);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(transport).processor(processor));
            System.out.println("Starting simple SSL server");
            server.serve();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
