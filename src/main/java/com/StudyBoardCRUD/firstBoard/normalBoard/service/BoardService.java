package com.StudyBoardCRUD.firstBoard.normalBoard.service;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.BoardDto;
import java.util.List;

public interface BoardService {

  List<BoardDto> findBoardListByBoardType(String boardType);

}
