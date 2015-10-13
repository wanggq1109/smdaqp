
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
 *         &lt;element name="GetCarInOutInfoByPlaceResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCarInOutInfoByPlaceResult"
})
@XmlRootElement(name = "GetCarInOutInfoByPlaceResponse")
public class GetCarInOutInfoByPlaceResponse {

    @XmlElement(name = "GetCarInOutInfoByPlaceResult")
    protected String getCarInOutInfoByPlaceResult;

    /**
     * Gets the value of the getCarInOutInfoByPlaceResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCarInOutInfoByPlaceResult() {
        return getCarInOutInfoByPlaceResult;
    }

    /**
     * Sets the value of the getCarInOutInfoByPlaceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCarInOutInfoByPlaceResult(String value) {
        this.getCarInOutInfoByPlaceResult = value;
    }

}
