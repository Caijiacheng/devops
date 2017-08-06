package com.devops.micro;

import io.grpc.examples.helloworld.HelloWorldServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by caijiacheng on 06/08/2017.
 */
@Service
public class GrpcService {

    static Logger logger = LoggerFactory.getLogger(GrpcService.class.getName());

    @Value("${grpc.port}")
    private int gport;

    @PostConstruct
    void initService() throws IOException {
        new HelloWorldServer().start(gport);
        logger.warn("Grpc stared on port: {}", gport);
    }

}
