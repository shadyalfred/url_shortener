package org.demos.url_shortener.repositories;

import java.util.Optional;

import org.demos.url_shortener.models.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
    public Optional<Url> findById(String id);
    public Optional<Url> findByKey(String key);
    public Optional<Url> findByValue(String value);
}
