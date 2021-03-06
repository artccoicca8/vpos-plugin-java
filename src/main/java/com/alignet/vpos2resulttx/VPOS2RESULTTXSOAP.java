
package com.alignet.vpos2resulttx;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VPOS2RESULTTXSOAP", targetNamespace = "http://www.alignet.com/VPOS2RESULTTX/", wsdlLocation = "https://testecommerce.credibanco.com/vpos2br/services/VPOS2RESULTTXSOAP/META-INF/VPOS2RESULTTXSOAP.wsdl")
public class VPOS2RESULTTXSOAP
    extends Service
{

    private final static URL VPOS2RESULTTXSOAP_WSDL_LOCATION;
    private final static WebServiceException VPOS2RESULTTXSOAP_EXCEPTION;
    private final static QName VPOS2RESULTTXSOAP_QNAME = new QName("http://www.alignet.com/VPOS2RESULTTX/", "VPOS2RESULTTXSOAP");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://testecommerce.credibanco.com/vpos2br/services/VPOS2RESULTTXSOAP/META-INF/VPOS2RESULTTXSOAP.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VPOS2RESULTTXSOAP_WSDL_LOCATION = url;
        VPOS2RESULTTXSOAP_EXCEPTION = e;
    }

    public VPOS2RESULTTXSOAP() {
        super(__getWsdlLocation(), VPOS2RESULTTXSOAP_QNAME);
    }

    public VPOS2RESULTTXSOAP(WebServiceFeature... features) {
        super(__getWsdlLocation(), VPOS2RESULTTXSOAP_QNAME, features);
    }

    public VPOS2RESULTTXSOAP(URL wsdlLocation) {
        super(wsdlLocation, VPOS2RESULTTXSOAP_QNAME);
    }

    public VPOS2RESULTTXSOAP(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VPOS2RESULTTXSOAP_QNAME, features);
    }

    public VPOS2RESULTTXSOAP(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VPOS2RESULTTXSOAP(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns VPOS2RESULTTX
     */
    @WebEndpoint(name = "VPOS2RESULTTXSOAP")
    public VPOS2RESULTTX getVPOS2RESULTTXSOAP() {
        return super.getPort(new QName("http://www.alignet.com/VPOS2RESULTTX/", "VPOS2RESULTTXSOAP"), VPOS2RESULTTX.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VPOS2RESULTTX
     */
    @WebEndpoint(name = "VPOS2RESULTTXSOAP")
    public VPOS2RESULTTX getVPOS2RESULTTXSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.alignet.com/VPOS2RESULTTX/", "VPOS2RESULTTXSOAP"), VPOS2RESULTTX.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VPOS2RESULTTXSOAP_EXCEPTION!= null) {
            throw VPOS2RESULTTXSOAP_EXCEPTION;
        }
        return VPOS2RESULTTXSOAP_WSDL_LOCATION;
    }

}
