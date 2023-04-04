
public class MemberAccess {
	String id = "hoguma";
	String name = "호구마";
	String tel = "010-1234-5678";
	String email = "hoguma@naver.com";
	
	public MemberAccess() {
		
	}
	public MemberDTO getMember() {
		MemberDTO dto = new MemberDTO();
		dto.setUserId(id);
		dto.setUserName(name);
		dto.setTel(tel);
		dto.setEmail(email);
		
		return dto;
	}
	public MemberDTO[] getAllMember() {
		// 총 회원 세 명 : m1, m2, m3
		// 배열에 MemberDTO를 담아 세 명의 정보를 묶는다.
		// DB회원 선택 후 1명의 회원을 DTO에 담아 배열에 담는다.
		MemberDTO m1 = new MemberDTO();
		m1.setUserId("No1GodDev");
		m1.setUserName("권정훈");
		m1.setTel("010-1234-5678");
		
		/*
			이하는 MemberDTO에 
			
				public MemberDTO(String userId, String userName, String tel) {
					this.userId = userId;
					this.userName = userName;
					this.tel = tel;
				}
			 
			라는 새로운 메서드를 만들었기에 실행 가능
		*/
		
		MemberDTO m2 = new MemberDTO("MasterDev", "훈민정음", "010-1111-2222");
		MemberDTO m3 = new MemberDTO("RightDev", "정훈", "010-3333-4444");
		
		// 배열에 MemberDTO 담기
		MemberDTO[] member = new MemberDTO[3];
		member[0] = m1;
		member[1] = m2;
		member[2] = m3;
		
		return member;
	}
}
