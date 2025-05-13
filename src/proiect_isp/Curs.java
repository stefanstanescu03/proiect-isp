package proiect_isp;

import java.util.List;

public class Curs {
	private String denumire;
	private int an;
	
	private List<Material> materiale;
	private List<Student> studenti;

	public Curs(String denumire, int an, List<Material> materiale) {
		super();
		this.denumire = denumire;
		this.an = an;
		this.materiale = materiale;
		this.materiale = null;
	}
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getAn() {
		return an;
	}

	public void setAn(int an) {
		this.an = an;
	}

	public List<Material> getMateriale() {
		return materiale;
	}

	public void setMateriale(List<Material> materiale) {
		this.materiale = materiale;
	}
	
	
	
}
