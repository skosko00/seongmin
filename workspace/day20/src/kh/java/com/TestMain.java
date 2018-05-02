package kh.java.com;

public class TestMain {

	public static void main(String[] args) {
		AnimalMgr<Tiger> m1 = new AnimalMgr<Tiger>(new Tiger(100));
		AnimalMgr<Bear> m2 = new AnimalMgr<Bear>(new Bear(200));

		System.out.println(m1.data.hp);
		System.out.println(m2.data.hp);
	}

}
