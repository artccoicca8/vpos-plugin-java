package com.alignet.ws.vposResult;

import com.alignet.bean.BeanConsulta;
import com.alignet.pasarela.crypto.CryptoUtil;
import com.alignet.plugin.C;
import com.alignet.plugin.Z;
import com.alignet.plugin.exception.PlugInVPOSException;
import java.io.Reader;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.encoders.UrlBase64;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ReceiveWS {
	private AsymmetricKeyParameter BDWS;

	public ReceiveWS(Reader reader, Reader reader1, String s) throws PlugInVPOSException {
		try {
			this.addProduct = Z.I(reader1);
			this.BDWS = Z.I(reader);
			this.addTax = s;
		} catch (Exception e) {
			throw new PlugInVPOSException("Error leyendo la llave Publica " + e);
		}
	}

	private AsymmetricKeyParameter addProduct;
	private String addTax;

	public final void execute(BeanConsulta vposConsulta) throws PlugInVPOSException {
		if (vposConsulta == null) {
			throw new PlugInVPOSException("Error parametro BeanConsulta es nulo");
		}
		String s = vposConsulta.getCipheredSessionKey();
		byte[] abyte0 = (byte[]) null;
		abyte0 = UrlBase64.decode(s);
		byte[] abyte1 = (byte[]) null;
		try {
			abyte1 = CryptoUtil.Z(abyte0, this.addProduct);
		} catch (Exception exception) {
			throw new PlugInVPOSException("Error desencriptando la llave de sesion", exception);
		}
		String s1 = vposConsulta.getCipheredXML();
		byte[] abyte2 = (byte[]) null;
		abyte2 = UrlBase64.decode(s1);
		byte[] abyte3 = Hex.decode(this.addTax);
		byte[] abyte4 = (byte[]) null;
		try {
			abyte4 = CryptoUtil.Z(abyte2, abyte1, abyte3);
		} catch (Exception exception1) {
			throw new PlugInVPOSException("Error desencriptando xml decodificado", exception1);
		}
		String s2 = vposConsulta.getCipheredSignature();
		byte[] abyte5 = (byte[]) null;
		abyte5 = UrlBase64.decode(s2);

		String s3 = new String(abyte4);
		vposConsulta.setClearXML(s3);
		BDWS(vposConsulta, s3);
	}

	private void BDWS(BeanConsulta vposConsulta, String s) throws PlugInVPOSException {
		C c = new C(s);
		Element element = c.I();
		if (!element.getNodeName().equals("VPOSTransaction1.2")) {
			throw new PlugInVPOSException("El nodo raiz no corresponde con VPOSTransaction1.2");
		}
		NodeList nodelist = element.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			Node node1 = node.getFirstChild();
			if (node1 instanceof Text) {
				String s1 = ((Text) node1).getNodeValue();
				try {
					vposConsulta.getClass()
							.getMethod("set" + node.getNodeName().substring(0, 1).toUpperCase()
									+ node.getNodeName().substring(1), new Class[] { String.class })
							.invoke(vposConsulta, new Object[] { s1 });
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
