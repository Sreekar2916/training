package com.uniquehire.cafe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "table_name", length = 50, nullable = false)
    private String tableName;

    // Constructors
    public AuditLog() {
    }

    public AuditLog(Long id, String tableName) {
        this.id = id;
        this.tableName = tableName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
