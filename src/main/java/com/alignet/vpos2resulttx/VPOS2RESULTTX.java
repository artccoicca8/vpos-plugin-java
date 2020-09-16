
package com.alignet.vpos2resulttx;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VPOS2RESULTTX", targetNamespace = "http://www.alignet.com/VPOS2RESULTTX/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VPOS2RESULTTX {


    /**
     * 
     * @param signature
     * @param xml
     * @param sessionkey
     * @param acquirerId
     * @param commerceId
     * @param xmlRes
     */
    @WebMethod(action = "http://www.alignet.com/VPOS2RESULTTX/search")
    @RequestWrapper(localName = "search", targetNamespace = "http://www.alignet.com/VPOS2RESULTTX/", className = "com.alignet.vpos2resulttx.Search")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://www.alignet.com/VPOS2RESULTTX/", className = "com.alignet.vpos2resulttx.SearchResponse")
    public void search(
        @WebParam(name = "acquirerId", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<String> acquirerId,
        @WebParam(name = "commerceId", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<String> commerceId,
        @WebParam(name = "xml", targetNamespace = "")
        String xml,
        @WebParam(name = "signature", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<String> signature,
        @WebParam(name = "sessionkey", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<String> sessionkey,
        @WebParam(name = "xmlRes", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<String> xmlRes);

}
