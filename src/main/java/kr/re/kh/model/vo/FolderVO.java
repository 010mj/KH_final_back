package kr.re.kh.model.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FolderVO {

    private Long folderId;
    private String folderName;
    private LocalDateTime createdAt = LocalDateTime.now();

}
