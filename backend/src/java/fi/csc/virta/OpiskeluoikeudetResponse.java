
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
 *         &lt;element ref="{urn:mace:funet.fi:virta/2013/01/29}Opiskeluoikeudet"/>
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
    "opiskeluoikeudet"
})
@XmlRootElement(name = "OpiskeluoikeudetResponse", namespace = "http://tietovaranto.csc.fi/luku")
public class OpiskeluoikeudetResponse {

    @XmlElement(name = "Opiskeluoikeudet", required = true)
    protected OpiskeluoikeudetLaajennettuTyyppi opiskeluoikeudet;

    /**
     * Gets the value of the opiskeluoikeudet property.
     * 
     * @return
     *     possible object is
     *     {@link OpiskeluoikeudetLaajennettuTyyppi }
     *     
     */
    public OpiskeluoikeudetLaajennettuTyyppi getOpiskeluoikeudet() {
        return opiskeluoikeudet;
    }

    /**
     * Sets the value of the opiskeluoikeudet property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpiskeluoikeudetLaajennettuTyyppi }
     *     
     */
    public void setOpiskeluoikeudet(OpiskeluoikeudetLaajennettuTyyppi value) {
        this.opiskeluoikeudet = value;
    }

}
