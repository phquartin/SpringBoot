package dev.project.springboot.ninjas.model;

import dev.project.springboot.missions.model.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Transforma uma classe em uma entidade do Banco de Dados
@Table(name = "tb_ninjas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    // @ManyToOne - Muitos ninjas tem uma missao.
    @ManyToOne
    @JoinColumn(name = "mission_id") // Chave Estrangeira
    private MissionModel mission;

}


