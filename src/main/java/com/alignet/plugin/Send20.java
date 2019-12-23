package com.alignet.plugin;

import com.alignet.bean.AdministrativeRate;
import com.alignet.bean.Airport;
import com.alignet.bean.Flight;
import com.alignet.bean.Good;
import com.alignet.bean.Passenger;
import com.alignet.bean.Product;
import com.alignet.bean.Tax;
import com.alignet.bean.VPOS20Bean;
import com.alignet.pasarela.crypto.CryptoUtil;
import com.alignet.plugin.exception.PlugInVPOSException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Vector;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.encoders.UrlBase64;
import org.w3c.dom.Element;

public class Send20 {
	private AsymmetricKeyParameter BDWS;
	private AsymmetricKeyParameter addElement;
	private String append;

	public Send20(Reader reader, Reader reader1, String s) throws PlugInVPOSException {
		try {
			this.addElement = Z.I(reader1);
			this.BDWS = Z.I(reader);
			this.append = s;
		} catch (Exception e) {
			throw new PlugInVPOSException("Error leyendo la llave Publica", e);
		}
	}

	private void BDWS(VPOS20Bean vpos20bean) throws PlugInVPOSException {
		vpos20bean.setAcquirerId(vpos20bean.getAcquirerId());
		vpos20bean.setCommerceId(vpos20bean.getCommerceId());
		vpos20bean.setPurchaseAmount(vpos20bean.getPurchaseAmount());
		vpos20bean.setPurchaseCurrencyCode(vpos20bean.getPurchaseCurrencyCode());
		vpos20bean.setPurchaseOperationNumber(vpos20bean.getPurchaseOperationNumber());
	}

	public final void execute(VPOS20Bean vpos20bean) throws PlugInVPOSException {
		if (vpos20bean == null) {
			throw new PlugInVPOSException("Error parametro VPOSBean es nulo");
		}
		BDWS(vpos20bean);
		byte[] abyte0 = CryptoUtil.I();
		byte[] abyte1 = (byte[]) null;
		try {
			abyte1 = CryptoUtil.I(abyte0, this.BDWS);
		} catch (Exception exception) {
			throw new PlugInVPOSException("Error encriptando la llave de sesion", exception);
		}
		String s = null;
		s = new String(UrlBase64.encode(abyte1));
		vpos20bean.setCipheredSessionKey(s);
		String s1 = addElement(vpos20bean);
		byte[] abyte2 = (byte[]) null;
		try {
			abyte2 = s1.getBytes("UTF-8");
		} catch (UnsupportedEncodingException unsupportedencodingexception) {
			throw new PlugInVPOSException("Error codificando xml claro", unsupportedencodingexception);
		}
		byte[] abyte3 = Hex.decode(this.append);
		byte[] abyte4 = (byte[]) null;
		try {
			abyte4 = CryptoUtil.I(abyte2, abyte0, abyte3);
		} catch (Exception exception1) {
			throw new PlugInVPOSException("Error encriptando xml codificado", exception1);
		}
		String s2 = null;
		s2 = new String(UrlBase64.encode(abyte4));
		vpos20bean.setCipheredXML(s2);
		String s3 = null;
		try {
			s3 = new String(UrlBase64.encode(CryptoUtil.C(abyte2, this.addElement)));
		} catch (Exception exception2) {
			throw new PlugInVPOSException("Error firmando", exception2);
		}
		vpos20bean.setCipheredSignature(s3);
	}

