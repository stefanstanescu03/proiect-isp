package proiect_isp;

public class Cont {
	private String username;
	private String parola;
	private String nume;
	private String prenume;
	private String email;
	private String telefon;

	public Cont(String username, String parola, String nume, String prenume, String email, String telefon) {
		super();
		this.username = username;
		this.parola = parola;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.telefon = telefon;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
}
