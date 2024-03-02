package domain.Member.Email;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor
@Getter
public class Email {
    private String email;

    public Email(String email) {
        if(isValidEmail(email)){
            this.email = email;
        }
        else this.email = null; //email 형식에 맞지 않는 문자열인 경우, email에 널 대입
    }

    //Email 수정 못하도록 setter 존재 X

    private boolean isValidEmail(String email){
        String regex = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]+$"; //이메일 정규표현식
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}