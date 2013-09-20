package com.robotmotel.server;

import com.robotmotel.hello.HelloRequest;
import com.robotmotel.hello.HelloResponse;
import com.robotmotel.hello.HelloWorld;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * User: cyberroadie
 * Date: 04/09/2013
 */
public class HelloWorldHandler implements HelloWorld.Iface {

    Logger logger = LoggerFactory.getLogger(HelloWorldHandler.class);

    @Override
    public void ping() throws TException {
        logger.info("ping!");
    }

    @Override
    public HelloResponse getHello(HelloRequest helloRequest) throws TException {
        logger.info("Hello " + helloRequest.getName());
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setGreeting("Hello " + helloRequest.getName() + "!");
        UUID uuid = UUID.randomUUID();
        helloResponse.setMostUUID(uuid.getMostSignificantBits());
        helloResponse.setLeastUUID(uuid.getLeastSignificantBits());
        return helloResponse;
    }

}
