package com.robotmotel.client;

import com.robotmotel.hello.HelloRequest;
import com.robotmotel.hello.HelloResponse;
import com.robotmotel.hello.HelloWorld;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: cyberroadie
 * Date: 10/09/2013
 */
public class HelloWorldSSLClient {
    public static void main(String[] args) throws TException {
        startServer();
    }

    public static void startServer() throws TException {
        TTransport transport = TSSLTransportFactory.getClientSocket("www.cyberroadie.org", 1443);

        TProtocol protocol = new TBinaryProtocol(transport);
        HelloWorld.Client client = new HelloWorld.Client(protocol);

        client.ping();
        System.out.println("Server alive");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String name = null;
            try {
                name = br.readLine();
                HelloRequest request = new HelloRequest();
                request.setName(name);
                HelloResponse response = client.getHello(request);
                System.out.println(response.getGreeting());
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }
        }

    }
}
