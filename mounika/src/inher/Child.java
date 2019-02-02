package inher;

public class Child extends Parent{
	public void test3()
	{
		System.out.println("test3");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Child c=new Child();
c.test1();
c.test2();
c.test3();
	}

}
