
package fi.csc.virta;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArvosanaEiKaytossaKoodiTyyppi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArvosanaEiKaytossaKoodiTyyppi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;maxLength value="20"/>
 *     &lt;enumeration value="Arvosana ei kaytossa"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArvosanaEiKaytossaKoodiTyyppi")
@XmlEnum
public enum ArvosanaEiKaytossaKoodiTyyppi {


    /**
     * 
     * 					Arvosana ei käytössä
     * 				
     * 
     */
    @XmlEnumValue("Arvosana ei kaytossa")
    ARVOSANA_EI_KAYTOSSA("Arvosana ei kaytossa");
    private final String value;

    ArvosanaEiKaytossaKoodiTyyppi(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ArvosanaEiKaytossaKoodiTyyppi fromValue(String v) {
        for (ArvosanaEiKaytossaKoodiTyyppi c: ArvosanaEiKaytossaKoodiTyyppi.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
