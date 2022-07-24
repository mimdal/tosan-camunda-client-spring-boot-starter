/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.SchemaLogEntryDto;
import com.tosan.camunda.camundaclient.generated.model.SchemaLogQueryDto;
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
public interface SchemaLogApi {

    Logger log = LoggerFactory.getLogger(SchemaLogApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Get List", description = "Queries for schema log entries that fulfill given parameters.", tags={ "Schema Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful. **Note**: In order to get any results a user of group `camunda-admin` must be authenticated.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SchemaLogEntryDto.class)))) })
    @RequestMapping(value = "/schema/log",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SchemaLogEntryDto>> getSchemaLog(@Parameter(in = ParameterIn.QUERY, description = "Only return schema log entries with a specific version." ,schema=@Schema()) @Valid @RequestParam(value = "version", required = false) String version, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "timestamp" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get List (POST)", description = "Queries for schema log entries that fulfill given parameters.", tags={ "Schema Log" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful. **Note**: In order to get any results a user of group camunda-admin must be authenticated.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SchemaLogEntryDto.class)))) })
    @RequestMapping(value = "/schema/log",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<SchemaLogEntryDto>> querySchemaLog(@Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody SchemaLogQueryDto body);

}

