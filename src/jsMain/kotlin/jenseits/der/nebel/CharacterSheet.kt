package jenseits.der.nebel

import kotlinx.html.*
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createGeneralSection() {
  h2 {
    classes = setOf("subtitle")
    +"Allgemeines"
  }

  div {
    classes = setOf("container")
    groupWithLabelAndInputField("characterName", "Charaktername")
    groupWithLabelAndInputField("countryOfOrigin", "Herkunft")
    groupWithLabelAndInputField("profession", "Beruf")
    groupWithLabelAndInputField("status", "Status")
  }

}

fun TagConsumer<HTMLElement>.createAttributeSection() {
  h2 {
    classes = setOf("subtitle")
    +"Attribute (Stufe x 20) Start-EP: 920"
  }
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

private fun DIV.groupWithLabelAndInputField(id: String, labelName: String) {
  div {
    classes = setOf("field is-horizontal")
    div {
      classes = setOf("field-label is-normal")
      label {
        classes = setOf("label")
        htmlFor = id
        +labelName
      }
    }
    div {
      classes = setOf("field-body")
      div {
        classes = setOf("field")
        p {
          classes = setOf("control")
          input {
            classes = setOf("input")
            this.id = id
            placeholder = labelName
            type = InputType.text
          }
        }
      }
    }
  }

}