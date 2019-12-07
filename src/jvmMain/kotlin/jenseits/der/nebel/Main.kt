package jenseits.der.nebel

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.html.respondHtml
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.body
import kotlinx.html.h1

fun main() {
  val host = "127.0.0.1"
  val port = 8888

  // Ktor HTTP server startup
  // see https://ktor.io for more details
  val server = embeddedServer(Netty, host = host, port = port) {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
      get("/") {
        call.respondHtml {
          body {
            h1 { +"Charakterverwaltung" }
          }
        }
      }
    }
  }

  server.start()

  val address = "http://$host:$port"
  println("=============================================")
  println("")
  println("The character management backend is started at $address")
  println("")
  println("Open the following in a browser")
  println("  $address")
  println("")
}