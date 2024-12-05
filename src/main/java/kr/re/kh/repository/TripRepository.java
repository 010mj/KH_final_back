package kr.re.kh.repository;

import kr.re.kh.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    boolean existsByTitle(String title);

    List<Trip> findByUserId(String userId);

    void deleteById(Long id);
}

