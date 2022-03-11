package comsam.spring02.DI03_member_ref;
/*
 * <회원 기능 이용해 DI 실습하기>
 * MemberService             MeberDAO
 *      
   MemberServiceImp ---의존관계-->MemberDAOImpl
   					<---주입----
 */      
public interface MemberService {
	public void listMembers();
}
