package kr.re.kh.service;

import kr.re.kh.entity.Schedule;
import kr.re.kh.mapper.TripMapper;
import kr.re.kh.repository.ScheduleRepository;
import kr.re.kh.repository.TripRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ScheduleService {
    private final TripMapper tripMapper;
    private final ScheduleRepository scheduleRepository;
    private final TripRepository tripRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, TripRepository tripRepository,TripMapper tripMapper) {
        this.scheduleRepository = scheduleRepository;
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }
    public List<Schedule> getSchedulesByTripId(String tripId) {
        return tripMapper.getSchedulesByTripId(tripId);
    }
    // 새로운 스케줄 추가
    public Schedule createSchedule(Schedule schedule) {
        // 관련 Trip ID 유효성 검사
        if (!tripRepository.existsByTitle(schedule.getTripId())) {
            throw new IllegalArgumentException("Invalid trip ID: " + schedule.getTripId());
        }
        return scheduleRepository.save(schedule);
    }

    // 특정 일정의 모든 스케줄 조회
//    public List<Schedule> getSchedulesByTripId(String tripId) {
//        return scheduleRepository.findByTripId(String.valueOf(tripId));
//    }

    // 특정 스케줄 수정
    public Schedule updateSchedule(Long id, Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with ID: " + id));

        existingSchedule.setPlaceName(schedule.getPlaceName());
        existingSchedule.setStartTime(schedule.getStartTime());
        existingSchedule.setEndTime(schedule.getEndTime());

        return scheduleRepository.save(existingSchedule);
    }

    // 특정 스케줄 삭제
    public void deleteSchedule(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new EntityNotFoundException("Schedule not found with ID: " + id);
        }
        scheduleRepository.deleteById(id);
    }
}

