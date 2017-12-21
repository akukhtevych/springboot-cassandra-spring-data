package com.highload.app.models;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
import java.util.Date;
import java.util.UUID;


@Table(value = "transactions")
public class TransactionData {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUIDs.timeBased();

    @Column(value = "time")
    private Date time = new java.util.Date();

    @Column(value = "issuer_account")
    private String issuerAccount;

    @Column(value = "recipient_account")
    private String recipientAccount;

    @Column(value = "value")
    private String value;

    @Transient
    @JsonIgnore
    @JsonProperty(value = "key")
    private String key;

    public TransactionData() { };

    public TransactionData(UUID id, Date time, String issuerAccount, String recipientAccount, String value) {
        this.id = id;
        this.time = time;
        this.issuerAccount = issuerAccount;
        this.recipientAccount = recipientAccount;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIssuerAccount() {
        return issuerAccount;
    }

    public void setIssuerAccount(String issuerAccount) {
        this.issuerAccount = issuerAccount;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
