/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.BatchDto;
import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.DeleteHistoricDecisionInstancesDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricDecisionInstanceDto;
import java.time.OffsetDateTime;
import com.tosan.camunda.camundaclient.generated.model.SetRemovalTimeToHistoricDecisionInstancesDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface HistoricDecisionInstanceApi {

    Logger log = LoggerFactory.getLogger(HistoricDecisionInstanceApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Delete Async (POST)", description = "Delete multiple historic decision instances asynchronously (batch). At least `historicDecisionInstanceIds` or `historicDecisionInstanceQuery`  has to be provided. If both are provided then all instances matching query  criterion and instances from the list will be deleted.", tags={ "Historic Decision Instance" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BatchDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, i.e. neither `historicDecisionInstanceIds` nor `historicDecisionInstanceQuery` is present. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling)  for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/decision-instance/delete",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<BatchDto> deleteAsync(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody DeleteHistoricDecisionInstancesDto body);


    @Operation(summary = "Get Historic Decision Instance", description = "Retrieves a historic decision instance by id, according to the  `HistoricDecisionInstance` interface in the engine.", tags={ "Historic Decision Instance" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HistoricDecisionInstanceDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Historic decision instance with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/decision-instance/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HistoricDecisionInstanceDto> getHistoricDecisionInstance(@Parameter(in = ParameterIn.PATH, description = "The id of the historic decision instance to be retrieved.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.QUERY, description = "Include input values in the result. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "includeInputs", required = false) Boolean includeInputs, @Parameter(in = ParameterIn.QUERY, description = "Include output values in the result. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "includeOutputs", required = false) Boolean includeOutputs, @Parameter(in = ParameterIn.QUERY, description = "Disables fetching of byte array input and output values. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "disableBinaryFetching", required = false) Boolean disableBinaryFetching, @Parameter(in = ParameterIn.QUERY, description = "Disables deserialization of input and output values that are custom objects. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "disableCustomObjectDeserialization", required = false) Boolean disableCustomObjectDeserialization);


    @Operation(summary = "Get Historic Decision Instances", description = "Queries for historic decision instances that fulfill the given parameters.  The size of the result set can be retrieved by using the  [Get Historic Decision Instance Count](https://docs.camunda.org/manual/7.17/reference/rest/history/decision-instance/get-decision-instance-query-count/)  method.", tags={ "Historic Decision Instance" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricDecisionInstanceDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/decision-instance",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<HistoricDecisionInstanceDto>> getHistoricDecisionInstances(@Parameter(in = ParameterIn.QUERY, description = "Filter by decision instance id." ,schema=@Schema()) @Valid @RequestParam(value = "decisionInstanceId", required = false) String decisionInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by decision instance ids. Must be a comma-separated list of decision instance ids." ,schema=@Schema()) @Valid @RequestParam(value = "decisionInstanceIdIn", required = false) String decisionInstanceIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the decision definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionId", required = false) String decisionDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the decision definitions the instances belongs to. Must be a comma-separated list of decision definition ids." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionIdIn", required = false) String decisionDefinitionIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the decision definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionKey", required = false) String decisionDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by the keys of the decision definition the instances belongs to. Must be a comma- separated list of decision definition keys." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionKeyIn", required = false) String decisionDefinitionKeyIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the name of the decision definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionName", required = false) String decisionDefinitionName, @Parameter(in = ParameterIn.QUERY, description = "Filter by the name of the decision definition the instances belongs to, that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionNameLike", required = false) String decisionDefinitionNameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the process definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the process definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKey", required = false) String processDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by the process instance the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the case definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "caseDefinitionId", required = false) String caseDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the case definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "caseDefinitionKey", required = false) String caseDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by the case instance the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "caseInstanceId", required = false) String caseInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the activity ids the instances belongs to. Must be a comma-separated list of acitvity ids." ,schema=@Schema()) @Valid @RequestParam(value = "activityIdIn", required = false) String activityIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the activity instance ids the instances belongs to. Must be a comma-separated list of acitvity instance ids." ,schema=@Schema()) @Valid @RequestParam(value = "activityInstanceIdIn", required = false) String activityInstanceIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids. A historic decision instance must have one of the given tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic decision instances that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that were evaluated before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM- dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "evaluatedBefore", required = false) OffsetDateTime evaluatedBefore, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that were evaluated after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM- dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "evaluatedAfter", required = false) OffsetDateTime evaluatedAfter, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that were evaluated by the given user." ,schema=@Schema()) @Valid @RequestParam(value = "userId", required = false) String userId, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that have a given root decision instance id. This also includes the decision instance with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "rootDecisionInstanceId", required = false) String rootDecisionInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances those are the root decision instance of an evaluation. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "rootDecisionInstancesOnly", required = false) Boolean rootDecisionInstancesOnly, @Parameter(in = ParameterIn.QUERY, description = "Filter by the decision requirements definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionRequirementsDefinitionId", required = false) String decisionRequirementsDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the decision requirements definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionRequirementsDefinitionKey", required = false) String decisionRequirementsDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Include input values in the result. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "includeInputs", required = false) Boolean includeInputs, @Parameter(in = ParameterIn.QUERY, description = "Include output values in the result. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "includeOutputs", required = false) Boolean includeOutputs, @Parameter(in = ParameterIn.QUERY, description = "Disables fetching of byte array input and output values. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "disableBinaryFetching", required = false) Boolean disableBinaryFetching, @Parameter(in = ParameterIn.QUERY, description = "Disables deserialization of input and output values that are custom objects. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "disableCustomObjectDeserialization", required = false) Boolean disableCustomObjectDeserialization, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "evaluationTime", "tenantId" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get Historic Decision Instance Count", description = "Queries for the number of historic decision instances that fulfill the given parameters.  Takes the same parameters as the  [Get Historic Decision Instances](https://docs.camunda.org/manual/7.17/reference/rest/history/decision-instance/get-decision-instance-query/)  method.", tags={ "Historic Decision Instance" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/decision-instance/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getHistoricDecisionInstancesCount(@Parameter(in = ParameterIn.QUERY, description = "Filter by decision instance id." ,schema=@Schema()) @Valid @RequestParam(value = "decisionInstanceId", required = false) String decisionInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by decision instance ids. Must be a comma-separated list of decision instance ids." ,schema=@Schema()) @Valid @RequestParam(value = "decisionInstanceIdIn", required = false) String decisionInstanceIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the decision definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionId", required = false) String decisionDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the decision definitions the instances belongs to. Must be a comma-separated list of decision definition ids." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionIdIn", required = false) String decisionDefinitionIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the decision definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionKey", required = false) String decisionDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by the keys of the decision definition the instances belongs to. Must be a comma- separated list of decision definition keys." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionKeyIn", required = false) String decisionDefinitionKeyIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the name of the decision definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionName", required = false) String decisionDefinitionName, @Parameter(in = ParameterIn.QUERY, description = "Filter by the name of the decision definition the instances belongs to, that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "decisionDefinitionNameLike", required = false) String decisionDefinitionNameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the process definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the process definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKey", required = false) String processDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by the process instance the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the case definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "caseDefinitionId", required = false) String caseDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the case definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "caseDefinitionKey", required = false) String caseDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by the case instance the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "caseInstanceId", required = false) String caseInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the activity ids the instances belongs to. Must be a comma-separated list of acitvity ids." ,schema=@Schema()) @Valid @RequestParam(value = "activityIdIn", required = false) String activityIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the activity instance ids the instances belongs to. Must be a comma-separated list of acitvity instance ids." ,schema=@Schema()) @Valid @RequestParam(value = "activityInstanceIdIn", required = false) String activityInstanceIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids. A historic decision instance must have one of the given tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic decision instances that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that were evaluated before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM- dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "evaluatedBefore", required = false) OffsetDateTime evaluatedBefore, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that were evaluated after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM- dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "evaluatedAfter", required = false) OffsetDateTime evaluatedAfter, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that were evaluated by the given user." ,schema=@Schema()) @Valid @RequestParam(value = "userId", required = false) String userId, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances that have a given root decision instance id. This also includes the decision instance with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "rootDecisionInstanceId", required = false) String rootDecisionInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Restrict to instances those are the root decision instance of an evaluation. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "rootDecisionInstancesOnly", required = false) Boolean rootDecisionInstancesOnly, @Parameter(in = ParameterIn.QUERY, description = "Filter by the decision requirements definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionRequirementsDefinitionId", required = false) String decisionRequirementsDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by the key of the decision requirements definition the instances belongs to." ,schema=@Schema()) @Valid @RequestParam(value = "decisionRequirementsDefinitionKey", required = false) String decisionRequirementsDefinitionKey);


    @Operation(summary = "Set Removal Time Async (POST)", description = "Sets the removal time to multiple historic decision instances asynchronously (batch).  At least `historicDecisionInstanceIds` or `historicDecisionInstanceQuery` has to be provided. If both are provided, all instances matching query criterion and instances from the list will be updated with a removal time.", tags={ "Historic Decision Instance" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BatchDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Request was unsuccessfull due to a bad user request. This occurs if some of the query parameters are invalid, e. g. if neither historicDecisionInstances nor historicDecisionInstanceQuery is present or if no mode is specified.  See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/decision-instance/set-removal-time",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<BatchDto> setRemovalTimeAsyncHistoricDecisionInstance(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody SetRemovalTimeToHistoricDecisionInstancesDto body);

}
