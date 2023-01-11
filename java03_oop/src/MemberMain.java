
public class MemberMain {

	public MemberMain() {
		MemberAccess ma = new MemberAccess();
		MemberDTO m = ma.getMember();
		System.out.println(m.toString());
		
		// m1, m2, m3 세 명의 회원
		MemberDTO[] arr = ma.getAllMember();
		for(int i=0; i<arr.length; i++) { // 배열의 길이만큼 반복
			MemberDTO dto = arr[i];
			System.out.printf("%s\t%s\t%s\t\n", dto.getUserId(), dto.getUserName(), dto.getTel());
		}
	}

	public static void main(String[] args) {
		new MemberMain();
	}

}
