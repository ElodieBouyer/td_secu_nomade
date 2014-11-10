package xml;

import org.xml.sax.*;
import org.xml.sax.helpers.LocatorImpl;

public class ActivitiesHandler implements ContentHandler {

	public ActivitiesHandler() {
		super();
		locator = new LocatorImpl();
	}

	public void setDocumentLocator(Locator value) {
		locator = value;
	}

	public void startDocument() throws SAXException {
		System.out.println("Debut de l'analyse du document");
	}

	public void endDocument() throws SAXException {
		System.out.println("Fin de l'analyse du document");
	}

	public void startPrefixMapping(String prefix, String URI)
			throws SAXException {
		System.out.println("Traitement de l'espace de nommage : " + URI
				+ ", prefixe choisi : " + prefix);
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("Fin de traitement de l'espace de nommage : "
				+ prefix);
	}

	public void startElement(String nameSpaceURI, String localName,
			String rawName, Attributes attributs) throws SAXException {
		System.out.println("Ouverture de la balise : " + localName);

		if (!"".equals(nameSpaceURI)) {
			System.out.println("  appartenant a l'espace de nom : "
					+ nameSpaceURI);
		}

		System.out.println("  Attributs de la balise : ");

		for (int index = 0; index < attributs.getLength(); index++) {
			System.out.println("     - " + attributs.getLocalName(index)
					+ " = " + attributs.getValue(index));
		}
	}

	public void endElement(String nameSpaceURI, String localName, String rawName)
			throws SAXException {
		System.out.print("Fermeture de la balise : " + localName);

		if (!"".equals(nameSpaceURI)) {
			System.out
					.print("appartenant a l'espace de nommage : " + localName);
		}

		System.out.println();
	}

	public void characters(char[] ch, int start, int end) throws SAXException {
		System.out.println("#PCDATA : " + new String(ch, start, end));
	}

	public void ignorableWhitespace(char[] ch, int start, int end)
			throws SAXException {
		System.out.println("espaces inutiles rencontres : ..."
				+ new String(ch, start, end) + "...");
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
		System.out.println("Instruction de fonctionnement : " + target);
		System.out.println("  dont les arguments sont : " + data);
	}

	public void skippedEntity(String arg0) throws SAXException {
		// Je ne fais rien, ce qui se passe n'est pas franchement normal.
		// Pour eviter cet evenement, le mieux est quand meme de specifier une
		// DTD pour vos
		// documents XML et de les faire valider par votre parser.
	}

	private Locator locator;

}