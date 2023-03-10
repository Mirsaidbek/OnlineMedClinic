package dev.said.onlinemedclinic.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor implements Domain {
    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Specialization specialization;
    private String info;
    @Column(nullable = true, columnDefinition = "numeric(15, 2) default 0")
    private Double rating;
}
