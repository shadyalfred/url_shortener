package org.demos.url_shortener.models;

import org.demos.url_shortener.services.HashGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document
public class Url {
    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String key;

    @NonNull
    private String value;

    public Url() {}

    public Url(String value) {
        this.value = value;
        this.key = HashGenerator.getHash();
    }

    public Url(String value, String key) {
        this.key = key;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Url [id=" + id + ", key=" + key + ", value=" + value + "]";
    }
}
