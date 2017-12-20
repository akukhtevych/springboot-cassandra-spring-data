package com.highload.app.models;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.cassandra.core.PrimaryKeyType;
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
    private int issuerAccount;

    @Column(value = "recipient_account")
    private int recipientAccount;

    @Column(value = "value")
    private float value;

    public TransactionData() { };

    public TransactionData(UUID id, Date time, int issuerAccount, int recipientAccount, float value) {
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

    public int getIssuerAccount() {
        return issuerAccount;
    }

    public void setIssuerAccount(int issuerAccount) {
        this.issuerAccount = issuerAccount;
    }

    public int getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(int recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
