package proiect_isp;

import java.util.List;

public class Student extends Cont{
	private int anUniversitar;
	private List<Curs> cursuri;
	private List<Nota> note;
	
	public Student(String username, String parola, String nume, String prenume, 
			String email, String telefon, int anUniversitar, List<Curs> cursuri, List<Nota> note) {
		super(username, parola, nume, prenume, email, telefon);
		this.anUniversitar = anUniversitar;
		this.cursuri = cursuri;
		this.note = note;
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

	public void setCursuri(List<Curs> cursuri) {
		this.cursuri = cursuri;
	}

	public List<Nota> getNote() {
		return note;
	}

	public void setNote(List<Nota> note) {
		this.note = note;
	}
	
}
