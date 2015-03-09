package com.github.mather.uddf

import org.specs2.mutable._

import scala.xml.{Elem, XML}

/**
 *
 * @author kuwahataeisuke
 */
class BreathingGasesUsedSpec extends Specification {
  val xml = XML.load(getClass.getResource("/2_1_breathing_gases_used.xml"))

  "Diver Data XML" >> {
    "can be load as XML" >> {
      xml must haveClass[Elem]
    }
    "can be parsed as UDDF" >> {
      val uddf = scalaxb.fromXML[Uddf](xml)
      uddf must haveClass[Uddf]
    }
  }
}
