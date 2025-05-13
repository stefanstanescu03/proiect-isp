package proiect_isp;

import java.util.ArrayList;
import java.util.List;

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
	
}
