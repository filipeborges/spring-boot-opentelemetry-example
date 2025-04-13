package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table
public class HelloWorld {
    @Id
    private Long id;
    private String message;
    private String language;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloWorld that = (HelloWorld) o;
        return Objects.equals(message, that.message) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, language);
    }
}
