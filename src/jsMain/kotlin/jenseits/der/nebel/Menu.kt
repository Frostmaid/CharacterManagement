package jenseits.der.nebel

import kotlinx.html.*
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createMenu() {
  aside {
    classes = setOf("column is-2 is-narrow-mobile is-fullheight section is-hidden-mobile")
    ul {
      classes = setOf("menu-list")
      li { a { +"Neuen Charakter anlegen" } }
      li { a { +"Meine Charakter" } }
      li { a { +"Charakterübersicht" } }
    }
  }
}