package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import proiect_isp.Administrator;
import proiect_isp.Curs;
import proiect_isp.Material;
import proiect_isp.Nota;
import proiect_isp.Profesor;
import proiect_isp.Student;

class TestCautareMateriale {

	@Test
	void testCautaMateriale() {
		
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
		admin.inregistrareStudent(new Student("1234", "Mierlan", "Cantemir", "catemir@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Chistoc", "Gabriel", "gabriel@gmail.com", "0736254398", 2), studenti);
		
		admin.inrolareStudenti(studenti, cursuri.get(0));
		
		profesori.get(0).inregistrareNota(new Nota(cursuri.get(0), new Date(), 3), studenti.get(1));
		profesori.get(0).inregistrareNota(new Nota(cursuri.get(0), new Date(), 6), studenti.get(2));
		profesori.get(0).inregistrareNota(new Nota(cursuri.get(0), new Date(), 10), studenti.get(3));
		
		// Verificare curs in desfasurare in prima jumatate a semestrului
		List<Material> materiale1 = studenti.get(0).cautaMateriale(cursuri.get(0), LocalDate.of(2024, 10, 12));
		
		List<Material> materialeCorecte1 = new ArrayList<Material>();
		materialeCorecte1.add(cursuri.get(0).getMateriale().get(0));
		
		assertTrue(materiale1.equals(materialeCorecte1));
		
		// Verificare curs in a doua jumatate a semestrului
		List<Material> materiale2 = studenti.get(0).cautaMateriale(cursuri.get(0), LocalDate.of(2025, 5, 14));
		
		List<Material> materialeCorecte2 = new ArrayList<Material>();
		materialeCorecte2.add(cursuri.get(0).getMateriale().get(1));
		materialeCorecte2.add(cursuri.get(0).getMateriale().get(2));
		
		assertTrue(materiale2.equals(materialeCorecte2));
		
		// Verificare curs terminat nota sub 5
		List<Material> materiale3 = studenti.get(1).cautaMateriale(cursuri.get(0), LocalDate.of(2025, 5, 14));		
		assertTrue(materiale3.equals(materialeCorecte1));
		
		// Verificare curs terminat nota intre 5 si 8
		List<Material> materiale4 = studenti.get(2).cautaMateriale(cursuri.get(0), LocalDate.of(2025, 5, 14));		
		assertTrue(materiale4.equals(materialeCorecte2));
		
		// Verificare curs terminat nota intre 8 si 10
		List<Material> materiale5 = studenti.get(3).cautaMateriale(cursuri.get(0), LocalDate.of(2025, 5, 14));
		List<Material> materialeCorecte3 = new ArrayList<Material>();
		materialeCorecte3.add(cursuri.get(0).getMateriale().get(3));
		assertTrue(materiale5.equals(materialeCorecte3));
		
	}

}
