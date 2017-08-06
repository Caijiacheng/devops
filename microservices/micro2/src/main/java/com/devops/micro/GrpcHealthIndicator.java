package com.devops.micro;

import io.grpc.examples.routeguide.RouteGuideClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by caijiacheng on 06/08/2017.
 */
@Component
public class GrpcHealthIndicator implements HealthIndicator{
    @Value("${grpc.host.micro1}")
    private String hostMicro1;
    @Value("${grpc.port.micro1}")
    private int portMicro1;

    @Override
    public Health health() {
        try{
            checkRPC();
        }catch (Throwable ex) {
            return Health.down().withDetail("can't reach Micro2", ex).build();
        }
        return Health.up().withDetail("GRpc", String.format("Micor1 => grpc://%s:%d", hostMicro1, portMicro1)).build();
    }

    void checkRPC() throws InterruptedException, IOException {

        RouteGuideClient client = new RouteGuideClient(hostMicro1, portMicro1);
        try {
            client.getFeatureWithReply(0, 0);
        } finally {
            client.shutdownNow();
        }
    }

}
