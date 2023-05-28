package practice.reactspringbootnettytoy1.movie.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class NettyChannelHandlerMovie extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

        // ChannelHandlerContext and FullHttpRequest together contain comprehensive data, such as header info, request url, message and more, as found in lower level packet information.  Unpacking these data can facilitate creating a customized server.. Very facsinating..!

        String reqMethod = msg.method().name();
        String reqUri = msg.uri();

        // (1) POST (INSERT) Movie
        if (reqMethod.equals("POST") && reqUri.equals("http://localhost/movies")) {
            // TODO: logic here

            System.out.println("*********** POST method invoked ***********");
        }

        // (2) GET (SELECT) Movie
        if (reqMethod.equals("GET") && reqUri.equals("http://localhost/movies")) {
            // TODO: logic here
            System.out.println("*********** GET method invoked ***********");
        }


        ByteBuf content = Unpooled.copiedBuffer("Hello World!", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
        ctx.write(response);
        ctx.flush();


        /*
        ByteBuf content = Unpooled.copiedBuffer("Hello World!", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
        ctx.write(response);
        ctx.flush();
         */

    }
}
