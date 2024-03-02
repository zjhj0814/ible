package service;

import domain.Member.Email.Email;
import domain.Member.Member;
import domain.group.GroupName;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MemberRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    @Autowired MemberRepository memberRepository;

    /*
    회원가입
     */
    public String join(Member member){
        isValidEmail(member.getEmail());
        duplicatedId(member.getId());
        memberRepository.save(member);
        return member.getId();
    }

    /*
    아이디 중복 확인 코드
     */
    private void duplicatedId(String id){
        Member findById = memberRepository.findById(id);
        if(findById!=null){
            throw new IllegalStateException("아이디가 이미 존재합니다.");
        }
    }

    /*
    이메일 검증 코드
     */
    private void isValidEmail(Email email){
        String regex = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]+$"; //이메일 정규표현식
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email.getEmail());
        if(!m.matches()){
            throw new IllegalStateException("이메일 형식이 올바르지 않습니다.");
        }
    }

    /*
    그룹 정보 수정하기
     */
    public void updateGroup(Member member, GroupName groupName){
        memberRepository.updateGroupName(member, groupName);
    }
}
