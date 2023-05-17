/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.CorrelationMessageDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.MessageCorrelationResultWithVariableDto;
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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface MessageApi {

    Logger log = LoggerFactory.getLogger(MessageApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Correlate", description = "Correlates a message to the process engine to either trigger a message start event or an intermediate message  catching event. Internally this maps to the engine's message correlation builder methods `MessageCorrelationBuilder#correlateWithResult()` and `MessageCorrelationBuilder#correlateAllWithResult()`. For more information about the correlation behavior, see the [Message Events](https://docs.camunda.org/manual/7.17/bpmn20/events/message-events/) section of the [BPMN 2.0 Implementation Reference](https://docs.camunda.org/manual/7.17/reference/bpmn20/).", tags={ "Message" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful. The property `resultEnabled` in the request body was `true`. The `variables` property is only returned, if the property variablesInResultEnable` was set to `true` in the request.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MessageCorrelationResultWithVariableDto.class)))),
        
        @ApiResponse(responseCode = "204", description = "Request successful. The property `resultEnabled` in the request body was `false` (Default)."),
        
        @ApiResponse(responseCode = "400", description = "Returned if: * no `messageName` was supplied * both `tenantId` and `withoutTenantId` are supplied * the message has not been correlated to exactly one entity (execution or process definition) * the variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported.  See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/message",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<MessageCorrelationResultWithVariableDto>> deliverMessage(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody CorrelationMessageDto body);

}