	private static String addElement(VPOS20Bean vpos20bean) throws PlugInVPOSException {
		C c = new C();
		Element element = c.I("VPOSTransaction1.2");
		Field[] afield = vpos20bean.getClass().getDeclaredFields();
		for (int i = 0; i < afield.length; i++) {
			Field field = afield[i];
			int j = field.getModifiers();
			if (Modifier.isPrivate(j) && !Modifier.isStatic(j) && !contains.contains(field.getName())) {
				Object obj = null;
				if (field.getName().equals("products")) {
					Element element1 = c.I(element, "products");
					Vector<Product> vector = (Vector) vpos20bean.getProducts();
					if (vector != null) {
						for (int k = 0; k < vector.size(); k++) {
							Product product = vector.elementAt(k);
							Element element3 = c.I(element1, "Product");
							element3.setAttribute("productCode", product.getProductCode());
							element3.setAttribute("productItem", product.getProductItem());
							element3.setAttribute("productAmount", product.getProductAmount());
							element3.setAttribute("productPromotionCode", product.getProductPromotionCode());
						}
					}
				} else if (field.getName().equals("taxes")) {
					Element element2 = c.I(element, "taxes");
					Vector<Tax> vector1 = (Vector) vpos20bean.getTaxes();
					if (vector1 != null) {
						for (int l = 0; l < vector1.size(); l++) {
							Tax tax = vector1.elementAt(l);
							Element element4 = c.I(element2, "Tax");
							element4.setAttribute("name", tax.getName());
							element4.setAttribute("amount", tax.getAmount());
						}

					}
				} else if (field.getName().equals("flight")) {
					Element element2 = c.I(element, "flight");
					Vector<Flight> vector1 = (Vector) vpos20bean.getFlight();
					if (vector1 != null) {
						for (int l = 0; l < vector1.size(); l++) {
							Flight flight = vector1.elementAt(l);
							Element element4 = c.I(element2, "Flight");
							element4.setAttribute("flightAirlineCode", flight.getFlightAirlineCode());
							element4.setAttribute("flightDepartureAirport", flight.getFlightDepartureAirport());
							element4.setAttribute("flightArriveAirport", flight.getFlightArriveAirport());
							element4.setAttribute("flightDepartureDate", flight.getFlightDepartureDate());
							element4.setAttribute("flightDepartureTime", flight.getFlightDepartureTime());
							element4.setAttribute("flightArriveDate", flight.getFlightArriveDate());
							element4.setAttribute("flightArriveTime", flight.getFlightArriveTime());
							element4.setAttribute("flightReservation", flight.getFlightReservation());
							element4.setAttribute("flightDepartureIata", flight.getFlightDepartureIata());
							element4.setAttribute("flightArriveIata", flight.getFlightArriveIata());
						}

					}
				} else if (field.getName().equals("administrativeRate")) {
					Element element2 = c.I(element, "administrativeRate");
					Vector<AdministrativeRate> vector1 = (Vector) vpos20bean.getAdministrativeRate();
					if (vector1 != null) {
						for (int l = 0; l < vector1.size(); l++) {
							AdministrativeRate admRate = vector1.elementAt(l);
							Element element4 = c.I(element2, "AdministrativeRate");
							element4.setAttribute("administrativeRateAmount", admRate.getAdministrativeRateAmount());
							element4.setAttribute("administrativeRateIva", admRate.getAdministrativeRateIva());
							element4.setAttribute("administrativeRateIvaReturn",
									admRate.getAdministrativeRateIvaReturn());
							element4.setAttribute("administrativeRateCode", admRate.getAdministrativeRateCode());

						}

					}
				} else if (field.getName().equals("passenger")) {
					Element element2 = c.I(element, "passenger");
					Vector<Passenger> vector1 = (Vector) vpos20bean.getPassenger();
					if (vector1 != null) {
						for (int l = 0; l < vector1.size(); l++) {
							Passenger pass = vector1.elementAt(l);
							Element element4 = c.I(element2, "Passenger");
							element4.setAttribute("passengerFirstName", pass.getPassengerFirstName());
							element4.setAttribute("passengerLastName", pass.getPassengerLastName());
							element4.setAttribute("passengerDocumentType", pass.getPassengerDocumentType());
							element4.setAttribute("passengerDocumentNumber", pass.getPassengerDocumentNumber());
							element4.setAttribute("passengerAgencyCode", pass.getPassengerAgencyCode());
						}
					}
				} else if (field.getName().equals("good")) {
					Element element2 = c.I(element, "good");
					Vector<Good> vector1 = (Vector) vpos20bean.getGood();
					if (vector1 != null) {
						for (int l = 0; l < vector1.size(); l++) {
							Good good = vector1.elementAt(l);
							Element element4 = c.I(element2, "Good");
							element4.setAttribute("goodName", good.getGoodName());
							element4.setAttribute("goodDescription", good.getGoodDescription());
							element4.setAttribute("goodQuantity", good.getGoodQuantity());
							element4.setAttribute("goodUnitprice", good.getGoodUnitprice());
						}
					}
				} else if (field.getName().equals("airport")) {
					Element element2 = c.I(element, "airport");
					Vector<Airport> vector1 = (Vector) vpos20bean.getAirport();
					if (vector1 != null) {
						for (int l = 0; l < vector1.size(); l++) {
							Airport air = vector1.elementAt(l);
							Element element4 = c.I(element2, "Airport");
							element4.setAttribute("airportCode", air.getAirportCode());
							element4.setAttribute("airportCity", air.getAirportCity());
							element4.setAttribute("airportCountry", air.getAirportCountry());
						}
					}
				} else {
					Object obj1;
					try {
						obj1 = vpos20bean.getClass().getMethod(
								"get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
								null).invoke(vpos20bean, null);
					} catch (Exception exception) {
						PlugInVPOSException pluginvposexception = new PlugInVPOSException(
								"Error al convertir el bean del VPOS en XML");
						throw pluginvposexception;
					}
					if (obj1 != null) {
						c.I(element, field.getName(), obj1.toString());
					}
				}
			}
		}
		String s = "";
		try {
			s = c.Z();
		} catch (Exception e) {
			throw new PlugInVPOSException("Error de creacion de XML en cadena", e);
		}
		return s;
	}

	private static final Vector contains = new Vector();
	static {
		contains.addElement("validSign");
		contains.addElement("cipheredSessionKey");
		contains.addElement("cipheredXML");
		contains.addElement("cipheredSignature");
		contains.addElement("clearXML");
	}
}
