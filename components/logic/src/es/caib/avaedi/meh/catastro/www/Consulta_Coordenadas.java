/**
 * Consulta_Coordenadas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.caib.avaedi.meh.catastro.www;

public class Consulta_Coordenadas implements java.io.Serializable, org.apache.axis.encoding.AnyContentType, org.apache.axis.encoding.MixedContentType {
	private org.apache.axis.message.MessageElement[] _any;

	public Consulta_Coordenadas() {
	}

	public Consulta_Coordenadas(org.apache.axis.message.MessageElement[] _any) {
		this._any = _any;
	}

	/**
	 * Gets the _any value for this Consulta_Coordenadas.
	 * 
	 * @return _any
	 */
	public org.apache.axis.message.MessageElement[] get_any() {
		return _any;
	}

	/**
	 * Sets the _any value for this Consulta_Coordenadas.
	 * 
	 * @param _any
	 */
	public void set_any(org.apache.axis.message.MessageElement[] _any) {
		this._any = _any;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Consulta_Coordenadas))
			return false;
		Consulta_Coordenadas other = (Consulta_Coordenadas) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true && ((this._any == null && other.get_any() == null) || (this._any != null && java.util.Arrays.equals(this._any, other.get_any())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (get_any() != null) {
			for (int i = 0; i < java.lang.reflect.Array.getLength(get_any()); i++) {
				java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
				if (obj != null && !obj.getClass().isArray()) {
					_hashCode += obj.hashCode();
				}
			}
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(Consulta_Coordenadas.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.catastro.meh.es/", ">Consulta_Coordenadas"));
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType, java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}