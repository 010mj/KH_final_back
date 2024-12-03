package kr.re.kh.entity;

import lombok.*;


@Getter
@Setter
@ToString
public class FavoriteRequest {
    private Long folderId;
    private String placeName;
   // private String address;
    //private Double latitude;
   // private Double longitude;
    private String memo;
}
