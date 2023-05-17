/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricDetailDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricDetailQueryDto;
import java.time.OffsetDateTime;
import org.springframework.core.io.Resource;
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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface HistoricDetailApi {

    Logger log = LoggerFactory.getLogger(HistoricDetailApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Get Historic Details", description = "Queries for historic details that fulfill the given parameters. The size of the result set can be retrieved by using the [Get Historic Detail Count](https://docs.camunda.org/manual/7.17/reference/rest/history/detail/get-detail-query-count/) method.", tags={ "Historic Detail" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricDetailDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/detail",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<HistoricDetailDto>> getHistoricDetails(@Parameter(in = ParameterIn.QUERY, description = "Filter by process instance id." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Only include historic details which belong to one of the passed comma-separated process instance ids." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceIdIn", required = false) String processInstanceIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by execution id." ,schema=@Schema()) @Valid @RequestParam(value = "executionId", required = false) String executionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by task id." ,schema=@Schema()) @Valid @RequestParam(value = "taskId", required = false) String taskId, @Parameter(in = ParameterIn.QUERY, description = "Filter by activity instance id." ,schema=@Schema()) @Valid @RequestParam(value = "activityInstanceId", required = false) String activityInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by case instance id." ,schema=@Schema()) @Valid @RequestParam(value = "caseInstanceId", required = false) String caseInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by case execution id." ,schema=@Schema()) @Valid @RequestParam(value = "caseExecutionId", required = false) String caseExecutionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by variable instance id." ,schema=@Schema()) @Valid @RequestParam(value = "variableInstanceId", required = false) String variableInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Only include historic details where the variable updates belong to one of the passed comma-separated list of variable types. A list of all supported variable types can be found [here](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/#supported-variable-values). **Note:** All non-primitive variables are associated with the type `serializable`." ,schema=@Schema()) @Valid @RequestParam(value = "variableTypeIn", required = false) String variableTypeIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic details that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Filter by a user operation id." ,schema=@Schema()) @Valid @RequestParam(value = "userOperationId", required = false) String userOperationId, @Parameter(in = ParameterIn.QUERY, description = "Only include `HistoricFormFields`. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "formFields", required = false) Boolean formFields, @Parameter(in = ParameterIn.QUERY, description = "Only include `HistoricVariableUpdates`. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "variableUpdates", required = false) Boolean variableUpdates, @Parameter(in = ParameterIn.QUERY, description = "Excludes all task-related `HistoricDetails`, so only items which have no task id set will be selected. When this parameter is used together with `taskId`, this call is ignored and task details are not excluded. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "excludeTaskDetails", required = false) Boolean excludeTaskDetails, @Parameter(in = ParameterIn.QUERY, description = "Restrict to historic variable updates that contain only initial variable values. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "initial", required = false) Boolean initial, @Parameter(in = ParameterIn.QUERY, description = "Restrict to historic details that occured before the given date (including the date). Default [format](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/) `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., 2013-01-23T14:42:45.000+0200." ,schema=@Schema()) @Valid @RequestParam(value = "occurredBefore", required = false) OffsetDateTime occurredBefore, @Parameter(in = ParameterIn.QUERY, description = "Restrict to historic details that occured after the given date (including the date). Default [format](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/) `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., 2013-01-23T14:42:45.000+0200." ,schema=@Schema()) @Valid @RequestParam(value = "occurredAfter", required = false) OffsetDateTime occurredAfter, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "processInstanceId", "variableName", "variableType", "variableRevision", "formPropertyId", "time", "occurrence", "tenantId" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults, @Parameter(in = ParameterIn.QUERY, description = "Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default `true`).  If set to `true`, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson's](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API's classpath.  If set to `false`, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note:** While `true` is the default value for reasons of backward compatibility, we recommend setting this parameter to `false` when developing web applications that are independent of the Java process applications deployed to the engine." ,schema=@Schema()) @Valid @RequestParam(value = "deserializeValues", required = false) Boolean deserializeValues);


    @Operation(summary = "Get Historic Detail Count", description = "Queries for the number of historic details that fulfill the given parameters. Takes the same parameters as the [Get Historic Details](https://docs.camunda.org/manual/7.17/reference/rest/history/detail/get-detail-query/) method.", tags={ "Historic Detail" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/detail/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getHistoricDetailsCount(@Parameter(in = ParameterIn.QUERY, description = "Filter by process instance id." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Only include historic details which belong to one of the passed comma-separated process instance ids." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceIdIn", required = false) String processInstanceIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by execution id." ,schema=@Schema()) @Valid @RequestParam(value = "executionId", required = false) String executionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by task id." ,schema=@Schema()) @Valid @RequestParam(value = "taskId", required = false) String taskId, @Parameter(in = ParameterIn.QUERY, description = "Filter by activity instance id." ,schema=@Schema()) @Valid @RequestParam(value = "activityInstanceId", required = false) String activityInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by case instance id." ,schema=@Schema()) @Valid @RequestParam(value = "caseInstanceId", required = false) String caseInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by case execution id." ,schema=@Schema()) @Valid @RequestParam(value = "caseExecutionId", required = false) String caseExecutionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by variable instance id." ,schema=@Schema()) @Valid @RequestParam(value = "variableInstanceId", required = false) String variableInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Only include historic details where the variable updates belong to one of the passed comma-separated list of variable types. A list of all supported variable types can be found [here](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/#supported-variable-values). **Note:** All non-primitive variables are associated with the type `serializable`." ,schema=@Schema()) @Valid @RequestParam(value = "variableTypeIn", required = false) String variableTypeIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic details that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Filter by a user operation id." ,schema=@Schema()) @Valid @RequestParam(value = "userOperationId", required = false) String userOperationId, @Parameter(in = ParameterIn.QUERY, description = "Only include `HistoricFormFields`. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "formFields", required = false) Boolean formFields, @Parameter(in = ParameterIn.QUERY, description = "Only include `HistoricVariableUpdates`. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "variableUpdates", required = false) Boolean variableUpdates, @Parameter(in = ParameterIn.QUERY, description = "Excludes all task-related `HistoricDetails`, so only items which have no task id set will be selected. When this parameter is used together with `taskId`, this call is ignored and task details are not excluded. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "excludeTaskDetails", required = false) Boolean excludeTaskDetails, @Parameter(in = ParameterIn.QUERY, description = "Restrict to historic variable updates that contain only initial variable values. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "initial", required = false) Boolean initial, @Parameter(in = ParameterIn.QUERY, description = "Restrict to historic details that occured before the given date (including the date). Default [format](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/) `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., 2013-01-23T14:42:45.000+0200." ,schema=@Schema()) @Valid @RequestParam(value = "occurredBefore", required = false) OffsetDateTime occurredBefore, @Parameter(in = ParameterIn.QUERY, description = "Restrict to historic details that occured after the given date (including the date). Default [format](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/) `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., 2013-01-23T14:42:45.000+0200." ,schema=@Schema()) @Valid @RequestParam(value = "occurredAfter", required = false) OffsetDateTime occurredAfter);


    @Operation(summary = "Get Historic Detail", description = "Retrieves a historic detail by id.", tags={ "Historic Detail" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HistoricDetailDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/detail/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HistoricDetailDto> historicDetail(@Parameter(in = ParameterIn.PATH, description = "The id of the detail.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.QUERY, description = "Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default `true`).  If set to `true`, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson's](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API's classpath.  If set to `false`, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note:** While `true` is the default value for reasons of backward compatibility, we recommend setting this parameter to `false` when developing web applications that are independent of the Java process applications deployed to the engine." ,schema=@Schema()) @Valid @RequestParam(value = "deserializeValue", required = false) Boolean deserializeValue);


    @Operation(summary = "Get Historic Detail (Binary)", description = "Retrieves the content of a historic variable update by id. Applicable for byte array and file variables.", tags={ "Historic Detail" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = Resource.class))),
        
        @ApiResponse(responseCode = "400", description = "Detail with given id exists but is not a binary variable. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Detail with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/detail/{id}/data",
        produces = { "application/octet-stream", "*/*", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Resource> historicDetailBinary(@Parameter(in = ParameterIn.PATH, description = "The id of the historic variable update.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get Historic Details (POST)", description = "Queries for historic details that fulfill the given parameters. This method is slightly more powerful than the [Get Historic Details](https://docs.camunda.org/manual/7.17/reference/rest/history/detail/get-detail-query/) method because it allows sorting by multiple parameters. The size of the result set can be retrieved by using the [Get Historic Detail Count](https://docs.camunda.org/manual/7.17/reference/rest/history/detail/get-detail-query-count/) method.", tags={ "Historic Detail" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricDetailDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/detail",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<HistoricDetailDto>> queryHistoricDetails(@Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults, @Parameter(in = ParameterIn.QUERY, description = "Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default `true`).  If set to `true`, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson's](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API's classpath.  If set to `false`, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note:** While `true` is the default value for reasons of backward compatibility, we recommend setting this parameter to `false` when developing web applications that are independent of the Java process applications deployed to the engine." ,schema=@Schema()) @Valid @RequestParam(value = "deserializeValues", required = false) Boolean deserializeValues, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody HistoricDetailQueryDto body);

}

