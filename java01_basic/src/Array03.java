
public class Array03 {

	public static void main(String[] args) {
		// args[0], "ggm" == true, != false
		if(args[0].equals("ggm") && args[1].equals("1234")) {
			for(int i=0; i<args.length; i++) {
				System.out.println("args["+i+"]="+args[i]);
			}
		} else {
			System.out.println("fail");
		}

	}

}
