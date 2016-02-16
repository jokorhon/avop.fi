
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 			StudyRight
 * 			* Single study right
 * 		
 * 
 * <p>Java class for OpiskeluoikeusTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpiskeluoikeusTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlkuPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi"/>
 *         &lt;element name="LoppuPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi" minOccurs="0"/>
 *         &lt;element name="Tila" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:mace:funet.fi:virta/2013/01/29}AikajaksoTyyppi">
 *                 &lt;sequence>
 *                   &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusTilaKoodiTyyppi"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Tyyppi" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusTyyppiKoodiTyyppi"/>
 *         &lt;element name="Myontaja" type="{urn:mace:funet.fi:virta/2013/01/29}OrganisaatioRooliOsuusLaajennettu1Tyyppi"/>
 *         &lt;element name="Organisaatio" type="{urn:mace:funet.fi:virta/2013/01/29}OrganisaatioRooliOsuusTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Jakso" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:mace:funet.fi:virta/2013/01/29}AikajaksoTyyppi">
 *                 &lt;sequence>
 *                   &lt;element name="Koulutuskoodi" type="{urn:mace:funet.fi:virta/2013/01/29}KoulutuskoodiKoodiTyyppi" minOccurs="0"/>
 *                   &lt;element name="Koulutuskunta" type="{urn:mace:funet.fi:virta/2013/01/29}KuntaKoodiTyyppi"/>
 *                   &lt;element name="Koulutuskieli" type="{urn:mace:funet.fi:virta/2013/01/29}KieliKoodiTyyppi" minOccurs="0"/>
 *                   &lt;element name="Rahoituslahde" type="{urn:mace:funet.fi:virta/2013/01/29}RahoituslahdeKoodiTyyppi" minOccurs="0"/>
 *                   &lt;element name="Patevyys" type="{urn:mace:funet.fi:virta/2013/01/29}PatevyysKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="koulutusmoduulitunniste" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}KoulutusmoduulitunnisteTyyppi" />
 *                 &lt;attribute name="valtakunnallinenKoulutusmoduulitunniste" type="{urn:mace:funet.fi:virta/2013/01/29}ValtakunnallinenKoulutusmoduulitunnisteTyyppi" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Ensisijaisuus" type="{urn:mace:funet.fi:virta/2013/01/29}AikajaksoTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Koulutusala2002" type="{urn:mace:funet.fi:virta/2013/01/29}Koulutusala2002KoodiTyyppi" minOccurs="0"/>
 *           &lt;element name="Opintoala1995" type="{urn:mace:funet.fi:virta/2013/01/29}Opintoala1995KoodiTyyppi" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="Liittyvyys" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="liittyvaOpiskeluoikeusAvain" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusAvainTyyppi" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SiirtoOpiskelija" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SiirtoPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi"/>
 *                   &lt;element name="LasnaPoissaoloLukukausiMaara" type="{urn:mace:funet.fi:virta/2013/01/29}LasnaPoissaoloLukukausiMaaraTyyppi"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="lahdeOpiskeluoikeusAvain" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusAvainTyyppi" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="KansainvalinenVaihto" type="{urn:mace:funet.fi:virta/2013/01/29}KansainvalinenVaihtoKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Laajuus" type="{urn:mace:funet.fi:virta/2013/01/29}LaajuusLaajennettuTyyppi" minOccurs="0"/>
 *         &lt;element name="Aikuiskoulutus" type="{urn:mace:funet.fi:virta/2013/01/29}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *         &lt;element name="AvoinVayla" type="{urn:mace:funet.fi:virta/2013/01/29}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *         &lt;element name="AsetusMaisteriohjelma" type="{urn:mace:funet.fi:virta/2013/01/29}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusAvainTyyppi" />
 *       &lt;attribute name="opiskelijaAvain" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskelijaAvainTyyppi" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpiskeluoikeusTyyppi", propOrder = {
    "alkuPvm",
    "loppuPvm",
    "tila",
    "tyyppi",
    "myontaja",
    "organisaatio",
    "jakso",
    "ensisijaisuus",
    "koulutusala2002",
    "opintoala1995",
    "liittyvyys",
    "siirtoOpiskelija",
    "kansainvalinenVaihto",
    "laajuus",
    "aikuiskoulutus",
    "avoinVayla",
    "asetusMaisteriohjelma"
})
public class OpiskeluoikeusTyyppi {

