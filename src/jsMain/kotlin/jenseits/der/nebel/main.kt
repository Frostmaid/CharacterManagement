package jenseits.der.nebel

import kotlinx.html.dom.append
import kotlin.browser.document

const val jvmBackend = "http://127.0.0.1:8888/"

fun main() {
  document.getElementById("app")
    ?.also { it.innerHTML = "" }
    ?.append {
      createGeneralSection()
      createAttributeSection()
    }
}