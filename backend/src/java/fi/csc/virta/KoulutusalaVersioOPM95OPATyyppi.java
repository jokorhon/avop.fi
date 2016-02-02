
package fi.csc.virta;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Koulutusalan versio OPINTOALA 1995 (opm95opa).
 * 			
 * 			Versio sisältää:
 * 			- attribuutti: tunnus (aidosti mikä koulutusalan versio)
 * 			- elementti: koodi, kullekin versiolle on oma joukko koodiarvoja
 * 		
 * 
 * <p>Java class for KoulutusalaVersioOPM95OPATyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KoulutusalaVersioOPM95OPATyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2013/01/29}Opintoala1995KoodiTyyppi"/>
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
@XmlType(name = "KoulutusalaVersioOPM95OPATyyppi", propOrder = {
    "koodi",
    "osuus"
})
public class KoulutusalaVersioOPM95OPATyyppi {

    @XmlElement(name = "Koodi", required = true)
    protected String koodi;
    @XmlElement(name = "Osuus")
    protected BigDecimal osuus;

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