    @XmlElement(name = "AlkuPvm", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar alkuPvm;
    @XmlElement(name = "LoppuPvm")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar loppuPvm;
    @XmlElement(name = "Tila", required = true)
    protected List<OpiskeluoikeusTyyppi.Tila> tila;
    @XmlElement(name = "Tyyppi", required = true)
    protected String tyyppi;
    @XmlElement(name = "Myontaja", required = true)
    protected OrganisaatioRooliOsuusLaajennettu1Tyyppi myontaja;
    @XmlElement(name = "Organisaatio")
    protected List<OrganisaatioRooliOsuusTyyppi> organisaatio;
    @XmlElement(name = "Jakso")
    protected List<OpiskeluoikeusTyyppi.Jakso> jakso;
    @XmlElement(name = "Ensisijaisuus")
    protected List<AikajaksoTyyppi> ensisijaisuus;
    @XmlElement(name = "Koulutusala2002")
    protected String koulutusala2002;
    @XmlElement(name = "Opintoala1995")
    protected String opintoala1995;
    @XmlElement(name = "Liittyvyys")
    protected List<OpiskeluoikeusTyyppi.Liittyvyys> liittyvyys;
    @XmlElement(name = "SiirtoOpiskelija")
    protected OpiskeluoikeusTyyppi.SiirtoOpiskelija siirtoOpiskelija;
    @XmlElement(name = "KansainvalinenVaihto")
    protected String kansainvalinenVaihto;
    @XmlElement(name = "Laajuus")
    protected LaajuusLaajennettuTyyppi laajuus;
    @XmlElement(name = "Aikuiskoulutus")
    protected Boolean aikuiskoulutus;
    @XmlElement(name = "AvoinVayla")
    protected Boolean avoinVayla;
    @XmlElement(name = "AsetusMaisteriohjelma")
    protected Boolean asetusMaisteriohjelma;
    @XmlAttribute(name = "avain", required = true)
    protected String avain;
    @XmlAttribute(name = "opiskelijaAvain", required = true)
    protected String opiskelijaAvain;

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
     * Gets the value of the tila property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tila property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTila().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi.Tila }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi.Tila> getTila() {
        if (tila == null) {
            tila = new ArrayList<OpiskeluoikeusTyyppi.Tila>();
        }
        return this.tila;
    }

    /**
     * Gets the value of the tyyppi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTyyppi() {
        return tyyppi;
    }

    /**
     * Sets the value of the tyyppi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTyyppi(String value) {
        this.tyyppi = value;
    }

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
     * Gets the value of the organisaatio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organisaatio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganisaatio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganisaatioRooliOsuusTyyppi }
     * 
     * 
     */
    public List<OrganisaatioRooliOsuusTyyppi> getOrganisaatio() {
        if (organisaatio == null) {
            organisaatio = new ArrayList<OrganisaatioRooliOsuusTyyppi>();
        }
        return this.organisaatio;
    }

    /**
     * Gets the value of the jakso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jakso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJakso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi.Jakso }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi.Jakso> getJakso() {
        if (jakso == null) {
            jakso = new ArrayList<OpiskeluoikeusTyyppi.Jakso>();
        }
        return this.jakso;
    }

    /**
     * Gets the value of the ensisijaisuus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ensisijaisuus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnsisijaisuus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AikajaksoTyyppi }
     * 
     * 
     */
    public List<AikajaksoTyyppi> getEnsisijaisuus() {
        if (ensisijaisuus == null) {
            ensisijaisuus = new ArrayList<AikajaksoTyyppi>();
        }
        return this.ensisijaisuus;
    }

    /**
     * Gets the value of the koulutusala2002 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoulutusala2002() {
        return koulutusala2002;
    }

    /**
     * Sets the value of the koulutusala2002 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoulutusala2002(String value) {
        this.koulutusala2002 = value;
    }

    /**
     * Gets the value of the opintoala1995 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpintoala1995() {
        return opintoala1995;
    }

    /**
     * Sets the value of the opintoala1995 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpintoala1995(String value) {
        this.opintoala1995 = value;
    }

    /**
     * Gets the value of the liittyvyys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the liittyvyys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLiittyvyys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi.Liittyvyys }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi.Liittyvyys> getLiittyvyys() {
        if (liittyvyys == null) {
            liittyvyys = new ArrayList<OpiskeluoikeusTyyppi.Liittyvyys>();
        }
        return this.liittyvyys;
    }

    /**
     * Gets the value of the siirtoOpiskelija property.
     * 
     * @return
     *     possible object is
     *     {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija }
     *     
     */
    public OpiskeluoikeusTyyppi.SiirtoOpiskelija getSiirtoOpiskelija() {
        return siirtoOpiskelija;
    }

