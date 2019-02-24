
package wst.lab1.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for menagerie complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="menagerie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="animal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrival" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="breed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="health" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "menagerie", propOrder = {
        "animal",
        "arrival",
        "breed",
        "health",
        "id",
        "name"
})
public class Menagerie {

    protected String animal;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrival;
    protected String breed;
    protected String health;
    protected Long id;
    protected String name;

    /**
     * Gets the value of the animal property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Sets the value of the animal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAnimal(String value) {
        this.animal = value;
    }

    /**
     * Gets the value of the arrival property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getArrival() {
        return arrival;
    }

    /**
     * Sets the value of the arrival property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setArrival(XMLGregorianCalendar value) {
        this.arrival = value;
    }

    /**
     * Gets the value of the breed property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the value of the breed property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBreed(String value) {
        this.breed = value;
    }

    /**
     * Gets the value of the health property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHealth() {
        return health;
    }

    /**
     * Sets the value of the health property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHealth(String value) {
        this.health = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

}
