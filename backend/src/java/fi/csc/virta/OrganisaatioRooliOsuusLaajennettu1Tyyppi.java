
package fi.csc.virta;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganisaatioRooliOsuusLaajennettu1Tyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisaatioRooliOsuusLaajennettu1Tyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rooli" type="{urn:mace:funet.fi:virta/2013/01/29}OrganisaatioRooliKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2013/01/29}OrganisaatioKoodiTyyppi"/>
 *         &lt;element name="Osuus" type="{urn:mace:funet.fi:virta/2013/01/29}OsuusTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisaatioRooliOsuusLaajennettu1Tyyppi", propOrder = {
    "rooli",
    "koodi",
    "osuus"
})
public class OrganisaatioRooliOsuusLaajennettu1Tyyppi {

    @XmlElement(name = "Rooli")
    protected String rooli;
    @XmlElement(name = "Koodi", required = true)
    protected String koodi;
    @XmlElement(name = "Osuus")
    protected BigDecimal osuus;

    /**
     * Gets the value of the rooli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRooli() {
        return rooli;
    }

    /**
     * Sets the value of the rooli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRooli(String value) {
        this.rooli = value;
    }

    /**
     * Gets the value of the koodi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoodi() {
        return koodi;
    }

    /**
     * Sets the value of the koodi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoodi(String value) {
        this.koodi = value;
    }

    /**
     * Gets the value of the osuus property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOsuus() {
        return osuus;
    }

    /**
     * Sets the value of the osuus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOsuus(BigDecimal value) {
        this.osuus = value;
    }

}
