package com.github.mather.uddf

import org.specs2.mutable._
import com.github.mather.uddf.Uddf

import scala.xml.{Elem, XML}


/**
 *
 * @author kuwahataeisuke
 */
class DescriptionOfDiveSpotSpec extends Specification {

  val xml = XML.load(getClass.getResource("/1_2_description_of_dive_spot.xml"))

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
