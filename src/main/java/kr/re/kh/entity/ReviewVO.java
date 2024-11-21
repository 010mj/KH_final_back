package kr.re.kh.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "REVIEW")
public class ReviewVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_id", nullable = false)
    private Long placeId;

    @Column(name = "user_id", nullable = false)
    private Long userId;
    private Integer rating;
    private String cmt;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
