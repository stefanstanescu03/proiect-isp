package proiect_isp;

public class Material {
	private String denumire;
	private int dificultate;
	private Profesor profesor;
	private Curs curs;

	public Material(String denumire, int dificultate, Curs curs) {
		this.denumire = denumire;
		this.dificultate = dificultate;
		this.profesor = null;
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
	
	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public void afisare() {
		System.out.println("Denumire: " + denumire);
		System.out.println("Dificultate: " + dificultate);
		System.out.println("Profesor: " + profesor.getNume() + " " + profesor.getPrenume());
		System.out.println("Curs: " + curs.getDenumire());
	}
	
	
}
