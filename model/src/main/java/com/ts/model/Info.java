package com.ts.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Info implements Serializable{
    private Integer id;

    private String identification;

    private String socialSecurityCards;

    private String fiscard;

    private String insuredYear;

    private BigDecimal price;

    private String securityType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getSocialSecurityCards() {
        return socialSecurityCards;
    }

    public void setSocialSecurityCards(String socialSecurityCards) {
        this.socialSecurityCards = socialSecurityCards == null ? null : socialSecurityCards.trim();
    }

    public String getFiscard() {
        return fiscard;
    }

    public void setFiscard(String fiscard) {
        this.fiscard = fiscard == null ? null : fiscard.trim();
    }

    public String getInsuredYear() {
        return insuredYear;
    }

    public void setInsuredYear(String insuredYear) {
        this.insuredYear = insuredYear == null ? null : insuredYear.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType == null ? null : securityType.trim();
    }

    public Info() {

    }
}