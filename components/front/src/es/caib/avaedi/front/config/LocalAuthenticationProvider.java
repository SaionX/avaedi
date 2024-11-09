package es.caib.avaedi.front.config;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.UsuarioBO;
import es.caib.avaedi.logic.vo.UsuarioFormVO;

/**
 * Proveedor de autenticación. Autentica usuarios y configura sus roles
 * 
 * @author agarcia
 * 
 */
@Component
public class LocalAuthenticationProvider {

	/*
	 * public LocalUserDetails authenticate(String name, String password) throws
	 * GenericBusinessException {
	 * 
	 * //String name = authentication.getName(); //String password =
	 * authentication.getCredentials().toString(); LocalUserDetails user =
	 * this.loadUserByUsername(name);
	 * 
	 * if (parsePassword(name,
	 * password).equals(user.getUsuario().getPassword())) {
	 * user.getUsuario().setPassword(null); // Mejor no pasar la contraseña a
	 * las capas siguientes //UsernamePasswordAuthenticationToken auth = new
	 * UsernamePasswordAuthenticationToken(user, password,
	 * user.getAuthorities()); //return auth; return user; } else { throw new
	 * GenericBusinessException("Bad Credentials"); }
	 * 
	 * }
	 */

	/**
	 * Bean para acceder a los métodos de negocio: Usuario
	 */
	@Autowired
	@Qualifier("UsuarioBean")
	protected UsuarioBO usuarioBO;

	private LocalUserDetails loadUserByUsername(String username) throws GenericBusinessException {

		UsuarioFormVO usuario;
		try {
			usuario = this.usuarioBO.findUsuarioByUsername(username);
			if (usuario == null) {
				usuario = new UsuarioFormVO();
				usuario.setUsername(username);
			}
			LocalUserDetails user = new LocalUserDetails(usuario);
			return user;

		} catch (GenericBusinessException e) {
			throw new GenericBusinessException(e.getMessage(), e);
		}

	}

	public synchronized LocalUserDetails loadFromAuthenticatedRequest(HttpServletRequest request) throws GenericBusinessException {

		LocalUserDetails usuarioData = (LocalUserDetails) request.getSession().getAttribute(BaseFrontPrincipal.SESSION_ATTRIB_NAME);
		Principal requestUser = request.getUserPrincipal();
		if ((usuarioData != null) && (requestUser.getName().equals(usuarioData.getUsername()))) {
			return usuarioData;
		} else {
			usuarioData = this.loadUserByUsername(requestUser.getName());
			usuarioData.setAuthorities(this.computeUserRoles(request, usuarioData));

			request.getSession().setAttribute(BaseFrontPrincipal.SESSION_ATTRIB_NAME, usuarioData);
			return usuarioData;
		}
	}

	private List<String> computeUserRoles(HttpServletRequest request, LocalUserDetails usuarioData) {
		List<String> roles = new ArrayList<String>();
		if (request.isUserInRole(Constants.ADMIN)) {
			roles.add(Constants.ADMIN);
		}
		if (request.isUserInRole(Constants.CONSULTA)) {
			roles.add(Constants.CONSULTA);
		}
		if (request.isUserInRole(Constants.OPERADOR)) {
			roles.add(Constants.OPERADOR);
		}
		if (request.isUserInRole(Constants.MUNICIPI)) {
			roles.add(Constants.MUNICIPI);
		}

		return roles;
	}

}
