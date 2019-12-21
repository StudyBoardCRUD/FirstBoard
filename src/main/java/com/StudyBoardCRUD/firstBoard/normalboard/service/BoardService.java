package com.StudyBoardCRUD.firstBoard.normalboard.service;

import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import java.util.List;

public interface BoardService {

  List<BoardDto> findBoardListByBoardType(long boardType);

}
