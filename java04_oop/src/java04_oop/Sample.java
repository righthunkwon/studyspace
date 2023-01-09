package java04_oop;
class Test	{
	int x;
	public void setX(int x) {this.x= x;}
	public int getX()	{return x;}
}

class Ex	{
	Test y;
	public void setY(Test y) {this.y= y;}
	public Test getY()	{return y;}
}
public class Sample {

	public static void main(String[] args) {
		Ex o = new Ex();
		Test i = new Test();
		int n=10;	
		i.setX(n);	//int x = 10
		o.setY(i);	//Test y = i의 주소(reference)
		System.out.println(o.getY().getX());//o.getY() = i의 주소 -> i.getX() => 10

	}

}
