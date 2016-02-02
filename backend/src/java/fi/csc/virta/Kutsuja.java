
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Kutsuja complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kutsuja">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jarjestelma">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tunnus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="avain">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kutsuja", namespace = "http://tietovaranto.csc.fi/luku", propOrder = {
    "jarjestelma",
    "tunnus",
    "avain"
})
public class Kutsuja {

    @XmlElement(required = true)
    protected String jarjestelma;
    @XmlElement(required = true)
    protected String tunnus;
    @XmlElement(required = true)
    protected String avain;

    /**
     * Gets the value of the jarjestelma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJarjestelma() {
        return jarjestelma;
    }

    /**
     * Sets the value of the jarjestelma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJarjestelma(String value) {
        this.jarjestelma = value;
    }

    /**
     * Gets the value of the tunnus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTunnus() {
        return tunnus;
    }

    /**
     * Sets the value of the tunnus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTunnus(String value) {
        this.tunnus = value;
    }

    /**
     * Gets the value of the avain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvain() {
        return avain;
    }

    /**
     * Sets the value of the avain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvain(String value) {
        this.avain = value;
    }

}
