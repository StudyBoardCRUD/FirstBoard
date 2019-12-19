package com.StudyBoardCRUD.firstBoard.normalBoard.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "board")
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String name;

  private String nickName;

  private String email;

  @Column(nullable = false)
  private String role;

  @CreationTimestamp
  @Column(nullable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private Date lastLoggedIn;


}
