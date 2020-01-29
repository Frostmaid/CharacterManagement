package jenseits.der.nebel

import kotlinx.html.*
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.plusButton(onClickFunction: (Any) -> Unit) {
  button {

    classes = setOf("button")
    span {
      classes = setOf("icon is-small")
      i { classes = setOf("fas fa-plus") }
    }

  }.onclick = onClickFunction
}