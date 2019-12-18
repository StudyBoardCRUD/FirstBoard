package com.StudyBoardCRUD.firstBoard.normalBoard.service;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.Board;
import java.util.List;

public interface BoardService {

  List<Board> findBoardListByBoardType(String boardType);

}
