package org.demos.url_shortener.controllers;

import org.demos.url_shortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class UrlController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/{key}")
    public String url(@PathVariable String key, final Model model) {
        var url = urlService.findByKey(key);

        if (url.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return String.format("redirect:%s", url.get().getValue());
        }
    }
}
