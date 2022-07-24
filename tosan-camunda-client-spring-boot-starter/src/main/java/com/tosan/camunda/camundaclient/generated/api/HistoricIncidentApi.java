/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricIncidentDto;
import java.time.OffsetDateTime;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface HistoricIncidentApi {

    Logger log = LoggerFactory.getLogger(HistoricIncidentApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Get Incidents", description = "Queries for historic incidents that fulfill given parameters. The size of the result set can be retrieved by using the [Get Incident Count](https://docs.camunda.org/manual/7.17/reference/rest/history/incident/get-incident-query-count/) method.", tags={ "Historic Incident" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricIncidentDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/incident",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<HistoricIncidentDto>> getHistoricIncidents(@Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given id." ,schema=@Schema()) @Valid @RequestParam(value = "incidentId", required = false) String incidentId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to the given incident type. See the [User Guide](/manual/develop/user-guide/process-engine/incidents/#incident-types) for a list of incident types." ,schema=@Schema()) @Valid @RequestParam(value = "incidentType", required = false) String incidentType, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given incident message." ,schema=@Schema()) @Valid @RequestParam(value = "incidentMessage", required = false) String incidentMessage, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character '%' to express like-strategy: starts with (string%), ends with (%string) or contains (%string%). " ,schema=@Schema()) @Valid @RequestParam(value = "incidentMessageLike", required = false) String incidentMessageLike, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to a process definition with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given processDefinitionKey." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKey", required = false) String processDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have one of the given process definition keys." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKeyIn", required = false) String processDefinitionKeyIn, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to a process instance with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to an execution with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "executionId", required = false) String executionId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have a createTime date before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "createTimeBefore", required = false) OffsetDateTime createTimeBefore, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have a createTime date after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "createTimeAfter", required = false) OffsetDateTime createTimeAfter, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have an endTimeBefore date before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "endTimeBefore", required = false) OffsetDateTime endTimeBefore, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have an endTimeAfter date after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "endTimeAfter", required = false) OffsetDateTime endTimeAfter, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to an activity with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "activityId", required = false) String activityId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that were created due to the failure of an activity with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "failedActivityId", required = false) String failedActivityId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given incident id as cause incident." ,schema=@Schema()) @Valid @RequestParam(value = "causeIncidentId", required = false) String causeIncidentId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given incident id as root cause incident." ,schema=@Schema()) @Valid @RequestParam(value = "rootCauseIncidentId", required = false) String rootCauseIncidentId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given parameter set as configuration." ,schema=@Schema()) @Valid @RequestParam(value = "configuration", required = false) String _configuration, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given parameter set as history configuration." ,schema=@Schema()) @Valid @RequestParam(value = "historyConfiguration", required = false) String historyConfiguration, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that are open." ,schema=@Schema()) @Valid @RequestParam(value = "open", required = false) Boolean open, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that are resolved." ,schema=@Schema()) @Valid @RequestParam(value = "resolved", required = false) Boolean resolved, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that are deleted." ,schema=@Schema()) @Valid @RequestParam(value = "deleted", required = false) Boolean deleted, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have one of the given comma-separated tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic incidents that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have one of the given comma-separated job definition ids." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionIdIn", required = false) String jobDefinitionIdIn, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "incidentId", "incidentMessage", "createTime", "endTime", "incidentType", "executionId", "activityId", "processInstanceId", "processDefinitionId", "processDefinitionKey", "causeIncidentId", "rootCauseIncidentId", "configuration", "historyConfiguration", "tenantId", "incidentState" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder);


    @Operation(summary = "Get Incident Count", description = "Queries for the number of historic incidents that fulfill the given parameters. Takes the same parameters as the [Get Incidents](https://docs.camunda.org/manual/7.17/reference/rest/history/incident/get-incident-query/) method.", tags={ "Historic Incident" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/incident/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getHistoricIncidentsCount(@Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given id." ,schema=@Schema()) @Valid @RequestParam(value = "incidentId", required = false) String incidentId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to the given incident type. See the [User Guide](/manual/develop/user-guide/process-engine/incidents/#incident-types) for a list of incident types." ,schema=@Schema()) @Valid @RequestParam(value = "incidentType", required = false) String incidentType, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given incident message." ,schema=@Schema()) @Valid @RequestParam(value = "incidentMessage", required = false) String incidentMessage, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character '%' to express like-strategy: starts with (string%), ends with (%string) or contains (%string%). " ,schema=@Schema()) @Valid @RequestParam(value = "incidentMessageLike", required = false) String incidentMessageLike, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to a process definition with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given processDefinitionKey." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKey", required = false) String processDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have one of the given process definition keys." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKeyIn", required = false) String processDefinitionKeyIn, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to a process instance with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to an execution with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "executionId", required = false) String executionId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have a createTime date before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "createTimeBefore", required = false) OffsetDateTime createTimeBefore, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have a createTime date after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "createTimeAfter", required = false) OffsetDateTime createTimeAfter, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have an endTimeBefore date before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "endTimeBefore", required = false) OffsetDateTime endTimeBefore, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have an endTimeAfter date after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "endTimeAfter", required = false) OffsetDateTime endTimeAfter, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that belong to an activity with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "activityId", required = false) String activityId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that were created due to the failure of an activity with the given id." ,schema=@Schema()) @Valid @RequestParam(value = "failedActivityId", required = false) String failedActivityId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given incident id as cause incident." ,schema=@Schema()) @Valid @RequestParam(value = "causeIncidentId", required = false) String causeIncidentId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given incident id as root cause incident." ,schema=@Schema()) @Valid @RequestParam(value = "rootCauseIncidentId", required = false) String rootCauseIncidentId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given parameter set as configuration." ,schema=@Schema()) @Valid @RequestParam(value = "configuration", required = false) String _configuration, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have the given parameter set as history configuration." ,schema=@Schema()) @Valid @RequestParam(value = "historyConfiguration", required = false) String historyConfiguration, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that are open." ,schema=@Schema()) @Valid @RequestParam(value = "open", required = false) Boolean open, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that are resolved." ,schema=@Schema()) @Valid @RequestParam(value = "resolved", required = false) Boolean resolved, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that are deleted." ,schema=@Schema()) @Valid @RequestParam(value = "deleted", required = false) Boolean deleted, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have one of the given comma-separated tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic incidents that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to incidents that have one of the given comma-separated job definition ids." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionIdIn", required = false) String jobDefinitionIdIn, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "incidentId", "incidentMessage", "createTime", "endTime", "incidentType", "executionId", "activityId", "processInstanceId", "processDefinitionId", "processDefinitionKey", "causeIncidentId", "rootCauseIncidentId", "configuration", "historyConfiguration", "tenantId", "incidentState" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder);

}
