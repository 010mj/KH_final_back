package kr.re.kh.service;

import kr.re.kh.entity.Trip;
import kr.re.kh.repository.ScheduleRepository;
import kr.re.kh.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class TripService {

    private final TripRepository tripRepository;
    private final ScheduleRepository scheduleRepository;

    public TripService(TripRepository tripRepository, ScheduleRepository scheduleRepository) {
        this.tripRepository = tripRepository;
        this.scheduleRepository = scheduleRepository;
    }

    // 여행 일정 생성
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    // 전체 여행 일정 조회
    public List<Trip> getAllTrips(Long userId) {

        return tripRepository.findByUserId(userId.toString());
    }

    // 특정 여행 일정 상세 조회
    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip not found with ID: " + id));
    }

    // 여행 일정 수정
    public Trip updateTrip(Long id, Trip trip) {
        Trip existingTrip = getTripById(id);
        existingTrip.setDescription(trip.getDescription());
        existingTrip.setStartDate(trip.getStartDate());
        existingTrip.setEndDate(trip.getEndDate());
        return tripRepository.save(existingTrip);
    }

    // 여행 일정 삭제
    public void deleteTrip(Long id,String tripId) {
        log.info("deleteById");
        tripRepository.deleteById(id);
        log.info("deleteByTripId");
        scheduleRepository.deleteByTripId(tripId);
    }

}

