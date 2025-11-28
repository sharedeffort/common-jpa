package com.library.jpa.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseEntity extends BaseCreateEntity {

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private String deletedBy;

    /**
     * Soft Delete 처리
     */
    public void softDelete(String deletedBy) {
        this.deletedAt = LocalDateTime.now();
        this.deletedBy = deletedBy;
    }

    /**
     * Soft Delete 여부 확인
     */
    public boolean isDeleted() {
        return deletedAt != null;
    }
}