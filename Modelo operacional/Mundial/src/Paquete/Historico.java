package Paquete;

public class Historico {
	public String TipoPartido;
	public String Fecha;
	public String nom_eq1;
	public String nom_eq2;
	public int goles_eq1;
	public int goles_eq2;
	public Historico(String tipo, String fecha, String ideq1, String ideq2, int goleq1, int goleq2) {
		this.TipoPartido = tipo;
		this.Fecha = fecha;
		this.nom_eq1 = ideq1;
		this.nom_eq2 = ideq2;
		this.goles_eq1 = goleq1;
		this.goles_eq2 = goleq2;
	}
	
	public Historico () {
		this.TipoPartido = null;
		this.Fecha = null;
		this.nom_eq1 = null;
		this.nom_eq2 = null;
		this.goles_eq1 = 0;
		this.goles_eq2 = 0;
	}

	public String getTipoPartido() {
		return TipoPartido;
	}

	public void setTipoPartido(String tipoPartido) {
		TipoPartido = tipoPartido;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getNom_eq1() {
		return nom_eq1;
	}

	public void setNom_eq1(String id_eq1) {
		this.nom_eq1 = id_eq1;
	}

	public String getNom_eq2() {
		return nom_eq2;
	}

	public void setNom_eq2(String id_eq2) {
		this.nom_eq2 = id_eq2;
	}

	public int getGoles_eq1() {
		return goles_eq1;
	}

	public void setGoles_eq1(int goles_eq1) {
		this.goles_eq1 = goles_eq1;
	}

	public int getGoles_eq2() {
		return goles_eq2;
	}

	public void setGoles_eq2(int goles_eq2) {
		this.goles_eq2 = goles_eq2;
	}
	
	
}
