package com.StudyBoardCRUD.firstBoard.normalboard.domain.repository;

import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDto, Long> {

  List<BoardDto> findBoardsByBoardType(Long boardType);

}
