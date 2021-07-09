/**
 * 
 */
package in.javakids.util;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author Shashidhara ML
 *
 */
public class XPathUtility {
	
	public static Document getDocument(InputStream fileStream) {
		Document doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;

	}

	public static XPath getXPath(Document doc) {
		XPath xpath = null;
		try {
			XPathFactory xpathfactory = XPathFactory.newInstance();
			xpath = xpathfactory.newXPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xpath;

	}
	
	public static void getValue(String xmlPath,XPath xpath,Document doc) {
		 try {
			 XPathExpression expr = xpath.compile(xmlPath);
		        Object result = expr.evaluate(doc, XPathConstants.NODESET);
		        NodeList nodes = (NodeList) result;
		        for (int i = 0; i < nodes.getLength(); i++) {
		            System.out.println(nodes.item(i).getNodeValue());
		        }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
