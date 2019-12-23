package com.alignet.plugin;

import com.alignet.plugin.exception.PlugInVPOSException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class C {
	private Document BDWS;

	public C() {
		this.BDWS = BDWS();
	}

	public C(String paramString) {
		this.BDWS = appendChild(paramString);
	}

	public final Element I(String paramString) {
		Element localElement = this.BDWS.createElement(paramString);
		this.BDWS.appendChild(localElement);
		return localElement;
	}

	public final Element I() {
		Element localElement = this.BDWS.getDocumentElement();
		return localElement;
	}

	public final Element I(Element paramElement, String paramString) {
		Element localElement = this.BDWS.createElement(paramString);
		paramElement.appendChild(localElement);
		return localElement;
	}

	public final Element I(Element paramElement, String paramString1, String paramString2) {
		Element localElement = this.BDWS.createElement(paramString1);
		paramElement.appendChild(localElement);
		if (paramString2 != null && !paramString2.equals("")) {
			Text localText = this.BDWS.createTextNode(paramString2);
			localElement.appendChild(localText);
		}
		return localElement;
	}

	private Document BDWS() {
		Document localDocument = null;
		try {
			DocumentBuilder localDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			localDocument = localDocumentBuilder.newDocument();
		} catch (ParserConfigurationException localParserConfigurationException) {
			System.out.println(localParserConfigurationException.getMessage());
		}
		return localDocument;
	}

	private Document appendChild(String paramString) {
		Document localDocument = null;
		StringReader localStringReader = new StringReader(paramString);
		InputSource localInputSource = new InputSource(localStringReader);
		DOMParser localDOMParser = new DOMParser();
		try {
			localDOMParser.parse(localInputSource);
		} catch (Exception localException) {
			PlugInVPOSException localPlugInVPOSException = new PlugInVPOSException("Error al parsear", localException);
			throw localPlugInVPOSException;
		}
		localDocument = localDOMParser.getDocument();
		return localDocument;
	}

	public final String Z() {
		I localI = new I(true);
		localI.I(this.BDWS);
		return localI.I();
	}
}