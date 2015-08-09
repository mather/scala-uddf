package com.github.mather.uddf.example

import com.github.mather.uddf.Uddf
import org.specs2.mutable._

import scala.xml.{Elem, XML}


/**
 *
 * @author kuwahataeisuke
 */
class ConfigurationOfADiveComputerSpec extends Specification {

  val xml = XML.load(getClass.getResource("/5_1_configuration_of_a_dive_computer.xml"))

  "ConfigurationOfADiveComputer XML" >> {
    "can be load as XML" >> {
      xml must haveClass[Elem]
    }
    "can be parsed as UDDF" >> {
      val uddf = scalaxb.fromXML[Uddf](xml)
      uddf must haveClass[Uddf]
    }
  }
}
