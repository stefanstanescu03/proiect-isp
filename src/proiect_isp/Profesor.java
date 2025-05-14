package proiect_isp;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Cont{
	private List<Curs> cursuriPredate;
	private List<Material> materialeIncarcate;

	public Profesor(String parola, String nume, String prenume, String email, String telefon) {
		super(parola, nume, prenume, email, telefon);
		this.cursuriPredate = new ArrayList<Curs>();
		this.materialeIncarcate = new ArrayList<Material>();
	}

	public List<Curs> getCursuriPredate() {
		return cursuriPredate;
	}
	
	public void adaugareCursPredat(Curs curs) {
		cursuriPredate.add(curs);
	}

	public void setCursuriPredate(List<Curs> cursuriPredate) {
		this.cursuriPredate = cursuriPredate;
	}
	
	public void inregistrareMaterial(Material material) {
		material.setProfesor(this);
		material.getCurs().adaugareMaterial(material);
		this.materialeIncarcate.add(material);
	}
	
	public List<Material> getMaterialeIncarcate() {
		return materialeIncarcate;
	}

	public void setMaterialeIncarcate(List<Material> materialeIncarcate) {
		this.materialeIncarcate = materialeIncarcate;
	}

	public boolean inregistrareNota(Nota nota, Student denotat) {
		Curs cursdenotat = nota.getCurs();

		if (this.cursuriPredate.indexOf(cursdenotat) == -1 || denotat.getCursuri().indexOf(cursdenotat) == -1) {
			return false;
		}
		denotat.adaugareNota(nota);
		return true;
	}
	
	public void afisare() {
		super.afisare();
		for(Curs curs : cursuriPredate) {
			System.out.println("Denumire: " + curs.getDenumire() );
			System.out.println("An: " + curs.getAn() );
		}
	}
	
	public boolean isTeaching(Curs curs) {
		if (this.cursuriPredate.indexOf(curs) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
