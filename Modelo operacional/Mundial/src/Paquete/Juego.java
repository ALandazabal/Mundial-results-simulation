package Paquete;

public class Juego {
	public int etapa;
	public String id_eq1;
	public String id_eq2;
	public int goles_eq1;
	public int goles_eq2;
	
	
	public Juego (int et, String ideq1, String ideq2, int goleq1, int goleq2) {
		this.etapa = et;
		this.id_eq1 = ideq1;
		this.id_eq2 = ideq2;
		this.goles_eq1 = goleq1;
		this.goles_eq2 = goleq2;
		
	}
	
	public Juego () {
		this.etapa = 0;
		this.id_eq1 = null;
		this.id_eq2 = null;
		this.goles_eq1 = 0;
		this.goles_eq2 = 0;
		
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}

	public String getId_eq1() {
		return id_eq1;
	}

	public void setId_eq1(String id_eq1) {
		this.id_eq1 = id_eq1;
	}

	public String getId_eq2() {
		return id_eq2;
	}

	public void setId_eq2(String id_eq2) {
		this.id_eq2 = id_eq2;
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
