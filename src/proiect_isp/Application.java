package proiect_isp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application {

	static List<Profesor> profesori;
	static List<Student> studenti;
	static List<Curs> cursuri;
	static Administrator admin;
	
	public static void main(String[] args) {
		
		profesori = new ArrayList<Profesor>();
		studenti = new ArrayList<Student>(); 
		cursuri = new ArrayList<Curs>();
		admin = new Administrator("1234", "Ionescu", "Vladone", "vlad@gmail.com", "0736254378");

	//	admin.inregistrareProfesor(new Profesor("1234", "Popescu", "Ion", "ion@gmail.com", "0736253472"), profesori);
	//	admin.inregistrareCurs(new Curs("PCLP", 1), profesori, cursuri);
		
	//	profesori.get(0).inregistrareMaterial(new Material("Introducere in C++", 2, cursuri.get(0)));
	//	profesori.get(0).inregistrareMaterial(new Material("Introducere in arhitectura calculatoarelor", 6, cursuri.get(0)));
		//profesori.get(0).inregistrareMaterial(new Material("Introducere in limbaje de asamblare", 7, cursuri.get(0)));
	//	profesori.get(0).inregistrareMaterial(new Material("Grafica avansata", 10, cursuri.get(0)));
		
	//	admin.inregistrareStudent(new Student("1234", "Oancea", "Vasile", "vasi@gmail.com", "0736254398", 1), studenti);
	//	admin.inregistrareStudent(new Student("1234", "Dobrin", "Matei", "matei@gmail.com", "0736254398", 2), studenti);

		admin.inregistrareProfesor(new Profesor("1234", "Popescu", "Ion", "ion@gmail.com", "0736253472"), profesori);
		admin.inregistrareStudent(new Student("1234", "Oancea", "Vasile", "vasi@gmail.com", "0736254398", 1), studenti);
		admin.inregistrareStudent(new Student("1234", "Dobrin", "Matei", "matei@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Mierlan", "Cantemir", "catemir@gmail.com", "0736254398", 2), studenti);
		admin.inregistrareStudent(new Student("1234", "Chistoc", "Gabriel", "gabriel@gmail.com", "0736254398", 2), studenti);

		

	//	admin.inrolareStudenti(studenti, cursuri.get(0));
		boolean exitLogare = false;
		boolean exitCont = true;
		boolean exit = false;

		

	//	profesori.get(0).inregistrareNota(new Nota(cursuri.get(0), new Date(), 6), studenti.get(1));

		Scanner scanner = new Scanner(System.in);

//		List<Material> materiale = studenti.get(0).cautaMateriale(cursuri.get(0), LocalDate.of(2024, 10, 12));
//		for (Material material : materiale) {
//			material.afisare();
//		}
//		System.out.println(studenti.get(1).getNote().size());

		Cont contCurent = null;
		
		System.out.println("Sistem inteligent de recomandare de materiale! xD");
		
		while(!exit) {
			// bucla de logare
			while (!exitLogare) {
					
					System.out.println("Optiuni: ");
					System.out.println("1: logare");
					System.out.println("2: iesire");
					
					int optiune = scanner.nextInt();
					scanner.nextLine(); // golire buffer
					
					switch (optiune) {
					case 1:
						contCurent = logare(scanner);
						if (contCurent == null) {
							System.out.println("Logare esuata");
						} else {
							exitLogare = true;
							exitCont = false;
							System.out.println("Logare reusita");
						}
						break;
					case 2:
						exit = true;
						exitLogare = true;
						break;
					default:
						System.out.println("Optiune invalida");
						break;
					}
			}
			
			if (!exitCont) {
				System.out.println("Bine ai revenit " + contCurent.getPrenume() + "!");
			}
			// bucla cont
			while (!exitCont) {
				if (contCurent instanceof Administrator) {
					System.out.println("Optiuni: ");
					System.out.println("1: vizualizare cont");
					System.out.println("2: inregistrare profesor");
					System.out.println("3: inregistrare student");
					System.out.println("4: inrolare studenti");
					System.out.println("5: creare curs");
					System.out.println("6: iesire cont");
					System.out.println("7: iesire aplicatie");
					
					int optiune = scanner.nextInt();
					scanner.nextLine(); 
					
					switch (optiune) {
					case 1:
						contCurent.afisare();
						break;
					case 2:
						inregistrareCont(scanner, 1);
						break;
					case 3:
						inregistrareCont(scanner, 2);
						break;
					case 4:
						inrolareStudenti(scanner);
						break;
					case 5:
						creareCurs(scanner);
						break;
					case 6:
						exitCont = true;
						exitLogare = false;
						break;
					case 7:
						exit = true;
						exitCont = true;
						break;
					default:
						System.out.println("Optiune invalida");
						break;
					}
				}
				if (contCurent instanceof Student) {
					System.out.println("Optiuni: ");
					System.out.println("1: vizualizare cont");
					System.out.println("2: vizualizare cursuri");
					System.out.println("3: vizualizare note");
					System.out.println("4: iesire cont");
					System.out.println("5: lasa-te de facultate");
					
					int optiune = scanner.nextInt();
					scanner.nextLine(); 
					
					switch (optiune) {
					case 1:
						contCurent.afisare();
						break;
					case 2:
						((Student) contCurent).afisareCursuri();
						break;
					case 3:
						((Student) contCurent).afisareNote();
						break;
					case 4:
						exitCont = true;
						exitLogare = false;
						break;
					case 5:
						exit = true;
						exitCont = true;
						break;
					default:
						System.out.println("Optiune invalida");
						break;
					}
				}
				if (contCurent instanceof Profesor) {
					System.out.println("Optiuni: ");
					System.out.println("1: vizualizare cont");
					System.out.println("2: vizualizare cursuri");
					System.out.println("3: vizualizare materiale");
					System.out.println("4: iesire cont");
					System.out.println("5: iesire aplicatie");
					
					int optiune = scanner.nextInt();
					scanner.nextLine(); 
					
					switch (optiune) {
					case 1:
						contCurent.afisare();
						break;
					case 2:
						((Profesor) contCurent).afisareCursuri();
						break;
					case 3:
						((Profesor) contCurent).afisareMateriale();
						break;
					case 4:
						exitCont = true;
						exitLogare = false;
						break;
					case 5:
						exit = true;
						exitCont = true;
						break;
					default:
						System.out.println("Optiune invalida");
						break;
					}
				}
			}
		}

		scanner.close();
	}
	
	public static Cont logare(Scanner scanner) {		
		System.out.print("email: ");
		String email = scanner.nextLine();
		System.out.print("parola: ");
		String parola = scanner.nextLine();
		
		if (admin.getEmail().equals(email) && admin.checkPassword(parola)) {
			return admin;
		}
			
		for (Student student : studenti) {
			if (student.getEmail().equals(email) && student.checkPassword(parola)) {
				return student;
			}
		}
			
		for (Profesor profesor : profesori) {
			if (profesor.getEmail().equals(email) && profesor.checkPassword(parola)) {
				return profesor;
			}
		}
		
		return null;
	}
	
	public static void inregistrareCont(Scanner scanner, int tip) {
		System.out.println("Introdu datele");
		System.out.print("nume: ");
		String nume = scanner.nextLine();
		System.out.print("prenume: ");
		String prenume = scanner.nextLine();
		System.out.print("telefon: ");
		String telefon = scanner.nextLine();
		System.out.print("email: ");
		String email = scanner.nextLine();
		System.out.print("parola: ");
		String parola = scanner.nextLine();
		
		if (tip == 1) {
			admin.inregistrareProfesor(new Profesor(parola, nume, prenume, email, telefon), profesori);
		} else {
			System.out.print("an: ");
			int an = scanner.nextInt();
			scanner.nextLine();
			admin.inregistrareStudent(new Student(parola, nume, prenume, email, telefon, an), studenti);
		}
		System.out.println("Inregistrarea a avut succes, in total avem " + (studenti.size() + profesori.size()) + " suflete");
	}
	
	public static void creareCurs(Scanner scanner) {
		
		System.out.println("Introdu datele:");
		System.out.print("Denumire curs: ");
		String denumire = scanner.nextLine();
		System.out.print("An curs: ");
		int an = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Cati profesori predau acest curs?");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		List<Profesor> profesoriSelectati = new ArrayList<Profesor>();
		
		System.out.println("Introdu email-urile lor:");
		while(num != 0) {
			System.out.println("Numarul de email-uri ramase: " + num);
			String email = scanner.nextLine();
			for (Profesor profesor : profesori) {
				if (profesor.getEmail().equals(email)) {
					profesoriSelectati.add(profesor);
					num--;
				}
			}
		}
		
		admin.inregistrareCurs(new Curs(denumire, an), profesoriSelectati, cursuri);
	}
	
	public static void inrolareStudenti(Scanner scanner) {
		System.out.println("Introdu datele:");
		System.out.println("Denumire curs: ");
		String denumire = scanner.nextLine();
		
		Curs cursSelectat = null;
		for (Curs curs : cursuri) {
			if (curs.getDenumire().equals(denumire)) {
				cursSelectat = curs;
				break;
			}
		}
		
		if (cursSelectat == null) {
			System.out.println("Curs invalid");
		} else {
			System.out.println("Cati studenti inrolezi?");
			int num = scanner.nextInt();
			scanner.nextLine();
			
			List<Student> studentiSelectati = new ArrayList<Student>();
			
			System.out.println("Introdu email-urile lor:");
			while(num != 0) {
				System.out.println("Numarul de email-uri ramase: " + num);
				String email = scanner.nextLine();
				for (Student student : studenti) {
					if (student.getEmail().equals(email)) {
						studentiSelectati.add(student);
						num--;
					}
				}
			}
			admin.inrolareStudenti(studentiSelectati, cursSelectat);
		}
	}
}
