package edu.bu.oneshelf.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;



@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class CreateUpdateTimeStampModel {
    @CreationTimestamp
    @Column(updatable = false)
    protected Date createdAt;
    @UpdateTimestamp
    protected Date updatedAt;
}
