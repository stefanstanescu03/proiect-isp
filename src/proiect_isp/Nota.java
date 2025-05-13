package proiect_isp;

import java.util.Date;

public class Nota {
	private Curs curs;
	private Date data;
	private int valoare;

	public Nota(Curs curs, Date data, int valoare) {
		super();
		this.curs = curs;
		this.data = data;
		this.valoare = valoare;
	}

	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getValoare() {
		return valoare;
	}

	public void setValoare(int valoare) {
		this.valoare = valoare;
	}
	
	public void afisare() {
		System.out.println("Curs: " + curs);
		System.out.println("Data: " + data);
		System.out.println("Nota: " + valoare);
	}
	
}
