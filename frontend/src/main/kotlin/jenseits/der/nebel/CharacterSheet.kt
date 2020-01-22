package jenseits.der.nebel

import kotlinx.html.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.createCharacterCreationForm() {
  h1 {
    classes = setOf("title has-text-centered")
    +"Charaktererschaffung"
  }
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

private fun TagConsumer<HTMLElement>.createGeneralSection() {
  h2 {
    classes = setOf("subtitle has-text-centered")
    +"Allgemeines"
  }

  div {
    classes = setOf("container")
    groupWithLabelAndInputField("characterName", "Name")
    groupWithLabelAndInputField("countryOfOrigin", "Herkunft")
    groupWithLabelAndInputField("profession", "Beruf")
    groupWithLabelAndInputField("status", "Status")
  }

}

private fun TagConsumer<HTMLElement>.createAttributeSection() {
  h2 {
    classes = setOf("subtitle has-text-centered")
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

private fun TagConsumer<HTMLElement>.createTalentSection() {
  h2 {
    classes = setOf("subtitle has-text-centered")
    +"Talente"
  }

  button {
    classes = setOf("button")
    span {
      classes = setOf("icon is-small")
      i { classes = setOf("fas fa-plus") }
    }

    onClickFunction = { }
  }

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