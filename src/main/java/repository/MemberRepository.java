package repository;

import domain.Member.Email.Email;
import domain.Member.Member;
import domain.group.Group;
import domain.group.GroupName;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
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
    계정 모두 찾아서 리턴받기
    */
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    /*
    회원 선택 그룹 수정하기
    -> DB에서 추가, 삭제되지는 않으니가 구현하지 않아도 되려나..
    -> memberRepository로 들어오려면 생성해야만 함
     */
    //영속vs비영속 엔티티인지 고민해볼것!//
    //영속 엔티티라면 내가 생각하던대로
    //비영속 엔티티라면 변경감지로(dirty checking)
    @Transactional
    public void updateGroupName(Member member, GroupName groupName){
        Member byId = em.find(Member.class, member.getId());
        byId.setGroup(groupName); //이러면 걍 DB도 저장되는건가?
    }


}
