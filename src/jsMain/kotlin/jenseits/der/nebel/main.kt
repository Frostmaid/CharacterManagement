package jenseits.der.nebel

import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.section
import kotlin.browser.document

const val jvmBackend = "http://127.0.0.1:8888/"

fun main() {
  document.getElementById("app")
    ?.also { it.innerHTML = "" }
    ?.append {
      section {
        classes = setOf("main-content columns is-fullheight")
        createMenu()

        div {
          classes = setOf("container column is-10")
          div {
            classes = setOf("section")

            div {
              classes = setOf("columns")
              div {
                classes = setOf("column")
                createGeneralSection()
              }
              div {
                classes = setOf("column")
                createAttributeSection()
              }
            }
          }
        }
      }
    }
}