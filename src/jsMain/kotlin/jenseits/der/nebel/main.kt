package jenseits.der.nebel

import kotlinx.html.classes
import kotlinx.html.dom.append
import kotlinx.html.js.button
import kotlinx.html.js.onClickFunction
import kotlinx.html.span
import kotlin.browser.document

const val jvmBackend = "http://127.0.0.1:8888/"

fun main() {
  document.getElementById("app")
    ?.also { it.innerHTML = "" }
    ?.append {
      button {
        onClickFunction = {
          span { +"fooooo" }
          println("fooooo")
        }
        classes = setOf("foo-button", "pure-button")
        +"foooo"
      }
    }
}