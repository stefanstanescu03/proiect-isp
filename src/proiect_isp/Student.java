package proiect_isp;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Student extends Cont{
	private int anUniversitar;
	private List<Curs> cursuri;
	private List<Nota> note;
	
	public Student(String parola, String nume, String prenume, 
			String email, String telefon, int anUniversitar) {
		super(parola, nume, prenume, email, telefon);
		this.anUniversitar = anUniversitar;
		this.cursuri = new ArrayList<Curs>();
		this.note = new ArrayList<Nota>();
	}

	public int getAnUniversitar() {
		return anUniversitar;
	}

	public void setAnUniversitar(int anUniversitar) {
		this.anUniversitar = anUniversitar;
	}

	public List<Curs> getCursuri() {
		return cursuri;
	}
	
	public void inrolareCurs(Curs curs) {
		cursuri.add(curs);
	}

	public void setCursuri(List<Curs> cursuri) {
		this.cursuri = cursuri;
	}

	public List<Nota> getNote() {
		return note;
	}
	
	public void adaugareNota(Nota nota) {
		note.add(nota);
	}

	public void setNote(List<Nota> note) {
		this.note = note;
	}
	
	public void afisare() {
		super.afisare();
		System.out.println("An: " + anUniversitar );
	}

	public void afisareNote() {
		for (Nota nota : note) {
			System.out.println(nota.getCurs().getDenumire() + "  " + nota.getValoare());
		}
	}

	public List<Material> cautaMateriale(Curs curs, LocalDate dataCurenta) {
		if (cursuri.indexOf(curs) == -1) {
			return null;
		}
		
		List<Material> materialeRecomandate = new ArrayList<Material>();
		
		if (anUniversitar == curs.getAn()) {
			 LocalDate jumatateSem1 = LocalDate.of(2024, 12, 20);
			 LocalDate inceputSem2 = LocalDate.of(2025, 2, 24);
			 LocalDate jumatateSem2 = LocalDate.of(2025, 4, 7);
		     
		     if (dataCurenta.isBefore(jumatateSem1) || (dataCurenta.isAfter(inceputSem2) && dataCurenta.isBefore(jumatateSem2))) {
		    	 for (Material material : curs.getMateriale()) {
					if (material.getDificultate() < 5) {
						materialeRecomandate.add(material);
					}
				}
		     } else {
		    	 for (Material material : curs.getMateriale()) {
					if (material.getDificultate() >= 5 && material.getDificultate() < 8) {
						materialeRecomandate.add(material);
					}
				}
		     }
		     
		} else {
			int notaObtinuta = -1;
			for (Nota nota : note) {
				if (nota.getCurs() == curs) {
					notaObtinuta = nota.getValoare();
					break;
				}
			}
			if (notaObtinuta < 5) {
				for (Material material : curs.getMateriale()) {
					if (material.getDificultate() < 5) {
						materialeRecomandate.add(material);
					}
				}
			} else {
				if (notaObtinuta >= 5 && notaObtinuta < 8) {
					for (Material material : curs.getMateriale()) {
						if (material.getDificultate() >= 5 && material.getDificultate() < 8) {
							materialeRecomandate.add(material);
						}
					}
				} else {
					for (Material material : curs.getMateriale()) {
						if (material.getDificultate() >= 8) {
							materialeRecomandate.add(material);
						}
					}
				}
			}
		}
		
		return materialeRecomandate;
	}
	
	public boolean isInrolat(Curs curs) {
		if (this.cursuri.indexOf(curs) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
