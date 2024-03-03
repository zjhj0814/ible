package repository;

import domain.Email.Email;
import domain.Member;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Repository
public class MemberRepository {

    @Autowired
    private final EntityManager em;

    /*
    Member 테이블에 넣기
     */
    public void save(Member member){
        em.persist(member);
        //이메일 관련 예외처리는 어디서 일어나야 할까? 서비스 계층에서 일어난다
    }

    /*
    아이디로 찾기
     */
    public Member findById(String id){
        return em.find(Member.class, id);
    }

    /*
    이메일로 찾기
    */
    public List<Member> findByEmail(Email email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email",email)
                .getResultList();
    }

    /*
    회원계정 모두 찾아서 리턴받기
    */
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

}
