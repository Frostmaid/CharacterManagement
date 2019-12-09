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

private fun DIV.attributeCheckbox(id: String, labelName: String) {
  div {
    classes = setOf("field is-horizontal")
    label {
      classes = setOf("checkbox")
      htmlFor = id
      +labelName

      input {
        this.id = "${id}1"
        type = InputType.checkBox
      }
      input {
        this.id = "${id}2"
        type = InputType.checkBox
      }
      input {
        this.id = "${id}3"
        type = InputType.checkBox
      }
      input {
        this.id = "${id}4"
        type = InputType.checkBox
      }
      input {
        this.id = "${id}5"
        type = InputType.checkBox
      }
    }
  }
}

private fun DIV.groupWithLabelAndInputField(id: String, labelName: String) {
  div {
    classes = setOf("field is-horizontal")
    div {
      classes = setOf("field-label is-normal")
      label {
        htmlFor = id
        +labelName
      }
    }
    div {
      classes = setOf("field-body")
      div {
        classes = setOf("field")
        div {
          classes = setOf("control")
          input {
            this.id = id
            placeholder = labelName
            type = InputType.text
          }
        }
      }
    }
  }

}