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

	public boolean inregistrareCurs(Curs curs, List<Profesor> profesori, List<Curs> cursuri) {
		for (Curs cursExistent : cursuri) {
			if (cursExistent.getDenumire().equals(curs.getDenumire())) {
				return false;
			}
		}
		
		curs.setProfesori(profesori);
		for (Profesor profesor : profesori) {
			if (!profesor.isTeaching(curs)) {
				profesor.adaugareCursPredat(curs);
			}
		}
		
		cursuri.add(curs);
		
		return true;
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
