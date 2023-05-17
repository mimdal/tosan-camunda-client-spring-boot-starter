/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.BatchDto;
import com.tosan.camunda.camundaclient.generated.model.CleanableHistoricBatchReportResultDto;
import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.HistoricBatchDto;
import com.tosan.camunda.camundaclient.generated.model.SetRemovalTimeToHistoricBatchesDto;
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
public interface HistoricBatchApi {

    Logger log = LoggerFactory.getLogger(HistoricBatchApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Delete Historic Batch", description = "Deletes a historic batch by id, including related historic job logs.", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful. This method returns no content."),
        
        @ApiResponse(responseCode = "404", description = "Historic batch with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteHistoricBatch(@Parameter(in = ParameterIn.PATH, description = "The id of the batch to be deleted.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get Cleanable Batch Report", description = "Retrieves a report about a historic batch operations relevant to history cleanup (see [History cleanup](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#history-cleanup) ) so that you can tune the history time to live. These reports include the count of the finished batches, cleanable batches and type of the batch. The size of the result set can be retrieved by using the [Get Cleanable Batch Report Count](https://docs.camunda.org/manual/7.17/reference/rest/history/batch/get-cleanable-batch-report-count/) method.  **Please note:** The history time to live for batch operations does not support [Multi-Tenancy](https://docs.camunda.org/manual/7.17/user-guide/process-engine/multi-tenancy.md). The report will return an information for all batch operations (for all tenants) if you have permissions to see the history. ", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CleanableHistoricBatchReportResultDto.class)))),
        
        @ApiResponse(responseCode = "500", description = "See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch/cleanable-batch-report",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<CleanableHistoricBatchReportResultDto>> getCleanableHistoricBatchesReport(@Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "finished" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get Cleanable Batch Report Count", description = "Queries for the number of report results about a historic batch operations relevant to history cleanup (see [History cleanup](https://docs.camunda.org/manual/7.17/user-guide/process-engine/history/#history-cleanup) ). Takes the same parameters as the [Get Cleanable Batch Report](https://docs.camunda.org/manual/7.17/reference/rest/history/batch/get-cleanable-batch-report/) method.", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "500", description = "See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch/cleanable-batch-report/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getCleanableHistoricBatchesReportCount(@Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema()) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get Historic Batch", description = "Retrieves a historic batch by id, according to the `HistoricBatch` interface in the engine.", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HistoricBatchDto.class))),
        
        @ApiResponse(responseCode = "404", description = " Historic batch with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HistoricBatchDto> getHistoricBatch(@Parameter(in = ParameterIn.PATH, description = "The id of the historic batch to be retrieved.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get Historic Batches", description = "Queries for historic batches that fulfill given parameters. Parameters may be the properties of batches, such as the id or type. The size of the result set can be retrieved by using the [Get Historic Batch Count](https://docs.camunda.org/manual/7.17/reference/rest/history/batch/get-query-count/) method.", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HistoricBatchDto.class)))),
        
        @ApiResponse(responseCode = "400", description = " Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<HistoricBatchDto>> getHistoricBatches(@Parameter(in = ParameterIn.QUERY, description = "Filter by batch id." ,schema=@Schema()) @Valid @RequestParam(value = "batchId", required = false) String batchId, @Parameter(in = ParameterIn.QUERY, description = "Filter by batch type. See the [User Guide](https://docs.camunda.org/manual/7.17/user-guide/process-engine/batch/#creating-a-batch) for more information about batch types." ,schema=@Schema()) @Valid @RequestParam(value = "type", required = false) String type, @Parameter(in = ParameterIn.QUERY, description = " Filter completed or not completed batches. If the value is `true`, only completed batches, i.e., end time is set, are returned. Otherwise, if the value is `false`, only running batches, i.e., end time is null, are returned." ,schema=@Schema()) @Valid @RequestParam(value = "completed", required = false) Boolean completed, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids. A batch matches if it has one of the given tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include batches which belong to no tenant. Value can effectively only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "batchId", "startTime", "endTime", "tenantId" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get Historic Batch Count", description = "Requests the number of historic batches that fulfill the query criteria. Takes the same filtering parameters as the [Get Historic Batches](https://docs.camunda.org/manual/7.17/reference/rest/history/batch/get-query/) method.", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = " Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getHistoricBatchesCount(@Parameter(in = ParameterIn.QUERY, description = "Filter by batch id." ,schema=@Schema()) @Valid @RequestParam(value = "batchId", required = false) String batchId, @Parameter(in = ParameterIn.QUERY, description = "Filter by batch type. See the [User Guide](https://docs.camunda.org/manual/7.17/user-guide/process-engine/batch/#creating-a-batch) for more information about batch types." ,schema=@Schema()) @Valid @RequestParam(value = "type", required = false) String type, @Parameter(in = ParameterIn.QUERY, description = " Filter completed or not completed batches. If the value is `true`, only completed batches, i.e., end time is set, are returned. Otherwise, if the value is `false`, only running batches, i.e., end time is null, are returned." ,schema=@Schema()) @Valid @RequestParam(value = "completed", required = false) Boolean completed, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids. A batch matches if it has one of the given tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include batches which belong to no tenant. Value can effectively only be `true`, as `false` is the default behavior." ,schema=@Schema()) @Valid @RequestParam(value = "withoutTenantId", required = false) Boolean withoutTenantId);


    @Operation(summary = "Set Removal Time Async (POST)", description = "Sets the removal time to multiple historic batches asynchronously (batch).  At least __historicBatchIds__ or __historicBatchQuery__ has to be provided. If both are provided, all instances matching query criterion and instances from the list will be updated with a removal time.", tags={ "Historic Batch" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BatchDto.class))),
        
        @ApiResponse(responseCode = "400", description = " Request was unsuccessful due to a bad user request. This occurs if some of the query parameters are invalid, e.g. if neither historicBatchIds nor historicBatchQuery is present or if no mode is specified.  See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/history/batch/set-removal-time",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<BatchDto> setRemovalTimeAsyncHistoricBatch(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody SetRemovalTimeToHistoricBatchesDto body);

}

