package kr.re.kh.entity;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteRequest {
    private Long folderId;
    private String placeName;
    private String address;
    private Double latitude;
    private Double longitude;
    private String memo;
}
