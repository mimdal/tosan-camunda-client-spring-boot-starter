/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricJobLogDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricJobLogQueryDto;
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
public interface HistoricJobLogApi {

    Logger log = LoggerFactory.getLogger(HistoricJobLogApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Get Job Log", description = "Retrieves a historic job log by id.", tags={ "Historic Job Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HistoricJobLogDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Historic job log with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/job-log/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HistoricJobLogDto> getHistoricJobLog(@Parameter(in = ParameterIn.PATH, description = "The id of the log entry.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get Job Logs", description = "Queries for historic job logs that fulfill the given parameters. The size of the result set can be retrieved by using the [Get Job Log Count](https://docs.camunda.org/manual/7.17/reference/rest/history/job-log/get-job-log-query-count/) method.", tags={ "Historic Job Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricJobLogDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/job-log",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<HistoricJobLogDto>> getHistoricJobLogs(@Parameter(in = ParameterIn.QUERY, description = "Filter by historic job log id." ,schema=@Schema()) @Valid @RequestParam(value = "logId", required = false) String logId, @Parameter(in = ParameterIn.QUERY, description = "Filter by job id." ,schema=@Schema()) @Valid @RequestParam(value = "jobId", required = false) String jobId, @Parameter(in = ParameterIn.QUERY, description = "Filter by job exception message." ,schema=@Schema()) @Valid @RequestParam(value = "jobExceptionMessage", required = false) String jobExceptionMessage, @Parameter(in = ParameterIn.QUERY, description = "Filter by job definition id." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionId", required = false) String jobDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by job definition type. See the [User Guide](https://docs.camunda.org/manual/7.17/user-guide/process-engine/the-job-executor/#job-creation) for more information about job definition types." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionType", required = false) String jobDefinitionType, @Parameter(in = ParameterIn.QUERY, description = "Filter by job definition configuration." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionConfiguration", required = false) String jobDefinitionConfiguration, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job logs which belong to one of the passed activity ids." ,schema=@Schema()) @Valid @RequestParam(value = "activityIdIn", required = false) String activityIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job logs which belong to failures of one of the passed activity ids." ,schema=@Schema()) @Valid @RequestParam(value = "failedActivityIdIn", required = false) String failedActivityIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job logs which belong to one of the passed execution ids." ,schema=@Schema()) @Valid @RequestParam(value = "executionIdIn", required = false) String executionIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by process instance id." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by process definition id." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by process definition key." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKey", required = false) String processDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by deployment id." ,schema=@Schema()) @Valid @RequestParam(value = "deploymentId", required = false) String deploymentId, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job log entries which belong to one of the passed and comma- separated tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job log entries that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Filter by hostname." ,schema=@Schema()) @Valid @RequestParam(value = "hostname", required = false) String hostname, @Parameter(in = ParameterIn.QUERY, description = "Only include logs for which the associated job had a priority lower than or equal to the given value. Value must be a valid `long` value." ,schema=@Schema()) @Valid @RequestParam(value = "jobPriorityLowerThanOrEquals", required = false) Long jobPriorityLowerThanOrEquals, @Parameter(in = ParameterIn.QUERY, description = "Only include logs for which the associated job had a priority higher than or equal to the given value. Value must be a valid `long` value." ,schema=@Schema()) @Valid @RequestParam(value = "jobPriorityHigherThanOrEquals", required = false) Long jobPriorityHigherThanOrEquals, @Parameter(in = ParameterIn.QUERY, description = "Only include creation logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "creationLog", required = false) Boolean creationLog, @Parameter(in = ParameterIn.QUERY, description = "Only include failure logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "failureLog", required = false) Boolean failureLog, @Parameter(in = ParameterIn.QUERY, description = "Only include success logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "successLog", required = false) Boolean successLog, @Parameter(in = ParameterIn.QUERY, description = "Only include deletion logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "deletionLog", required = false) Boolean deletionLog, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "timestamp", "jobId", "jobDefinitionId", "jobDueDate", "jobRetries", "jobPriority", "activityId", "executionId", "processInstanceId", "processDefinitionId", "processDefinitionKey", "deploymentId", "hostname", "occurrence", "tenantId" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get Job Log Count", description = "Queries for the number of historic job logs that fulfill the given parameters. Takes the same parameters as the [Get Job Logs](https://docs.camunda.org/manual/7.17/reference/rest/history/job-log/get-job-log-query/) method.", tags={ "Historic Job Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/job-log/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getHistoricJobLogsCount(@Parameter(in = ParameterIn.QUERY, description = "Filter by historic job log id." ,schema=@Schema()) @Valid @RequestParam(value = "logId", required = false) String logId, @Parameter(in = ParameterIn.QUERY, description = "Filter by job id." ,schema=@Schema()) @Valid @RequestParam(value = "jobId", required = false) String jobId, @Parameter(in = ParameterIn.QUERY, description = "Filter by job exception message." ,schema=@Schema()) @Valid @RequestParam(value = "jobExceptionMessage", required = false) String jobExceptionMessage, @Parameter(in = ParameterIn.QUERY, description = "Filter by job definition id." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionId", required = false) String jobDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by job definition type. See the [User Guide](https://docs.camunda.org/manual/7.17/user-guide/process-engine/the-job-executor/#job-creation) for more information about job definition types." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionType", required = false) String jobDefinitionType, @Parameter(in = ParameterIn.QUERY, description = "Filter by job definition configuration." ,schema=@Schema()) @Valid @RequestParam(value = "jobDefinitionConfiguration", required = false) String jobDefinitionConfiguration, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job logs which belong to one of the passed activity ids." ,schema=@Schema()) @Valid @RequestParam(value = "activityIdIn", required = false) String activityIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job logs which belong to failures of one of the passed activity ids." ,schema=@Schema()) @Valid @RequestParam(value = "failedActivityIdIn", required = false) String failedActivityIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job logs which belong to one of the passed execution ids." ,schema=@Schema()) @Valid @RequestParam(value = "executionIdIn", required = false) String executionIdIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by process instance id." ,schema=@Schema()) @Valid @RequestParam(value = "processInstanceId", required = false) String processInstanceId, @Parameter(in = ParameterIn.QUERY, description = "Filter by process definition id." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId, @Parameter(in = ParameterIn.QUERY, description = "Filter by process definition key." ,schema=@Schema()) @Valid @RequestParam(value = "processDefinitionKey", required = false) String processDefinitionKey, @Parameter(in = ParameterIn.QUERY, description = "Filter by deployment id." ,schema=@Schema()) @Valid @RequestParam(value = "deploymentId", required = false) String deploymentId, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job log entries which belong to one of the passed and comma- separated tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include historic job log entries that belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Filter by hostname." ,schema=@Schema()) @Valid @RequestParam(value = "hostname", required = false) String hostname, @Parameter(in = ParameterIn.QUERY, description = "Only include logs for which the associated job had a priority lower than or equal to the given value. Value must be a valid `long` value." ,schema=@Schema()) @Valid @RequestParam(value = "jobPriorityLowerThanOrEquals", required = false) Long jobPriorityLowerThanOrEquals, @Parameter(in = ParameterIn.QUERY, description = "Only include logs for which the associated job had a priority higher than or equal to the given value. Value must be a valid `long` value." ,schema=@Schema()) @Valid @RequestParam(value = "jobPriorityHigherThanOrEquals", required = false) Long jobPriorityHigherThanOrEquals, @Parameter(in = ParameterIn.QUERY, description = "Only include creation logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "creationLog", required = false) Boolean creationLog, @Parameter(in = ParameterIn.QUERY, description = "Only include failure logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "failureLog", required = false) Boolean failureLog, @Parameter(in = ParameterIn.QUERY, description = "Only include success logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "successLog", required = false) Boolean successLog, @Parameter(in = ParameterIn.QUERY, description = "Only include deletion logs. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "deletionLog", required = false) Boolean deletionLog);


    @Operation(summary = "Get Job Log Exception Stacktrace", description = "Retrieves the corresponding exception stacktrace to the passed historic job log by id.", tags={ "Historic Job Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = Object.class))),
        
        @ApiResponse(responseCode = "404", description = "Historic job log with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/job-log/{id}/stacktrace",
        produces = { "text/plain", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getStacktraceHistoricJobLog(@Parameter(in = ParameterIn.PATH, description = "The id of the historic job log to get the exception stacktrace for.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get Job Logs (POST)", description = "Queries for historic job logs that fulfill the given parameters. This method is slightly more powerful than the [Get Job Logs](https://docs.camunda.org/manual/7.17/reference/rest/history/job-log/get-job-log-query/) method because it allows filtering by historic job logs values of the different types `String`, `Number` or `Boolean`.", tags={ "Historic Job Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricJobLogDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/job-log",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<HistoricJobLogDto>> queryHistoricJobLogs(@Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody HistoricJobLogQueryDto body);


    @Operation(summary = "Get Job Log Count (POST)", description = "Queries for the number of historic job logs that fulfill the given parameters. This method takes the same message body as the [Get Job Logs (POST)](https://docs.camunda.org/manual/7.17/reference/rest/history/job-log/post-job-log-query/) method and therefore it is slightly more powerful than the [Get Job Log Count](https://docs.camunda.org/manual/7.17/reference/rest/history/job-log/get-job-log-query-count/) method.", tags={ "Historic Job Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/job-log/count",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<CountResultDto> queryHistoricJobLogsCount(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody HistoricJobLogQueryDto body);

}