    /**
     * Sets the value of the siirtoOpiskelija property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija }
     *     
     */
    public void setSiirtoOpiskelija(OpiskeluoikeusTyyppi.SiirtoOpiskelija value) {
        this.siirtoOpiskelija = value;
    }

    /**
     * Gets the value of the kansainvalinenVaihto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKansainvalinenVaihto() {
        return kansainvalinenVaihto;
    }

    /**
     * Sets the value of the kansainvalinenVaihto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKansainvalinenVaihto(String value) {
        this.kansainvalinenVaihto = value;
    }

    /**
     * Gets the value of the laajuus property.
     * 
     * @return
     *     possible object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public LaajuusLaajennettuTyyppi getLaajuus() {
        return laajuus;
    }

    /**
     * Sets the value of the laajuus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public void setLaajuus(LaajuusLaajennettuTyyppi value) {
        this.laajuus = value;
    }

    /**
     * Gets the value of the aikuiskoulutus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAikuiskoulutus() {
        return aikuiskoulutus;
    }

    /**
     * Hack to get this value working with clojure.java.data's from-java
     */
    public Boolean getAikuiskoulutus() {
        return aikuiskoulutus;
    }

    /**
     * Sets the value of the aikuiskoulutus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAikuiskoulutus(Boolean value) {
        this.aikuiskoulutus = value;
    }

    /**
     * Gets the value of the avoinVayla property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvoinVayla() {
        return avoinVayla;
    }

    /**
     * Sets the value of the avoinVayla property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvoinVayla(Boolean value) {
        this.avoinVayla = value;
    }

    /**
     * Gets the value of the asetusMaisteriohjelma property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAsetusMaisteriohjelma() {
        return asetusMaisteriohjelma;
    }

    /**
     * Sets the value of the asetusMaisteriohjelma property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAsetusMaisteriohjelma(Boolean value) {
        this.asetusMaisteriohjelma = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:mace:funet.fi:virta/2013/01/29}AikajaksoTyyppi">
     *       &lt;sequence>
     *         &lt;element name="Koulutuskoodi" type="{urn:mace:funet.fi:virta/2013/01/29}KoulutuskoodiKoodiTyyppi" minOccurs="0"/>
     *         &lt;element name="Koulutuskunta" type="{urn:mace:funet.fi:virta/2013/01/29}KuntaKoodiTyyppi"/>
     *         &lt;element name="Koulutuskieli" type="{urn:mace:funet.fi:virta/2013/01/29}KieliKoodiTyyppi" minOccurs="0"/>
     *         &lt;element name="Rahoituslahde" type="{urn:mace:funet.fi:virta/2013/01/29}RahoituslahdeKoodiTyyppi" minOccurs="0"/>
     *         &lt;element name="Patevyys" type="{urn:mace:funet.fi:virta/2013/01/29}PatevyysKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="koulutusmoduulitunniste" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}KoulutusmoduulitunnisteTyyppi" />
     *       &lt;attribute name="valtakunnallinenKoulutusmoduulitunniste" type="{urn:mace:funet.fi:virta/2013/01/29}ValtakunnallinenKoulutusmoduulitunnisteTyyppi" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "koulutuskoodi",
        "koulutuskunta",
        "koulutuskieli",
        "rahoituslahde",
        "patevyys"
    })
    public static class Jakso
        extends AikajaksoTyyppi
    {

        @XmlElement(name = "Koulutuskoodi")
        protected String koulutuskoodi;
        @XmlElement(name = "Koulutuskunta", required = true)
        protected String koulutuskunta;
        @XmlElement(name = "Koulutuskieli")
        protected String koulutuskieli;
        @XmlElement(name = "Rahoituslahde")
        protected String rahoituslahde;
        @XmlElement(name = "Patevyys")
        protected List<String> patevyys;
        @XmlAttribute(name = "koulutusmoduulitunniste", required = true)
        protected String koulutusmoduulitunniste;
        @XmlAttribute(name = "valtakunnallinenKoulutusmoduulitunniste")
        protected String valtakunnallinenKoulutusmoduulitunniste;

        /**
         * Gets the value of the koulutuskoodi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutuskoodi() {
            return koulutuskoodi;
        }

        /**
         * Sets the value of the koulutuskoodi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutuskoodi(String value) {
            this.koulutuskoodi = value;
        }

        /**
         * Gets the value of the koulutuskunta property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutuskunta() {
            return koulutuskunta;
        }

        /**
         * Sets the value of the koulutuskunta property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutuskunta(String value) {
            this.koulutuskunta = value;
        }

        /**
         * Gets the value of the koulutuskieli property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutuskieli() {
            return koulutuskieli;
        }

        /**
         * Sets the value of the koulutuskieli property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutuskieli(String value) {
            this.koulutuskieli = value;
        }

        /**
         * Gets the value of the rahoituslahde property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRahoituslahde() {
            return rahoituslahde;
        }

        /**
         * Sets the value of the rahoituslahde property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRahoituslahde(String value) {
            this.rahoituslahde = value;
        }

        /**
         * Gets the value of the patevyys property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the patevyys property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPatevyys().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPatevyys() {
            if (patevyys == null) {
                patevyys = new ArrayList<String>();
            }
            return this.patevyys;
        }

        /**
         * Gets the value of the koulutusmoduulitunniste property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutusmoduulitunniste() {
            return koulutusmoduulitunniste;
        }

        /**
         * Sets the value of the koulutusmoduulitunniste property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutusmoduulitunniste(String value) {
            this.koulutusmoduulitunniste = value;
        }

        /**
         * Gets the value of the valtakunnallinenKoulutusmoduulitunniste property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValtakunnallinenKoulutusmoduulitunniste() {
            return valtakunnallinenKoulutusmoduulitunniste;
        }

        /**
         * Sets the value of the valtakunnallinenKoulutusmoduulitunniste property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValtakunnallinenKoulutusmoduulitunniste(String value) {
            this.valtakunnallinenKoulutusmoduulitunniste = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="liittyvaOpiskeluoikeusAvain" use="required" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusAvainTyyppi" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Liittyvyys {

        @XmlAttribute(name = "liittyvaOpiskeluoikeusAvain", required = true)
        protected String liittyvaOpiskeluoikeusAvain;

        /**
         * Gets the value of the liittyvaOpiskeluoikeusAvain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLiittyvaOpiskeluoikeusAvain() {
            return liittyvaOpiskeluoikeusAvain;
        }

        /**
         * Sets the value of the liittyvaOpiskeluoikeusAvain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLiittyvaOpiskeluoikeusAvain(String value) {
            this.liittyvaOpiskeluoikeusAvain = value;
        }

    }


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
     *         &lt;element name="SiirtoPvm" type="{urn:mace:funet.fi:virta/2013/01/29}PvmTyyppi"/>
     *         &lt;element name="LasnaPoissaoloLukukausiMaara" type="{urn:mace:funet.fi:virta/2013/01/29}LasnaPoissaoloLukukausiMaaraTyyppi"/>
     *       &lt;/sequence>
     *       &lt;attribute name="lahdeOpiskeluoikeusAvain" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusAvainTyyppi" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "siirtoPvm",
        "lasnaPoissaoloLukukausiMaara"
    })
    public static class SiirtoOpiskelija {

        @XmlElement(name = "SiirtoPvm", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar siirtoPvm;
        @XmlElement(name = "LasnaPoissaoloLukukausiMaara")
        protected short lasnaPoissaoloLukukausiMaara;
        @XmlAttribute(name = "lahdeOpiskeluoikeusAvain")
        protected String lahdeOpiskeluoikeusAvain;

        /**
         * Gets the value of the siirtoPvm property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSiirtoPvm() {
            return siirtoPvm;
        }

        /**
         * Sets the value of the siirtoPvm property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSiirtoPvm(XMLGregorianCalendar value) {
            this.siirtoPvm = value;
        }

        /**
         * Gets the value of the lasnaPoissaoloLukukausiMaara property.
         * 
         */
        public short getLasnaPoissaoloLukukausiMaara() {
            return lasnaPoissaoloLukukausiMaara;
        }

        /**
         * Sets the value of the lasnaPoissaoloLukukausiMaara property.
         * 
         */
        public void setLasnaPoissaoloLukukausiMaara(short value) {
            this.lasnaPoissaoloLukukausiMaara = value;
        }

        /**
         * Gets the value of the lahdeOpiskeluoikeusAvain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLahdeOpiskeluoikeusAvain() {
            return lahdeOpiskeluoikeusAvain;
        }

        /**
         * Sets the value of the lahdeOpiskeluoikeusAvain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLahdeOpiskeluoikeusAvain(String value) {
            this.lahdeOpiskeluoikeusAvain = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:mace:funet.fi:virta/2013/01/29}AikajaksoTyyppi">
     *       &lt;sequence>
     *         &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskeluoikeusTilaKoodiTyyppi"/>
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
        "koodi"
    })
    public static class Tila
        extends AikajaksoTyyppi
    {

        @XmlElement(name = "Koodi", required = true)
        protected String koodi;

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

    }

}
