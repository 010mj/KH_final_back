package kr.re.kh.repository;

import kr.re.kh.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 특정 Trip의 스케줄 목록 조회
    List<Schedule> findByTripId(String tripId);

    //@Query(value = "DELETE FROM SCHEDULE WHERE TRIP_ID = :tripId", nativeQuery = true)
    // void deleteByTripId(String tripId);
}

