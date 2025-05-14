package proiect_isp;

import java.util.List;

public class Administrator extends Cont{

	public Administrator(String parola, String nume, String prenume, String email, String telefon) {
		super(parola, nume, prenume, email, telefon);
	}
	
	public void inregistrareStudent(Student student, List<Student> studenti) {
		boolean check = true;
		for(Student stud : studenti) {
			if(stud.getEmail()==student.getEmail()) {
				System.out.println("Acest student deja exista");
				check = false;
				break;
			}
		}
		if(check) {
			studenti.add(student);
		}
	}
	
	public void inregistrareProfesor(Profesor profesor, List<Profesor> profesori) {
		boolean check = true;
		for(Profesor prof : profesori) {
			if(prof.getEmail()==profesor.getEmail()) {
				System.out.println("Acest profesor deja exista");
				check = false;
				break;
			}
		}
		if(check) {
			profesori.add(profesor);
		}
	}

	
//	public void stergereStudent(Student student, List<Student> studenti) {
//		studenti.remove(student);
//	}
	
//	public void stergereProfesor(Profesor profesor, List<Profesor> profesori) {
//		profesori.remove(profesor);
//	}
	
	public void inregistrareCurs(Curs curs, List<Profesor> profesori, List<Curs> cursuri) {
		boolean check = true;
		for(Curs cr : cursuri) {
			if(cr.getDenumire()==curs.getDenumire()) {
				System.out.println("Acest curs deja exista");
				check = false;
				break;
			}
		}
		if(check) {
			curs.setProfesori(profesori);
			for (Profesor profesor : profesori) {
				if(profesor.isTeaching(curs)) {
					profesor.adaugareCursPredat(curs);
				}
			}
			cursuri.add(curs);
		}
	}
	
	
	public void inrolareStudenti(List<Student> studenti, Curs curs) {
		curs.setStudenti(studenti);
		for (Student student : studenti) {
			if(!student.isInrolat(curs)) {
				student.inrolareCurs(curs);
			}
		}
	}
}
