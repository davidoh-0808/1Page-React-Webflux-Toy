package practice.reactspringbootnettytoy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Configure Netty Server w/ Spring Boot
 * ( Spring Boot Webflux is a much convenient way to use Netty Non-Blocking features
 *   without the need to customize tiny details of lower layers like header info and protocols)
 */

@SpringBootApplication
public class _1PageReactWebfluxToy {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(_1PageReactWebfluxToy.class, args);
    }

}
