package com.StudyBoardCRUD.firstBoard.normalboard.service;

import com.StudyBoardCRUD.firstBoard.normalboard.domain.repository.BoardRepository;
import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  private final
  BoardRepository boardRepository;

  @Autowired
  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public List<BoardDto> findBoardListByBoardType(long boardType) {
    return boardRepository.findBoardsByBoardType(boardType);
  }
}
