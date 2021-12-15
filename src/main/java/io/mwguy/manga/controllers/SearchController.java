package io.mwguy.manga.controllers;

import io.mwguy.manga.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        if (query == null || query.isBlank()) {
            return "redirect:/";
        }

        model.addAttribute("searchQuery", query);
        model.addAttribute("result", searchService.search(query, 20));
        return "search";
    }
}
