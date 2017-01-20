package tutorial.webapp

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import org.scalajs.jquery.jQuery

import scala.scalajs.js.annotation.JSExport

object TutorialApp extends JSApp {

  def main(): Unit = {
    println("Hello World!")
//    this.appendPar(document.body, "Hello World")
    jQuery(setupUI _)

  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")

    jQuery("""<button type="button">Click me!</button>""")
      .click(addClickedMessage _)
      .appendTo(jQuery("body"))
  }

  @JSExport
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)

//    targetNode.appendChild(document.createElement("p").appendChild(document.createTextNode(text)))
  }
}