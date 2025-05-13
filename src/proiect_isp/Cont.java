package proiect_isp;

public class Cont {
	private String parola;
	private String nume;
	private String prenume;
	private String email;
	private String telefon;

	public Cont(String parola, String nume, String prenume, String email, String telefon) {
		this.parola = parola;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.telefon = telefon;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public boolean checkPassword(String parolaIntrodusa) {
		return parolaIntrodusa == this.parola;
	}
	
	public void afisare() {
		System.out.println("Nume: " + nume + " " + prenume);
		System.out.println("Email: " + email);
		System.out.println("Telefon: " + telefon);
	}
	
}
