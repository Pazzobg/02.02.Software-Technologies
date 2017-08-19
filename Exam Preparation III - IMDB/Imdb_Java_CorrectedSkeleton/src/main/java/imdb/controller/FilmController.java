package imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import imdb.bindingModel.FilmBindingModel;
import imdb.entity.Film;
import imdb.repository.FilmRepository;

import java.util.List;

@Controller
public class FilmController {
	private final FilmRepository filmRepository;

	@Autowired
	public FilmController(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Film> films = filmRepository.findAll();

		model.addAttribute("films", films);
		model.addAttribute("view", "film/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "film/create");
		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, FilmBindingModel filmBindMod) {

		if (filmBindMod.getName().equals("") ||
				filmBindMod.getGenre().equals("") ||
				filmBindMod.getDirector().equals("") ||
				filmBindMod.getYear() == 0) {
			return "redirect:/";
		}

		Film film = new Film(filmBindMod.getName(),
				filmBindMod.getGenre(),
				filmBindMod.getDirector(),
				filmBindMod.getYear());

		filmRepository.saveAndFlush(film);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		if (!this.filmRepository.exists(id)) {
			return "redirect:/";
		}

		Film filmForEdit = this.filmRepository.findOne(id);

		model.addAttribute("film", filmForEdit);
		model.addAttribute("view", "film/edit");

		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(Model model, @PathVariable int id, FilmBindingModel filmBindMod) {
		if (!this.filmRepository.exists(id) ||
				filmBindMod.getName().equals("") ||
				filmBindMod.getGenre().equals("") ||
				filmBindMod.getDirector().equals("") ||
				filmBindMod.getYear() == 0) {
			return "redirect:/";
		}

		Film filmForEdit = this.filmRepository.findOne(id);

		filmForEdit.setName(filmBindMod.getName());
		filmForEdit.setGenre(filmBindMod.getGenre());
		filmForEdit.setDirector(filmBindMod.getDirector());
		filmForEdit.setYear(filmBindMod.getYear());

		this.filmRepository.saveAndFlush(filmForEdit);

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		if (!this.filmRepository.exists(id)) {
			return "redirect:/";
		}

		Film filmToDelete = this.filmRepository.findOne(id);

		model.addAttribute("film", filmToDelete);
		model.addAttribute("view", "film/delete");

		return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {
		if (!this.filmRepository.exists(id)) {
			return "redirect:/";
		}

		Film filmToDelete = this.filmRepository.findOne(id);

		this.filmRepository.delete(filmToDelete);

		return "redirect:/";
	}
}
