
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 			Ilmoittautuminen
 * 			* Yksittäinen ilmoittautuminen
 * 		
 * 
 * <p>Java class for LukukausiIlmoittautuminenTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LukukausiIlmoittautuminenTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Myontaja" type="{urn:mace:funet.fi:virta/2013/01/29}OrganisaatioRooliOsuusLaajennettu1Tyyppi"/>
 *         &lt;element name="Tila" type="{urn:mace:funet.fi:virta/2013/01/29}LukukausiIlmoittautuminenTilaKoodiTyyppi"/>
 *         &lt;element name="IlmoittautumisPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi"/>
 *         &lt;element name="AlkuPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi"/>
 *         &lt;element name="LoppuPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi" minOccurs="0"/>
 *         &lt;element name="YlioppilaskuntaJasen" type="{urn:mace:funet.fi:virta/2013/01/29}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *         &lt;element name="YTHSMaksu" type="{urn:mace:funet.fi:virta/2013/01/29}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="opiskelijaAvain" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskelijaAvainTyyppi" />
 *       &lt;attribute name="opiskeluoikeusAvain" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusAvainTyyppi" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LukukausiIlmoittautuminenTyyppi", propOrder = {
    "myontaja",
    "tila",
    "ilmoittautumisPvm",
    "alkuPvm",
    "loppuPvm",
    "ylioppilaskuntaJasen",
    "ythsMaksu"
})
public class LukukausiIlmoittautuminenTyyppi {

    @XmlElement(name = "Myontaja", required = true)
    protected OrganisaatioRooliOsuusLaajennettu1Tyyppi myontaja;
    @XmlElement(name = "Tila", required = true)
    protected String tila;
    @XmlElement(name = "IlmoittautumisPvm", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ilmoittautumisPvm;
    @XmlElement(name = "AlkuPvm", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar alkuPvm;
    @XmlElement(name = "LoppuPvm")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar loppuPvm;
    @XmlElement(name = "YlioppilaskuntaJasen")
    protected Boolean ylioppilaskuntaJasen;
    @XmlElement(name = "YTHSMaksu")
    protected Boolean ythsMaksu;
    @XmlAttribute(name = "opiskelijaAvain", required = true)
    protected String opiskelijaAvain;
    @XmlAttribute(name = "opiskeluoikeusAvain")
    protected String opiskeluoikeusAvain;

    /**
     * Gets the value of the myontaja property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisaatioRooliOsuusLaajennettu1Tyyppi }
     *     
     */
    public OrganisaatioRooliOsuusLaajennettu1Tyyppi getMyontaja() {
        return myontaja;
    }

    /**
     * Sets the value of the myontaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisaatioRooliOsuusLaajennettu1Tyyppi }
     *     
     */
    public void setMyontaja(OrganisaatioRooliOsuusLaajennettu1Tyyppi value) {
        this.myontaja = value;
    }

    /**
     * Gets the value of the tila property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTila() {
        return tila;
    }

    /**
     * Sets the value of the tila property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTila(String value) {
        this.tila = value;
    }

    /**
     * Gets the value of the ilmoittautumisPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIlmoittautumisPvm() {
        return ilmoittautumisPvm;
    }

    /**
     * Sets the value of the ilmoittautumisPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIlmoittautumisPvm(XMLGregorianCalendar value) {
        this.ilmoittautumisPvm = value;
    }

    /**
     * Gets the value of the alkuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAlkuPvm() {
        return alkuPvm;
    }

    /**
     * Sets the value of the alkuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAlkuPvm(XMLGregorianCalendar value) {
        this.alkuPvm = value;
    }

    /**
     * Gets the value of the loppuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoppuPvm() {
        return loppuPvm;
    }

    /**
     * Sets the value of the loppuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoppuPvm(XMLGregorianCalendar value) {
        this.loppuPvm = value;
    }

    /**
     * Gets the value of the ylioppilaskuntaJasen property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isYlioppilaskuntaJasen() {
        return ylioppilaskuntaJasen;
    }

    /**
     * Sets the value of the ylioppilaskuntaJasen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setYlioppilaskuntaJasen(Boolean value) {
        this.ylioppilaskuntaJasen = value;
    }

    /**
     * Gets the value of the ythsMaksu property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isYTHSMaksu() {
        return ythsMaksu;
    }

    /**
     * Sets the value of the ythsMaksu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setYTHSMaksu(Boolean value) {
        this.ythsMaksu = value;
    }

    /**
     * Gets the value of the opiskelijaAvain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpiskelijaAvain() {
        return opiskelijaAvain;
    }

    /**
     * Sets the value of the opiskelijaAvain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpiskelijaAvain(String value) {
        this.opiskelijaAvain = value;
    }

    /**
     * Gets the value of the opiskeluoikeusAvain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpiskeluoikeusAvain() {
        return opiskeluoikeusAvain;
    }

    /**
     * Sets the value of the opiskeluoikeusAvain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpiskeluoikeusAvain(String value) {
        this.opiskeluoikeusAvain = value;
    }

}
