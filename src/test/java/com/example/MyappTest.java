package com.example;

import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class MyappTest {
  Vertx vertx = Vertx.vertx();

  @Test
  void start_server() {
    vertx.createHttpServer()
      .requestHandler(req -> req.response().end("Ok"))
      .listen(16969, ar -> {
        // (we can check here if the server started or not)
      });
  }
}