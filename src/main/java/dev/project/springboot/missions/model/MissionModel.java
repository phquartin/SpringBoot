package dev.project.springboot.missions.model;

import dev.project.springboot.ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import java.util.List;

@Entity
@Table(name = "tb_missions")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String name;

    private MissionRank Rank;

    // @OneToMany - Uma missao tem varios Ninjas
    @OneToMany(mappedBy = "mission")
    private List<NinjaModel> ninjas;

}
