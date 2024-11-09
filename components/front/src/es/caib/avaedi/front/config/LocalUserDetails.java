package es.caib.avaedi.front.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.logic.vo.UsuarioFormVO;

/**
 * TODO: eliminar si está obsoleto en entorno CAIB
 * 
 * @author agarcia
 * 
 */
public class LocalUserDetails implements BaseFrontPrincipal {

	private static final long serialVersionUID = 1L;
	private UsuarioFormVO usuario;

	public LocalUserDetails(UsuarioFormVO usuario) {
		this.setUsuario(usuario);
	}

	public String getPassword() {
		//return usuario.getPassword();
		return "";
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	// Implementa el interfaz UserDetails
	private Collection<String> authorities;
	private Set<String> roleNames = new HashSet<String>();

	public Collection<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> roles) {
		this.authorities = roles;
		this.roleNames.clear();
		this.roleNames.addAll(roles);
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		if (this.usuario != null) {

			//return this.usuario.isActivo();
			return true;
		}
		return false;
	}

	public void setUsuario(UsuarioFormVO usuario) {
		this.usuario = usuario;
	}

	public UsuarioFormVO getUsuario() {
		return usuario;
	}

	@Override
	public String getName() {
		return this.getUsername();
	}

	@Override
	public boolean isInRole(String rol) {
		return this.roleNames.contains(rol);
	}

	@Override
	public boolean isInAnyRole(String... roles) {
		for (String rol : roles) {
			if (this.isInRole(rol)) {
				return true;
			}
		}
		return false;
	}

}
