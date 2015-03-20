package com.github.mather.uddf

import com.github.mather.uddf
import org.specs2.mutable._

/**
 *
 * @author kuwahataeisuke
 */
class GeneratorSpec extends Specification {

  "Minimal generator element" >> {
  	"be parsed" >> {
      val xml = <generator xmlns="http://www.streit.cc/uddf/3.2/">
        <name>Sample</name>
      </generator>
      val generator = scalaxb.fromXML[uddf.Generator](xml)

      generator.name must_== "Sample"
    }
    "be created" >> {
      val generator = uddf.Generator("Sample")
      val xml = scalaxb.toXML(generator, "generator", uddf.defaultScope)
      (xml \ "name")(0).text must_== "Sample"
    }
  }
  
  "Full generator element" >> {
    "be parsed" >> {
      val xml = <generator xmlns="http://www.streit.cc/uddf/3.2/">
        <name>Sample</name>
        <aliasname>Simple Converter</aliasname>
        <aliasname>Other Converter</aliasname>
        <type>converter</type>
        <link ref="id_of_divecomputer" />
        <manufacturer id="sample_manufacture">
          <name>Scala-UDDF</name>
          <contact>
            <homepage>https://github.com/mather/scala-uddf/</homepage>
          </contact>
        </manufacturer>
        <version>0.0.1</version>
        <datetime>2015-03-16T23:00:00+09:00</datetime>
      </generator>
      val generator = scalaxb.fromXML[uddf.Generator](xml)
      generator.version must_== Some("0.0.1")
      generator.typeValue must_== Some(uddf.Converter)
    }
  }
}