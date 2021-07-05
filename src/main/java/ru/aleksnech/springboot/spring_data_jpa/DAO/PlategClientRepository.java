package ru.aleksnech.springboot.spring_data_jpa.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aleksnech.springboot.spring_data_jpa.entity.Plateg;

public interface PlategClientRepository extends JpaRepository<Plateg, Integer> {
}
