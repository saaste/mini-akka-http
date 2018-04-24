package com.example

import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

class RoutesSpec extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest
    with Routes {

  lazy val routes: Route = allRoutes


  "Routes" should {
    "return no users if no present (GET /)" in {
      val request = HttpRequest(uri = "/")

      request ~> allRoutes ~> check {
        status should ===(StatusCodes.OK)
        contentType should ===(ContentTypes.`text/plain(UTF-8)`)
        entityAs[String] should ===("""ROOT""")
      }
    }

  }

}