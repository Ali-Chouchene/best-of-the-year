package org.java.classes;

public class Movie {
	public String id;
	public String titolo;

	public Movie(String id, String titolo) {
		setId(id);
		setTitolo(titolo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
