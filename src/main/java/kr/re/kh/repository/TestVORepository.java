package kr.re.kh.repository;

import kr.re.kh.model.TestVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestVORepository extends JpaRepository<TestVO,Long> {
    //전체 데이터 반환
    List<TestVO> findAll();

    Optional<TestVO> findById(Long id);

    //title 컬럼 값이 일치하는 행 반환
    List<TestVO> findByTitle(String title);

    //title 컬럼 값이 일치하는 행을 특정 컬럼 ORDER BY로 반환
    List<TestVO> findByTitleContainingOrderByIdDesc(String title);

    //title 컬럼 값이 LIKE절을 적용한 상태로 행 반환
    List<TestVO> findByTitleContaining(String title);

    //검색조건에(where)여러개를 지정할 경우 :AND
    List<TestVO> findByTitleAndContent(String title, String Content);

    //검색조건에(where)여러개를 지정할 경우 :OR
    List<TestVO> findByTitleOrContent(String title, String Content);

    // 특정 데이터 행이 존재하는지 파악하고 true,false 반환
    boolean existsByTitle(String title);

}
