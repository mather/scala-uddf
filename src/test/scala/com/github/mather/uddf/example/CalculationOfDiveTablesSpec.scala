package com.github.mather.uddf.example

import com.github.mather.uddf.Uddf
import org.specs2.mutable._

import scala.xml.{Elem, XML}


/**
 *
 * @author kuwahataeisuke
 */
class CalculationOfDiveTablesSpec extends Specification {

  val xml = XML.load(getClass.getResource("/4_2_calculation_of_dive_tables.xml"))

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
