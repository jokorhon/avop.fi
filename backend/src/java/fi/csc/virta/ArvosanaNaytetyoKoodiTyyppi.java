
package fi.csc.virta;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArvosanaNaytetyoKoodiTyyppi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArvosanaNaytetyoKoodiTyyppi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;maxLength value="20"/>
 *     &lt;enumeration value="HYV"/>
 *     &lt;enumeration value="KH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArvosanaNaytetyoKoodiTyyppi")
@XmlEnum
public enum ArvosanaNaytetyoKoodiTyyppi {


    /**
     * 
     * 					Hyväksytty
     * 				
     * 
     */
    HYV,

    /**
     * 
     * 					Kiittäen hyväksytty
     * 				
     * 
     */
    KH;

    public String value() {
        return name();
    }

    public static ArvosanaNaytetyoKoodiTyyppi fromValue(String v) {
        return valueOf(v);
    }

}
