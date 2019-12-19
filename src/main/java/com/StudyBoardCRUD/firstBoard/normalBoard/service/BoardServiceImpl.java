package com.StudyBoardCRUD.firstBoard.normalBoard.service;

import com.StudyBoardCRUD.firstBoard.normalBoard.domain.repository.BoardRepository;
import com.StudyBoardCRUD.firstBoard.normalBoard.dto.BoardDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardRepository boardRepository;

  @Override
  public List<BoardDto> findBoardListByBoardType(String boardType) {
    List<BoardDto> boardDtoList = boardRepository.findBoardsByType(boardType);
    return boardDtoList;
  }
}
