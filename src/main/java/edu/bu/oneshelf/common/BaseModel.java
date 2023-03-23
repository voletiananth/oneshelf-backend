package edu.bu.oneshelf.common;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.Date;



@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class BaseModel extends CreateUpdateTimeStampModel {
    @Id
    @Getter
    @Column(updatable = false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    protected Long id;



}
