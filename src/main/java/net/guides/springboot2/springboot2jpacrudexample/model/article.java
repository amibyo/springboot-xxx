package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class article {

	private long id;
	
	private String nom;
	private String desc;
	private int qte;
	private String cat;
	private double prixa;
	private double prixv;
	public article() {
		
	}
	
	public article(String desc,int qte, String cat,String nom, double prixa,double prixv) {
	
		this.desc= desc;
		this.qte= qte;
		this.cat = cat;
		this.nom = nom;
		this.prixa = prixa;
		this.prixv = prixv;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	@Column(name = "nom", nullable = false)
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	
	
	
	
	@Column(name = "descs", nullable = false)
	public String getdesc() {
		return desc;
	}
	public void setdesc(String desc) {
		this.desc = desc;
	}
	
	
	
	@Column(name = "qte", nullable = false)
	public int getqte() {
		return qte;
	}
	public void setqte(int qte) {
		this.qte = qte;
	}
	
	
	
	
	@Column(name = "cat", nullable = false)
	public String getcat() {
		return cat;
	}
	public void setcat(String cat) {
		this.cat = cat;
	}
	@Column(name = "prixa", nullable = false)
	public double getprixa() {
		return prixa;
	}
	public void setprixa(double prixa) {
		this.prixa = prixa;
	}
	@Column(name = "prixv", nullable = false)
	public double getprixv() {
		return prixv;
	}
	public void setprixv(double prixv) {
		this.prixv = prixv;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id +", nom=" + nom + ", desc=" + desc + ", qte=" + qte
				+", cat=" + cat + ", prixa=" + prixa+", prixv=" + prixv +"]";
	}
	
}
