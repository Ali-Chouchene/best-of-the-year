package org.java.bestofyear.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.java.classes.Movie;
import org.java.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BestOfController {

	@GetMapping("{nome}")
	public String name(Model model, @PathVariable("nome") String nome) {
		model.addAttribute("name", nome);
		return "index";
	}

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("1", " Principe cerca moglie"));
		movies.add(new Movie("2", "Batman"));
		return movies;
	}

	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		songs.add(new Song("1", "Save your tears"));
		songs.add(new Song("2", "In the end"));
		return songs;
	}

	@GetMapping("movies")
	public String movies(Model model) {
		String lista = "";
		for (Movie val : getBestMovies()) {
			String titolo = val.getTitolo();
			String id = val.getId();
			lista += (id + " " + titolo + "\n");
		}
		model.addAttribute("tipo", "Film");
		model.addAttribute("lista", lista);
		return "index";

	}

	@GetMapping("songs")
	public String songs(Model model) {
		Date d = new Date();
		int year = d.getYear();
		int current_Year = year + 1900;
		String lista = "";
		for (Song val : getBestSongs()) {
			String titolo = val.getTitolo();
			String id = val.getId();
			lista += (id + " " + titolo + ", ");
		}

		model.addAttribute("year", current_Year);
		model.addAttribute("tipo", "Canzoni");
		model.addAttribute("lista", lista);
		return "index";

	}

	@GetMapping("songs/{id}")
	public String songsId(Model model, @PathVariable("id") String id) {
		String titolo = "";

		for (Song val : getBestSongs()) {
			if (val.getId() == id) {
				titolo += val.getTitolo();
			}
		}
		model.addAttribute("titolo", titolo);
		return "single";

	}
}
