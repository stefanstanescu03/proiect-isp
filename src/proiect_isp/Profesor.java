package proiect_isp;

import java.util.List;

public class Profesor extends Cont{
	private List<Curs> cursuriPredate;

	public Profesor(String parola, String nume, String prenume, String email, String telefon,) {
		super(parola, nume, prenume, email, telefon);
		cursuriPredate = new List<Curs>();
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
	
}
