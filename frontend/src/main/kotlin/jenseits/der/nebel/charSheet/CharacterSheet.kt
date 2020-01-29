package jenseits.der.nebel.charSheet

import jenseits.der.nebel.h1Title
import kotlinx.html.TagConsumer
import kotlinx.html.classes
import kotlinx.html.div
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createCharacterCreationForm() {
  h1Title("Charaktererschaffung")
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
  div {
    createTalentSection()
  }
}