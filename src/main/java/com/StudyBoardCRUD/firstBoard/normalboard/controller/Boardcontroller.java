package com.StudyBoardCRUD.firstBoard.normalboard.controller;

import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import com.StudyBoardCRUD.firstBoard.normalboard.service.BoardService;
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
public class Boardcontroller {

  private final BoardService boardService;

  @Autowired
  public Boardcontroller(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/list")
  public ResponseEntity<List<BoardDto>> getBoardList(
      @RequestParam(value = "boardType",
          defaultValue = "normal",
          required = false) long boardType) {

    List<BoardDto> boardDtoList = boardService.findBoardListByBoardType(boardType);

    return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
  }
}
