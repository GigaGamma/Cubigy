package com.cubigy.networking;

import java.util.HashMap;
import java.util.Random;

import com.cubigy.game.Team;
import com.cubigy.networking.packets.ChatPacket;
import com.cubigy.networking.packets.UserDataPacket;
import com.cubigy.networking.packets.WorldPacket;
import com.cubigy.resources.ResourceManager;
import com.cubigy.squares.CapitalSquare;
import com.cubigy.squares.CitySquare;
import com.cubigy.util.ColorUtil;
import com.cubigy.worlds.World;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends ChannelInboundHandlerAdapter {
	
	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	public static HashMap<Channel, Team> teams = new HashMap<Channel, Team>();
	public World world = new World();
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Client: " + ((ChatPacket) msg).getMessage());
	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) {
		System.out.println("Channel Registered");
		
		channels.add(ctx.channel());
		
		//System.out.println(ctx.writeAndFlush(new ChatPacket("test")));
		Random rand = new Random();
		int baseX = rand.nextInt(world.getWidth());
		int baseY = rand.nextInt(world.getHeight());
		final Team team = new Team(ctx.channel().remoteAddress().toString(), ColorUtil.generateRandomColor());
		teams.put(ctx.channel(), team);
		world.addTileToWorld(new CapitalSquare(baseX, baseY, team));
		world.addTileToWorld(new CitySquare("Outpost", baseX - 300, baseY, team));
		ctx.writeAndFlush(new WorldPacket(world));
		ResourceManager rm = new ResourceManager();
		rm.getGold().setAmount(100);
		ctx.writeAndFlush(new UserDataPacket(team, baseX, baseY, rm));
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state() == IdleState.ALL_IDLE) {
				System.out.println("Channel Idle");
				//ctx.writeAndFlush(new ChatPacket("test"));
			}
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
}
