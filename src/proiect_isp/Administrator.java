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
	
//	public void stergereStudent(Student student, List<Student> studenti) {
//		studenti.remove(student);
//	}
	
//	public void stergereProfesor(Profesor profesor, List<Profesor> profesori) {
//		profesori.remove(profesor);
//	}
	
	public void inregistrareCurs(Curs curs, List<Profesor> profesori, List<Curs> cursuri) {
		curs.setProfesori(profesori);
		for (Profesor profesor : profesori) {
			profesor.adaugareCursPredat(curs);
		}
		cursuri.add(curs);
	}
	
//	public void stergereCurs(Curs curs, List<Curs> cursuri) {
//		cursuri.remove(curs);
//	}
	
//	public void modificareCurs(Curs cursModificat, int index, List<Curs> cursuri) {
//		cursuri.set(index, cursModificat);
//	}
	
	public void inrolareStudenti(List<Student> studenti, Curs curs) {
		curs.setStudenti(studenti);
		for (Student student : studenti) {
			student.inrolareCurs(curs);
		}
	}
}
