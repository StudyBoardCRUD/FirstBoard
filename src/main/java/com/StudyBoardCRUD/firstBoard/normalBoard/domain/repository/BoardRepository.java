package com.StudyBoardCRUD.firstBoard.normalBoard.domain.repository;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.BoardDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDto, Long> {

  List<BoardDto> findBoardsByType(String boardType);

}
