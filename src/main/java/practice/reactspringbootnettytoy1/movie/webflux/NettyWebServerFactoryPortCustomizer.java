package practice.reactspringbootnettytoy1.movie.webflux;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Configure the Spring Boot embedded Netty server (WebServerFactoryCustomizer).
 * Customize the embedded Netty server (NettyServerCustomizer)
 */
@Component
public class NettyWebServerFactoryPortCustomizer
        implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Value("${server.port}")
    private int port;

    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        serverFactory.setPort(port);
    }


}
