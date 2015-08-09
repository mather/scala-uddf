package com.github.mather.uddf

import java.net.URI
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
    "be parsed and typed" >> {
      val xml = <generator xmlns="http://www.streit.cc/uddf/3.2/">
        <name>Sample</name>
        <aliasname>Simple Converter</aliasname>
        <aliasname>Other Converter</aliasname>
        <type>converter</type>
        <link ref="id_of_divecomputer" />
        <manufacturer id="sample_manufacturer">
          <name>Scala-UDDF</name>
          <address>
            <country>Japan</country>
          </address>
          <contact>
            <language>Japanese</language>
            <language>English</language>
            <homepage>https://github.com/mather/scala-uddf/</homepage>
          </contact>
        </manufacturer>
        <version>0.0.1</version>
        <datetime>2015-03-16T23:00:00+09:00</datetime>
      </generator>

      val generator = scalaxb.fromXML[uddf.Generator](xml)
      //println(generator)
      for {
        m <- generator.manufacturer
        c <- m.contact
      } {
        m.id must_== "sample_manufacturer"
        c.homepage.head must_== new URI("https://github.com/mather/scala-uddf/")
      }
      generator.version must_== Some("0.0.1")
      generator.typeValue must_== Some(uddf.Converter)
      //println(generator.datetime.get.getClass)
      //=> com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl
      //=> javax.xml.datatype.XMLGregorianCalender
    }

    "be created from object" >> {
      val generator = uddf.Generator("sample",
        typeValue = Some(uddf.Divecomputer),
        version = Some("1.0.2"),
        manufacturer = Some(uddf.ManufacturerType(uddf.NameAndAliasesSequence("manufacturer"),
          address = Some(uddf.AddressType(country=Some("Japan"))),
          contact = Some(uddf.ContactType(homepage=List(new URI("http://example.com/")))))
        )
      )
      val xml = scalaxb.toXML(generator, "generator", uddf.defaultScope)
      // println(xml)
      (xml \ "version")(0).text must_== "1.0.2"
    }
  }
}
