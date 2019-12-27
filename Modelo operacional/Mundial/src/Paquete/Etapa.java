package Paquete;

public class Etapa {
	public int id_etapa;
	public String descripcione;
	public Etapa(int et, String desc) {
		this.id_etapa = et;
		this.descripcione = desc;
	}
	
	public Etapa() {
		this.id_etapa = 0;
		this.descripcione = null;
	}

	public int getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(int id_etapa) {
		this.id_etapa = id_etapa;
	}

	public String getDescripcione() {
		return descripcione;
	}

	public void setDescripcione(String descripcione) {
		this.descripcione = descripcione;
	}
	
	
}
