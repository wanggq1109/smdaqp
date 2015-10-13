
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
 *         &lt;element name="PayParkingFeeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "payParkingFeeResult"
})
@XmlRootElement(name = "PayParkingFeeResponse")
public class PayParkingFeeResponse {

    @XmlElement(name = "PayParkingFeeResult")
    protected String payParkingFeeResult;

    /**
     * Gets the value of the payParkingFeeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayParkingFeeResult() {
        return payParkingFeeResult;
    }

    /**
     * Sets the value of the payParkingFeeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayParkingFeeResult(String value) {
        this.payParkingFeeResult = value;
    }

}
