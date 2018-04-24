package com.example

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport

trait JsonSupport extends SprayJsonSupport {
  // import the default encoders for primitive types (Int, String, Lists etc)
  import spray.json.DefaultJsonProtocol._


  // Create implicit formatters like this
  // implicit val userJsonFormat = jsonFormat3(YourCustomType)

}
