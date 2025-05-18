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

	public void adaugareMaterial(Material material) {
		materiale.add(material);
	}
	
	public void setMateriale(List<Material> materiale) {
		this.materiale = materiale;
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public void afisare() {
		System.out.println("=========================== " );
		System.out.println("Cursuri" );
		System.out.println("Denumire: " + denumire);
		System.out.println("An: " + an);
		if(profesori.size() != 0 ) {
			System.out.println();
			System.out.println("Profesori" );
			for(Profesor profesor : profesori) {
				System.out.println("Profesor: " + profesor.getNume() + "  " + profesor.getPrenume());
			}
		}
		System.out.println("=========================== " );	
		
	}
	
	public void afisareStudenti() {
		System.out.println("Studenti:" );
		for (Student student : studenti) {
			System.out.println(student.getNume() + " " + student.getPrenume());
		}
		System.out.println("=========================== " );
}

	public boolean isInrolat(Student student) {
		if (this.studenti.indexOf(student) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean areProfesor(Profesor profesor) {
		if (this.profesori.indexOf(profesor) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean esteIncarcat(Material material) {
		if (this.materiale.indexOf(material) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
