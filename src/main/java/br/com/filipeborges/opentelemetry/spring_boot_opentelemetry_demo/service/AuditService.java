package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.service;

import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.model.Audit;
import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.repository.nosql.AuditRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuditService {

    private AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public Mono<Audit> audit(String createdBy, Long helloWorldId) {
        return Mono.fromCallable(() -> new Audit(createdBy, helloWorldId))
                .flatMap(auditRepository::save);
    }
}
