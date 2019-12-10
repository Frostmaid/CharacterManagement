package jenseits.der.nebel

import kotlinx.html.DIV
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.input

fun DIV.checkBox(id: String) {
  input {
    this.id = id
    type = InputType.checkBox
  }
}