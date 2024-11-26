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
@Table(name="folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;

    private Long userId;

    @Column(nullable = false)
    private String folderName;

    private LocalDateTime createdAt = LocalDateTime.now();

}
