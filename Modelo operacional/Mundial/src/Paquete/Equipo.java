package Paquete;

public class Equipo {
	public String nombre;
	public String grupo;
	public boolean activo;
	public int ranking;
	public int partidos_t;
	public int partidos_g;
	public int partidos_e;
	public int puntajes_eq;
	public int dif_goles;
	
	public Equipo (String nom, String gr, boolean act, int rank, int t, int g, int e, int eq) {
		this.nombre = nom;
		this.grupo = gr;
		this.activo = act;
		this.ranking = rank;
		this.partidos_t = t;
		this.partidos_g = g;
		this.partidos_e = e;
		this.puntajes_eq = eq;
		this.puntajes_eq = 0;
	}
	
	public Equipo () {
		this.nombre = null;
		this.activo = false;
		this.ranking = 0;
		this.partidos_t = 0;
		this.partidos_g = 0;
		this.partidos_e = 0;
		this.puntajes_eq = 0;
		this.dif_goles = 0;
	}

	public int getPuntajes_eq() {
		return puntajes_eq;
	}

	public void setPuntajes_eq(int puntajes_eq) {
		this.puntajes_eq = puntajes_eq;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPartidos_t() {
		return partidos_t;
	}

	public void setPartidos_t(int partidos_t) {
		this.partidos_t = partidos_t;
	}

	public int getPartidos_g() {
		return partidos_g;
	}

	public void setPartidos_g(int partidos_g) {
		this.partidos_g = partidos_g;
	}

	public int getPartidos_e() {
		return partidos_e;
	}

	public void setPartidos_e(int partidos_e) {
		this.partidos_e = partidos_e;
	}

	public int getDif_goles() {
		return dif_goles;
	}

	public void setDif_goles(int dif_goles) {
		this.dif_goles = dif_goles;
	}
	
	
}
