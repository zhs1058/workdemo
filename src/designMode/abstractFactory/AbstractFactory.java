package designMode.abstractFactory;

import java.awt.Container;
import java.io.File;
import java.awt.*;
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

import designMode.LoadXMLUtil;

/**
 * ���󹤳�����
 * һ��ʹ�ó��󹤳�ģʽһ��Ҫ��������������
 * ϵͳ���ж����Ʒ�壬ÿ�����幤������ͬһ�嵫���ڲ�ͬ�ȼ��ṹ�Ĳ�Ʒ��
 * ϵͳһ��ֻ������������ĳһ���Ʒ����ͬ��Ĳ�Ʒһ��ʹ�á�
 * 
 * �������󹤳�ģʽ���˾��й�������ģʽ���ŵ��⣬������Ҫ�ŵ����¡�
 * 
 * ����������ڲ��Բ�Ʒ����������Ķ�ȼ���Ʒ��ͬ����������ר���������µ��������й���
 * ����Ҫ��Ʒ��ʱ�����󹤳����Ա�֤�ͻ���ʼ��ֻʹ��ͬһ����Ʒ�Ĳ�Ʒ�顣
 * ���󹤳���ǿ�˳���Ŀ���չ�ԣ�������һ���µĲ�Ʒ��ʱ������Ҫ�޸�ԭ���룬���㿪��ԭ��
 * ������ȱ���ǣ�����Ʒ������Ҫ����һ���µĲ�Ʒʱ�����еĹ����඼��Ҫ�����޸ġ�������ϵͳ�ĳ����Ժ�����Ѷȡ�
 * 
 * ��Ʒ��Ͳ�Ʒ�ȼ�(����)
 * һ����������������ȼ���Ʒ
 * 
 * �ġ����󹤳�ģʽ����չ��һ���ġ�����ԭ����б�ԣ�
 * 1��������һ���µĲ�Ʒ��ʱֻ������һ���µľ��幤��������Ҫ�޸�ԭ���룬���㿪��ԭ��
 * 2������Ʒ������Ҫ����һ��������Ĳ�Ʒʱ�������еĹ����඼��Ҫ�����޸ģ������㿪��ԭ��
 * @author HsZ
 *
 */
public class AbstractFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
        try {
            Farm f;
            Animal a;
            Plant p;
            f = (Farm) ReadXML.getObject();
            a = f.newAnimal();
            p = f.newPlant();
            a.show();
            p.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	    
	}

}

//�����Ʒ��������
interface Animal {
  public void show();
}

//�����Ʒ������
class Horse implements Animal {
  JScrollPane sp;
  JFrame jf = new JFrame("���󹤳�ģʽ����");
  public Horse() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("�����"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/A_Horse.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û�������ڹر�
  }
  public void show() {
      jf.setVisible(true);
  }
}
//�����Ʒ��ţ��
class Cattle implements Animal {
  JScrollPane sp;
  JFrame jf = new JFrame("���󹤳�ģʽ����");
  public Cattle() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("���ţ"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/A_Cattle.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û�������ڹر�
  }
  public void show() {
      jf.setVisible(true);
  }
}

//�����Ʒ��ֲ����
interface Plant {
  public void show();
}

//�����Ʒ��ˮ����
class Fruitage implements Plant {
  JScrollPane sp;
  JFrame jf = new JFrame("���󹤳�ģʽ����");
  public Fruitage() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("ֲ�ˮ��"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/P_Fruitage.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û�������ڹر�
  }
  public void show() {
      jf.setVisible(true);
  }
}
//�����Ʒ���߲���
class Vegetables implements Plant {
  JScrollPane sp;
  JFrame jf = new JFrame("���󹤳�ģʽ����");
  public Vegetables() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("ֲ��߲�"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/P_Vegetables.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û�������ڹر�
  }
  public void show() {
      jf.setVisible(true);
  }
}

//���󹤳���ũ����
interface Farm {
  public Animal newAnimal();
  public Plant newPlant();
}

class SGfarm implements Farm {
  public Animal newAnimal() {
      System.out.println("��ţ������");
      return new Cattle();
  }
  public Plant newPlant() {
      System.out.println("�߲˳��ɣ�");
      return new Vegetables();
  }
}
//���幤��������ũ����
class SRfarm implements Farm {
  public Animal newAnimal() {
      System.out.println("���������");
      return new Horse();
  }
  public Plant newPlant() {
      System.out.println("ˮ�����ɣ�");
      return new Fruitage();
  }
}

class ReadXML {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src/config/abstract-factory-config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "designMode.abstractFactory." + classNode.getNodeValue();
            System.out.println("��������" + cName);
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
