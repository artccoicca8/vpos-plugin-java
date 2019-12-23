package com.alignet.plugin;

import com.alignet.bean.VPOS20Bean;
import com.alignet.pasarela.crypto.CryptoUtil;
import com.alignet.plugin.exception.PlugInVPOSException;
import java.io.Reader;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.encoders.UrlBase64;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Receive20 {
	private AsymmetricKeyParameter BDWS;
	private AsymmetricKeyParameter addProduct;
	private String addTax;

	public Receive20(Reader reader, Reader reader1, String s) throws PlugInVPOSException {
		try {
			this.addProduct = Z.I(reader1);
			this.BDWS = Z.I(reader);
			this.addTax = s;
		} catch (Exception e) {
			throw new PlugInVPOSException("Error leyendo la llave Publica " + e);
		}
	}

	public final void execute(VPOS20Bean vpos20bean) throws PlugInVPOSException {
		if (vpos20bean == null) {
			throw new PlugInVPOSException("Error parametro VPOSBean es nulo");
		}
		String s = vpos20bean.getCipheredSessionKey();
		byte[] abyte0 = (byte[]) null;
		abyte0 = UrlBase64.decode(s);
		byte[] abyte1 = (byte[]) null;
		try {
			abyte1 = CryptoUtil.Z(abyte0, this.addProduct);
		} catch (Exception exception) {
			throw new PlugInVPOSException("Error desencriptando la llave de sesion", exception);
		}
		String s1 = vpos20bean.getCipheredXML();
		byte[] abyte2 = (byte[]) null;
		abyte2 = UrlBase64.decode(s1);
		byte[] abyte3 = Hex.decode(this.addTax);
		byte[] abyte4 = (byte[]) null;
		try {
			abyte4 = CryptoUtil.Z(abyte2, abyte1, abyte3);
		} catch (Exception exception1) {
			throw new PlugInVPOSException("Error desencriptando xml decodificado", exception1);
		}
		String s2 = vpos20bean.getCipheredSignature();
		byte[] abyte5 = (byte[]) null;
		abyte5 = UrlBase64.decode(s2);

		String s3 = new String(abyte4);
		vpos20bean.setClearXML(s3);
		BDWS(vpos20bean, s3);
	}

	private void BDWS(VPOS20Bean vpos20bean, String s) throws PlugInVPOSException {
		C c = new C(s);
		Element element = c.I();
		if (!element.getNodeName().equals("VPOSTransaction1.2")) {
			throw new PlugInVPOSException("El nodo raiz no corresponde con VPOSTransaction1.2");
		}
		NodeList nodelist = element.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			if (node.getNodeName().equals("products")) {
				NodeList nodelist1 = node.getChildNodes();
				for (int j = 0; j < nodelist1.getLength(); j++) {
					Node node2 = nodelist1.item(j);
					if (node2.getNodeName().equals("Product")) {
						NamedNodeMap namednodemap = node2.getAttributes();
						vpos20bean.addProduct(namednodemap.getNamedItem("productCode").getNodeValue(),
								namednodemap.getNamedItem("productItem").getNodeValue(),
								namednodemap.getNamedItem("productAmount").getNodeValue(),
								namednodemap.getNamedItem("productPromotionCode").getNodeValue());
					} else {

						throw new PlugInVPOSException("El nodo " + node2.getNodeName() + " no corresponde como hijo del nodo " + "products");
					}
				}
			} else if (node.getNodeName().equals("taxes")) {
				NodeList nodelist2 = node.getChildNodes();
				for (int k = 0; k < nodelist2.getLength(); k++) {
					Node node3 = nodelist2.item(k);
					if (node3.getNodeName().equals("Tax")) {
						NamedNodeMap namednodemap1 = node3.getAttributes();
						vpos20bean.addTax(namednodemap1.getNamedItem("name").getNodeValue(),
								namednodemap1.getNamedItem("amount").getNodeValue());
					} else {
						throw new PlugInVPOSException(
								"El nodo " + node3.getNodeName() + " no corresponde como hijo del nodo " + "taxes");
					}
				}
			} else if (node.getNodeName().equals("flight")) {
				NodeList nodelist2 = node.getChildNodes();
				for (int k = 0; k < nodelist2.getLength(); k++) {
					Node node3 = nodelist2.item(k);
					if (node3.getNodeName().equals("Flight")) {
						NamedNodeMap namednodemap1 = node3.getAttributes();
						vpos20bean.addFlight(namednodemap1.getNamedItem("flightAirlineCode").getNodeValue(),
								namednodemap1.getNamedItem("flightDepartureAirport").getNodeValue(),
								namednodemap1.getNamedItem("flightArriveAirport").getNodeValue(),
								namednodemap1.getNamedItem("flightDepartureDate").getNodeValue(),
								namednodemap1.getNamedItem("flightDepartureTime").getNodeValue(),
								namednodemap1.getNamedItem("flightArriveDate").getNodeValue(),
								namednodemap1.getNamedItem("flightArriveTime").getNodeValue(),
								namednodemap1.getNamedItem("flightReservation").getNodeValue(),
								namednodemap1.getNamedItem("flightDepartureIata").getNodeValue(),
								namednodemap1.getNamedItem("flightArriveIata").getNodeValue());
					} else {
						throw new PlugInVPOSException(
								"El nodo " + node3.getNodeName() + " no corresponde como hijo del nodo " + "Flight");
					}

				}

			} else if (node.getNodeName().equals("administrativeRate")) {
				NodeList nodelist2 = node.getChildNodes();
				if (nodelist2 != null) {
					for (int k = 0; k < nodelist2.getLength(); k++) {
						Node node3 = nodelist2.item(k);
						if (node3.getNodeName().equals("AdministrativeRate")) {
							NamedNodeMap namednodemap1 = node3.getAttributes();
							vpos20bean.addAdministrativeRate(
									namednodemap1.getNamedItem("administrativeRateAmount").getNodeValue(),
									namednodemap1.getNamedItem("administrativeRateIva").getNodeValue(),
									namednodemap1.getNamedItem("administrativeRateIvaReturn").getNodeValue(),
									namednodemap1.getNamedItem("administrativeRateCode").getNodeValue());
						} else {

							throw new PlugInVPOSException("El nodo " + node3.getNodeName()
									+ " no corresponde como hijo del nodo " + "administrativeRate");
						}

					}

				}
			} else if (node.getNodeName().equals("passenger")) {
				NodeList nodelist2 = node.getChildNodes();
				for (int k = 0; k < nodelist2.getLength(); k++) {
					Node node3 = nodelist2.item(k);
					if (node3.getNodeName().equals("Passenger")) {
						NamedNodeMap namednodemap1 = node3.getAttributes();
						vpos20bean.addPassenger(namednodemap1.getNamedItem("passengerFirstName").getNodeValue(),
								namednodemap1.getNamedItem("passengerLastName").getNodeValue(),
								namednodemap1.getNamedItem("passengerDocumentType").getNodeValue(),
								namednodemap1.getNamedItem("passengerDocumentNumber").getNodeValue(),
								namednodemap1.getNamedItem("passengerAgencyCode").getNodeValue());
					} else {
						throw new PlugInVPOSException(
								"El nodo " + node3.getNodeName() + " no corresponde como hijo del nodo " + "passenger");
					}
				}
			} else if (node.getNodeName().equals("good")) {
				NodeList nodelist2 = node.getChildNodes();
				for (int k = 0; k < nodelist2.getLength(); k++) {
					Node node3 = nodelist2.item(k);
					if (node3.getNodeName().equals("Good")) {
						NamedNodeMap namednodemap1 = node3.getAttributes();
						vpos20bean.addGood(namednodemap1.getNamedItem("goodName").getNodeValue(),
								namednodemap1.getNamedItem("goodDescription").getNodeValue(),
								namednodemap1.getNamedItem("goodQuantity").getNodeValue(),
								namednodemap1.getNamedItem("goodUnitprice").getNodeValue());
					} else {
						throw new PlugInVPOSException(
								"El nodo " + node3.getNodeName() + " no corresponde como hijo del nodo " + "good");
					}
				}
			} else if (node.getNodeName().equals("airport")) {
				NodeList nodelist2 = node.getChildNodes();
				for (int k = 0; k < nodelist2.getLength(); k++) {
					Node node3 = nodelist2.item(k);
					if (node3.getNodeName().equals("Airport")) {
						NamedNodeMap namednodemap1 = node3.getAttributes();
						vpos20bean.addAirport(namednodemap1.getNamedItem("airportCode").getNodeValue(),
								namednodemap1.getNamedItem("airportCity").getNodeValue(),
								namednodemap1.getNamedItem("airportCountry").getNodeValue());
					} else {
						throw new PlugInVPOSException(
								"El nodo " + node3.getNodeName() + " no corresponde como hijo del nodo " + "airport");
					}
				}
			} else {
				Node node1 = node.getFirstChild();
				if (node1 instanceof Text) {
					String s1 = ((Text) node1).getNodeValue();
					try {
						vpos20bean.getClass()
								.getMethod("set" + node.getNodeName().substring(0, 1).toUpperCase()
										+ node.getNodeName().substring(1), new Class[] { String.class })
								.invoke(vpos20bean, new Object[] { s1 });
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}
}
