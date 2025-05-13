package proiect_isp;

import java.util.List;

public class Profesor extends Cont{
	private List<Curs> cursuriPredate;

	public Profesor(String parola, String nume, String prenume, String email, String telefon,
			List<Curs> cursuriPredate) {
		super(parola, nume, prenume, email, telefon);
		this.cursuriPredate = cursuriPredate;
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
