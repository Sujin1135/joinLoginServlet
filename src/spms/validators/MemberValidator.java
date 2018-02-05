package spms.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import spms.vo.Member;

public class MemberValidator {
	public int validationCheck (Member member) {
		Pattern emailPattern =
                Pattern.compile("^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$"); // 이메일 밸리데이션 체크.
        Pattern namePattern =
                Pattern.compile("^[\\wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$"); // 이름 밸리데이션 체크.
        Pattern pwdPattern =
                Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$"); // 비밀번호 밸리데이션 체크.

        Matcher m = emailPattern.matcher(member.getEmail());
        if (!m.find()) { // 이메일이 밸리데이션 조건에 맞지 않을 경우.
            return -2;
        }

        m = namePattern.matcher(member.getName());
        if (!m.find()) { // 이름이 밸리데이션 조건에 맞지 않을 경우.
            return -3;
        }
        
        m = pwdPattern.matcher(member.getPassword());
        if (!m.find()) { // 비밀번호 밸리데이션 체크.
            return -4;
        }
        
        if (member.passwordCheck() == 0) { // 비밀번호와 비밀번호 확인이 일치한지 체크.
        		return -5;
        }

        return 1; // 밸리데이션 조건에 모두 충족할 경우.
	}
}
