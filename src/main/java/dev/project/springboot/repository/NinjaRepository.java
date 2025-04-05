package dev.project.springboot.repository;

import dev.project.springboot.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

}
