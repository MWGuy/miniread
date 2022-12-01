package io.mwguy.manga.controllers;

import io.mwguy.manga.repository.MangaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manga")
public class MangaController {
    private final MangaRepository mangaRepository;

    public MangaController(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @GetMapping("/{slug}")
    public String mangaPage(@PathVariable String slug, Model model) {
        var manga = mangaRepository.findBySlugIgnoreCase(slug);
        if (manga.isEmpty()) {
            return "404";
        }

        model.addAttribute("manga", manga.get());
        return "manga";
    }
}
