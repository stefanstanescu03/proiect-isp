package proiect_isp;

import java.util.List;

public class Administrator extends Cont{

	public Administrator(String parola, String nume, String prenume, String email, String telefon) {
		super(parola, nume, prenume, email, telefon);
	}
	
	public void inregistrareStudent(Student student, List<Student> studenti) {
		studenti.add(student);
	}
	
	public void inregistrareProfesor(Profesor profesor, List<Profesor> profesori) {
		profesori.add(profesor);
	}

	public void inregistrareCurs(Curs curs, List<Profesor> profesori, List<Curs> cursuri) {
		curs.setProfesori(profesori);
		for (Profesor profesor : profesori) {
			profesor.adaugareCursPredat(curs);
		}
		cursuri.add(curs);
	}
	
	
	public void inrolareStudenti(List<Student> studenti, Curs curs) {
		curs.setStudenti(studenti);
		for (Student student : studenti) {
			student.inrolareCurs(curs);
		}
	}
}
