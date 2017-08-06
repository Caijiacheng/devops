package com.devops.micro;

import io.grpc.examples.helloworld.HelloWorldClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by caijiacheng on 06/08/2017.
 */
// @ref: http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-health
@Component
public class GrpcHealthIndicator implements HealthIndicator {

//    private static final Logger logger = Logger//Logger.getLogger(GrpcHealthIndicator.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(GrpcHealthIndicator.class.getName());

    @Value("${grpc.host.micro2}")
    private String hostMicro2;
    @Value("${grpc.port.micro2}")
    private int portMicro2;

    @Override
    public Health health() {
        HelloWorldClient client = new HelloWorldClient(hostMicro2, portMicro2);
        try{
            client.greetWithRply("micro2");
        }catch (Throwable ex) {
            logger.warn("", ex);
            return Health.down().withDetail("grpc", ex).build();
        }finally {
            client.shutdownNow();
        }
        return Health.up().withDetail("GRPC is OK", String.format("Micor2 => grpc://%s:%d", hostMicro2, portMicro2)).build();
    }
}
