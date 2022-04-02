package designMode;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoadXMLUtil {

	public static Object getObject(String xmlName, String pathName) {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src/config/" + xmlName));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = pathName + classNode.getNodeValue();
            System.out.println("ÐÂÀàÃû£º" + cName);
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
