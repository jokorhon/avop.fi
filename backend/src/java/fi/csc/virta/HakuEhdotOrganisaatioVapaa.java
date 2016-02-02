
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HakuEhdotOrganisaatioVapaa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HakuEhdotOrganisaatioVapaa">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tietovaranto.csc.fi/luku}HakuEhdot">
 *       &lt;sequence>
 *         &lt;element ref="{http://tietovaranto.csc.fi/luku}organisaatio" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HakuEhdotOrganisaatioVapaa", namespace = "http://tietovaranto.csc.fi/luku", propOrder = {
    "organisaatio"
})
public class HakuEhdotOrganisaatioVapaa
    extends HakuEhdot
{

    protected String organisaatio;

    /**
     * Gets the value of the organisaatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisaatio() {
        return organisaatio;
    }

    /**
     * Sets the value of the organisaatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisaatio(String value) {
        this.organisaatio = value;
    }

}
