package org.java.bestofyear.controller;

import java.util.ArrayList;
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

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("1", "Principe cerca moglie",
				"https://sm.ign.com/ign_it/screenshot/default/principe-cerca-moglie-1-1920x1080_vs9s.jpg"));
		movies.add(new Movie("2", "Batman",
				"https://www.tomshw.it/images/images/2020/07/batman-the-dark-knight-prime-1-studio-104371.jpg"));
		movies.add(new Movie("3", "Spiderman",
				"https://media-assets.wired.it/photos/61e9211bd998b4630d91475a/16:9/w_1280,c_limit/cover-spider-man-no-way-home.jpg"));
		movies.add(new Movie("4", "Il signore degli anelli", "https://static.posters.cz/image/hp/66431.jpg"));
		movies.add(new Movie("5", "Star wars",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Star_Wars_Logo.svg/1200px-Star_Wars_Logo.svg.png"));
		return movies;
	}

	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		songs.add(new Song("1", "Save your tears",
				"https://m.media-amazon.com/images/M/MV5BZGIxMTAwZjctNmFkMC00MWI3LTlhODItMDlkMjA0N2U1YjAzXkEyXkFqcGdeQXVyNDU1NDIzMzY@._V1_.jpg"));
		songs.add(new Song("2", "In the end", "https://i.ytimg.com/vi/eVTXPUF4Oz4/maxresdefault.jpg"));
		songs.add(new Song("3", "Titi me pregunto",
				"https://i1.sndcdn.com/artworks-7fc67veDdEbOU2Qz-tRkjOQ-t500x500.jpg"));
		songs.add(new Song("4", "Dakiti", "https://i1.sndcdn.com/artworks-uvIy6PYmNg7VHaCo-6mocBw-t500x500.jpg"));
		songs.add(new Song("5", "Too many nights", "https://i.ytimg.com/vi/NyTkaQHdySM/sddefault.jpg"));
		return songs;
	}

//	@GetMapping("movies")
//	public String movies(Model model) {
//		String lista = "";
//		for (Movie val : getBestMovies()) {
//			String titolo = val.getTitolo();
//			String id = val.getId();
//			lista += (id + " " + titolo + ", ");
//		}
//		lista = lista.substring(0, lista.length() - 2);
//		model.addAttribute("tipo", "Film");
//		model.addAttribute("lista", lista);
//		return "movies";
//
//	}

	@GetMapping("/movies")
	public String movies(Model model) {
		List<Movie> movies = getBestMovies();
		model.addAttribute("movies", movies);
		return "movies";

	}

	@GetMapping("/songs")
	public String songs(Model model) {
		List<Song> songs = getBestSongs();
		model.addAttribute("songs", songs);
		return "songs";

	}

//	@GetMapping("songs")
//	public String songs(Model model) {
//		Date d = new Date();
//		int year = d.getYear();
//		int current_Year = year + 1900;
//		String lista = "";
//		for (Song val : getBestSongs()) {
//			String titolo = val.getTitolo();
//			String id = val.getId();
//			lista += (id + " " + titolo + ", ");
//		}
//		lista = lista.substring(0, lista.length() - 2);
//		model.addAttribute("year", current_Year);
//		model.addAttribute("tipo", "Canzoni");
//		model.addAttribute("lista", lista);
//		return "index";
//
//	}

	@GetMapping("songs/{id}")
	public String songsId(Model model, @PathVariable("id") int id) {
		String idS = Integer.toString(id);

		for (Song val : getBestSongs()) {
			if (val.getId().equals(idS)) {
				model.addAttribute("val", val);
			}
		}

		return "single";

	}

	@GetMapping("movies/{id}")
	public String moviesId(Model model, @PathVariable("id") int id) {
		String idS = Integer.toString(id);

		for (Movie val : getBestMovies()) {
			if (val.getId().equals(idS)) {
				model.addAttribute("val", val);
			}
		}

		return "single";

	}
}
