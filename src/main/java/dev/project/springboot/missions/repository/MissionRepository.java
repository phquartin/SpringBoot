package dev.project.springboot.missions.repository;

import dev.project.springboot.missions.model.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<MissionModel, Long> {
}
