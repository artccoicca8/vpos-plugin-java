
package com.alignet.vpos2resulttx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acquirerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commerceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmlRes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionkey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "acquirerId",
    "commerceId",
    "xmlRes",
    "signature",
    "sessionkey"
})
@XmlRootElement(name = "searchResponse")
public class SearchResponse {

    protected String acquirerId;
    protected String commerceId;
    protected String xmlRes;
    protected String signature;
    protected String sessionkey;

    /**
     * Gets the value of the acquirerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerId() {
        return acquirerId;
    }

    /**
     * Sets the value of the acquirerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerId(String value) {
        this.acquirerId = value;
    }

    /**
     * Gets the value of the commerceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommerceId() {
        return commerceId;
    }

    /**
     * Sets the value of the commerceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommerceId(String value) {
        this.commerceId = value;
    }

    /**
     * Gets the value of the xmlRes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlRes() {
        return xmlRes;
    }

    /**
     * Sets the value of the xmlRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlRes(String value) {
        this.xmlRes = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Gets the value of the sessionkey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionkey() {
        return sessionkey;
    }

    /**
     * Sets the value of the sessionkey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionkey(String value) {
        this.sessionkey = value;
    }

}
