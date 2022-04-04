package designMode.chainOfResponsibility;

/**
 * 
 * 一、责任链模式是一种对象行为型模式，其主要优点如下。
 * 1、降低了对象之间的耦合度。该模式使得一个对象无须知道到底是哪一个对象处理其请求以及链的结构，发送者和接收者也无须拥有对方的明确信息。
 * 2、增强了系统的可扩展性。可以根据需要增加新的请求处理类，满足开闭原则。
 * 3、增强了给对象指派职责的灵活性。当工作流程发生变化，可以动态地改变链内的成员或者调动它们的次序，也可动态地新增或者删除责任。
 * 4、责任链简化了对象之间的连接。每个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的 if 或者 if···else 语句。
 * 5、责任分担。每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。
 * 
 * 二、其主要缺点如下。
 * 1、不能保证每个请求一定被处理。由于一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直传到链的末端都得不到处理。
 * 2、对比较长的职责链，请求的处理可能涉及多个处理对象，系统性能将受到一定影响。
 * 3、职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错，如可能会造成循环调用。
 * @author 89704
 *
 */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Handler h1 = new ConcreteHandler1();
		Handler h2 = new ConcreteHandler2();
		Handler h3 = new ConcreteHandler3();
		h1.setNext(h2);
		h2.setNext(h3);
		h1.doHandler(1);
	}

}

abstract class Handler{
	private Handler next;
	
	public Handler getNext() {
		return this.next;
	}
	
	public void setNext(Handler handler) {
		this.next = handler;
	}
	
	public abstract void doHandler(int days);
}

class ConcreteHandler1 extends Handler{

	@Override
	public void doHandler(int days) {
		// TODO Auto-generated method stub
		if(days <= 2) {
			System.out.println("两天假老师给批准了");
		}else {
			System.out.println("老师无权审批，流转至下一审批节点");
			getNext().doHandler(days);
		}
	}
	
}

class ConcreteHandler2 extends Handler{

	@Override
	public void doHandler(int days) {
		// TODO Auto-generated method stub
		if(days <= 7) {
			System.out.println("一周假教导主任给批准了");
		}else {
			System.out.println("教导主任无权审批，流转至下一审批节点");
			getNext().doHandler(days);
		}
	}
	
}

class ConcreteHandler3 extends Handler{

	@Override
	public void doHandler(int days) {
		// TODO Auto-generated method stub
		System.out.println("请办理休学");
	}
	
}
