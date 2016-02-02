
package fi.csc.virta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fi.csc.virta package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Organisaatio_QNAME = new QName("http://tietovaranto.csc.fi/luku", "organisaatio");
    private final static QName _LukukausiIlmoittautumiset_QNAME = new QName("urn:mace:funet.fi:virta/2013/01/29", "LukukausiIlmoittautumiset");
    private final static QName _Opintosuoritukset_QNAME = new QName("urn:mace:funet.fi:virta/2013/01/29", "Opintosuoritukset");
    private final static QName _Opiskelijat_QNAME = new QName("urn:mace:funet.fi:virta/2013/01/29", "Opiskelijat");
    private final static QName _Opiskeluoikeudet_QNAME = new QName("urn:mace:funet.fi:virta/2013/01/29", "Opiskeluoikeudet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fi.csc.virta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OpiskelijanTiedotRequest }
     * 
     */
    public OpiskelijanTiedotRequest createOpiskelijanTiedotRequest() {
        return new OpiskelijanTiedotRequest();
    }

    /**
     * Create an instance of {@link OpintosuoritusTyyppi }
     * 
     */
    public OpintosuoritusTyyppi createOpintosuoritusTyyppi() {
        return new OpintosuoritusTyyppi();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi }
     * 
     */
    public OpiskeluoikeusTyyppi createOpiskeluoikeusTyyppi() {
        return new OpiskeluoikeusTyyppi();
    }

    /**
     * Create an instance of {@link ArvosanaAsteikkoMuuTyyppi }
     * 
     */
    public ArvosanaAsteikkoMuuTyyppi createArvosanaAsteikkoMuuTyyppi() {
        return new ArvosanaAsteikkoMuuTyyppi();
    }

    /**
     * Create an instance of {@link ArvosanaAsteikkoMuuTyyppi.Asteikko }
     * 
     */
    public ArvosanaAsteikkoMuuTyyppi.Asteikko createArvosanaAsteikkoMuuTyyppiAsteikko() {
        return new ArvosanaAsteikkoMuuTyyppi.Asteikko();
    }

    /**
     * Create an instance of {@link OpiskelijanKaikkiTiedotRequest }
     * 
     */
    public OpiskelijanKaikkiTiedotRequest createOpiskelijanKaikkiTiedotRequest() {
        return new OpiskelijanKaikkiTiedotRequest();
    }

    /**
     * Create an instance of {@link Kutsuja }
     * 
     */
    public Kutsuja createKutsuja() {
        return new Kutsuja();
    }

    /**
     * Create an instance of {@link HakuEhdotOrganisaatioVapaa }
     * 
     */
    public HakuEhdotOrganisaatioVapaa createHakuEhdotOrganisaatioVapaa() {
        return new HakuEhdotOrganisaatioVapaa();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetRequest }
     * 
     */
    public LukukausiIlmoittautumisetRequest createLukukausiIlmoittautumisetRequest() {
        return new LukukausiIlmoittautumisetRequest();
    }

    /**
     * Create an instance of {@link OpiskelijanTiedotResponse }
     * 
     */
    public OpiskelijanTiedotResponse createOpiskelijanTiedotResponse() {
        return new OpiskelijanTiedotResponse();
    }

    /**
     * Create an instance of {@link OpiskelijatLaajennettuTyyppi }
     * 
     */
    public OpiskelijatLaajennettuTyyppi createOpiskelijatLaajennettuTyyppi() {
        return new OpiskelijatLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuorituksetRequest }
     * 
     */
    public OpintosuorituksetRequest createOpintosuorituksetRequest() {
        return new OpintosuorituksetRequest();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetResponse }
     * 
     */
    public LukukausiIlmoittautumisetResponse createLukukausiIlmoittautumisetResponse() {
        return new LukukausiIlmoittautumisetResponse();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetLaajennettuTyyppi }
     * 
     */
    public LukukausiIlmoittautumisetLaajennettuTyyppi createLukukausiIlmoittautumisetLaajennettuTyyppi() {
        return new LukukausiIlmoittautumisetLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuorituksetResponse }
     * 
     */
    public OpintosuorituksetResponse createOpintosuorituksetResponse() {
        return new OpintosuorituksetResponse();
    }

    /**
     * Create an instance of {@link OpintosuorituksetLaajennettuTyyppi }
     * 
     */
    public OpintosuorituksetLaajennettuTyyppi createOpintosuorituksetLaajennettuTyyppi() {
        return new OpintosuorituksetLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link OpiskelijanKaikkiTiedotResponse }
     * 
     */
    public OpiskelijanKaikkiTiedotResponse createOpiskelijanKaikkiTiedotResponse() {
        return new OpiskelijanKaikkiTiedotResponse();
    }

    /**
     * Create an instance of {@link Virta }
     * 
     */
    public Virta createVirta() {
        return new Virta();
    }

    /**
     * Create an instance of {@link OpiskelijaLaajennettuTyyppi }
     * 
     */
    public OpiskelijaLaajennettuTyyppi createOpiskelijaLaajennettuTyyppi() {
        return new OpiskelijaLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link OpiskelijanTiedotRequest.Hakuehdot }
     * 
     */
    public OpiskelijanTiedotRequest.Hakuehdot createOpiskelijanTiedotRequestHakuehdot() {
        return new OpiskelijanTiedotRequest.Hakuehdot();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetRequest }
     * 
     */
    public OpiskeluoikeudetRequest createOpiskeluoikeudetRequest() {
        return new OpiskeluoikeudetRequest();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetResponse }
     * 
     */
    public OpiskeluoikeudetResponse createOpiskeluoikeudetResponse() {
        return new OpiskeluoikeudetResponse();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetLaajennettuTyyppi }
     * 
     */
    public OpiskeluoikeudetLaajennettuTyyppi createOpiskeluoikeudetLaajennettuTyyppi() {
        return new OpiskeluoikeudetLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link HakuEhdot }
     * 
     */
    public HakuEhdot createHakuEhdot() {
        return new HakuEhdot();
    }

    /**
     * Create an instance of {@link OrganisaatioRooliOsuusTyyppi }
     * 
     */
    public OrganisaatioRooliOsuusTyyppi createOrganisaatioRooliOsuusTyyppi() {
        return new OrganisaatioRooliOsuusTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuoritusNimiTyyppi }
     * 
     */
    public OpintosuoritusNimiTyyppi createOpintosuoritusNimiTyyppi() {
        return new OpintosuoritusNimiTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuoritusJulkinenLisatietoTyyppi }
     * 
     */
    public OpintosuoritusJulkinenLisatietoTyyppi createOpintosuoritusJulkinenLisatietoTyyppi() {
        return new OpintosuoritusJulkinenLisatietoTyyppi();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetTyyppi }
     * 
     */
    public OpiskeluoikeudetTyyppi createOpiskeluoikeudetTyyppi() {
        return new OpiskeluoikeudetTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuorituksetTyyppi }
     * 
     */
    public OpintosuorituksetTyyppi createOpintosuorituksetTyyppi() {
        return new OpintosuorituksetTyyppi();
    }

    /**
     * Create an instance of {@link AikajaksoTyyppi }
     * 
     */
    public AikajaksoTyyppi createAikajaksoTyyppi() {
        return new AikajaksoTyyppi();
    }

    /**
     * Create an instance of {@link OpiskelijaTyyppi }
     * 
     */
    public OpiskelijaTyyppi createOpiskelijaTyyppi() {
        return new OpiskelijaTyyppi();
    }

    /**
     * Create an instance of {@link HenkiloTyyppi }
     * 
     */
    public HenkiloTyyppi createHenkiloTyyppi() {
        return new HenkiloTyyppi();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetTyyppi }
     * 
     */
    public LukukausiIlmoittautumisetTyyppi createLukukausiIlmoittautumisetTyyppi() {
        return new LukukausiIlmoittautumisetTyyppi();
    }

    /**
     * Create an instance of {@link OpiskelijatTyyppi }
     * 
     */
    public OpiskelijatTyyppi createOpiskelijatTyyppi() {
        return new OpiskelijatTyyppi();
    }

    /**
     * Create an instance of {@link ArvosanaTyyppi }
     * 
     */
    public ArvosanaTyyppi createArvosanaTyyppi() {
        return new ArvosanaTyyppi();
    }

    /**
     * Create an instance of {@link LaajuusLaajennettuTyyppi }
     * 
     */
    public LaajuusLaajennettuTyyppi createLaajuusLaajennettuTyyppi() {
        return new LaajuusLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautuminenTyyppi }
     * 
     */
    public LukukausiIlmoittautuminenTyyppi createLukukausiIlmoittautuminenTyyppi() {
        return new LukukausiIlmoittautuminenTyyppi();
    }

    /**
     * Create an instance of {@link KoulutusalaVersioOPMALATyyppi }
     * 
     */
    public KoulutusalaVersioOPMALATyyppi createKoulutusalaVersioOPMALATyyppi() {
        return new KoulutusalaVersioOPMALATyyppi();
    }

    /**
     * Create an instance of {@link KoulutusalaVersioOPM95OPATyyppi }
     * 
     */
    public KoulutusalaVersioOPM95OPATyyppi createKoulutusalaVersioOPM95OPATyyppi() {
        return new KoulutusalaVersioOPM95OPATyyppi();
    }

    /**
     * Create an instance of {@link OrganisaatioRooliOsuusLaajennettu1Tyyppi }
     * 
     */
    public OrganisaatioRooliOsuusLaajennettu1Tyyppi createOrganisaatioRooliOsuusLaajennettu1Tyyppi() {
        return new OrganisaatioRooliOsuusLaajennettu1Tyyppi();
    }

    /**
     * Create an instance of {@link OpintosuoritusTyyppi.Sisaltyvyys }
     * 
     */
    public OpintosuoritusTyyppi.Sisaltyvyys createOpintosuoritusTyyppiSisaltyvyys() {
        return new OpintosuoritusTyyppi.Sisaltyvyys();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.Tila }
     * 
     */
    public OpiskeluoikeusTyyppi.Tila createOpiskeluoikeusTyyppiTila() {
        return new OpiskeluoikeusTyyppi.Tila();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.Jakso }
     * 
     */
    public OpiskeluoikeusTyyppi.Jakso createOpiskeluoikeusTyyppiJakso() {
        return new OpiskeluoikeusTyyppi.Jakso();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.Liittyvyys }
     * 
     */
    public OpiskeluoikeusTyyppi.Liittyvyys createOpiskeluoikeusTyyppiLiittyvyys() {
        return new OpiskeluoikeusTyyppi.Liittyvyys();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija }
     * 
     */
    public OpiskeluoikeusTyyppi.SiirtoOpiskelija createOpiskeluoikeusTyyppiSiirtoOpiskelija() {
        return new OpiskeluoikeusTyyppi.SiirtoOpiskelija();
    }

    /**
     * Create an instance of {@link ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana }
     * 
     */
    public ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana createArvosanaAsteikkoMuuTyyppiAsteikkoAsteikkoArvosana() {
        return new ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tietovaranto.csc.fi/luku", name = "organisaatio")
    public JAXBElement<String> createOrganisaatio(String value) {
        return new JAXBElement<String>(_Organisaatio_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LukukausiIlmoittautumisetLaajennettuTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2013/01/29", name = "LukukausiIlmoittautumiset")
    public JAXBElement<LukukausiIlmoittautumisetLaajennettuTyyppi> createLukukausiIlmoittautumiset(LukukausiIlmoittautumisetLaajennettuTyyppi value) {
        return new JAXBElement<LukukausiIlmoittautumisetLaajennettuTyyppi>(_LukukausiIlmoittautumiset_QNAME, LukukausiIlmoittautumisetLaajennettuTyyppi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpintosuorituksetLaajennettuTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2013/01/29", name = "Opintosuoritukset")
    public JAXBElement<OpintosuorituksetLaajennettuTyyppi> createOpintosuoritukset(OpintosuorituksetLaajennettuTyyppi value) {
        return new JAXBElement<OpintosuorituksetLaajennettuTyyppi>(_Opintosuoritukset_QNAME, OpintosuorituksetLaajennettuTyyppi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpiskelijatLaajennettuTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2013/01/29", name = "Opiskelijat")
    public JAXBElement<OpiskelijatLaajennettuTyyppi> createOpiskelijat(OpiskelijatLaajennettuTyyppi value) {
        return new JAXBElement<OpiskelijatLaajennettuTyyppi>(_Opiskelijat_QNAME, OpiskelijatLaajennettuTyyppi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpiskeluoikeudetLaajennettuTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2013/01/29", name = "Opiskeluoikeudet")
    public JAXBElement<OpiskeluoikeudetLaajennettuTyyppi> createOpiskeluoikeudet(OpiskeluoikeudetLaajennettuTyyppi value) {
        return new JAXBElement<OpiskeluoikeudetLaajennettuTyyppi>(_Opiskeluoikeudet_QNAME, OpiskeluoikeudetLaajennettuTyyppi.class, null, value);
    }

}
