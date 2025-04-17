package dev.project.springboot.missions.dto;

import dev.project.springboot.missions.model.MissionRank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {

    private Long id;
    private String name;
    private MissionRank Rank;

}
