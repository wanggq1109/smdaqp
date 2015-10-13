
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
 *         &lt;element name="GetParkingLotInfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getParkingLotInfoResult"
})
@XmlRootElement(name = "GetParkingLotInfoResponse")
public class GetParkingLotInfoResponse {

    @XmlElement(name = "GetParkingLotInfoResult")
    protected String getParkingLotInfoResult;

    /**
     * Gets the value of the getParkingLotInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetParkingLotInfoResult() {
        return getParkingLotInfoResult;
    }

    /**
     * Sets the value of the getParkingLotInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetParkingLotInfoResult(String value) {
        this.getParkingLotInfoResult = value;
    }

}
