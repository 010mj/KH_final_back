package kr.re.kh.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    private Long folderId;


    @Column(nullable = false)
    private String placeName;
    //private String address;
    //private Double latitude;
    //private Double longitude;
    private String memo;
    private LocalDateTime createdAt = LocalDateTime.now();
}
