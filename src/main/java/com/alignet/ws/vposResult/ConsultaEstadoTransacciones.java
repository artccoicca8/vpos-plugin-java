package com.alignet.ws.vposResult;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
			String vectorI = "";

			r1 = new FileReader(rutaLlavePubCifrado);
			r2 = new FileReader(rutaLlavePrivFirma);
			vectorI = vectorInitial;
			System.out.println("**********Iniciando el plugin**********");
			SendWS send = new SendWS(r1, r2, vectorI);
			System.out.println("********** Cifrando y Firmando el Bean Consulta Trx ...");
			send.execute(bean);
		} catch (PlugInVPOSException e) {
			System.out.println("Excepcion " + e);
		} catch (FileNotFoundException e) {
			System.out.println("Excepcion " + e);
		}

		Holder<String> acqId = new Holder<String>();
		acqId.value = bean.getAcquirerId();

		Holder<String> ecoId = new Holder<String>();
		ecoId.value = bean.getCommerceId();

		Holder<String> cipheXml = new Holder<String>();
		cipheXml.value = bean.getCipheredXML();

		Holder<String> cipheSing = new Holder<String>();
		cipheSing.value = bean.getCipheredSignature();

		Holder<String> cipheSess = new Holder<String>();
		cipheSess.value = bean.getCipheredSessionKey();

		Holder<String> cipheXmlRes = new Holder<String>();

//		    
//		    VPOS2RESULTTXSOAPStub.SearchResponse respuesta = null;
//		    VPOS2RESULTTXSOAPStub.Search search = new VPOS2RESULTTXSOAPStub.Search();

//		    search.setAcquirerId(bean.getAcquirerId());
//		    search.setCommerceId(bean.getCommerceId());
//		    search.setSessionkey(bean.getCipheredSessionKey());
//		    search.setSignature(bean.getCipheredSignature());
//		    search.setXml(bean.getCipheredXML());

		try {

			VPOS2RESULTTXSOAP vpos2resulttxsoap = new VPOS2RESULTTXSOAP();
			VPOS2RESULTTX vpos2resulttx = vpos2resulttxsoap.getVPOS2RESULTTXSOAP();

//		      ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
//		      VPOS2RESULTTXSOAPStub stub = new VPOS2RESULTTXSOAPStub(ctx, rutaWebService);

//			ServiceClient service = stub._getServiceClient();
//			service.getOptions().setTimeOutInMilliSeconds(Long.parseLong("60000"));

			System.out.println("********** Enviado consulta por WS ...");
//			respuesta = stub.search(search);
			vpos2resulttx.search(acqId, ecoId, bean.getCipheredXML(), cipheSing, cipheSess, cipheXmlRes);
			System.out.println("********** Respuesta desde WS Ok ...");
		} catch (Exception e) {
			System.out.println("Ocurrio un Error " + e);
			e.printStackTrace();
		}

		BeanConsulta beanC = new BeanConsulta();
		beanC.setCipheredSessionKey(cipheSess.value);
		beanC.setCipheredXML(cipheXml.value);
		beanC.setCipheredSignature(cipheSing.value);
		FileReader r1 = null;
		FileReader r5 = null;

		try {
			r1 = new FileReader(rutaLlavePubFirma);
			r5 = new FileReader(rutaLlavePrivCifrado);
			ReceiveWS receive = new ReceiveWS(r1, r5, "98bc2b8a83ceec0c");
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
