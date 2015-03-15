package com.github.mather.uddf.example

import com.github.mather.uddf.Uddf
import org.specs2.mutable._

import scala.xml.{Elem, XML}


/**
 *
 * @author kuwahataeisuke
 */
class CalculationOfAscentProfilesSpec extends Specification {

  val xml = XML.load(getClass.getResource("/4_1_calculation_of_ascent_profiles.xml"))

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
