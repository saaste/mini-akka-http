package com.example

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.get
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.util.Timeout

import scala.concurrent.duration._

trait Routes extends JsonSupport {
  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[Routes])

  implicit lazy val timeout: Timeout = Timeout(5.seconds)

  lazy val allRoutes: Route =
  pathSingleSlash {
    get {
      complete("ROOT")
    }
  }

}
