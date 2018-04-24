package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App with Routes with LazyLogging {

  implicit val system: ActorSystem = ActorSystem("miniServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  lazy val routes: Route = allRoutes
  Http().bindAndHandle(allRoutes, "localhost", 8080)

  logger.info("Server online at http://localhost:8080/")

  Await.result(system.whenTerminated, Duration.Inf)
}