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
		System.out.println("=========================== " );
		System.out.println("Profesor" );
		super.afisare();
	}
	
	public void afisareCursuri() {
		System.out.println("Cursurile lui " + this.getNume() + " " + this.getPrenume() + ":" );
		for(Curs curs : cursuriPredate) {
			System.out.println("Denumire: " + curs.getDenumire() );
			System.out.println("An: " + curs.getAn() );
		}
		System.out.println("=========================== " );
	}
	
	
	public void afisareMateriale() {
		System.out.println("Materialele incarcate de " + this.getNume() + " " + this.getPrenume() + ":" );
		for(Material material : materialeIncarcate) {
			System.out.println("Denumire: " + material.getDenumire() );
			System.out.println("Dificultate: " + material.getDificultate() );
			System.out.println("Curs: " + material.getCurs().getDenumire() );
		}
		System.out.println("=========================== " );
	}
	
	public boolean isTeaching(Curs curs) {
		if (this.cursuriPredate.indexOf(curs) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean esteIncarcat(Material material) {
		if (this.materialeIncarcate.indexOf(material) != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
