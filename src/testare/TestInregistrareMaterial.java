package testare;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import proiect_isp.Administrator;
import proiect_isp.Curs;
import proiect_isp.Material;
import proiect_isp.Profesor;


class TestInregistrareMaterial {

	@Test
	void testInregistrareMaterial() {
		Administrator admin = new Administrator("1234", "Ionescu", "Alex", "alex@gmail.com", "112");
		List<Profesor> profesori = new ArrayList<Profesor>();
		List<Curs> cursuri = new ArrayList<Curs>();

		
		Profesor profesor1 = new Profesor("123", "Mocanu", "Stefan", "sm@gmail.com", "0721345811");
		Profesor profesor2 = new Profesor("456", "Pietraru", "Radu", "pr@gmail.com", "0743868512");
		Profesor profesor3 = new Profesor("789", "Stoican", "Florin", "fs@gmail.com", "0798123176");
		Profesor profesor4 = new Profesor("134", "Dumitrescu", "Bogdan", "bd@gmail.com", "0751341878");
		
		Curs curs1 = new Curs("AM", 3);
		Curs curs2 = new Curs("SMP", 3);
		Curs curs3 = new Curs("TAIS", 2);
		Curs curs4 = new Curs("MN", 2);
		
		//Inregistrare profesori
		admin.inregistrareProfesor(profesor1, profesori);
		admin.inregistrareProfesor(profesor2, profesori);
		admin.inregistrareProfesor(profesor3, profesori);
		admin.inregistrareProfesor(profesor4, profesori);
		
		
		//Inregistrare cursuri
		List<Profesor> profesoricurs1 = new ArrayList<Profesor>();
		admin.inregistrareProfesor(profesor1, profesoricurs1);
		admin.inregistrareProfesor(profesor2, profesoricurs1);
		
		List<Profesor> profesoricurs3 = new ArrayList<Profesor>();
		admin.inregistrareProfesor(profesor3, profesoricurs3);

		List<Profesor> profesoricurs4 = new ArrayList<Profesor>();
		admin.inregistrareProfesor(profesor1, profesoricurs4);
		admin.inregistrareProfesor(profesor2, profesoricurs4);
		admin.inregistrareProfesor(profesor3, profesoricurs4);
		admin.inregistrareProfesor(profesor4, profesoricurs4);
		
		
		admin.inregistrareCurs(curs1, profesoricurs1, cursuri);
		admin.inregistrareCurs(curs2, profesoricurs1, cursuri);
		admin.inregistrareCurs(curs3, profesoricurs3, cursuri);
		admin.inregistrareCurs(curs4, profesoricurs4, cursuri);
		
		
		Material material1 = new Material("Introducere in programare",3,curs1,profesor1);
		Material material2 = new Material("Mod de realizare termostat",10,curs2,profesor2);
		Material material3 = new Material("Transformata Fourier",5,curs3,profesor3);
		Material material4 = new Material("Formate audio",7,curs1,profesor2);
		Material material5 = new Material("Ortogonalizare",6,curs4,profesor4);
		Material material6 = new Material("Algoritm QR",8,curs4,profesor2);
		Material material7 = new Material("Introducere in Matlab",2,curs4,profesor2);
		Material material8 = new Material("Matrici triunghiulare",3,curs4,profesor2);
		
		
		//Testare inregistrare material intr-un curs
		profesor1.inregistrareMaterial(material1);
		assertTrue(material1.esteIncarcatdeProfesor());
		assertTrue(material1.esteIncarcatlaCurs());
		
		//Testare neinregistrare material intr-un curs
		assertFalse(material2.esteIncarcatdeProfesor());
		assertFalse(material2.esteIncarcatlaCurs());
		
		
		//Testare inregistrare mai multe materiale intr-un curs
		profesor2.inregistrareMaterial(material6);
		profesor2.inregistrareMaterial(material7);
		profesor2.inregistrareMaterial(material8);
		
		assertTrue(material6.esteIncarcatdeProfesor());
		assertTrue(material6.esteIncarcatlaCurs());
		
		assertTrue(material7.esteIncarcatdeProfesor());
		assertTrue(material7.esteIncarcatlaCurs());
		
		assertTrue(material8.esteIncarcatdeProfesor());
		assertTrue(material8.esteIncarcatlaCurs());
		
		assertFalse(material3.esteIncarcatdeProfesor());
		assertFalse(material3.esteIncarcatlaCurs());
		
		//Testare inregistrare material deja existent in curs
		profesor1.inregistrareMaterial(material1);
		assertTrue(material1.esteIncarcatdeProfesor());
		assertTrue(material1.esteIncarcatlaCurs());
		
	}

}
