package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "maintenance")
public class maintenance {
	private long id;
	private String Nomc;
	private String prec ;
	private int telc;
	private String nomapp;
	private String modelapp;
	private String panne;
	private Date dateE;
	private Date dateS;
	private String user;
	private String tech;
	private double prix;
	public maintenance() {
	
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "Nomc", nullable = false)
	public String getNomc() {
		return Nomc;
	}
	public void setNomc(String nomc) {
		Nomc = nomc;
	}
	@Column(name = "prec", nullable = false)
	public String getPrec() {
		return prec;
	}
	public void setPrec(String prec) {
		this.prec = prec;
	}
	@Column(name = "telc", nullable = false)
	public int getTelc() {
		return telc;
	}
	public void setTelc(int telc) {
		this.telc = telc;
	}
	@Column(name = "nomapp", nullable = false)
	public String getNomapp() {
		return nomapp;
	}
	public void setNomapp(String nomapp) {
		this.nomapp = nomapp;
	}
	@Column(name = "modelapp", nullable = false)
	public String getModelapp() {
		return modelapp;
	}
	public void setModelapp(String modelapp) {
		this.modelapp = modelapp;
	}
	@Column(name = "panne", nullable = false)
	public String getPanne() {
		return panne;
	}
	public void setPanne(String panne) {
		this.panne = panne;
	}
	@Column(name = "dateE", nullable = false)
	public Date getDateE() {
		return dateE;
	}
	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}
	@Column(name = "dateS", nullable = false)
	public Date getDateS() {
		return dateS;
	}
	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}
	@Column(name = "user", nullable = false)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Column(name = "tech", nullable = false)
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "maintenance [id=" + id + ", Nomc=" + Nomc + ", prec=" + prec + ", telc=" + telc + ", nomapp=" + nomapp
				+ ", modelapp=" + modelapp + ", panne=" + panne + ", dateE=" + dateE + ", dateS=" + dateS + ", user="
				+ user + ", tech=" + tech + "]";
	}

}
