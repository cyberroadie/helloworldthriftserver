package com.robotmotel.server;

import com.robotmotel.hello.HelloWorld;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * User: cyberroadie
 * Date: 04/09/2013
 */
public class HelloWorldServer {

    public static HelloWorldHandler handler;
    public static HelloWorld.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new HelloWorldHandler();
            processor = new HelloWorld.Processor(handler);
            TServerTransport transport = new TServerSocket(4242);
            TServer server = new TSimpleServer(new TServer.Args(transport).processor(processor));
            System.out.println("Starting simple server");
            server.serve();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
