package jenseits.der.nebel.charSheet

import jenseits.der.nebel.checkBox
import jenseits.der.nebel.h2Title
import jenseits.der.nebel.plusButton
import kotlinx.html.*
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createTalentSection() {
  h2Title("Talente")

  plusButton { println("foooo") }

  table {
    classes = setOf("table is-bordered is-striped")
    thead {
      tr {
        th { +"Aktive Talente" }
        th { +"Bezugsattribute" }
        th { +"Wert x 15" }
      }
    }
    tbody {
      tr {
        td { +"Lorem ipsum + " }
        td { +"Weisheit" }
        td {
          div {
            classes = setOf("has-text-centered")
            checkBox("talent1")
            checkBox("talent2")
            checkBox("talent3")
          }
        }
      }
    }
  }
}