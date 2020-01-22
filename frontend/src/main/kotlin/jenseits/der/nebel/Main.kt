package jenseits.der.nebel

import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.section
import kotlin.browser.document
import kotlin.browser.window

fun main() {
  window.onload = {
    document.getElementById("app")
      ?.also { it.innerHTML = "" }
      ?.append {
        section {
          classes = setOf("main-content columns is-fullheight has-background-white-ter")
          createMenu()

          div {
            classes = setOf("column is-11")
            div {
              classes = setOf("section")
              createCharacterCreationForm()
            }
          }
        }
      }
  }
}