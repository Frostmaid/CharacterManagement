package jenseits.der.nebel.charSheet

import jenseits.der.nebel.checkBox
import jenseits.der.nebel.h2Title
import jenseits.der.nebel.plusButton
import kotlinx.html.*
import kotlinx.html.dom.append
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import kotlin.browser.document

fun TagConsumer<HTMLElement>.createTalentSection() {
  h2Title("Talente")

  val containerElement = document.getElementById("talentTable") as HTMLDivElement

  plusButton {

    containerElement.append {
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
            td { +"Lorem ipsum" }
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
  }


}