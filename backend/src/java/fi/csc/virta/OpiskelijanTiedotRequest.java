
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
 *         &lt;element name="Kutsuja" type="{http://tietovaranto.csc.fi/luku}Kutsuja"/>
 *         &lt;element name="Hakuehdot">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://tietovaranto.csc.fi/luku}HakuEhdot">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://tietovaranto.csc.fi/luku}organisaatio"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "", propOrder = {
    "kutsuja",
    "hakuehdot"
})
@XmlRootElement(name = "OpiskelijanTiedotRequest", namespace = "http://tietovaranto.csc.fi/luku")
public class OpiskelijanTiedotRequest {

    @XmlElement(name = "Kutsuja", namespace = "http://tietovaranto.csc.fi/luku", required = true)
    protected Kutsuja kutsuja;
    @XmlElement(name = "Hakuehdot", namespace = "http://tietovaranto.csc.fi/luku", required = true)
    protected OpiskelijanTiedotRequest.Hakuehdot hakuehdot;

    /**
     * Gets the value of the kutsuja property.
     * 
     * @return
     *     possible object is
     *     {@link Kutsuja }
     *     
     */
    public Kutsuja getKutsuja() {
        return kutsuja;
    }

    /**
     * Sets the value of the kutsuja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kutsuja }
     *     
     */
    public void setKutsuja(Kutsuja value) {
        this.kutsuja = value;
    }

    /**
     * Gets the value of the hakuehdot property.
     * 
     * @return
     *     possible object is
     *     {@link OpiskelijanTiedotRequest.Hakuehdot }
     *     
     */
    public OpiskelijanTiedotRequest.Hakuehdot getHakuehdot() {
        return hakuehdot;
    }

    /**
     * Sets the value of the hakuehdot property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpiskelijanTiedotRequest.Hakuehdot }
     *     
     */
    public void setHakuehdot(OpiskelijanTiedotRequest.Hakuehdot value) {
        this.hakuehdot = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://tietovaranto.csc.fi/luku}HakuEhdot">
     *       &lt;sequence>
     *         &lt;element ref="{http://tietovaranto.csc.fi/luku}organisaatio"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "organisaatio"
    })
    public static class Hakuehdot
        extends HakuEhdot
    {

        @XmlElement(namespace = "http://tietovaranto.csc.fi/luku", required = true)
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

}
