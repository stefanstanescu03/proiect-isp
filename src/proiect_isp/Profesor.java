package proiect_isp;

import java.util.List;

public class Profesor extends Cont{
	private List<Curs> currsuriPredate;

	public Profesor(String username, String parola, String nume, String prenume, String email, String telefon,
			List<Curs> currsuriPredate) {
		super(username, parola, nume, prenume, email, telefon);
		this.currsuriPredate = currsuriPredate;
	}

	public List<Curs> getCurrsuriPredate() {
		return currsuriPredate;
	}

	public void setCurrsuriPredate(List<Curs> currsuriPredate) {
		this.currsuriPredate = currsuriPredate;
	}
	
}
