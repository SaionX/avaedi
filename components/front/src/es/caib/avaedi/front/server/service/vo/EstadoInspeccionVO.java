package es.caib.avaedi.front.server.service.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EstadoInspeccionVO {

	public static class EdificioVO {

		/**
		 * Numeración extra del edificio, cuando coexiste más de una comunidad o
		 * una unidad de informe en el mismo número
		 */
		private String numeroExtra;

		private String estadoInspeccionEs;

		private String estadoInspeccionCa;

		private Integer proximaIEE;

		public String getNumeroExtra() {
			return numeroExtra;
		}

		public void setNumeroExtra(String numeroExtra) {
			this.numeroExtra = numeroExtra;
		}

		public String getEstadoInspeccionEs() {
			return estadoInspeccionEs;
		}

		public void setEstadoInspeccionEs(String estadoInspeccionEs) {
			this.estadoInspeccionEs = estadoInspeccionEs;
		}

		public String getEstadoInspeccionCa() {
			return estadoInspeccionCa;
		}

		public void setEstadoInspeccionCa(String estadoInspeccionCa) {
			this.estadoInspeccionCa = estadoInspeccionCa;
		}

		/**
		 * Año de próxima inspección
		 * 
		 * @return
		 */
		public Integer getProximaIEE() {
			return proximaIEE;
		}

		public void setProximaIEE(Integer proximaIEE) {
			this.proximaIEE = proximaIEE;
		}

	}

	private List<EdificioVO> edificios = new ArrayList<EdificioVO>();

	private String direccion;

	/**
	 * Nom
	 */
	private String referenciaCatastral;

	/**
	 * Año de construcción
	 */
	private Integer antiguedad;

	/**
	 * Coordenada X (UTM EPSG:25831)
	 */
	private BigDecimal centroX;
	/**
	 * Coordenada Y (UTM EPSG:25831)
	 */
	private BigDecimal centroY;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferenciaCatastral() {
		return referenciaCatastral;
	}

	public void setReferenciaCatastral(String referenciaCatastral) {
		this.referenciaCatastral = referenciaCatastral;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public BigDecimal getCentroX() {
		return centroX;
	}

	public void setCentroX(BigDecimal d) {
		this.centroX = d;
	}

	public BigDecimal getCentroY() {
		return centroY;
	}

	public void setCentroY(BigDecimal centroY) {
		this.centroY = centroY;
	}

	public void setEdificios(List<EdificioVO> edificios) {
		this.edificios = edificios;
	}

	public List<EdificioVO> getEdificios() {
		return edificios;
	}

}
