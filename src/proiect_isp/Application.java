package proiect_isp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		Date data = new Date();
		Profesor profesor = new Profesor("123", "Mocanu", "Stefan", "sm@gmail.com", "07n-amcartela");
		Curs curs = new Curs("Metode Numerice", 2);
		Curs curs1 = new Curs("TAIS", 2);
		Student student = new Student("1234", "Berianu", "Leonard", "sigma@gmail.com", "07amcartela", 3);
		Administrator admin = new Administrator("123", "Mocanu", "Stefan", "sm@gmail.com", "07n-amcartela");
		Nota nota = new Nota(curs1, data, 7);
		List<Student> studenti = new ArrayList<Student>();
		studenti.add(student);
		
		
		profesor.adaugareCursPredat(curs);
		profesor.adaugareCursPredat(curs1);
		admin.inrolareStudenti(studenti, curs1);
		profesor.inregistrareNota(nota, student);
		
		
		
		profesor.afisare();
		student.afisare();
		student.afisareNote();
	}

}
