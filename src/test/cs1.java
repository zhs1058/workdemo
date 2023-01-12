package test;

public class cs1 {

}

interface cl {
	
	public void print();
}

class cl1 implements cl {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("²ßÂÔ1");
	}
	
}

class cl2 implements cl {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("²ßÂÔ2");
	}
	
}

class factory {
	public cl getCL(String code) {
		if(code.equals("cl1")) {
			return new cl1();
		}else if(code.equals("cl2")) {
			return new cl2();
		}
		return null;
		
	}
}
