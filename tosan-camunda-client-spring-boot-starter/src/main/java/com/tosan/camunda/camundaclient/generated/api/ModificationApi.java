/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.BatchDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.ModificationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface ModificationApi {

    Logger log = LoggerFactory.getLogger(ModificationApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Execute Modification", description = "Executes a modification synchronously for multiple process instances. To modify a single process instance, use the [Modify Process Instance Execution State](https://docs.camunda.org/manual/7.17/reference/rest/process-instance/post-modification/) method. To execute a modification asynchronously, use the [Execute Modification Async (Batch)](https://docs.camunda.org/manual/7.17/reference/rest/modification/post-modification-async/) method.  For more information about the difference between synchronous and asynchronous execution of a modification, please refer to the related section of the [user guide](https://docs.camunda.org/manual/7.17/user-guide/process-engine/process-instance-migration.md#executing-a-migration-plan).", tags={ "Modification" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful. This method returns no content."),
        
        @ApiResponse(responseCode = "400", description = " In case following parameters are missing: instructions, processDefinitionId, activityId or transitionId, processInstanceIds or processInstanceQuery, an exception of type `InvalidRequestException` is returned. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/modification/execute",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> executeModification(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody ModificationDto body);


    @Operation(summary = "Execute Modification Async (Batch)", description = "Executes a modification asynchronously for multiple process instances. To execute a modification synchronously, use the [Execute Modification](https://docs.camunda.org/manual/7.17/reference/rest/modification/post-modification-sync/) method.  For more information about the difference between synchronous and asynchronous execution of a modification, please refer to the related section of the [user guide](https://docs.camunda.org/manual/7.17/user-guide/process-engine/process-instance-migration.md#executing-a-migration-plan).", tags={ "Modification" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BatchDto.class))),
        
        @ApiResponse(responseCode = "400", description = " In case following parameters are missing: instructions, processDefinitionId, activityId or transitionId, processInstanceIds or processInstanceQuery, an exception of type `InvalidRequestException` is returned. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/modification/executeAsync",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<BatchDto> executeModificationAsync(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody ModificationDto body);

}

