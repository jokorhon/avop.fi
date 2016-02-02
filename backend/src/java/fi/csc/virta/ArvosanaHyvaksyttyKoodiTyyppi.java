
package fi.csc.virta;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArvosanaHyvaksyttyKoodiTyyppi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArvosanaHyvaksyttyKoodiTyyppi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;maxLength value="20"/>
 *     &lt;enumeration value="HYV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArvosanaHyvaksyttyKoodiTyyppi")
@XmlEnum
public enum ArvosanaHyvaksyttyKoodiTyyppi {


    /**
     * 
     * 					Hyväksytty
     * 				
     * 
     */
    HYV;

    public String value() {
        return name();
    }

    public static ArvosanaHyvaksyttyKoodiTyyppi fromValue(String v) {
        return valueOf(v);
    }

}
