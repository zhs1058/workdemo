package designMode.createType.builder;

import java.awt.Container;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;

/**
 * 建造者模式
 * 一、定义：指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 * 它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 * 二、该模式的主要优点如下：
 * 封装性好，构建和表示分离。
 * 扩展性好，各个具体的建造者相互独立，有利于系统的解耦。
 * 客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。
 * 三、其缺点如下：
 * 产品的组成部分必须相同，这限制了其使用范围。
 * 如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。
 * 四、建造者（Builder）模式和工厂模式的关注点不同：建造者模式注重零部件的组装过程，而工厂方法模式更注重零部件的创建过程，但两者可以结合使用。
 * @author HsZ
 *
 */
public class BuilderMole {

	public static void main(String[] args) {
		Builder builder = (Builder) ReadXML.getObject();
		Director director = new Director(builder);
		director.doThing();
		director.getResult();
		
	}

}

class Product {
	private String jacket;
	private String trousers;
	private String shoes;
	
	public void setJacket(String jacket) {
		this.jacket = jacket;
	}
	public void setTrousers(String trousers) {
		this.trousers = trousers;
	}
	public void setShoes(String shoes) {
		this.shoes = shoes;
	}
	
	public void show() {
		JFrame jf = new JFrame("建造者模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane(p);
        String parlour = jacket + trousers + shoes;
        JLabel l = new JLabel(new ImageIcon("src/images/builder/" + parlour + ".png"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("客厅"));
        p.add(l);
        contentPane.add(sp, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}

abstract class Builder{
	
	protected Product product = new Product();
	
	abstract public void  buildProduct();
	
	public void getResult() {
		product.show();
	}
	
}

class BuilderA extends Builder{

	@Override
	public void buildProduct() {
		
		product.setJacket("white");
		product.setTrousers("green");
		product.setShoes("green");
	}
	
}

class BuilderB extends Builder{

	@Override
	public void buildProduct() {
		// TODO Auto-generated method stub
		product.setJacket("green");
		product.setTrousers("black");
		product.setShoes("black");
	}
	
}

class Director{
	
	private Builder builder;
	
	Director(Builder builder){
		this.builder = builder;
	}
	
	public void doThing() {
		builder.buildProduct();
	}
	
	public void getResult() {
		builder.getResult();
	}
	
}

class ReadXML{
	public static Object getObject() {
		try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src/config/builder-config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "designMode.builder." + classNode.getNodeValue();
            System.out.println("新类名：" + cName);
            Class<?> c = Class.forName(cName);
            //Arrays.asList(c.getMethods()).forEach(item -> item.setAccessible(true));
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
