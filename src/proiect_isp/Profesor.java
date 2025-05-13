package proiect_isp;

import java.util.List;


public class Profesor extends Cont{
	private List<Curs> cursuriPredate;
	private List<Material> materialeIncarcate;

	public Profesor(String parola, String nume, String prenume, String email, String telefon) {
		super(parola, nume, prenume, email, telefon);
		this.cursuriPredate = new List<Curs>;
		this.materialeIncarcate = new List<Material>;
	}

	public List<Curs> getCurrsuriPredate() {
		return cursuriPredate;
	}
	
	public void adaugareCursPredat(Curs curs) {
		cursuriPredate.add(curs);
	}

	public void setCurrsuriPredate(List<Curs> cursuriPredate) {
		this.cursuriPredate = cursuriPredate;
	}
	
	public void inregistrareMaterial(Material material) {
		this.materialeIncarcate.add(material);
	}
	
	public void inregistrareNota(Nota nota, Student denotat) {
		Curs cursdenotat = nota.getCurs();
		for (Curs curs : cursuriPredate) {
			if(curs.getDenumire()==cursdenotat.getDenumire()) {
				for (Student student : curs.getStudenti())
					if(student.getEmail()==denotat.getEmail()) {
						student.adaugareNota(nota);
					}
					else {
						System.out.println("Acest student nu este inrolat la acest curs!");
					}
			}
			else {
				System.out.println("Acest profesor nu preda acest curs!");
			}
				
		}
	}
	
}
