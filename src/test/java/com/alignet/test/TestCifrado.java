package com.alignet.test;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alignet.bean.VPOS20Bean;
import com.alignet.plugin.Send20;
import com.alignet.plugin.exception.InvalidVPOSParameterException;
import com.alignet.plugin.exception.PlugInVPOSException;

public class TestCifrado {

	final static String VECTOR_INI = "aec811159abe0125";
	private static final Logger logger = LoggerFactory.getLogger(TestCifrado.class);


	public static void main(String[] args) {
		logger.info("");
		logger.info("LLego encripta ");
		logger.info(" =============== GenerarXML - Inicio =============== ");
		VPOS20Bean vPOSBean = new VPOS20Bean();

		try {

//			String operationNumber = "999895478";
			String operationNumber = new Long(System.currentTimeMillis()).toString().substring(4);
			logger.info("**** NUMERO DE OPERACION   : " + operationNumber);

			vPOSBean.setAcquirerId("1");
			vPOSBean.setCommerceId("1809");
			vPOSBean.setPurchaseOperationNumber(operationNumber);
			vPOSBean.setPurchaseAmount("10000");
			vPOSBean.setPurchaseCurrencyCode("170");
			vPOSBean.setPurchaseTerminalCode("2907891");
			vPOSBean.setPurchasePlanId("01");
			vPOSBean.setPurchaseQuotaId("001");
//			vPOSBean.setPurchaseShippingCharges((String) h.get("PurchaseShippingCharges"));

//			if (!((String) h.get("PurchaseShipperCode")).equals("")) {
//				vPOSBean.setPurchaseShipperCode((String) h.get("PurchaseShipperCode"));
//			}
//			if (!((String) h.get("PurchaseIva")).equals("")) {
			vPOSBean.setPurchaseIva("100");
			vPOSBean.setPurchaseIvaReturn("200");
			vPOSBean.setPurchaseLanguage("SP");
//			}
//			if (!((String) h.get("PurchaseIvaReturn")).equals("")) {
			
//			}
			
//			if (!((String) h.get("PurchaseIpAddress")).equals("")) {
			vPOSBean.setPurchaseIpAddress("172.19.44.54");
//			}
			vPOSBean.setBillingFirstName("Pablo");
			vPOSBean.setBillingLastName("Barrientos");
			vPOSBean.setBillingCountry("PE");
			vPOSBean.setBillingCity("Lima");
			vPOSBean.setBillingEmail("raul.barrientos@alignet.com");
			vPOSBean.setBillingPhoneNumber("016109500");
			vPOSBean.setBillingCelPhoneNumber("999999999");
			vPOSBean.setBillingGender("M");
			vPOSBean.setBillingAddress("Av Casimiro Ulloa 333");

			vPOSBean.setBillingState("Estado XYZ");
			vPOSBean.setBillingPostalCode("0001");

//			vPOSBean.setShippingState("Estado XYZ");
//			vPOSBean.setShippingPostalCode("0001");

			vPOSBean.setBillingBirthday("2012-04-03");
//			if (!((String) h.get("BillingOutIdentifierCity")).equals("")) {
//				vPOSBean.setBillingOutIdentifierCity((String) h.get("BillingOutIdentifierCity"));
//			}
//			if (!((String) h.get("BillingDateIdentifierDate")).equals("")) {
			vPOSBean.setBillingDateIdentifierDate("2013-02-11");
//			}
//			if (!((String) h.get("BillingNationality")).equals("")) {
			vPOSBean.setBillingNationality("PE");
//			}

			vPOSBean.setShippingCountry("CO");
			vPOSBean.setShippingCity("Bogota");
			vPOSBean.setShippingAddress("Jr. Carabelli");

//			if (!((String) h.get("ShippingReceptionMethod")).equals("")) {
//				vPOSBean.setShippingReceptionMethod((String) h.get("ShippingReceptionMethod"));
//			}
			vPOSBean.setShippingReceiverName("Rigoberto");
			vPOSBean.setShippingReceiverLastName("Pineda");

//			if (!((String) h.get("ShippingReceiverIdentifier")).equals("")) {
//				vPOSBean.setShippingReceiverIdentifier((String) h.get("ShippingReceiverIdentifier"));
//			}
//			if (!((String) h.get("TransactionTrace")).equals("")) {
				vPOSBean.setTransactionTrace("PC");
//			}
//			if (!((String) h.get("FingerPrint")).equals("")) {
//				vPOSBean.setFingerPrint((String) h.get("FingerPrint"));
////			}
			vPOSBean.setAdditionalObservations("cafe");

			// vPOSBean.addTax((String)h.get("TaxName1"), (String)h.get("TaxAmount1"));

//			logger.info("tax " + (String) h.get("TaxName2") + " /monto " + (String) h.get("TaxAmount2"));
			vPOSBean.addTax("IAC", "100");
			// vPOSBean.addTax("TASA_AERO", "500");

//			vPOSBean.addFlight((String)h.get("FlightAirlineCode"),(String)h.get("FlightDepartureAirport"), 
//            (String)h.get("FlightArriveAirport"), (String)h.get("FlightDepartureDate"), 
//            (String)h.get("FlightDepartureTime"), (String)h.get("FlightArriveDate"), 
//            (String)h.get("FlightArriveTime"), (String)h.get("FlightReservation"),"","");
//			
//				
//			if(!((String)h.get("AirportCodeDeparture")).equals("")){
//				vPOSBean.addAirport((String)h.get("AirportCodeDeparture"), (String)h.get("AirportCityDeparture"), 
//            	(String)h.get("AirportCountryDeparture"));
//			}
//			if(!((String)h.get("AirportCodeArrive")).equals("")){
//				vPOSBean.addAirport((String)h.get("AirportCodeArrive"), (String)h.get("AirportCityArrive"), 
//            	(String)h.get("AirportCountryArrive"));
//			}
//			if(!((String)h.get("PassengerFirstName")).equals("")||!((String)h.get("PassengerLastName")).equals("")){
//				vPOSBean.addPassenger((String)h.get("PassengerFirstName"), (String)h.get("PassengerLastName"), 
//            	(String)h.get("PassengerDocumentType"), (String)h.get("PassengerDocumentNumber"),
//            	(String)h.get("PassengerAgencyCode"));
//			}
//			if (!((String) h.get("GoodName")).equals("")) {
//				vPOSBean.addGood((String) h.get("GoodName"), (String) h.get("GoodDescription"),
//						(String) h.get("GoodQuantity"), (String) h.get("GoodUnitprice"));
//			}

//			vPOSBean.addProduct((String) h.get("ProductItem"), (String) h.get("ProductCode"),
//					(String) h.get("ProductAmount"), (String) h.get("ProductPromotionCode"));

//			vPOSBean.addAdministrativeRate((String) h.get("AdministrativeRateAmount"),
//					(String) h.get("AdministrativeRateIva"), (String) h.get("AdministrativeRateIvaReturn"),
//					(String) h.get("AdministrativeRateCode"));

//			if (!((String) h.get("Reserved1")).equals("")) {
//				vPOSBean.setReserved1((String) h.get("Reserved1"));
//			}
//			if (!((String) h.get("Reserved2")).equals("")) {
//				vPOSBean.setReserved2((String) h.get("Reserved2"));
//			}
//			if (!((String) h.get("Reserved3")).equals("")) {
//				vPOSBean.setReserved3((String) h.get("Reserved3"));
//			}
//			if (!((String) h.get("Reserved4")).equals("")) {
//				vPOSBean.setReserved4((String) h.get("Reserved4"));
//			}
//			if (!((String) h.get("Reserved5")).equals("")) {
//				vPOSBean.setReserved5((String) h.get("Reserved5"));
//			}
		} catch (InvalidVPOSParameterException e) {
			e.printStackTrace();
		}

		try {
			FileReader r1 = null;
			FileReader r2 = null;

			r1 = new FileReader("D:/Llaves/llavesAlignet2/LLAVE.VPOS.CRB.CRYPTO.1024.PKCS1_NET.txt");// ok
			r2 = new FileReader("D:/Llaves/llavesComercio/PrivadasComercioLlavedeFirma.txt"); // 10013003

//			r1 = new FileReader(ruta+ "/WEB-INF/llavesAlignet2/LLAVE.VPOS.CRB.CRYPTO.1024.PKCS1.txt");//ok 
//			r2 = new FileReader(ruta+ "/WEB-INF/llavesComercio/LLAVE_FIRM_PRIV.txt");	//	10013003

			Send20 send = new Send20(r1, r2, VECTOR_INI);
			send.execute(vPOSBean);
		} catch (PlugInVPOSException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		logger.info("XML ENCRIPTADO  :" + vPOSBean.getCipheredXML());
		logger.info("CIPHERED SIGNATUE  :" + vPOSBean.getCipheredSignature());
		logger.info("LLAVE DE SESSION ENCRIPTADA   :" + vPOSBean.getCipheredSessionKey());
//		Hashtable ht = new Hashtable();
//		ht.put("AcquirerId", (String) h.get("AcquirerId"));
//		ht.put("CommerceId", (String) h.get("CommerceId"));
//		ht.put("XML", vPOSBean.getCipheredXML());
//		ht.put("SIGNATURE", vPOSBean.getCipheredSignature());
//		ht.put("SESSIONKEY", vPOSBean.getCipheredSessionKey());
		logger.info(" =============== GenerarXML - Fin =============== ");
	}

}
