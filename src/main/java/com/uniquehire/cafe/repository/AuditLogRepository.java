package com.uniquehire.cafe.repository;

import com.uniquehire.cafe.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
