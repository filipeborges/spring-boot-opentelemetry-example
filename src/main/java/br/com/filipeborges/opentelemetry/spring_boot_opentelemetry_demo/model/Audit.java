package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document("audit")
public class Audit {
    private ObjectId id;
    private String createdBy;
    private Long helloWorldId;
    private LocalDateTime createdAt;

    public Audit(String createdBy, Long helloWorldId) {
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.helloWorldId = helloWorldId;
    }

    public Audit() {
    }

    public ObjectId getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getHelloWorldId() {
        return helloWorldId;
    }

    public void setHelloWorldId(Long helloWorldId) {
        this.helloWorldId = helloWorldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audit audit = (Audit) o;
        return Objects.equals(createdBy, audit.createdBy) && Objects.equals(helloWorldId, audit.helloWorldId) && Objects.equals(createdAt, audit.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, helloWorldId, createdAt);
    }
}
