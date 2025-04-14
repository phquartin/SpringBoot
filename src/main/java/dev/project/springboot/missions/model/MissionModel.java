package dev.project.springboot.missions.model;

import dev.project.springboot.ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private MissionRank Rank;

    // @OneToMany - Uma missao tem varios Ninjas
    @OneToMany(mappedBy = "mission")
    private List<NinjaModel> ninjas;

}
