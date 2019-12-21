package com.StudyBoardCRUD.firstBoard.normalboard.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private User writer;

  @OneToOne(mappedBy = "boardType")
  @Column(nullable = false)
  private Long boardType;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;
}
