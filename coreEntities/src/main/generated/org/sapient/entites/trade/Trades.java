//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.22 at 09:56:04 AM IST 
//


package org.sapient.entites.trade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="trade" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="tradeType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="security" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="company" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "trade"
})
@XmlRootElement(name = "trades")
public class Trades implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(required = true)
    protected List<Trades.Trade> trade;

    /**
     * Gets the value of the trade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Trades.Trade }
     * 
     * 
     */
    public List<Trades.Trade> getTrade() {
        if (trade == null) {
            trade = new ArrayList<Trades.Trade>();
        }
        return this.trade;
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
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="tradeType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="security" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="company" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="amount" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Trade implements Serializable{
		private static final long serialVersionUID = 1L;
		@XmlAttribute(name = "id")
        protected Integer id;
        @XmlAttribute(name = "tradeType")
        protected String tradeType;
        @XmlAttribute(name = "security")
        protected String security;
        @XmlAttribute(name = "company")
        protected String company;
        @XmlAttribute(name = "quantity")
        protected Integer quantity;
        @XmlAttribute(name = "amount")
        protected Double amount;
        @XmlAttribute(name = "time")
        protected Long time;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setId(Integer value) {
            this.id = value;
        }

        /**
         * Gets the value of the tradeType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTradeType() {
            return tradeType;
        }

        /**
         * Sets the value of the tradeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTradeType(String value) {
            this.tradeType = value;
        }

        /**
         * Gets the value of the security property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSecurity() {
            return security;
        }

        /**
         * Sets the value of the security property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSecurity(String value) {
            this.security = value;
        }

        /**
         * Gets the value of the company property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompany() {
            return company;
        }

        /**
         * Sets the value of the company property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompany(String value) {
            this.company = value;
        }

        /**
         * Gets the value of the quantity property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setQuantity(Integer value) {
            this.quantity = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Double getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setAmount(Double value) {
            this.amount = value;
        }

        /**
         * Gets the value of the time property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Long getTime() {
            return time;
        }

        /**
         * Sets the value of the time property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setTime(Long value) {
            this.time = value;
        }

		@Override
		public String toString() {
			return "Trade [id=" + id + ", tradeType=" + tradeType + ", security=" + security + ", company=" + company
					+ ", quantity=" + quantity + ", amount=" + amount + ", time=" + time + "]";
		}
    }

}
