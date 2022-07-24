/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.MetricsIntervalResultDto;
import com.tosan.camunda.camundaclient.generated.model.MetricsResultDto;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface MetricsApi {

    Logger log = LoggerFactory.getLogger(MetricsApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Delete Task Worker Metrics", description = "Deletes all task worker metrics prior to the given date or all if no date is provided.", tags={ "Metrics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "403", description = "If the user who performs the operation is not a <b>camunda-admin</b> user.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/metrics/task-worker",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTaskMetrics(@Parameter(in = ParameterIn.QUERY, description = "The date prior to which all task worker metrics should be deleted." ,schema=@Schema()) @Valid @RequestParam(value = "date", required = false) OffsetDateTime date);


    @Operation(summary = "Get Sum", description = "Retrieves the `sum` (count) for a given metric.", tags={ "Metrics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MetricsResultDto.class))) })
    @RequestMapping(value = "/metrics/{metrics-name}/sum",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MetricsResultDto> getMetrics(@Parameter(in = ParameterIn.PATH, description = "The name of the metric.", required=true, schema=@Schema(allowableValues={ "activity-instance-start", "activity-instance-end", "decision-instances", "flow-node-instances", "job-acquisition-attempt", "job-acquired-success", "job-acquired-failure", "job-execution-rejected", "job-successful", "job-failed", "job-locked-exclusive", "executed-decision-elements", "history-cleanup-removed-process-instances", "history-cleanup-removed-case-instances", "history-cleanup-removed-decision-instances", "history-cleanup-removed-batch-operations", "history-cleanup-removed-task-metrics", "unique-task-workers", "process-instances", "task-users" }
)) @PathVariable("metrics-name") String metricsName, @Parameter(in = ParameterIn.QUERY, description = "The start date (inclusive)." ,schema=@Schema()) @Valid @RequestParam(value = "startDate", required = false) OffsetDateTime startDate, @Parameter(in = ParameterIn.QUERY, description = "The end date (exclusive)." ,schema=@Schema()) @Valid @RequestParam(value = "endDate", required = false) OffsetDateTime endDate);


    @Operation(summary = "Get Metrics in Interval", description = "Retrieves a list of metrics, aggregated for a given interval.", tags={ "Metrics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MetricsIntervalResultDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/metrics",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<MetricsIntervalResultDto>> interval(@Parameter(in = ParameterIn.QUERY, description = "The name of the metric." ,schema=@Schema(allowableValues={ "activity-instance-start", "activity-instance-end", "decision-instances", "flow-node-instances", "job-acquisition-attempt", "job-acquired-success", "job-acquired-failure", "job-execution-rejected", "job-successful", "job-failed", "job-locked-exclusive", "executed-decision-elements", "history-cleanup-removed-process-instances", "history-cleanup-removed-case-instances", "history-cleanup-removed-decision-instances", "history-cleanup-removed-batch-operations", "history-cleanup-removed-task-metrics", "process-instances", "task-users" }
)) @Valid @RequestParam(value = "name", required = false) String name, @Parameter(in = ParameterIn.QUERY, description = "The name of the reporter (host), on which the metrics was logged. This will have value provided by the [hostname configuration property](https://docs.camunda.org/manual/7.17/reference/deployment-descriptors/tags/process-engine/#hostname)." ,schema=@Schema()) @Valid @RequestParam(value = "reporter", required = false) String reporter, @Parameter(in = ParameterIn.QUERY, description = "The start date (inclusive)." ,schema=@Schema()) @Valid @RequestParam(value = "startDate", required = false) OffsetDateTime startDate, @Parameter(in = ParameterIn.QUERY, description = "The end date (exclusive)." ,schema=@Schema()) @Valid @RequestParam(value = "endDate", required = false) OffsetDateTime endDate, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults, @Parameter(in = ParameterIn.QUERY, description = "The interval for which the metrics should be aggregated. Time unit is seconds. Default: The interval is set to 15 minutes (900 seconds)." ,schema=@Schema( defaultValue="900")) @Valid @RequestParam(value = "interval", required = false, defaultValue="900") String interval, @Parameter(in = ParameterIn.QUERY, description = "Aggregate metrics by reporter." ,schema=@Schema()) @Valid @RequestParam(value = "aggregateByReporter", required = false) String aggregateByReporter);

}
