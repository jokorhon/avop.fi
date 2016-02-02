
package fi.csc.virta;

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
 *         &lt;element ref="{urn:mace:funet.fi:virta/2013/01/29}Opintosuoritukset"/>
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
    "opintosuoritukset"
})
@XmlRootElement(name = "OpintosuorituksetResponse", namespace = "http://tietovaranto.csc.fi/luku")
public class OpintosuorituksetResponse {

    @XmlElement(name = "Opintosuoritukset", required = true)
    protected OpintosuorituksetLaajennettuTyyppi opintosuoritukset;

    /**
     * Gets the value of the opintosuoritukset property.
     * 
     * @return
     *     possible object is
     *     {@link OpintosuorituksetLaajennettuTyyppi }
     *     
     */
    public OpintosuorituksetLaajennettuTyyppi getOpintosuoritukset() {
        return opintosuoritukset;
    }

    /**
     * Sets the value of the opintosuoritukset property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpintosuorituksetLaajennettuTyyppi }
     *     
     */
    public void setOpintosuoritukset(OpintosuorituksetLaajennettuTyyppi value) {
        this.opintosuoritukset = value;
    }

}
