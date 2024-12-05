package kr.re.kh.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity(name = "SCHEDULE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tripId;  // 연결된 Trip의 ID

    private String placeName;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();




}

