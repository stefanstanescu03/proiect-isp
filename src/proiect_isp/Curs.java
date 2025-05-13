package proiect_isp;

import java.util.ArrayList;
import java.util.List;

public class Curs {
	private String denumire;
	private int an;
	
	private List<Profesor> profesori;
	private List<Material> materiale;
	private List<Student> studenti;

	public Curs(String denumire, int an) {
		super();
		this.denumire = denumire;
		this.an = an;
		this.materiale = new ArrayList<Material>();
		this.profesori = new ArrayList<Profesor>();
		this.studenti = new ArrayList<Student>();
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
	
	public void afisare() {
		System.out.println("Denumire: " + denumire);
		System.out.println("An: " + an);
		for(Profesor profesor : profesori) {
			System.out.println("Profesor: " + profesor.getNume() + profesor.getPrenume());
		}
		
	}
	
	
	
}
