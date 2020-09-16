package com.alignet.test;

import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alignet.bean.BeanConsulta;
import com.alignet.ws.vpos.result.SendWS;

public class WsTest {
	final static String VECTOR_INI = "aec811159abe0125";
	private static final Logger logger = LoggerFactory.getLogger(WsTest.class);

	public static void main(String[] args) {

		logger.info("");
		logger.info("LLego encripta ");
		logger.info(" =============== GenerarXML - Inicio =============== ");
		BeanConsulta bean = new BeanConsulta();
		bean.setAcquirerId("1");
		bean.setCommerceId("1809");
		bean.setNumOrder("11720201594495367");

		try {

			FileReader r1 = new FileReader("D:/Llaves/llavesAlignet2/LLAVE.VPOS.CRB.CRYPTO.1024.PKCS1_NET.txt");// ok
			FileReader r2 = new FileReader("D:/Llaves/llavesComercio/PrivadasComercioLlavedeFirma.txt"); // 10013003
			SendWS sendWS = new SendWS(r1, r2, VECTOR_INI);
			sendWS.execute(bean); 
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("XML ENCRIPTADO  :" + bean.getCipheredXML());
		logger.info("CIPHERED SIGNATUE  :" + bean.getCipheredSignature());
		logger.info("LLAVE DE SESSION ENCRIPTADA   :" + bean.getCipheredSessionKey());

	}
}
