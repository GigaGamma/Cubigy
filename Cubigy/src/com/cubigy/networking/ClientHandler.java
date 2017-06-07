package com.cubigy.networking;

import com.cubigy.networking.packets.ChatPacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Server: " + ((ChatPacket) msg).getMessage());
		ctx.writeAndFlush(new ChatPacket("Hello"));
	}
	
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) {
		//System.out.println("Channel Registered");
		//System.out.println(ctx.writeAndFlush("Test"));
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
}
