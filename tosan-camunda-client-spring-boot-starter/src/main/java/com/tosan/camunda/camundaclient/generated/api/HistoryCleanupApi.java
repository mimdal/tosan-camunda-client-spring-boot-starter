/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.HistoryCleanupConfigurationDto;
import com.tosan.camunda.camundaclient.generated.model.JobDto;
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
public interface HistoryCleanupApi {

    Logger log = LoggerFactory.getLogger(HistoryCleanupApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Clean up history (POST)", description = "Schedules asynchronous history cleanup (See [History cleanup](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#history-cleanup)).  **Note:** This endpoint will return at most a single history cleanup job. Since version `7.9.0` it is possible to configure multiple [parallel history cleanup jobs](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#parallel-execution). Use [`GET /history/cleanup/jobs`](https://docs.camunda.org/manual/7.17/reference/rest/history/history-cleanup/get-history-cleanup-jobs) to find all the available history cleanup jobs.", tags={ "History Cleanup" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = JobDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid or the engine does not participate in history cleanup. See [Cleanup Execution Participation per Node](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#cleanup-execution-participation-per-node).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/cleanup",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<JobDto> cleanupAsync(@Parameter(in = ParameterIn.QUERY, description = "When true the job will be scheduled for nearest future. When `false`, the job will be scheduled for next batch window start time. Default is `true`." ,schema=@Schema()) @Valid @RequestParam(value = "immediatelyDue", required = false) Boolean immediatelyDue);


    @Operation(summary = "Find clean up history job (GET)", description = "**Deprecated!** Use `GET /history/cleanup/jobs` instead.  Finds history cleanup job (See [History cleanup](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#history-cleanup)).", tags={ "History Cleanup" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = JobDto.class))),
        
        @ApiResponse(responseCode = "404", description = "History clean up job does not exist.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/cleanup/job",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JobDto> findCleanupJob();


    @Operation(summary = "Find clean up history jobs (GET)", description = "Finds history cleanup jobs (See [History cleanup](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#history-cleanup)).", tags={ "History Cleanup" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = JobDto.class)))),
        
        @ApiResponse(responseCode = "404", description = "History clean up jobs are empty.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/cleanup/jobs",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<JobDto>> findCleanupJobs();


    @Operation(summary = "Get History Cleanup Configuration", description = "Retrieves history cleanup batch window configuration (See [History cleanup](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#history-cleanup)).", tags={ "History Cleanup" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HistoryCleanupConfigurationDto.class))) })
    @RequestMapping(value = "/history/cleanup/configuration",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HistoryCleanupConfigurationDto> getHistoryCleanupConfiguration();

}

