package org.demos.url_shortener.services;

import java.util.Optional;

import org.demos.url_shortener.models.Url;
import org.demos.url_shortener.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public Url save(Url url) {
        while (url.getKey() == null || existsByKey(url.getKey())) {
            url.setKey(HashGenerator.getHash());
        }

        return urlRepository.save(url);
    }

    public Optional<Url> findByKey(String key) {
        return urlRepository.findByKey(key);
    }

    public Optional<Url> findByValue(String value) {
        return urlRepository.findByValue(value);
    }

    public boolean existsByKey(String key) {
        var url = urlRepository.findByKey(key);
        
        return url.isPresent();
    }
}
