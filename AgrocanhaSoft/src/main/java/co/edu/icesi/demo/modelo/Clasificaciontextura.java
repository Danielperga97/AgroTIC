package co.edu.icesi.demo.modelo;
// Generated 18/05/2017 01:24:35 PM by Hibernate Tools 5.1.4.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clasificaciontextura generated by hbm2java
 */
public class Clasificaciontextura implements java.io.Serializable {

	private BigDecimal clatexid;
	private String nombrecla;
	private Set<Caracterizacionlote> caracterizacionlotes = new HashSet<Caracterizacionlote>(0);

	public Clasificaciontextura() {
	}

	public Clasificaciontextura(BigDecimal clatexid, String nombrecla) {
		this.clatexid = clatexid;
		this.nombrecla = nombrecla;
	}

	public Clasificaciontextura(BigDecimal clatexid, String nombrecla, Set<Caracterizacionlote> caracterizacionlotes) {
		this.clatexid = clatexid;
		this.nombrecla = nombrecla;
		this.caracterizacionlotes = caracterizacionlotes;
	}

	public BigDecimal getClatexid() {
		return this.clatexid;
	}

	public void setClatexid(BigDecimal clatexid) {
		this.clatexid = clatexid;
	}

	public String getNombrecla() {
		return this.nombrecla;
	}

	public void setNombrecla(String nombrecla) {
		this.nombrecla = nombrecla;
	}

	public Set<Caracterizacionlote> getCaracterizacionlotes() {
		return this.caracterizacionlotes;
	}

	public void setCaracterizacionlotes(Set<Caracterizacionlote> caracterizacionlotes) {
		this.caracterizacionlotes = caracterizacionlotes;
	}

}
