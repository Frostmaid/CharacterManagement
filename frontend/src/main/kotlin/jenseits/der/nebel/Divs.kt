package jenseits.der.nebel

import kotlinx.html.*

fun DIV.checkBox(id: String) {
  input {
    classes = setOf("checkbox")
    this.id = id
    type = InputType.checkBox
  }
}