package io.mwguy.manga.controllers;

import io.mwguy.manga.repository.ChapterRepository;
import io.mwguy.manga.repository.MangaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final ChapterRepository chapterRepository;
    private final MangaRepository mangaRepository;

    public IndexController(ChapterRepository chapterRepository, MangaRepository mangaRepository) {
        this.chapterRepository = chapterRepository;
        this.mangaRepository = mangaRepository;
    }

    @GetMapping("/")
    public String mangaPage(Model model) {
        model.addAttribute("latestManga", mangaRepository.findAll(Pageable.ofSize(20)).getContent());
        model.addAttribute("latestChapters", chapterRepository.findAll(PageRequest.of(0, 20).withSort(Sort.by(Sort.Direction.DESC, "createdAt"))).getContent());
        return "index";
    }
}
