package xml;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Parser {
	public Parser(String uri, ActivitiesHandler handler)
			throws SAXException, IOException {
		XMLReader saxReader = XMLReaderFactory
				.createXMLReader("org.apache.xerces.parsers.SAXParser");
		saxReader.setContentHandler(handler);
		saxReader.parse(uri);
	}
}
