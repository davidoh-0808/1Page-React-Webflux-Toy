package practice.reactspringbootnettytoy1.movie.netty;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import practice.reactspringbootnettytoy1.movie.entity.Movie;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NettyChannelHandlerMovie extends SimpleChannelInboundHandler<FullHttpRequest> {

    /* ** SPRING IOC ISSUE **
    private MovieController movieController;

    NettyChannelHandlerMovie() {
        this.movieController = new MovieController(

                new MovieServiceImpl( new MovieRepository( ** SPRING IOC ISSUE ** ) )
        );
    }
    */

    private List<Movie> movieList = new ArrayList<>();

    // so manually injecting data.. for time sake
    NettyChannelHandlerMovie() {
        movieList.add( Movie.builder().id(1).genre("action").title("John Wick").build() );
        movieList.add( Movie.builder().id(2).genre("action").title("The Fast And Furious").build() );
        movieList.add( Movie.builder().id(3).genre("sci-fi").title("Interstellar").build() );
        movieList.add( Movie.builder().id(4).genre("animation").title("Your Name Is").build() );
        movieList.add( Movie.builder().id(5).genre("drama").title("The Godfather").build() );
        movieList.add( Movie.builder().id(6).genre("comedy").title("Central Intelligence").build() );
    }

    // test this Netty endpoint by sending Postman request via "GET or POST http://localhost:8888/movies"
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

        // ChannelHandlerContext and FullHttpRequest together contain comprehensive data, such as header info, request url, message and more, as found in lower level packet information.  Unpacking these data can facilitate creating a customized server.. Very facsinating..!

        String reqMethod = msg.method().name(); // << either POST or GET
        String reqUri = msg.uri(); // << either POST /movies or GET /movies

        // (1) POST (INSERT) Movie
        if (reqMethod.equals("POST") && reqUri.equals("movies")) {

            /* ** SPRING IOC ISSUE **
            MovieController.saveMovie(Movie movie) */

            /* configure POST
               read byteBuf from Netty Channel and convert it into Java Object Movie*/
            ByteBuf byteBuf = msg.content();

            byte[] byteArray = new byte[byteBuf.readableBytes()];
            byteBuf.getBytes(byteBuf.readerIndex(), byteArray);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Object byteBufToJavaObject = objectInputStream.readObject();

            objectInputStream.close();
            byteArrayInputStream.close();

            // TODO : CHECK .. not sure????
            Movie newMovie = (Movie) byteBufToJavaObject;
            movieList.add(newMovie);

        }

        // (2) GET (SELECT) Movie
        if (reqMethod.equals("GET") && reqUri.equals("movies")) {

            /* ** SPRING IOC ISSUE **
            invoke controller .getAllMovies() */

            // configure Netty response
            // << insert the actual movie data here ? TODO: CHECK
            ByteBuf headerContent = Unpooled.copiedBuffer( new Gson().toJson(movieList), CharsetUtil.UTF_8);

            FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, headerContent);
            resp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html");

            // insert the actual movie data here ? TODO: CHECK
            resp.headers().set(HttpHeaderNames.CONTENT_LENGTH, headerContent.readableBytes());

            // send the message via Netty Pipeline and remove it afterward
            ctx.write(resp);
            ctx.flush();

        }


    }
}
