package kr.re.kh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "TEST_VO" )
@NoArgsConstructor
public class TestVO {

    @Id
    @Column(name= "TEST_ID" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITLE" , length = 200)
    private String title;

    @Column(name="CONTENT" , length = 250)
    private String content;

    public TestVO(TestVO testVO){
        id = testVO.getId();
        title= testVO.getTitle();
        content = testVO.getContent();
    }
}
