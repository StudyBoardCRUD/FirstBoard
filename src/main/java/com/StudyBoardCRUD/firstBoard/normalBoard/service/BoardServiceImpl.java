package com.StudyBoardCRUD.firstBoard.normalBoard.service;

import com.StudyBoardCRUD.firstBoard.normalBoard.domain.repository.BoardRepository;
import com.StudyBoardCRUD.firstBoard.normalBoard.dto.Board;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardRepository boardRepository;

  @Override
  public List<Board> findBoardListByBoardType(String boardType) {
    List<Board> boardList = boardRepository.findBoardsByType(boardType);
    return boardList;
  }
}
