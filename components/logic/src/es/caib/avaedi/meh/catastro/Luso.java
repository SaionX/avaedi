//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.05 at 02:13:53 PM CEST 
//

package es.caib.avaedi.meh.catastro;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for luso.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="luso">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Almacen-Estacionamiento"/>
 *     &lt;enumeration value="Residencial"/>
 *     &lt;enumeration value="Industrial"/>
 *     &lt;enumeration value="Oficinas"/>
 *     &lt;enumeration value="Comercial"/>
 *     &lt;enumeration value="Deportivo"/>
 *     &lt;enumeration value="Espectaculos"/>
 *     &lt;enumeration value="Ocio y Hosteleria"/>
 *     &lt;enumeration value="Sanidad y Beneficencia"/>
 *     &lt;enumeration value="Cultural"/>
 *     &lt;enumeration value="Religioso"/>
 *     &lt;enumeration value="Obras de urbanizacion y jardineria, suelos sin edificar"/>
 *     &lt;enumeration value="Edificio Singular"/>
 *     &lt;enumeration value="RDL 1/2004 8.2a"/>
 *     &lt;enumeration value="RDL 1/2004 8.2b"/>
 *     &lt;enumeration value="RDL 1/2004 8.2c"/>
 *     &lt;enumeration value="RDL 1/2004 8.2d"/>
 *     &lt;enumeration value="Almacen agrario"/>
 *     &lt;enumeration value="Industrial agrario"/>
 *     &lt;enumeration value="Agrario"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "luso")
@XmlEnum
public enum Luso {

	@XmlEnumValue("Almacen-Estacionamiento")
	ALMACEN_ESTACIONAMIENTO("Almacen-Estacionamiento"), @XmlEnumValue("Residencial")
	RESIDENCIAL("Residencial"), @XmlEnumValue("Industrial")
	INDUSTRIAL("Industrial"), @XmlEnumValue("Oficinas")
	OFICINAS("Oficinas"), @XmlEnumValue("Comercial")
	COMERCIAL("Comercial"), @XmlEnumValue("Deportivo")
	DEPORTIVO("Deportivo"), @XmlEnumValue("Espectaculos")
	ESPECTACULOS("Espectaculos"), @XmlEnumValue("Ocio y Hosteleria")
	OCIO_Y_HOSTELERIA("Ocio y Hosteleria"), @XmlEnumValue("Sanidad y Beneficencia")
	SANIDAD_Y_BENEFICENCIA("Sanidad y Beneficencia"), @XmlEnumValue("Cultural")
	CULTURAL("Cultural"), @XmlEnumValue("Religioso")
	RELIGIOSO("Religioso"), @XmlEnumValue("Obras de urbanizaci\u00f3n y jardineria, suelos sin edificar")
	OBRAS_DE_URBANIZACIoN_Y_JARDINERIA_SUELOS_SIN_EDIFICAR("Obras de urbanizaci\u00f3n y jardineria, suelos sin edificar"), @XmlEnumValue("Edificio Singular")
	EDIFICIO_SINGULAR("Edificio Singular"), @XmlEnumValue("RDL 1/2004 8.2a")
	RDL_1_2004_8_2_A("RDL 1/2004 8.2a"), @XmlEnumValue("RDL 1/2004 8.2b")
	RDL_1_2004_8_2_B("RDL 1/2004 8.2b"), @XmlEnumValue("RDL 1/2004 8.2c")
	RDL_1_2004_8_2_C("RDL 1/2004 8.2c"), @XmlEnumValue("RDL 1/2004 8.2d")
	RDL_1_2004_8_2_D("RDL 1/2004 8.2d"), @XmlEnumValue("Almacen agrario")
	ALMACEN_AGRARIO("Almacen agrario"), @XmlEnumValue("Industrial agrario")
	INDUSTRIAL_AGRARIO("Industrial agrario"), @XmlEnumValue("Agrario")
	AGRARIO("Agrario");
	private final String value;

	Luso(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static Luso fromValue(String v) {
		for (Luso c : Luso.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}