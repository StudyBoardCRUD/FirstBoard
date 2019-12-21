package com.StudyBoardCRUD.firstBoard.normalboard.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private long id;
  private String userId;
  private String password;
  private String name;
  private String nickName;
  private String email;
  private String role;
  private Date createdAt;
  private Date lastLoggedIn;
}
