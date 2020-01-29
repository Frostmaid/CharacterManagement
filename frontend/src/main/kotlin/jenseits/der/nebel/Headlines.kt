package jenseits.der.nebel

import kotlinx.html.TagConsumer
import kotlinx.html.classes
import kotlinx.html.h1
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.h1Title(title: String) {
  h1 {
    classes = setOf("title has-text-centered")
    +title
  }
}

fun TagConsumer<HTMLElement>.h2Title(title: String) {
  h1 {
    classes = setOf("subtitle has-text-centered")
    +title
  }
}