
public class Tree_01_순회 {
	private static char[] arr = new char[] { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I' };
	private static int n = arr.length;
	
	/*
	 * 					A
	 * 
	 * 				B		C
	 * 
	 * 			  D	  E	  F	  G
	 * 
	 * 				H   I
	 * */

	public static void main(String[] args) {
//		preorder(1);
//		System.out.println();
		
//		inorder(1);
//		System.out.println();
		
		postorder(1);
		System.out.println();
	}

	// 전위순회(VLR)
	// i : 현재 방문하고 있는 노드 번호
	private static void preorder(int i) {
		if (i < n) {
			if (arr[i] != ' ') {
				System.out.print(arr[i] + " "); // V
			}
			preorder(2 * i); // L
			preorder(2 * i + 1); // R
		}
	}
	
	// 중위순회(LVR)
	// i : 현재 방문하고 있는 노드 번호
	private static void inorder(int i) {
		if (i < n) {
			inorder(2 * i); // L
			if (arr[i] != ' ') {
				System.out.print(arr[i] + " "); // V
			}
			inorder(2 * i + 1); // R
		}
	}
	
	// 후위순회(LRV)
	// i : 현재 방문하고 있는 노드 번호
	private static void postorder(int i) {
		if (i < n) {
			postorder(2 * i); // L
			postorder(2 * i + 1); // R
			if (arr[i] != ' ') {
				System.out.print(arr[i] + " "); // V
			}
		}
	}
}
