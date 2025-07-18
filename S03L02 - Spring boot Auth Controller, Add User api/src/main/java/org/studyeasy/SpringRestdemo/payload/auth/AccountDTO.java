package org.studyeasy.SpringRestdemo.payload.auth;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDTO {

    private String email;
    private String password;
    
}
