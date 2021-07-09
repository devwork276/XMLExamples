/**
 * 
 */
package in.javakids.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;

import in.javakids.util.XPathUtility;

/**
 * @author Shashidhara ML
 *
 */
public class XMLParseUsingXPath {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(
				"C:\\System Design\\microservices\\workspaces\\XMLXPathExample\\src\\in\\javakids\\test\\test.xml");
		Document doc = XPathUtility.getDocument(inputStream);
		XPath xpath = XPathUtility.getXPath(doc);
		// Prints Title of All Book nodes
		XPathUtility.getValue("//book/title/text()", xpath, doc);
		// Prints Title of First Book node
		XPathUtility.getValue("//book[1]/title/text()", xpath, doc);
	}
}
