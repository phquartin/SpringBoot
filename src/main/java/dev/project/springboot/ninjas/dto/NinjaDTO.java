package dev.project.springboot.ninjas.dto;

import dev.project.springboot.missions.model.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private int age;
    private String skills;
    private MissionModel mission;

}
