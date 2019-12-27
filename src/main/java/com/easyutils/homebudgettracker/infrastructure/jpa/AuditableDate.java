package com.easyutils.homebudgettracker.infrastructure.jpa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableDate {

    @Column(name = "aangemaakt_op", updatable = false)
    @CreatedDate
    private LocalDateTime aangemaaktOp;

    @Column(name = "gewijzigd_op", insertable = false)
    @LastModifiedDate
    private LocalDateTime gewijzigdOp;
}
