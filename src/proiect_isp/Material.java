package proiect_isp;

public class Material {
	private String denumire;
	private int dificultate;
	private Profesor profesor;
	private Curs curs;

	public Material(String denumire, int dificultate, Profesor profesor,Curs curs) {
		super();
		this.denumire = denumire;
		this.dificultate = dificultate;
		this.profesor = profesor;
		this.curs = curs;
	}

	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public int getDificultate() {
		return dificultate;
	}
	public void setDificultate(int dificultate) {
		this.dificultate = dificultate;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
