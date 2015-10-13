
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
 *         &lt;element name="GetParkingPaymentInfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getParkingPaymentInfoResult"
})
@XmlRootElement(name = "GetParkingPaymentInfoResponse")
public class GetParkingPaymentInfoResponse {

    @XmlElement(name = "GetParkingPaymentInfoResult")
    protected String getParkingPaymentInfoResult;

    /**
     * Gets the value of the getParkingPaymentInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetParkingPaymentInfoResult() {
        return getParkingPaymentInfoResult;
    }

    /**
     * Sets the value of the getParkingPaymentInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetParkingPaymentInfoResult(String value) {
        this.getParkingPaymentInfoResult = value;
    }

}
