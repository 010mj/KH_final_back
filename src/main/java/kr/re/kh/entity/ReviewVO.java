package kr.re.kh.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class ReviewVO {

    private Long id;
    private Long placeId;
    private Long userId;
    private Integer rating;
    private byte[] cmt;
    private LocalDateTime createdAt;
}
