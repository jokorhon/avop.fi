
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
 *         &lt;element ref="{urn:mace:funet.fi:virta/2013/01/29}LukukausiIlmoittautumiset"/>
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
    "lukukausiIlmoittautumiset"
})
@XmlRootElement(name = "LukukausiIlmoittautumisetResponse", namespace = "http://tietovaranto.csc.fi/luku")
public class LukukausiIlmoittautumisetResponse {

    @XmlElement(name = "LukukausiIlmoittautumiset", required = true)
    protected LukukausiIlmoittautumisetLaajennettuTyyppi lukukausiIlmoittautumiset;

    /**
     * Gets the value of the lukukausiIlmoittautumiset property.
     * 
     * @return
     *     possible object is
     *     {@link LukukausiIlmoittautumisetLaajennettuTyyppi }
     *     
     */
    public LukukausiIlmoittautumisetLaajennettuTyyppi getLukukausiIlmoittautumiset() {
        return lukukausiIlmoittautumiset;
    }

    /**
     * Sets the value of the lukukausiIlmoittautumiset property.
     * 
     * @param value
     *     allowed object is
     *     {@link LukukausiIlmoittautumisetLaajennettuTyyppi }
     *     
     */
    public void setLukukausiIlmoittautumiset(LukukausiIlmoittautumisetLaajennettuTyyppi value) {
        this.lukukausiIlmoittautumiset = value;
    }

}
