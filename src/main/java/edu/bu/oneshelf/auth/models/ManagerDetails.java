package edu.bu.oneshelf.auth.models;

import edu.bu.oneshelf.common.BaseModel;
import edu.bu.oneshelf.pantry.models.Pantry;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@Entity(name = "manager_details")
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@Table(name = "manager_details")
public class ManagerDetails extends BaseModel {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",unique = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pantry_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Pantry pantry;
}
