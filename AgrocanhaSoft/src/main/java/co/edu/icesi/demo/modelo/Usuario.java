package co.edu.icesi.demo.modelo;
// Generated 18/05/2017 01:24:35 PM by Hibernate Tools 5.1.4.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private BigDecimal usuid;
	private Rol rol;
	private String nombreusu;
	private String cedulausu;
	private String passwordusu;
	private Set<Diagnosticoagronomo> diagnosticoagronomos = new HashSet<Diagnosticoagronomo>(0);

	public Usuario() {
	}

	public Usuario(BigDecimal usuid, String nombreusu, String cedulausu, String passwordusu) {
		this.usuid = usuid;
		this.nombreusu = nombreusu;
		this.cedulausu = cedulausu;
		this.passwordusu = passwordusu;
	}

	public Usuario(BigDecimal usuid, Rol rol, String nombreusu, String cedulausu, String passwordusu,
			Set<Diagnosticoagronomo> diagnosticoagronomos) {
		this.usuid = usuid;
		this.rol = rol;
		this.nombreusu = nombreusu;
		this.cedulausu = cedulausu;
		this.passwordusu = passwordusu;
		this.diagnosticoagronomos = diagnosticoagronomos;
	}

	public BigDecimal getUsuid() {
		return this.usuid;
	}

	public void setUsuid(BigDecimal usuid) {
		this.usuid = usuid;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombreusu() {
		return this.nombreusu;
	}

	public void setNombreusu(String nombreusu) {
		this.nombreusu = nombreusu;
	}

	public String getCedulausu() {
		return this.cedulausu;
	}

	public void setCedulausu(String cedulausu) {
		this.cedulausu = cedulausu;
	}

	public String getPasswordusu() {
		return this.passwordusu;
	}

	public void setPasswordusu(String passwordusu) {
		this.passwordusu = passwordusu;
	}

	public Set<Diagnosticoagronomo> getDiagnosticoagronomos() {
		return this.diagnosticoagronomos;
	}

	public void setDiagnosticoagronomos(Set<Diagnosticoagronomo> diagnosticoagronomos) {
		this.diagnosticoagronomos = diagnosticoagronomos;
	}

}
