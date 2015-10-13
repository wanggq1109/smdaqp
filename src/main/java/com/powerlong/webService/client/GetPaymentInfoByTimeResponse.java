
package com.powerlong.webService.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetPaymentInfoByTimeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getPaymentInfoByTimeResult"
})
@XmlRootElement(name = "GetPaymentInfoByTimeResponse")
public class GetPaymentInfoByTimeResponse {

    @XmlElement(name = "GetPaymentInfoByTimeResult")
    protected String getPaymentInfoByTimeResult;

    /**
     * Gets the value of the getPaymentInfoByTimeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetPaymentInfoByTimeResult() {
        return getPaymentInfoByTimeResult;
    }

    /**
     * Sets the value of the getPaymentInfoByTimeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetPaymentInfoByTimeResult(String value) {
        this.getPaymentInfoByTimeResult = value;
    }

}
