
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
 *         &lt;element name="GetCarInOutByVoucherResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCarInOutByVoucherResult"
})
@XmlRootElement(name = "GetCarInOutByVoucherResponse")
public class GetCarInOutByVoucherResponse {

    @XmlElement(name = "GetCarInOutByVoucherResult")
    protected String getCarInOutByVoucherResult;

    /**
     * Gets the value of the getCarInOutByVoucherResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCarInOutByVoucherResult() {
        return getCarInOutByVoucherResult;
    }

    /**
     * Sets the value of the getCarInOutByVoucherResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCarInOutByVoucherResult(String value) {
        this.getCarInOutByVoucherResult = value;
    }

}
