package com.lbg.ob.cnf.entitlement;

//import com.lbg.ob.cnf.entitlement.data.CreateEntitlementInputData;

import com.lbg.ob.cnf.entitlement.data.CreateEntitlementInputData;
import com.lbg.ob.cnf.entitlement.data.CreateEntitlementOutputData;
import com.lbg.ob.cnf.entitlement.data.GetEntitlementInputData;
import com.lbg.ob.cnf.entitlement.domain.model.*;
import com.lbg.ob.cnf.entitlement.enums.BrandEnum;
import com.lbg.ob.cnf.entitlement.enums.ChannelEnum;
import com.lbg.ob.cnf.entitlement.enums.InternalUserRoleEnum;
import com.lbg.ob.cnf.entitlement.exception.GenericRuntimeException;
import com.lbg.ob.cnf.entitlement.testData.EntitlementTestData;
import com.lbg.ob.cnf.entitlement.testData.GetEntitlementTestData;
import com.lbg.ob.cnf.entitlement.util.EntitlementConstant;
import com.lbg.ob.cnf.entitlement.util.EntitlementErrorConstant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestHeader;

import java.util.ArrayList;
import java.util.List;

@Path(value = "/")
public class EntitlementGetCreateController {


    // @ConfigProperty(name = "greetings")
    //String message;


