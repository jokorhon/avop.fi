
package fi.csc.virta;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArvosanaToinenKotimainenKoodiTyyppi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArvosanaToinenKotimainenKoodiTyyppi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;maxLength value="20"/>
 *     &lt;enumeration value="TT"/>
 *     &lt;enumeration value="HT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArvosanaToinenKotimainenKoodiTyyppi")
@XmlEnum
public enum ArvosanaToinenKotimainenKoodiTyyppi {


    /**
     * 
     * 					Tyydyttävät tiedot
     * 				
     * 
     */
    TT,

    /**
     * 
     * 					Hyvät tiedot
     * 				
     * 
     */
    HT;

    public String value() {
        return name();
    }

    public static ArvosanaToinenKotimainenKoodiTyyppi fromValue(String v) {
        return valueOf(v);
    }

}
