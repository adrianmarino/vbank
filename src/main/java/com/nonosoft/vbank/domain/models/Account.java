package com.nonosoft.vbank.domain.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "CODE" }, name = "UK_ACCOUNT_CODE")
})
public class Account extends Model {

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    public Account() {}

    public Account(String code) {
        this.code = code;
        this.amount = new BigDecimal(0);
        this.active = true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
