package com.cubigy.networking;

import com.cubigy.networking.packets.Packet;
import com.cubigy.networking.packets.UserDataPacket;
import com.cubigy.networking.packets.WorldPacket;
import com.cubigy.util.Camera;
import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.GameScreen;
import com.cubigy.networking.packets.ChatPacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	
	private ChannelHandlerContext ctx;
	
	public void sendPacket(Packet chatPacket) {
		ctx.writeAndFlush(chatPacket);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof Packet) {
			if (msg instanceof WorldPacket) {
				if (Cubigy.getInstance().currentScreen instanceof GameScreen) {
					((GameScreen) Cubigy.getInstance().currentScreen).setWorld(((WorldPacket) msg).getWorld());
				}
			}
			if (msg instanceof UserDataPacket) {
				Cubigy.getInstance().team = ((UserDataPacket) msg).getTeam();
				
				Camera.moveTo(-((UserDataPacket) msg).getBaseX() + Cubigy.getInstance().window.getWidth() / 2, -((UserDataPacket) msg).getBaseY() + Cubigy.getInstance().window.getHeight() / 2);
			
				GameScreen.resources = ((UserDataPacket) msg).getResources();
				//System.out.println(GameScreen.resources.getGold().getAmount());
			}
		}
		else {
			System.out.println(msg);
		}
		//ctx.writeAndFlush(new ChatPacket("Hello"));
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		this.ctx = ctx;
		
		System.out.println("Client Active");
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
