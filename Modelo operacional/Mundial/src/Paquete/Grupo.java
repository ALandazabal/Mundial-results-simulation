package Paquete;

public class Grupo {
	public int id_grupo;
	public String descripciong;
	public Grupo(int idg, String desc){
		this.id_grupo = idg;
		this.descripciong = desc;
	}
	
	public Grupo(){
		this.id_grupo = 0;
		this.descripciong = null;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getDescripciong() {
		return descripciong;
	}

	public void setDescripciong(String descripciong) {
		this.descripciong = descripciong;
	}
	
}
