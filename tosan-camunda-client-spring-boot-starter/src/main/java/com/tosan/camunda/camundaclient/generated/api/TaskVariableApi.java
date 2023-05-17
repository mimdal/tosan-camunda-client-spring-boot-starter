/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.PatchVariablesDto;
import org.springframework.core.io.Resource;
import com.tosan.camunda.camundaclient.generated.model.VariableValueDto;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface TaskVariableApi {

    Logger log = LoggerFactory.getLogger(TaskVariableApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Delete Task Variable", description = "Removes a variable that is visible to a task. A variable is visible to a task if it is a local task variable or declared in a parent scope of the task. See documentation on [visiblity of variables](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/).", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "500", description = "Task id is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables/{varName}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTaskVariable(@Parameter(in = ParameterIn.PATH, description = "The id of the task to delete the variable from.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The name of the variable to be removed.", required=true, schema=@Schema()) @PathVariable("varName") String varName);


    @Operation(summary = "Get Task Variable", description = "Retrieves a variable from the context of a given task. The variable must be visible from the task. It is visible from the task if it is a local task variable or declared in a parent scope of the task. See documentation on [visiblity of variables](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/).", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = VariableValueDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "500", description = "Task id is `null` or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables/{varName}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<VariableValueDto> getTaskVariable(@Parameter(in = ParameterIn.PATH, description = "The id of the task to retrieve the variable from.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The name of the variable to get.", required=true, schema=@Schema()) @PathVariable("varName") String varName, @Parameter(in = ParameterIn.QUERY, description = "Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on the server side (default `true`).  If set to `true`, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson's](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API's classpath.  If set to `false`, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While `true` is the default value for reasons of backward compatibility, we recommend setting this parameter to `false` when developing web applications that are independent of the Java process applications deployed to the engine." ,schema=@Schema( defaultValue="true")) @Valid @RequestParam(value = "deserializeValue", required = false, defaultValue="true") Boolean deserializeValue);


    @Operation(summary = "Get Task Variable (Binary)", description = "Retrieves a binary variable from the context of a given task. Applicable for byte array and file variables. The variable must be visible from the task. It is visible from the task if it is a local task variable or declared in a parent scope of the task. See documentation on [visiblity of variables](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/).", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.         For binary variables or files without any MIME type information, a byte stream is returned.         File variables with MIME type information are returned as the saved type.         Additionally, for file variables the Content-Disposition header will be set.", content = @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = Resource.class))),
        
        @ApiResponse(responseCode = "400", description = "Variable with given id exists but is not a binary variable.See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables/{varName}/data",
        produces = { "application/octet-stream", "text/plain", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Resource> getTaskVariableBinary(@Parameter(in = ParameterIn.PATH, description = "The id of the task to retrieve the variable for.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The name of the variable to retrieve.", required=true, schema=@Schema()) @PathVariable("varName") String varName);


    @Operation(summary = "Get Task Variables", description = "Retrieves all variables visible from the task. A variable is visible from the task if it is a local task variable or declared in a parent scope of the task. See documentation on [visiblity of variables](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/).", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VariableValueDto.class)))),
        
        @ApiResponse(responseCode = "500", description = "Task id is `null` or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Map<String, VariableValueDto>> getTaskVariables(@Parameter(in = ParameterIn.PATH, description = "The id of the task to retrieve the variables from.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.QUERY, description = "Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on the server side (default `true`). If set to `true`, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson's](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API's classpath.  If set to `false`, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While `true` is the default value for reasons of backward compatibility, we recommend setting this parameter to `false` when developing web applications that are independent of the Java process applications deployed to the engine." ,schema=@Schema( defaultValue="true")) @Valid @RequestParam(value = "deserializeValues", required = false, defaultValue="true") Boolean deserializeValues);


    @Operation(summary = "Update/Delete Task Variables", description = "Updates or deletes the variables visible from the task. Updates precede deletions. So, if a variable is updated AND deleted, the deletion overrides the update. A variable is visible from the task if it is a local task variable or declared in a parent scope of the task. See documentation on [visiblity of variables](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/).", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "400", description = "The variable value or type is invalid. For example the value could not be parsed to an `Integer` value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "500", description = "Update or delete could not be executed because the task is `null` or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> modifyTaskVariables(@Parameter(in = ParameterIn.PATH, description = "The id of the task to set variables for.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody PatchVariablesDto body);


    @Operation(summary = "Update Task Variable", description = "Updates a process variable that is visible from the Task scope. A variable is visible from the task if it is a local task variable, or declared in a parent scope of the task. See the documentation on [variable scopes and visibility](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables#variable-scopes-and-variable-visibility).  **Note**: If a variable doesn't exist, the variable is created in the top-most scope visible from the task.", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "400", description = "The variable name, value or type is invalid, for example if the value could not be parsed to an `Integer` value or the passed variable type is not supported or a new transient variable has the name that is already persisted. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "500", description = "The variable name is `null`, or the Task id is `null` or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables/{varName}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putTaskVariable(@Parameter(in = ParameterIn.PATH, description = "The id of the task to set the variable for.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The name of the variable to set.", required=true, schema=@Schema()) @PathVariable("varName") String varName, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody VariableValueDto body);


    @Operation(summary = "Update Task Variable (Binary)", description = "Sets the serialized value for a binary variable or the binary value for a file variable visible from the task. A variable is visible from the task if it is a local task variable or declared in a parent scope of the task. See documentation on [visiblity of variables](https://docs.camunda.org/manual/7.17/user-guide/process-engine/variables/).", tags={ "Task Variable" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "400", description = "The variable value or type is invalid, for example if no filename is set. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "500", description = "Variable name is `null`, or the Task id is `null` or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/task/{id}/variables/{varName}/data",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> setBinaryTaskVariable(@Parameter(in = ParameterIn.PATH, description = "The id of the task to retrieve the variable for.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The name of the variable to retrieve.", required=true, schema=@Schema()) @PathVariable("varName") String varName, @Parameter(description = "file detail") @Valid @RequestPart("file") MultipartFile data, @Parameter(in = ParameterIn.DEFAULT, description = "",schema=@Schema(allowableValues={ "Bytes", "File" }
)) @RequestParam(value="valueType", required=false)  String valueType);

}

