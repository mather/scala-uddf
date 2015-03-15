package com.github.mather.uddf.example

import com.github.mather.uddf.Uddf
import org.specs2.mutable._

import scala.xml.{Elem, XML}


/**
 *
 * @author kuwahataeisuke
 */
class ReadingRecordedDataFromDiveComputerSpec extends Specification {

  "1st example" >> {
    val xml = XML.load(getClass.getResource("/5_2_reading_recorded_data_from_dive_computer_1.xml"))

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

  "2nd example" >> {
    val xml = XML.load(getClass.getResource("/5_3_reading_recorded_data_from_dive_computer_2.xml"))

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



}
