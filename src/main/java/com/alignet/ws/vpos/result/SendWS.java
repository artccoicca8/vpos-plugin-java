package com.alignet.ws.vpos.result;

import com.alignet.bean.BeanConsulta;
import com.alignet.pasarela.crypto.CryptoUtil;
import com.alignet.plugin.C;
import com.alignet.plugin.Z;
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

public class SendWS {

	private AsymmetricKeyParameter BDWS;
	private AsymmetricKeyParameter addElement;
	private String append;

	private static final Vector contains = new Vector();
	static {
		contains.addElement("validSign");
		contains.addElement("cipheredSessionKey");
		contains.addElement("cipheredXML");
		contains.addElement("cipheredSignature");
		contains.addElement("clearXML");
	}

	public SendWS(Reader reader, Reader reader1, String s) throws PlugInVPOSException {
		try {
			this.addElement = Z.I(reader1);
			this.BDWS = Z.I(reader);
			this.append = s;
		} catch (Exception e) {
			throw new PlugInVPOSException("Error leyendo la llave Publica", e);
		}
	}

	private void BDWS(BeanConsulta bean) throws PlugInVPOSException {
		bean.setAcquirerId(bean.getAcquirerId());
		bean.setCommerceId(bean.getCommerceId());
		bean.setNumOrder(bean.getNumOrder());
	}

	public final void execute(BeanConsulta bean) throws PlugInVPOSException {
		if (bean == null) {
			throw new PlugInVPOSException("Error parametro BeanConsulta es nulo");
		}
		BDWS(bean);
		byte[] abyte0 = CryptoUtil.I();
		byte[] abyte1 = (byte[]) null;
		try {
			abyte1 = CryptoUtil.I(abyte0, this.BDWS);
		} catch (Exception exception) {
			throw new PlugInVPOSException("Error encriptando la llave de sesion", exception);
		}
		String s = null;
		s = new String(UrlBase64.encode(abyte1));
		bean.setCipheredSessionKey(s);
		String s1 = addElement(bean);
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
		bean.setCipheredXML(s2);
		String s3 = null;
		try {
			s3 = new String(UrlBase64.encode(CryptoUtil.C(abyte2, this.addElement)));
		} catch (Exception exception2) {
			throw new PlugInVPOSException("Error firmando", exception2);
		}
		bean.setCipheredSignature(s3);
	}

	private static String addElement(BeanConsulta bean) throws PlugInVPOSException {
		C c = new C();
		Element element = c.I("VPOSTransaction1.2");
		Field[] afield = bean.getClass().getDeclaredFields();
		for (int i = 0; i < afield.length; i++) {
			Field field = afield[i];
			int j = field.getModifiers();
			if (Modifier.isPrivate(j) && !Modifier.isStatic(j) && !contains.contains(field.getName())) {
				Object obj1, obj = null;

				try {
					obj1 = bean.getClass().getMethod(
							"get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), null)
							.invoke(bean, null);
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

		String s = "";
		try {
			s = c.Z();
		} catch (Exception e) {
			throw new PlugInVPOSException("Error de creacion de XML en cadena", e);
		}

		return s;
	}

}
