package com.github.mather.uddf.example

import com.github.mather.uddf.Uddf
import org.specs2.mutable._

import scala.xml.{Elem, XML}

/**
 *
 * @author kuwahataeisuke
 */
class BiologicalPopulationInventoriesSpec extends Specification {
  val xml = XML.load(getClass.getResource("/1_3_biological_population_inventories.xml"))

  "BiologicalPopulationInventories XML" >> {
    "can be load as XML" >> {
      xml must haveClass[Elem]
    }
    "can be parsed as UDDF" >> {
      val uddf = scalaxb.fromXML[Uddf](xml)
      uddf must haveClass[Uddf]
    }
  }
}
