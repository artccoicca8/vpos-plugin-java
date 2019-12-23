package com.alignet.plugin;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class I {

	private static String BDWS = "UTF8";
	private static String[] append = new String[] { "Default", "UTF-8", "US-ASCII", "ISO-8859-1", "ISO-8859-2",
			"ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9",
			"ISO-2022-JP", "SHIFT_JIS", "EUC-JP", "GB2312", "BIG5", "EUC-KR", "ISO-2022-KR", "KOI8-R", "EBCDIC-CP-US",
			"EBCDIC-CP-CA", "EBCDIC-CP-NL", "EBCDIC-CP-DK", "EBCDIC-CP-NO", "EBCDIC-CP-FI", "EBCDIC-CP-SE",
			"EBCDIC-CP-IT", "EBCDIC-CP-ES", "EBCDIC-CP-GB", "EBCDIC-CP-FR", "EBCDIC-CP-AR1", "EBCDIC-CP-HE",
			"EBCDIC-CP-CH", "EBCDIC-CP-ROECE", "EBCDIC-CP-YU", "EBCDIC-CP-IS", "EBCDIC-CP-AR2", "UTF-16" };
	protected PrintWriter charAt;
	protected StringWriter compareTo;
	protected boolean equalsIgnoreCase;

	public I(boolean flag) {
		this.compareTo = new StringWriter();
		this.charAt = new PrintWriter(this.compareTo);
		this.equalsIgnoreCase = flag;
	}

	public static final String BDWS() {
		return BDWS;
	}

	public final void I(Node node) {
		String s1;
		int i;
		NodeList nodelist1;
		Attr[] aattr;
		if (node == null)
			return;
		short word0 = node.getNodeType();
		switch (word0) {
		case 9:
			if (!this.equalsIgnoreCase) {
				String s = BDWS();
				if (s.equalsIgnoreCase("DEFAULT")) {
					s = "UTF-8";
				} else if (s.equalsIgnoreCase("Unicode")) {
					s = "UTF-16";
				}
				this.charAt.println("<?xml version=\"1.0\" encoding=\"" + s + "\"?>");
			}
			I(((Document) node).getDocumentElement());
			this.charAt.flush();
			break;

		case 1:
			this.charAt.print('<');
			this.charAt.print(node.getNodeName());
			aattr = append(node.getAttributes());
			for (i = 0; i < aattr.length; i++) {
				Attr attr = aattr[i];
				this.charAt.print(' ');
				this.charAt.print(attr.getNodeName());
				this.charAt.print("=\"");
				this.charAt.print(charAt(attr.getNodeValue()));
				this.charAt.print('"');
			}

			this.charAt.print('>');
			nodelist1 = node.getChildNodes();
			if (nodelist1 != null) {
				int k = nodelist1.getLength();
				for (int i1 = 0; i1 < k; i1++) {
					I(nodelist1.item(i1));
				}
			}
			break;
		case 5:
			if (this.equalsIgnoreCase) {
				NodeList nodelist = node.getChildNodes();
				if (nodelist != null) {

					int j = nodelist.getLength();
					for (int l = 0; l < j; l++)
						I(nodelist.item(l));
				}
				break;
			}
			this.charAt.print('&');
			this.charAt.print(node.getNodeName());
			this.charAt.print(';');
			break;

		case 4:
			if (this.equalsIgnoreCase) {
				this.charAt.print(charAt(node.getNodeValue()));
				break;
			}
			this.charAt.print("<![CDATA[");
			this.charAt.print(node.getNodeValue());
			this.charAt.print("]]>");
			break;

		case 3:
			this.charAt.print(charAt(node.getNodeValue()));
			break;
		case 7:
			this.charAt.print("<?");
			this.charAt.print(node.getNodeName());
			s1 = node.getNodeValue();
			if (s1 != null && s1.length() > 0) {
				this.charAt.print(' ');
				this.charAt.print(s1);
			}
			this.charAt.print("?>");
			break;
		}
		if (word0 == 1) {
			this.charAt.print("</");
			this.charAt.print(node.getNodeName());
			this.charAt.print('>');
		}
		this.charAt.flush();
	}

	protected final Attr[] append(NamedNodeMap namednodemap) {
		int i = (namednodemap == null) ? 0 : namednodemap.getLength();
		Attr[] aattr = new Attr[i];
		for (int j = 0; j < i; j++) {
			aattr[j] = (Attr) namednodemap.item(j);
		}
		for (int k = 0; k < i - 1; k++) {
			String s = aattr[k].getNodeName();
			int l = k;
			for (int i1 = k + 1; i1 < i; i1++) {
				String s1 = aattr[i1].getNodeName();
				if (s1.compareTo(s) < 0) {
					s = s1;
					l = i1;
				}
			}

			if (l != k) {
				Attr attr = aattr[k];
				aattr[k] = aattr[l];
				aattr[l] = attr;
			}
		}

		return aattr;
	}

	protected final String charAt(String s) {
		StringBuffer stringbuffer = new StringBuffer();
		int i = (s == null) ? 0 : s.length();
		for (int j = 0; j < i; j++) {
			char c = s.charAt(j);
			switch (c) {
			case '<':
				stringbuffer.append("&lt;");
				break;

			case '>':
				stringbuffer.append("&gt;");
				break;

			case '&':
				stringbuffer.append("&amp;");
				break;

			case '"':
				stringbuffer.append("&quot;");
				break;

			case '\n':
			case '\r':
				if (this.equalsIgnoreCase) {

					stringbuffer.append("&#");
					stringbuffer.append(Integer.toString(c));
					stringbuffer.append(';');
					break;
				}

			default:
				stringbuffer.append(c);
				break;
			}

		}
		return stringbuffer.toString();
	}

	public final String I() {
		if (this.compareTo != null) {
			return this.compareTo.getBuffer().toString();
		}
		return null;
	}

}
