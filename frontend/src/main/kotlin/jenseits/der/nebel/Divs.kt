package jenseits.der.nebel

import kotlinx.html.*

fun DIV.checkBox(id: String) {
  input {
    classes = setOf("checkbox")
    this.id = id
    type = InputType.checkBox
  }
}

fun DIV.groupWithLabelAndInputField(id: String, labelName: String) {
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