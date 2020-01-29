package jenseits.der.nebel.charSheet

import jenseits.der.nebel.checkBox
import jenseits.der.nebel.h2Title
import kotlinx.html.*
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createAttributeSection() {
  h2Title("Attribute (Stufe x 20) Start-EP: 920")
  div {
    classes = setOf("container")
    div {
      classes = setOf("columns")
      div {
        classes = setOf("column")
        attributeCheckbox("magic", "Magie")
        attributeCheckbox("charisma", "Charisma")
        attributeCheckbox("intelligence", "Intelligenz")
        attributeCheckbox("reflexes", "Reflexe")
        attributeCheckbox("willpower", "Willenskraft")
      }
      div {
        classes = setOf("column")
        attributeCheckbox("strength", "Körperkraft")
        attributeCheckbox("agility", "Geschicklichkeit")
        attributeCheckbox("perception", "Wahrnehmung")
        attributeCheckbox("sleightOfHand", "Fingerfertigkeit")
        attributeCheckbox("toughness", "Zähigkeit")
      }
    }
  }
}

private fun DIV.attributeCheckbox(id: String, labelName: String) {
  label {
    classes = setOf("checkbox label")
    htmlFor = id
    +labelName
  }

  checkBox("${id}1")
  checkBox("${id}2")
  checkBox("${id}3")
  checkBox("${id}4")
  checkBox("${id}5")
}