package com.StudyBoardCRUD.firstBoard.normalboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

  private long id;
  private String title;
  private String content;
  private Long boardType;
}
