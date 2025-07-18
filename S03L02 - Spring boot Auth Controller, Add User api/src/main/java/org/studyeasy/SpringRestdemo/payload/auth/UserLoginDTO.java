package org.studyeasy.SpringRestdemo.payload.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
   
    private String email;
    private String password;
}
