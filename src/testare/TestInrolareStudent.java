package testare;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import proiect_isp.Administrator;
import proiect_isp.Curs;
import proiect_isp.Profesor;
import proiect_isp.Student;

class TestInrolareStudent {
	
	@Test
	void testInrolareStudent() {
		
		List<Profesor> profesori = new ArrayList<Profesor>();
		List<Student> studenti = new ArrayList<Student>(); 
		List<Curs> cursuri = new ArrayList<Curs>();
		
		Administrator admin = new Administrator("1234", "Ionescu", "Alex", "alex@gmail.com", "112");
		admin.inregistrareProfesor(new Profesor("1234", "Popescu", "Ion", "ion@gmail.com", "0736253472"), profesori);
		admin.inregistrareCurs(new Curs("PCLP", 1), profesori, cursuri);
		admin.inregistrareCurs(new Curs("MN", 2), profesori, cursuri);
		admin.inregistrareCurs(new Curs("PA", 2), profesori, cursuri);
		admin.inregistrareCurs(new Curs("PCLP", 2), profesori, cursuri);
		
		admin.inregistrareStudent(new Student("1234", "Oancea", "Vasile", "vasi@gmail.com", "0736254398", 1), studenti);
		admin.inregistrareStudent(new Student("1234", "Dobrin", "Matei", "matei@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Mierlan", "Cantemir", "catemir@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Chistoc", "Gabriel", "gabriel@gmail.com", "0736254398", 2), studenti);
		
		//Test inrolare un singur student la un curs
		List<Student> studentsolo = new ArrayList<Student>();
		studentsolo.add(studenti.get(0));
		admin.inrolareStudenti(studentsolo, cursuri.get(0));
		for (int i = 0; i<studentsolo.size(); i++) {
			assertTrue(studentsolo.get(i).isInrolat(cursuri.get(0)));
			assertTrue(cursuri.get(0).isInrolat(studentsolo.get(i)));
		}
		
		//Test inrolare mai multi studenti la un curs
		List<Student> studentplus = new ArrayList<Student>();
		studentplus.add(studenti.get(1));
		studentplus.add(studenti.get(2));
		studentplus.add(studenti.get(3));
		admin.inrolareStudenti(studentplus, cursuri.get(2));
		for (int i = 0; i<studentplus.size(); i++) {
			assertTrue(studentplus.get(i).isInrolat(cursuri.get(2)));
			assertTrue(cursuri.get(2).isInrolat(studentplus.get(i)));
		}
		
		//Test reinrolare studenti in acelasi curs
		List<Student> studentplus2 = new ArrayList<Student>();
		studentplus2.add(studenti.get(1));
		studentplus2.add(studenti.get(2));
		studentplus2.add(studenti.get(3));
		admin.inrolareStudenti(studentplus2, cursuri.get(2));
		for (int i = 0; i<studentplus2.size(); i++) {
			assertTrue(studentplus2.get(i).isInrolat(cursuri.get(2)));
			assertTrue(cursuri.get(2).isInrolat(studentplus2.get(i)));
		}
		
		//Test daca studentii nu sunt automat inrolat la cursuri atunci cand sunt inregistrati
		admin.inregistrareStudent(new Student("1234", "Cristache", "Gabriela", "cg@gmail.com", "0736254398", 1), studenti);
		admin.inregistrareStudent(new Student("1234", "Georgescu", "Calin", "gc@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Telemac", "Itzli", "ti@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Eminescu", "Mihai", "em@gmail.com", "0736254398", 3), studenti);
		List<Student> studentplus3 = new ArrayList<Student>();
		studentplus3.add(studenti.get(4));
		studentplus3.add(studenti.get(5));
		studentplus3.add(studenti.get(6));
		for (int i = 0; i<studentplus3.size(); i++) {
			assertFalse(studentplus3.get(i).isInrolat(cursuri.get(1)));
			assertFalse(cursuri.get(1).isInrolat(studentplus3.get(i)));
		}
		
	}
}
