package designMode.templateMethod;
/**
 * 模板方法，适用于流程相同，但是各个环节具体内容不同
 * 例如出国留学手续一般经过以下流程：索取学校资料，提出入学申请，
 * 办理因私出国护照、出境卡和公证，申请签证，体检、订机票、准备行装，
 * 抵达目标学校等，其中有些业务对各个学校是一样的，
 * 但有些业务因学校不同而不同，所以比较适合用模板方法模式来实现。
 * @author HsZ
 *
 */
public class TemplateMethod {

	public static void main(String[] args) {
		OverseasStudy overStudy1 = new zhangsan();
		OverseasStudy overStudy2 = new lisi();
		overStudy1.method();
		overStudy2.method();
	}
	
}

abstract class OverseasStudy {
	/**
	 * 毕业学校
	 */
	abstract void graduationSchool();
	
	/**
	 * 护照信息
	 */
	abstract void passportInfo();
	
	/**
	 * 目的地
	 */
	abstract void destination();
	
	public void method() {
		graduationSchool();
		passportInfo();
		destination();
	}
	
}

class zhangsan extends OverseasStudy {

	@Override
	void graduationSchool() {
		// TODO Auto-generated method stub
		System.out.print("我毕业于北京大学    ");
		
	}

	@Override
	void passportInfo() {
		// TODO Auto-generated method stub
		System.out.print("我的护照信息：姓名：张三；年龄：19岁；国籍：中国     ");
		
	}

	@Override
	void destination() {
		// TODO Auto-generated method stub
		System.out.println("我的留学目的地是德国");
	}
	
}

class lisi extends OverseasStudy {

	@Override
	void graduationSchool() {
		// TODO Auto-generated method stub
		System.out.print("我毕业于南京大学    ");
		
	}

	@Override
	void passportInfo() {
		// TODO Auto-generated method stub
		System.out.print("我的护照信息：姓名：李四；年龄：20岁；国籍：中国     ");
	}

	@Override
	void destination() {
		// TODO Auto-generated method stub
		System.out.println("我的留学目的地是美国");
	}
	
}