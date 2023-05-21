package com.example;

import rife.bld.Project;

import java.util.List;

import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.*;

public class MyappBuild extends Project {
  public MyappBuild() {
    pkg = "com.example";
    name = "Myapp";
    mainClass = "com.example.MyappMain";
    version = version(0,1,0);

    repositories = List.of(MAVEN_CENTRAL);

    var vertxVersion = version(4,4,2);

    scope(compile)
      .include(dependency("io.vertx", "vertx-web", vertxVersion));

    scope(test)
      .include(dependency("org.junit.platform", "junit-platform-console", version(1,9,3)))
      .include(dependency("io.vertx", "vertx-junit5", vertxVersion));
  }

  public static void main(String[] args) {
    new MyappBuild().start(args);
  }
}