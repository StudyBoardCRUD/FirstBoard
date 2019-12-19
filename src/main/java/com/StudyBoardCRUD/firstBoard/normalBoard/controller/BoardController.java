package com.StudyBoardCRUD.firstBoard.normalBoard.controller;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.BoardDto;
import com.StudyBoardCRUD.firstBoard.normalBoard.service.BoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("/list")
  public ResponseEntity<List<BoardDto>> getBoardList(
      @RequestParam(value = "boardType",
          defaultValue = "normal",
          required = false) String boardType) {

    List<BoardDto> boardDtoList = boardService.findBoardListByBoardType(boardType);

    return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
  }
}
