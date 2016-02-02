
package fi.csc.virta;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArvosanaTutkielmaKoodiTyyppi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArvosanaTutkielmaKoodiTyyppi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;maxLength value="20"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="L"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArvosanaTutkielmaKoodiTyyppi")
@XmlEnum
public enum ArvosanaTutkielmaKoodiTyyppi {


    /**
     * 
     * 					Improbatur
     * 				
     * 
     */
    I,

    /**
     * 
     * 					Approbatur
     * 				
     * 
     */
    A,

    /**
     * 
     * 					Lubenter approbatur
     * 				
     * 
     */
    B,

    /**
     * 
     * 					Non sine laude approbatur
     * 				
     * 
     */
    N,

    /**
     * 
     * 					Cum laude approbatur
     * 				
     * 
     */
    C,

    /**
     * 
     * 					Magna cum laude approbatur
     * 				
     * 
     */
    M,

    /**
     * 
     * 					Eximia cum laude approbatur
     * 				
     * 
     */
    E,

    /**
     * 
     * 					Laudatur
     * 				
     * 
     */
    L;

    public String value() {
        return name();
    }

    public static ArvosanaTutkielmaKoodiTyyppi fromValue(String v) {
        return valueOf(v);
    }

}
