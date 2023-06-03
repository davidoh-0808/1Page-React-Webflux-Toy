package practice.reactspringbootnettytoy1.movie.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


/**
 * The router listens for traffic on the /hello path and returns the value provided by our reactive handler class
 *
 *  In Spring WebFlux, router functions are used to route requests to the corresponding HandlerFunction. Typically, you don’t write router functions yourself, but use a method in the RouterFunctions handler class to create them. RouterFunctions.route() (with no parameters) gives you a fluent constructor to create a router function, while RouterFunctions.route(RequestPredicate, HandlerFunction) gives you a direct way to create a router.
 *
 *  This is similar to MVC Controller where API endpoints are defined
 *
 *  1. declare router with API endpoints
 *  2. map each endpoint with appropriate reactive handler
 *  3. define a web client to consume the ServerResponse from the reactive handler
 *
    Netty uses NioEventLoop

    NioEventLoop : an event loop in Java for handling I/O operations for channels using non-blocking I/O
    Event loop : Eventloop is an infinite loop, where at each iteration all the tasks that the Selector provides and that are stored in special queues are executed.
 */
@EnableWebFlux  // <<  enables use of annotated controllers and functional endpoints
//@Configuration
public class NettyReactiveRouter {

    @Bean
    public RouterFunction<ServerResponse> route(NettyReactiveHandlerMovie handler) {

        return RouterFunctions
                .route()
                .GET("/movies", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::getMovies)
                .build();
    }

}
