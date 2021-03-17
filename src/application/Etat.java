package application;

public class Etat {
	private String c;
	private String p;

	public Etat(String courrant, String precedent) {
		this.c = courrant;
		this.p = precedent;
	}

	public String getCourrant() {
		return this.c;
	}

	public void setCourrant(String c) {
		this.c = c;
	}

	public String getPrecedent() {
		return this.p;
	}

	public void setPrecedent(String p) {
		this.p = p;
	}
}
