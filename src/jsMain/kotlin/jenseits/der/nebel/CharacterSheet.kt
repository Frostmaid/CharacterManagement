package jenseits.der.nebel

import kotlinx.html.*
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createGeneralSection() {
  form {
    classes = setOf("pure-form", "pure-form-aligned")
    fieldSet {
      legend {
        +"Allgemeines"
      }
      groupWithLabelAndInputField("characterName", "Charaktername")
      groupWithLabelAndInputField("countryOfOrigin", "Herkunft")
      groupWithLabelAndInputField("profession", "Beruf")
      groupWithLabelAndInputField("status", "Status")
    }
  }
}

fun TagConsumer<HTMLElement>.createAttributeSection() {
  form {
    classes = setOf("pure-form")
    legend {
      +"Attribute (Stufe x 20) Start-EP: 920"
    }
    div {
      classes = setOf("pure-g")
      div {
        classes = setOf("pure-u-1-2")

        attributeCheckbox("magic", "Magie")
        attributeCheckbox("charisma", "Charisma")
        attributeCheckbox("intelligence", "Intelligenz")
        attributeCheckbox("reflexes", "Reflexe")
        attributeCheckbox("willpower", "Willenskraft")
      }
      div {
        classes = setOf("pure-u-1-2")
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
  div {
    classes = setOf("pure-controls")
    label {
      classes = setOf("pure-checkbox")
      htmlFor = id
      +labelName

      input {
        this.id = "${id}1"
        type = InputType.checkBox
        value = ""
      }
      input {
        this.id = "${id}2"
        type = InputType.checkBox
        value = ""
      }
      input {
        this.id = "${id}3"
        type = InputType.checkBox
        value = ""
      }
      input {
        this.id = "${id}4"
        type = InputType.checkBox
        value = ""
      }
      input {
        this.id = "${id}5"
        type = InputType.checkBox
        value = ""
      }
    }
  }
}

private fun FIELDSET.groupWithLabelAndInputField(id: String, labelName: String) {
  div {
    classes = setOf("pure-control-group")
    label {
      htmlFor = id
      +labelName
    }
    input {
      this.id = id
      placeholder = labelName
      type = InputType.text
    }
  }
}