package kr.re.kh.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FavoriteVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본 키

    @Column(nullable = false)
    private Long userId; // 사용자 ID

    @Column(nullable = false)
    private String itemName; // 즐겨찾기 항목 이름

    @Column(nullable = false)
    private String itemType; // 항목 유형 (예: 관광지, 상품 등)
}