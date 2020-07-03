package ua.home.servicediscoverer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author azatvornitskiy
 * @since 2020-07-03
 */
@EnableEurekaServer
@SpringBootApplication
public class MainServiceDiscoverer
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainServiceDiscoverer.class, args);
    }
}
