package kr.re.kh.mapper;

import kr.re.kh.model.vo.FolderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FolderMapper {

    List<FolderVO> selectFolderByUserId(Long userId);

}
