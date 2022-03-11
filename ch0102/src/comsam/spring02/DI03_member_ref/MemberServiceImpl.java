package comsam.spring02.DI03_member_ref;

public class MemberServiceImpl implements MemberService{
	
        private MemberDAO memberDAO; //주입되는 빈을 저장할 MemberDAO타입의 속성을 선언한다.
		
		//setMemberDAO이름이  xml파일의 id의 이름과 일치해야함
		//member.xml 을 이용해 만든 빈에  memberDAO객체를 주입한다.
		public void setMemberDAO(MemberDAO memberDAO) {
			this.memberDAO=memberDAO;
		}

	@Override
	public void listMembers() {
		memberDAO.listMembers();
		
	}
	
}
