package com.devops.micro;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.grpc.examples.helloworld.HelloWorldClient;
import io.grpc.examples.routeguide.RouteGuideClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by caijiacheng on 06/08/2017.
 */
// @ref: http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-health
@Component
public class GrpcHealthIndicator implements HealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(GrpcHealthIndicator.class.getName());

    @Value("${grpc.host.micro2}")
    private String hostMicro2;
    @Value("${grpc.port.micro2}")
    private int portMicro2;

    @Value("${grpc.host.micro1}")
    private String hostMicro1;
    @Value("${grpc.port.micro1}")
    private int portMicro1;


    @Override
    public Health health() {

        
        Health.Builder health;

        boolean error = false;

        Map<String, String> micro1 = Maps.newTreeMap();
        micro1.put("host", hostMicro1);
        micro1.put("port", String.valueOf(portMicro1));


        try{
            checkMicro1();
        }catch (Throwable ex) {
            micro1.put("error",  ex.getClass().getName() + ": " + ex.getMessage());
            error = true;
        }

        Map<String, String> micro2 = Maps.newTreeMap();
        micro2.put("host", hostMicro2);
        micro2.put("port", String.valueOf(portMicro2));

        try{
            checkMicro2();
        }catch (Throwable ex) {
            micro2.put("error",  ex.getClass().getName() + ": " + ex.getMessage());
            error = true;
        }

        if (error) {
            return Health.down().withDetail("GRpc", ImmutableMap.of("Micro1", micro1, "Micro2", micro2)).build();
        }

        return Health.up().withDetail("GRpc", ImmutableMap.of("Micro1", micro1, "Micro2", micro2)).build();

    }

    void checkMicro1() throws InterruptedException, IOException {

        RouteGuideClient client = new RouteGuideClient(hostMicro1, portMicro1);
        try {
            client.getFeatureWithReply(0, 0);
        } finally {
            client.shutdownNow();
        }
    }

    void checkMicro2() throws InterruptedException, IOException {
        HelloWorldClient client = new HelloWorldClient(hostMicro2, portMicro2);
        try{
            client.greetWithRply("micro2");
        }finally {
            client.shutdownNow();
        }
    }
}
