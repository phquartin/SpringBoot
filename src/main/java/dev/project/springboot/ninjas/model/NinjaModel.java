package dev.project.springboot.ninjas.model;

import dev.project.springboot.missions.model.MissionModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity // Transforma uma classe em uma entidade do Banco de Dados
@Table(name = "tb_ninjas")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "mission")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String skills;

    // @ManyToOne - Muitos ninjas tem uma missao.
    @ManyToOne
    @JoinColumn(name = "mission_id") // Chave Estrangeira
    private MissionModel mission;
}


