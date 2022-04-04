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
 * ������ģʽ
 * һ�����壺ָ��һ�����Ӷ���Ĺ��������ı�ʾ���룬ʹͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ�����������ģʽ����Ϊ������ģʽ��
 * ���ǽ�һ�����ӵĶ���ֽ�Ϊ����򵥵Ķ���Ȼ��һ��һ���������ɡ��������벻������룬����Ʒ����ɲ����ǲ���ģ���ÿһ�����ǿ������ѡ��ġ�
 * ������ģʽ����Ҫ�ŵ����£�
 * ��װ�Ժã������ͱ�ʾ���롣
 * ��չ�Ժã���������Ľ������໥������������ϵͳ�Ľ��
 * �ͻ��˲���֪����Ʒ�ڲ���ɵ�ϸ�ڣ������߿��ԶԴ���������ϸ��������������ģ������κ�Ӱ�죬���ڿ���ϸ�ڷ��ա�
 * ������ȱ�����£�
 * ��Ʒ����ɲ��ֱ�����ͬ������������ʹ�÷�Χ��
 * �����Ʒ���ڲ��仯���ӣ������Ʒ�ڲ������仯��������ҲҪͬ���޸ģ�����ά���ɱ��ϴ�
 * �ġ������ߣ�Builder��ģʽ�͹���ģʽ�Ĺ�ע�㲻ͬ��������ģʽע���㲿������װ���̣�����������ģʽ��ע���㲿���Ĵ������̣������߿��Խ��ʹ�á�
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
		JFrame jf = new JFrame("������ģʽ����");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane(p);
        String parlour = jacket + trousers + shoes;
        JLabel l = new JLabel(new ImageIcon("src/images/builder/" + parlour + ".png"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("����"));
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
            System.out.println("��������" + cName);
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
