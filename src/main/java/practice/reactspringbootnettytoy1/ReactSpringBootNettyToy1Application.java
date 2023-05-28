package practice.reactspringbootnettytoy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import practice.reactspringbootnettytoy1.movie.netty.NettyAppServer;

/**
 * Configure Netty Server w/o Spring Boot
 * ( Spring Boot Webflux is also available and is much more convenient,
 *   but decided to try Netty Server from scratch )
 */

@SpringBootApplication
public class ReactSpringBootNettyToy1Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ReactSpringBootNettyToy1Application.class, args);

        // run Netty Server (/practice/reactspringbootnettytoy1/movie/netty)
        new NettyAppServer().run();
    }

}
