package es.caib.avaedi.front.server;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;

public class RestServiceHelper {
	private static HashMap<String, PropiedadProp> HASHMAPPROD = getProductosFiltro();
	private static HashMap<String, PropiedadProp> HASMAPFAMI = getFamiliaFiltro();

	public HashMap<String, PropiedadProp> getProductosFiltroPropiedades() {
		return RestServiceHelper.HASHMAPPROD;
	}

	public HashMap<String, PropiedadProp> getFamiliaFiltroPropiedades() {
		return RestServiceHelper.HASMAPFAMI;
	}

	public void setBuscadorProductoFilters(Collection<FilterConfig> filters, UriInfo uriInfo, String lang) {
		MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
		Set<String> keys = params.keySet();
		String[] keysArray = keys.toArray(new String[keys.size()]);
		Arrays.sort(keysArray);
		HashMap<String, PropiedadProp> hmPropiedades = this.getProductosFiltroPropiedades();
		for (String i : keysArray) {
			if (hmPropiedades.containsKey(i)) {
				List<String> list = params.get(i);
				String valor = list.get(0);
				if (valor == null || valor == "") {
					return;
				}
				System.out.println("Se anade el filtro: " + i + " con valores: " + valor);

				FilterConfig filtro = new FilterConfig();

				filtro.setField("id,nombre" + lang + ",ingredientes" + lang);
				filtro.setComparison("like");
				filtro.setValue(valor);

				PropiedadProp temp = hmPropiedades.get(i);

				String nombre = temp.isMultilang() ? temp.getNombre() + lang : temp.getNombre();
				filtro = new FilterConfig(temp.getTipo(), nombre, CriteriaUtils.COMPARISON_EQUAL, valor);
				filters.add(filtro);

				System.out.println("Anadiendo filtro: " + filtro.getField() + " de tipo: " + filtro.getType() + "con criterio: " + filtro.getComparison() + " para valor: " + filtro.getValue());
			} else {
				System.out.println("filtro no admitido: " + i + " ;  Ignorando.");
			}
		}

	}

	private static HashMap<String, PropiedadProp> getProductosFiltro() {

		HashMap<String, PropiedadProp> hashPropiedades = new HashMap<String, PropiedadProp>();
		hashPropiedades.put("productoId", new PropiedadProp("id", FilterConfig.TYPE_NUMERIC));
		hashPropiedades.put("productoNombre", new PropiedadProp("nombre", FilterConfig.TYPE_STRING, true));
		hashPropiedades.put("productoIngredientes", new PropiedadProp("ingredientes", FilterConfig.TYPE_STRING, true));

		return hashPropiedades;
	}

	private static HashMap<String, PropiedadProp> getFamiliaFiltro() {

		HashMap<String, PropiedadProp> hashPropiedades = new HashMap<String, PropiedadProp>();
		hashPropiedades.put("id", new PropiedadProp("id", FilterConfig.TYPE_NUMERIC));
		hashPropiedades.put("nombre", new PropiedadProp("nombre", FilterConfig.TYPE_STRING, true));

		return hashPropiedades;
	}

	public static class PropiedadProp {
		private String nombre;
		private String tipo;
		private boolean multilang;

		public PropiedadProp(String nombre, String tipo) {
			this.nombre = nombre;
			this.tipo = tipo;
			this.multilang = false;
		}

		public PropiedadProp(String nombre, String tipo, boolean multilang) {
			this.nombre = nombre;
			this.tipo = tipo;
			this.multilang = multilang;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public void setMultilang(boolean multilang) {
			this.multilang = multilang;
		}

		public boolean isMultilang() {
			return multilang;
		}

	}

}
