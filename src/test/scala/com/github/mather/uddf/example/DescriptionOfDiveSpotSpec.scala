package com.github.mather.uddf.example

import com.github.mather.uddf.Uddf
import org.specs2.mutable._

import scala.xml.{Elem, XML}


/**
 *
 * @author kuwahataeisuke
 */
class DescriptionOfDiveSpotSpec extends Specification {

  val xml = XML.load(getClass.getResource("/1_2_description_of_dive_spot.xml"))

  "DescriptionOfDiveSpot XML" >> {
    "can be load as XML" >> {
      xml must haveClass[Elem]
    }
    "can be parsed as UDDF" >> {
      val uddf = scalaxb.fromXML[Uddf](xml)
      uddf must haveClass[Uddf]
    }
    "must have manufacturer ID" >> {
      val uddf = scalaxb.fromXML[Uddf](xml)
      uddf.generator.flatMap(_.manufacturer.map(_.id)) must beSome("foo")
    }
  }
}
