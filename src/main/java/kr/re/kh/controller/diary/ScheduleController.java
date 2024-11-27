package kr.re.kh.controller.diary;

import kr.re.kh.annotation.CurrentUser;
import kr.re.kh.entity.Schedule;
import kr.re.kh.entity.Trip;
import kr.re.kh.model.CustomUserDetails;
import kr.re.kh.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@Slf4j
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    // 1. 새로운 스케줄 추가
    @PostMapping
    public ResponseEntity<Schedule> createSchedule(
            @RequestBody Schedule schedule,
            @CurrentUser CustomUserDetails userDetails // 로그인한 사용자 정보
    ) {
        log.info(userDetails.toString());
        String TripId = String.valueOf(schedule.getTripId()); // Trip ID 가져오기

        log.info(schedule.toString());

        Schedule request = new Schedule();
        request.setTripId(schedule.getTripId());
        request.setPlaceName(schedule.getPlaceName());

        String startTimeStr =  schedule.getStartTime();
        String endTimeStr =  schedule.getEndTime();

        SimpleDateFormat sdf = new SimpleDateFormat("MM:SS");


        request.setTripId(schedule.getTripId());
        log.info(request.toString());
        Schedule createdSchedule = scheduleService.createSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule);
    }

    // 2. 특정 일정의 모든 스케줄 조회
    @GetMapping("/trips/{tripId}")
    public ResponseEntity<List<Schedule>> getSchedulesByTripId(@PathVariable Long tripId) {
        List<Schedule> schedules = scheduleService.getSchedulesByTripId(tripId);
        return ResponseEntity.ok(schedules);
    }

    // 3. 특정 스케줄 수정
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        Schedule updatedSchedule = scheduleService.updateSchedule(id, schedule);
        return ResponseEntity.ok(updatedSchedule);
    }

    // 4. 특정 스케줄 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }



}

