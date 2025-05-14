package proiect_isp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

	public static void main(String[] args) {
//		Date data = new Date();
//		Profesor profesor = new Profesor("123", "Mocanu", "Stefan", "sm@gmail.com", "07n-amcartela");
//		Curs curs = new Curs("Metode Numerice", 2);
//		Curs curs1 = new Curs("TAIS", 2);
//		Student student = new Student("1234", "Berianu", "Leonard", "sigma@gmail.com", "07amcartela", 3);
//		Administrator admin = new Administrator("123", "Mocanu", "Stefan", "sm@gmail.com", "07n-amcartela");
//		Nota nota = new Nota(curs1, data, 7);
//		List<Student> studenti = new ArrayList<Student>();
//		studenti.add(student);
//		
//		profesor.adaugareCursPredat(curs);
//		profesor.adaugareCursPredat(curs1);
//		admin.inrolareStudenti(studenti, curs1);
//		profesor.inregistrareNota(nota, student);
//		
//		
//		
//		profesor.afisare();
//		student.afisare();
//		student.afisareNote();
		
		List<Profesor> profesori = new ArrayList<Profesor>();
		List<Student> studenti = new ArrayList<Student>(); 
		List<Curs> cursuri = new ArrayList<Curs>();
		
		Administrator admin = new Administrator("1234", "Ionescu", "Alex", "alex@gmail.com", "112");
		admin.inregistrareProfesor(new Profesor("1234", "Popescu", "Ion", "ion@gmail.com", "0736253472"), profesori);
		admin.inregistrareCurs(new Curs("PCLP", 1), profesori, cursuri);
		
		profesori.get(0).inregistrareMaterial(new Material("Introducere in C++", 2, cursuri.get(0)));
		profesori.get(0).inregistrareMaterial(new Material("Introducere in arhitectura calculatoarelor", 6, cursuri.get(0)));
		profesori.get(0).inregistrareMaterial(new Material("Introducere in limbaje de asamblare", 7, cursuri.get(0)));
		profesori.get(0).inregistrareMaterial(new Material("Grafica avansata", 10, cursuri.get(0)));
		
		admin.inregistrareStudent(new Student("1234", "Oancea", "Vasile", "vasi@gmail.com", "0736254398", 1), studenti);
		admin.inregistrareStudent(new Student("1234", "Dobrin", "Matei", "matei@gmail.com", "0736254398", 2), studenti);
		
		admin.inrolareStudenti(studenti, cursuri.get(0));
		
		profesori.get(0).inregistrareNota(new Nota(cursuri.get(0), new Date(), 6), studenti.get(1));
		
		List<Material> materiale = studenti.get(0).cautaMateriale(cursuri.get(0), LocalDate.of(2024, 10, 12));
		for (Material material : materiale) {
			material.afisare();
		}
//		System.out.println(studenti.get(1).getNote().size());
		
	}

}
