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
 * 抽象工厂方法
 * 一、使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 * 
 * 二、抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
 * 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。
 * 三、其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。增加了系统的抽象性和理解难度。
 * 
 * 产品族和产品等级(种类)
 * 一共工厂可以生产多等级产品
 * 
 * 四、抽象工厂模式的扩展有一定的“开闭原则”倾斜性：
 * 1、当增加一个新的产品族时只需增加一个新的具体工厂，不需要修改原代码，满足开闭原则。
 * 2、当产品族中需要增加一个新种类的产品时，则所有的工厂类都需要进行修改，不满足开闭原则。
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

//抽象产品：动物类
interface Animal {
  public void show();
}

//具体产品：马类
class Horse implements Animal {
  JScrollPane sp;
  JFrame jf = new JFrame("抽象工厂模式测试");
  public Horse() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/A_Horse.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
  }
  public void show() {
      jf.setVisible(true);
  }
}
//具体产品：牛类
class Cattle implements Animal {
  JScrollPane sp;
  JFrame jf = new JFrame("抽象工厂模式测试");
  public Cattle() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/A_Cattle.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
  }
  public void show() {
      jf.setVisible(true);
  }
}

//抽象产品：植物类
interface Plant {
  public void show();
}

//具体产品：水果类
class Fruitage implements Plant {
  JScrollPane sp;
  JFrame jf = new JFrame("抽象工厂模式测试");
  public Fruitage() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("植物：水果"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/P_Fruitage.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
  }
  public void show() {
      jf.setVisible(true);
  }
}
//具体产品：蔬菜类
class Vegetables implements Plant {
  JScrollPane sp;
  JFrame jf = new JFrame("抽象工厂模式测试");
  public Vegetables() {
      Container contentPane = jf.getContentPane();
      JPanel p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.setBorder(BorderFactory.createTitledBorder("植物：蔬菜"));
      sp = new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1 = new JLabel(new ImageIcon("src/images/abstractFactory/P_Vegetables.jpg"));
      p1.add(l1);
      jf.pack();
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
  }
  public void show() {
      jf.setVisible(true);
  }
}

//抽象工厂：农场类
interface Farm {
  public Animal newAnimal();
  public Plant newPlant();
}

class SGfarm implements Farm {
  public Animal newAnimal() {
      System.out.println("新牛出生！");
      return new Cattle();
  }
  public Plant newPlant() {
      System.out.println("蔬菜长成！");
      return new Vegetables();
  }
}
//具体工厂：上饶农场类
class SRfarm implements Farm {
  public Animal newAnimal() {
      System.out.println("新马出生！");
      return new Horse();
  }
  public Plant newPlant() {
      System.out.println("水果长成！");
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
            System.out.println("新类名：" + cName);
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
