package co.edu.icesi.demo.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.demo.dao.IUsuarioDAO;
import co.edu.icesi.demo.daow.IRolDAOW;
import co.edu.icesi.demo.daow.IUsuarioDAOW;
import co.edu.icesi.demo.modelo.Rol;
import co.edu.icesi.demo.modelo.Usuario;
import co.edu.icesi.demo.servicios.IAdministradorCadenas;
import co.edu.icesi.demo.util.FacesUtils;

@Scope("singleton")
@Service("accesoLogica")
public class AccesoLogic implements IAccesoLogic {

	@Autowired
	private IRolDAOW rolDAOW;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private IUsuarioDAOW usuarioDAOW;
	
	@Autowired
	private IAdministradorCadenas revisorCadenas;
	
	private final static String CLAVE_UTIL = "AgroUsuario";
	
	/**
	 * Nombre: Iniciar Sesi�n
	 * Descripcion: Loguea a un usuario, por medio de unas credenciales, para permitirle el
	 * 				uso de los servicios del sistema
	 * @param - cedulaUsuario : La cedula del usuario, qui�n quiere iniciar sesi�n en el
	 * 							sistema
	 * @param - password : La contrase�a de la cuenta del usuario, qui�n
	 * 					   quiere iniciar sesi�n en el sistema
	 * @return - boolean : Indica si las credenciales ingresadas fueron validas y as� se le
	 * 					   permite al usuario ingresar al sistema
	 * **/
	
	@Override
	@Transactional(readOnly = true)
	public boolean iniciarSesion(String cedulaUsuario, String password) throws Exception{

		boolean fueAutenticado = false;

		if (cedulaUsuario == null || cedulaUsuario.trim().equalsIgnoreCase("")){
			throw new Exception("La cedula est� vac�a!");
		}
		
		if (password == null || password.trim().equalsIgnoreCase("")){
			throw new Exception("La contrase�a est� vac�a!");
		}
		
		Usuario usuario = usuarioDAOW.buscarUsuarioPorCedula(cedulaUsuario);
		
		if (usuario == null){
			throw new Exception("No Existe Un Usuario con la Cedula Digitada");
		}
		
		if(!usuario.getPasswordusu().equals(password)){
			throw new Exception("Error: Contrase�a Incorrecta!");
		}
		
		FacesUtils.putinSession(CLAVE_UTIL, usuario);
		
		fueAutenticado = true;
		
		return fueAutenticado;
	}
	
	/**
	 * Nombre: CambiarContrasenha
	 * Descripcion: Permite a un usuario, modificar la contrase�a de su cuenta
	 * @param - nuevoPassword : La contrase�a nueva de la cuenta del usuario
	 * @param - usuario : El usuario, a qui�n se le har� un cambio de contrase�a
	 * @return - String : Un mensaje con el resultado del proceso 0de cambio de contrase�a
	 * **/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String cambiarContrasenha(String nuevoPassword, Usuario usuario) throws Exception{

		String resultadoOperacion = "";

		if (usuario==null){
			throw new Exception("El Usuario es nulo!");
		}
		
		if (nuevoPassword == null || nuevoPassword.trim().equalsIgnoreCase("")){
			throw new Exception("La nueva contrase�a est� vac�a!");
		}
		
		if (!revisorCadenas.longitudPasswordValida(nuevoPassword))
			throw new Exception("La contrase�a debe tener entre 6 y 10 caracteres!");
		
		Usuario usuarioBuscado = usuarioDAOW.buscarUsuarioPorCedula(usuario.getCedulausu());

		if (usuarioBuscado == null)
			throw new Exception("El Usuario no est� registrado!");
	
		
		usuario.setPasswordusu(nuevoPassword);
		
		usuarioDAO.merge(usuario);
		
		resultadoOperacion = "Contrase�a modificada correctamente!";
		
		return resultadoOperacion;
	}

	/**
	 * Nombre: darTodosLosRoles
	 * Descripcion: Entrega una lista con todos los roles (tipo de usuarios)
	 * 				que hay validados dentro del
	 * 				sistema
	 * @return - List<Rol> - La lista de los roles que hay disponibles en el sistema,
	 * 						 para iniciar sesi�n
	 * **/
	
	@Override
	@Transactional(readOnly = true)
	public List<Rol> darTodosLosRoles() {
		
		return rolDAOW.darTodosLosRoles();
	}

	/**
	 * Nombre: darUsuarioLogueado
	 * Descripcion: Entrega el usuario que est� logueado en el sistema
	 * @return - Usuario - El usuario que ha iniciado sesi�n en el sistema
	 * **/
	
	@Override
	public Usuario darUsuarioLogueado() {
		return (Usuario) FacesUtils.getfromSession(CLAVE_UTIL);
	}

}
