package practice.reactspringbootnettytoy1.movie.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyAppServer {

    // The Netty Server PORT must be different from Spring Boot (8080)
    private static final int HTTP_PORT = 8888;

    public void run() throws Exception {
        // Create the multithreaded event loops for the server
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // A helper class that simplifies server configuration
            ServerBootstrap httpBootstrap = new ServerBootstrap();

            // Configure the server
            httpBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)

                    /*
                        ** netty channel handler is registered here **
                        netty channel handler is like a gateway for all "controllers" as in typical REST API.  << I assume?

                        The actual "controllers" are registered in this channel handler
                     */
                    .childHandler( new NettyServerInitializer() )

                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // Bind and start to accept incoming connections.
            ChannelFuture httpChannel = httpBootstrap.bind(HTTP_PORT).sync();
            // Wait until server socket is closed
            httpChannel.channel().closeFuture().sync();
        }
        finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
