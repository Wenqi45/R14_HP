package ca.sogica.corelibrary;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLUtil {
	
	public static boolean xmlXSDValidation(String xlm, String xsd) {
		File xsdFile=new File("C:\\temp\\test\\Validator\\a.xsd");
		File xmlFile= new File("C:\\temp\\test\\Validator\\a.xml");
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema;
		try {
			schema = factory.newSchema(new StreamSource(xsdFile));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(xmlFile));
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		System.out.println("This is validated!");
        return true;
		
	}
	//use DOM or SAX 
	public static void getValueFromXml() {
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			}

}
