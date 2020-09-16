package com.alignet.ws.vpos.result;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.xml.ws.Holder;

import com.alignet.bean.BeanConsulta;
import com.alignet.plugin.exception.PlugInVPOSException;
import com.alignet.ws.vposClient.VPOS2RESULTTX;
import com.alignet.ws.vposClient.VPOS2RESULTTXSOAP;

public class ConsultaEstadoTransacciones {

	public BeanConsulta consultaEstadoTx(String acquirerId, String commerceId, String numOrden,
			String rutaLlavePubCifrado, String rutaLlavePrivFirma, String rutaLlavePubFirma,
			String rutaLlavePrivCifrado, String rutaWebService, String vectorInitial) {

		BeanConsulta bean = new BeanConsulta();
		bean.setAcquirerId(acquirerId);
		bean.setCommerceId(commerceId);
		bean.setNumOrder(numOrden);

		try {
			FileReader r1 = null;
			FileReader r2 = null;

			r1 = new FileReader(rutaLlavePubCifrado);
			r2 = new FileReader(rutaLlavePrivFirma);
			System.out.println("**********Iniciando el plugin**********");
			SendWS send = new SendWS(r1, r2, vectorInitial);
			System.out.println("********** Cifrando y Firmando el Bean Consulta Trx ...");
			send.execute(bean);
		} catch (PlugInVPOSException e) {
			System.out.println("Excepcion " + e);
		} catch (FileNotFoundException e) {
			System.out.println("Excepcion " + e);
		}

		Holder<String> acqId = new Holder<>();
		acqId.value = bean.getAcquirerId();

		Holder<String> ecoId = new Holder<>();
		ecoId.value = bean.getCommerceId();

		String cipheXml = bean.getCipheredXML();

		Holder<String> cipheSing = new Holder<>();
		cipheSing.value = bean.getCipheredSignature();

		Holder<String> cipheSess = new Holder<>();
		cipheSess.value = bean.getCipheredSessionKey();

		Holder<String> cipheXmlRes = new Holder<>();

		try {
			URL url = new URL(rutaWebService);
			VPOS2RESULTTXSOAP vpos2resulttxsoap = new VPOS2RESULTTXSOAP(url);
			VPOS2RESULTTX vpos2resulttx = vpos2resulttxsoap.getVPOS2RESULTTXSOAP();

			System.out.println("********** Enviado consulta por WS ...");
			vpos2resulttx.search(acqId, ecoId, cipheXml, cipheSing, cipheSess, cipheXmlRes);
			System.out.println("********** Respuesta desde WS Ok ...");
		} catch (Exception e) {
			System.out.println("Ocurrio un Error " + e);
			e.printStackTrace();
		}

		BeanConsulta beanC = new BeanConsulta();
		beanC.setCipheredSessionKey(cipheSess.value);
		beanC.setCipheredXML(cipheXmlRes.value);
		beanC.setCipheredSignature(cipheSing.value);
		FileReader r1 = null;
		FileReader r5 = null;

		try {
			r1 = new FileReader(rutaLlavePubFirma);
			r5 = new FileReader(rutaLlavePrivCifrado);
			ReceiveWS receive = new ReceiveWS(r1, r5, vectorInitial);
			System.out.println("********** Descinfrando la respuesta enviada ...");
			receive.execute(beanC);
		} catch (PlugInVPOSException e) {
			System.out.println("Excepcion" + e);
		} catch (FileNotFoundException e) {
			System.out.println("Excepcion" + e);
		} finally {
			if (r1 != null) {
				try {
					r1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (r5 != null) {
				try {
					r5.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return beanC;
	}
}
