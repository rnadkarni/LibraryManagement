package com.lbg.ob.cnf.entitlement.domain.model;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/*import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbg.ob.cnf.entitlement.util.EntitlementHelper;*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lbg.ob.cnf.entitlement.util.EntitlementHelper;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.annotation.JsonbProperty;

import java.util.List;

//@JsonInclude(Include.NON_NULL)
//@Entity
//@Table(name = "ENTITLEMENT")
public final class GetEntitlement extends AbstractEntitlement {

   // @Transient

    @JsonbProperty("EntitledAgreementResources")
    private List<GetEntitledAgreementResource> entitledAgreementResources;

    //@Transient
    @JsonbProperty("EntitledSimpleImmediatePaymentInformationResource")
    private GetEntitledSimpleImmediatePaymentResource entitledSimpleImmediatePaymentInformationResource;

    //@Transient
    @JsonbProperty("EntitledStandingOrderResource")
    private GetEntitledStandingOrderResource entitledStandingOrderResource;

 //@Transient
    @JsonbProperty("EntitledScheduledPaymentResource")
    private GetEntitledScheduledPaymentResource entitledScheduledPaymentResource;

     //  @Transient

    @JsonbProperty("EntitlementStatusChangeHistory")
    private List<EntitlementStatusChangeHistory> entitlementStatusChangeHistory;

  //  @Transient
    @JsonbProperty("EntitlementReauthHistory")
    private List<EntitlementReauthHistory> entitlementReauthHistory;

  // @Transient
    @JsonbProperty("EntitledInternationalImmediatePaymentResource")
    private GetEntitledInternationalImmediatePaymentResource entitledInternationalImmediatePaymentResource;

    // @Transient
    @JsonbProperty("EntitledVariableRecurringPaymentResource")
    private GetEntitledVariableRecurringPaymentResource entitledVariableRecurringPaymentResource;

  //  @Transient
    @JsonbProperty("EntitledFilePaymentResource")
    private EntitledFilePaymentResource entitledFilePaymentResource;

   // @Transient

    private long authTime;

  //public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public GetEntitlement() {
        //Default constructor
    }

  /*    @JsonProperty("CreatedDateTime")
    public String getCreatedTimestampString() {
        return createdTimestampString;
    }

    public void setCreatedTimestampString(Timestamp createDateTime) {
        this.createdTimestampString = EntitlementHelper.formatDateAsISO8601(createDateTime.getTime());
    }

    @JsonIgnore
    public Timestamp getCreatedDateTime() {
        return (Timestamp) createdDateTime.clone();
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = new Timestamp(createdDateTime);
    }*/

   // @JsonProperty("EntitledAgreementResources")
    public List<GetEntitledAgreementResource> getEntitledAgreementResources() {
        return entitledAgreementResources;
    }

    public void setEntitledAgreementResources(List<GetEntitledAgreementResource> entitledAgreementResources) {
        this.entitledAgreementResources = entitledAgreementResources;
    }

   // @JsonProperty("EntitledSimpleImmediatePaymentInformationResource")
    public GetEntitledSimpleImmediatePaymentResource getEntitledSimpleImmediatePaymentInformationResource() {
        return entitledSimpleImmediatePaymentInformationResource;
    }

    public void setEntitledSimpleImmediatePaymentInformationResource(GetEntitledSimpleImmediatePaymentResource entitledSimpleImmediatePaymentInformationResource) {
        this.entitledSimpleImmediatePaymentInformationResource = entitledSimpleImmediatePaymentInformationResource;
    }

   // @JsonProperty("EntitledStandingOrderResource")
    public GetEntitledStandingOrderResource getEntitledStandingOrderResource() {
        return entitledStandingOrderResource;
    }

    public void setEntitledStandingOrderResource(GetEntitledStandingOrderResource entitledStandingOrderResource) {
        this.entitledStandingOrderResource = entitledStandingOrderResource;
    }

   //@JsonProperty("EntitledScheduledPaymentResource")
    public GetEntitledScheduledPaymentResource getEntitledScheduledPaymentResource() {
        return entitledScheduledPaymentResource;
    }

    public void setEntitledScheduledPaymentResource(GetEntitledScheduledPaymentResource entitledScheduledPaymentResource) {
        this.entitledScheduledPaymentResource = entitledScheduledPaymentResource;
    }

   // @JsonProperty("EntitlementStatusChangeHistory")
    public List<EntitlementStatusChangeHistory> getEntitlementStatusChangeHistory() {
        return entitlementStatusChangeHistory;
    }

    public void setEntitlementStatusChangeHistory(List<EntitlementStatusChangeHistory> entitlementStatusChangeHistory) {
        this.entitlementStatusChangeHistory = entitlementStatusChangeHistory;
    }

   //  @JsonProperty("EntitlementReauthHistory")
    public List<EntitlementReauthHistory> getEntitlementReauthHistory() {
        return entitlementReauthHistory;
    }

    public void setEntitlementReauthHistory(List<EntitlementReauthHistory> entitlementReauthHistory) {
        this.entitlementReauthHistory = entitlementReauthHistory;
    }

    public static GetEntitlement getEntitlementFromJsonString(String jsonString) throws IOException {
       // return OBJECT_MAPPER.readValue(jsonString, GetEntitlement.class);

        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.fromJson(jsonString, GetEntitlement.class);
    }

   // @JsonProperty("EntitledInternationalImmediatePaymentResource")
    public GetEntitledInternationalImmediatePaymentResource getEntitledInternationalImmediatePaymentResource() {
        return entitledInternationalImmediatePaymentResource;
    }

    public void setEntitledInternationalImmediatePaymentResource(
            GetEntitledInternationalImmediatePaymentResource entitledInternationalImmediatePaymentResource) {
        this.entitledInternationalImmediatePaymentResource = entitledInternationalImmediatePaymentResource;
    }

   //@JsonProperty("EntitledVariableRecurringPaymentResource")
    public GetEntitledVariableRecurringPaymentResource getEntitledVariableRecurringPaymentResource() {
        return entitledVariableRecurringPaymentResource;
    }

    public void setEntitledVariableRecurringPaymentResource(GetEntitledVariableRecurringPaymentResource entitledVariableRecurringPaymentResource) {
        this.entitledVariableRecurringPaymentResource = entitledVariableRecurringPaymentResource;
    }

    // @JsonProperty("EntitledFilePaymentResource")
    public EntitledFilePaymentResource getEntitledFilePaymentResource() {
        return entitledFilePaymentResource;
    }

    public void setEntitledFilePaymentResource(EntitledFilePaymentResource entitledFilePaymentResource) {
        this.entitledFilePaymentResource = entitledFilePaymentResource;
    }

   // @JsonIgnore

    public long getAuthTime() {
        return authTime;
    }

    public void setAuthTime(long authTime) {
        this.authTime = authTime;
    }
}