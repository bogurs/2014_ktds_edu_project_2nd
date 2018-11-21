package com.ktds.closet.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.json.JsonObject;

import com.ktds.closet.dao.EtcDao;
import com.nhncorp.mods.socket.io.SocketIOServer;
import com.nhncorp.mods.socket.io.SocketIOSocket;
import com.nhncorp.mods.socket.io.impl.DefaultSocketIOServer;
import com.nhncorp.mods.socket.io.spring.DefaultEmbeddableVerticle;

public class VertxSample extends DefaultEmbeddableVerticle {
	private static SocketIOServer io = null;
	@Autowired
	EtcDao etcDao;

	@Override
	public void start(Vertx vertx) {
		int port = 12345;
		HttpServer server = vertx.createHttpServer();

		io = new DefaultSocketIOServer(vertx, server);

		io.sockets().onConnection(new Handler<SocketIOSocket>() {
			public void handle(final SocketIOSocket socket) {

				socket.on("msg", new Handler<JsonObject>() {
					public void handle(JsonObject event) {
						io.sockets().emit("response", event);
						WeatherVO weatherVO = new WeatherVO();
						weatherVO.setContent(event.getString("content"));
						weatherVO.setName(event.getString("name"));
						weatherVO.setEmail(event.getString("email"));
						etcDao.weatherStyleWrite(weatherVO);
					}
				});

			}
		});

		server.listen(port);
	}
}