    //@Path(value = "entitlements123")
    // @GET
    // @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public Response createEntitlement(@RestHeader(value = EntitlementConstant.X_LBG_INTERNAL_USER_ID) String internalUserId,
                                      @RestHeader(value = EntitlementConstant.X_LBG_INTERNAL_PARTY_ID) String internalPartyId,
                                      @RestHeader(value = EntitlementConstant.X_LBG_COMM_CLIENT_ID) String commercialClientId,
                                      @RestHeader(value = EntitlementConstant.X_LBG_INTERNAL_USER_ROLE) InternalUserRoleEnum internalUserRole,
                                      @RestHeader(value = EntitlementConstant.X_LBG_BRAND) final BrandEnum xLbgBrand,
                                      @RestHeader(value = EntitlementConstant.X_LBG_CHANNEL) final ChannelEnum xLbgChannel,
                                      @RestHeader(value = EntitlementConstant.X_LBG_TXN_CORRELATION_ID) String txnCorrelationId,
                                      @RestHeader(value = EntitlementConstant.X_LBG_FOV_INDICATOR) final Boolean fovIndicatorTemp,
                                      @RestHeader(value = EntitlementConstant.IS_REAUTH_QUERY_PARAM) final Boolean isReauthTemp,
                                      @RestHeader(value = EntitlementConstant.X_LBG_REAUTH_CONSENT_UPDATE) final Boolean updateConsentOnReauth,
                                      // @Valid
                                      CreateEntitlementInputData entitlementInputData) {


        //  return ()->{
        System.out.println("Sample json " + entitlementInputData.getIntentId());

        //  System.out.println("appliation property message "+message);
        EntitlementTestData entitlementTestData = new EntitlementTestData();
        CreateEntitlementOutputData response = entitlementTestData.createEntitlementData();
        Response build = Response.ok(response).build();
        return build;

    }


    /**
     * getEntitlement takes entitlementAccessCode for an Entitlement as a path parameter to retrieve
     * the Entitlement from the database. It is GET call and produces application/json
     *
     * @return Callable<GetEntitlement> Entitlement linked to entitlementAccessCode
     */
    //@IsAllowed(role = {"SYSTEM", "CUSTOMER"})
    @Path(value = "entitlements/{entitlementAccessCode}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //  @GetMapping(path = "/entitlements/{entitlementAccessCode}")
    public Response getEntitlement(
            @RestHeader(value = EntitlementConstant.X_LBG_INTERNAL_USER_ROLE)
            @NotNull(message = "Internal User role is missing") final InternalUserRoleEnum internalUserRole,
            @RestHeader(value = EntitlementConstant.X_LBG_TXN_CORRELATION_ID)
            @NotBlank(message = "Co-relation id is missing") final String txnCorrelationId,
            @RestHeader(value = EntitlementConstant.X_LBG_FOV_INDICATOR) final Boolean fovIndicatorTemp,
           @PathParam("entitlementAccessCode") String entitlementAccessCode) {

        System.out.println("Get Entitlements Accesscode >>>>>" + entitlementAccessCode);

        if (entitlementAccessCode.equalsIgnoreCase("2145")) {
            GenericRuntimeException errorResponse = new GenericRuntimeException(404, EntitlementErrorConstant.NOT_FOUND_ERROR_CODE, "Not found");

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(errorResponse.getError())
                    .build();
        }


        //Note : @JsonbTransient is equivalent to @JsonIgnore


       /* GetEntitlementInputData entitlementInputData = new GetEntitlementInputData();
        entitlementInputData.setInternalUserRole(internalUserRole);
        entitlementInputData.setTxnCorrelationId(txnCorrelationId);
        entitlementInputData.setEntitlementAccessCode(entitlementAccessCode);
        Boolean fovIndicator = BooleanUtils.isTrue(fovIndicatorTemp);
        String tppOrgId = StringUtils.isEmpty(request.getHeader(EntitlementConstant.X_TPP_ID)) ?  "NA" : request.getHeader(EntitlementConstant.X_TPP_ID);
        GetEntitlement getEntitlement = entitlementService.getEntitlement(entitlementInputData, txnCorrelationId, fovIndicator, tppOrgId);
        logger.trace("getEntitlement <-- EXIT");
        // return ResponseEntity.status(HttpStatus.OK).body(getEntitlement);*/


        GetEntitlementInputData entitlementInputData = new GetEntitlementInputData();
        entitlementInputData.setInternalUserRole(internalUserRole);
        entitlementInputData.setTxnCorrelationId(txnCorrelationId);
        entitlementInputData.setEntitlementAccessCode(entitlementAccessCode);
        // Boolean fovIndicator = BooleanUtils.isTrue(fovIndicatorTemp);


        GetEntitlementTestData entitlementResponse = new GetEntitlementTestData();

        GetEntitledAgreementResource getEntitledAgreementResource = entitlementResponse.updateAccessForAccountForEntitlementTest();

        //GetEntitledAgreementResource List
        List<GetEntitledAgreementResource> entitledAgreementResourceList = new ArrayList<>();
        entitledAgreementResourceList.add(getEntitledAgreementResource);

        //GetEntitledSimpleImmediatePaymentResource
        GetEntitledSimpleImmediatePaymentResource getEntitledSimpleImmediatePaymentResource = new GetEntitledSimpleImmediatePaymentResource();

        //GetEntitledStandingOrderResource
        GetEntitledStandingOrderResource getEntitledStandingOrderResource = entitlementResponse.getEntitlementStandingOrder();

        //GetEntitledScheduledPaymentResource
        GetEntitledScheduledPaymentResource getEntitledScheduledPaymentResource = entitlementResponse.getEntitlementScheduledPayment();

        //EntitlementReauthHistory
        EntitlementReauthHistory entitlementReauthHistory = entitlementResponse.getEntitlementReauthHistory();
        List<EntitlementReauthHistory> reauthHistoryListList = new ArrayList<>();
        reauthHistoryListList.add(entitlementReauthHistory);


        //GetEntitledScheduledPaymentResource
        EntitlementStatusChangeHistory getEntitlementStatusChangeHistory = entitlementResponse.getEntitlementStatusChangeHistory();
        List<EntitlementStatusChangeHistory> historyList = new ArrayList<>();
        historyList.add(getEntitlementStatusChangeHistory);

        //GetEntitledInternationalImmediatePaymentResource
        GetEntitledInternationalImmediatePaymentResource internationalImmediatePaymentResource = new GetEntitledInternationalImmediatePaymentResource();

        //GetEntitledVariableRecurringPaymentResource
        GetEntitledVariableRecurringPaymentResource entitledVariableRecurringPaymentResource = new GetEntitledVariableRecurringPaymentResource();

        //EntitledFilePaymentResource
        EntitledFilePaymentResource entitledFilePaymentResource = new EntitledFilePaymentResource();

        GetEntitlement getEntitlement = new GetEntitlement();
        getEntitlement.setEntitledAgreementResources(entitledAgreementResourceList);
        getEntitlement.setAuthTime(1);
        getEntitlement.setEntitledSimpleImmediatePaymentInformationResource(getEntitledSimpleImmediatePaymentResource);
        getEntitlement.setEntitledStandingOrderResource(getEntitledStandingOrderResource);
        getEntitlement.setEntitledScheduledPaymentResource(getEntitledScheduledPaymentResource);
        getEntitlement.setEntitlementStatusChangeHistory(historyList);
        getEntitlement.setEntitlementReauthHistory(reauthHistoryListList);
        getEntitlement.setEntitledInternationalImmediatePaymentResource(internationalImmediatePaymentResource);
        getEntitlement.setEntitledVariableRecurringPaymentResource(entitledVariableRecurringPaymentResource);
        getEntitlement.setEntitledFilePaymentResource(entitledFilePaymentResource);


        Response build = Response.ok(getEntitlement).build();
        return build;
    }


}
