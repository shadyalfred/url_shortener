package org.demos.url_shortener.controllers;

import org.apache.commons.validator.routines.UrlValidator;
import org.demos.url_shortener.models.Url;
import org.demos.url_shortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("url", new Url());
        return "index";
    }
    
    @PostMapping("/")
    public String storeNewUrl(@ModelAttribute Url url, Model model) {
        var urlCheck = urlService.findByValue(url.getValue());

        if (urlCheck.isPresent()) {
            url.setKey(urlCheck.get().getKey());
            model.addAttribute("newUrl", url);
            return "index";
        }

        UrlValidator urlValidator = new UrlValidator();
        if (! urlValidator.isValid(url.getValue())) {
            model.addAttribute("urlIsNotValid", true);
            return "index";
        };

        url = urlService.save(url);

        model.addAttribute("newUrl", url);
        return "index";
    }
}
