package io.mwguy.manga.controllers;

import io.mwguy.manga.repository.ChapterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    private final ChapterRepository chapterRepository;

    public ChapterController(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @GetMapping("/{uuid}")
    public String chapterPage(Model model, @PathVariable UUID uuid) {
        var chapter = chapterRepository.findById(uuid);
        model.addAttribute("chapter", chapter.get());
        return "chapter";
    }
}
