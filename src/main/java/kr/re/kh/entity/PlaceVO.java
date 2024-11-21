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
public class PlaceVO {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long tripId;


    private String name;


    private String address;


    private Double latitude;


    private Double longitude;


    private LocalDateTime createdAt;
}
