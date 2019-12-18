package com.StudyBoardCRUD.firstBoard.normalBoard.domain.repository;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

  List<Board> findBoardsByType(String boardType);

}
