package br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.repository.nosql;

import br.com.filipeborges.opentelemetry.spring_boot_opentelemetry_demo.model.Audit;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends ReactiveCrudRepository<Audit, ObjectId> {
}
