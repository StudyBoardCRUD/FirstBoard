package com.StudyBoardCRUD.firstBoard.normalboard.helper;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserPwdConvertHelper implements
    AttributeConverter<String, String> {

  private static final byte[] KEY = "lelecoder".getBytes();
  private static final String ALGORITHM = "AES/GCM/NoPadding";

  static class UserInfoCipherException extends RuntimeException {

    Key key;
    String cipherInstanceString;

    UserInfoCipherException() {
      super();
    }

    UserInfoCipherException(Exception e, Key key, String cipherInstanceString) {
      super(e);
      this.key = key;
      this.cipherInstanceString = cipherInstanceString;
    }
  }

  @Override
  public String convertToDatabaseColumn(String attribute) {
    Key key = new SecretKeySpec(KEY, "AES");
    try {
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      return new String(Base64.getEncoder().encode(cipher.doFinal(attribute.getBytes())));
    } catch (Exception e) {
      throw new UserInfoCipherException(e, key, ALGORITHM);
    }
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    Key key = new SecretKeySpec(KEY, "AES");
    try {
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, key);
      return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
    } catch (Exception e) {
      throw new UserInfoCipherException(e, key, ALGORITHM);
    }
  }

}
