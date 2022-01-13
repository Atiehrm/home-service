package ir.maktab.data.dao;

import ir.maktab.data.model.entity.member.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author arm 1/5/2022
 */
@Repository
public interface ManagerDao extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByEmail(String email);
}
