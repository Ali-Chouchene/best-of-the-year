package org.java.classes;

public class Song {
	public String id;
	public String titolo;
	public String img;

	public Song(String id, String titolo, String img) {
		setId(id);
		setTitolo(titolo);
		setImg(img);
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
