package practice.reactspringbootnettytoy1.movie.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;


public class NettyServerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new HttpServerCodec());

        /* used to gather the received data (max integer byte value) in ChannelHandlerContext - the ctx -
           which can later be used inside handlers ? */
        pipeline.addLast(new HttpObjectAggregator(Integer.MAX_VALUE));

        // the actual request handlers (similar to controllers in REST API) are registered here ?
        pipeline.addLast(new NettyChannelHandlerMovie());
    }

}
