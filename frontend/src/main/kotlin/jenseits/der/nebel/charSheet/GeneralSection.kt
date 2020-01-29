package jenseits.der.nebel.charSheet

import jenseits.der.nebel.groupWithLabelAndInputField
import jenseits.der.nebel.h2Title
import kotlinx.html.TagConsumer
import kotlinx.html.classes
import kotlinx.html.div
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createGeneralSection() {
  h2Title("Allgemeines")

  div {
    classes = setOf("container")
    groupWithLabelAndInputField("characterName", "Name")
    groupWithLabelAndInputField("countryOfOrigin", "Herkunft")
    groupWithLabelAndInputField("profession", "Beruf")
    groupWithLabelAndInputField("status", "Status")
  }

}