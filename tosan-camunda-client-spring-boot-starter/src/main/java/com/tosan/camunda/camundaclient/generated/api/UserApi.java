/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.ResourceOptionsDto;
import com.tosan.camunda.camundaclient.generated.model.UserCredentialsDto;
import com.tosan.camunda.camundaclient.generated.model.UserDto;
import com.tosan.camunda.camundaclient.generated.model.UserProfileDto;
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
public interface UserApi {

    Logger log = LoggerFactory.getLogger(UserApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Options", description = "The `/user` resource supports two custom `OPTIONS` requests, one for the resource as such and one for individual user instances. The `OPTIONS` request allows checking for the set of available operations that the currently authenticated user can perform on the /user resource. If the user can perform an operation or not may depend on various things, including the user's authorizations to interact with this resource and the internal configuration of the process engine. `OPTIONS /user` returns available interactions on the resource.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceOptionsDto.class))) })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        method = RequestMethod.OPTIONS)
    ResponseEntity<ResourceOptionsDto> availableOperations();


    @Operation(summary = "Options", description = "The `/user` resource supports two custom `OPTIONS` requests, one for the resource as such and one for individual user instances. The `OPTIONS` request allows checking for the set of available operations that the currently authenticated user can perform on the /user resource. If the user can perform an operation or not may depend on various things, including the user's authorizations to interact with this resource and the internal configuration of the process engine. `OPTIONS /user/{id}` returns available interactions on a resource instance.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceOptionsDto.class))) })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.OPTIONS)
    ResponseEntity<ResourceOptionsDto> availableUserOperations(@Parameter(in = ParameterIn.PATH, description = "The id of the user to be deleted.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Create", description = "Create a new user.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful.") })
    @RequestMapping(value = "/user/create",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody UserDto body);


    @Operation(summary = "Delete", description = "Deletes a user by id.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "403", description = "Identity service is read-only (Cannot modify users / groups / memberships).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))),
        
        @ApiResponse(responseCode = "404", description = "A Deployment with the provided id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "The id of the user to be deleted.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get List Count", description = "Queries for the number of deployments that fulfill given parameters. Takes the same parameters as the [Get Users](https://docs.camunda.org/manual/7.17/reference/rest/user/get-query/) method.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example, if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getUserCount(@Parameter(in = ParameterIn.QUERY, description = "Filter by user id" ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) String id, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of user ids." ,schema=@Schema()) @Valid @RequestParam(value = "idIn", required = false) String idIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the first name of the user. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "firstName", required = false) String firstName, @Parameter(in = ParameterIn.QUERY, description = "Filter by the first name that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "firstNameLike", required = false) String firstNameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the last name of the user. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "lastName", required = false) String lastName, @Parameter(in = ParameterIn.QUERY, description = "Filter by the last name that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "lastNameLike", required = false) String lastNameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the email of the user. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "email", required = false) String email, @Parameter(in = ParameterIn.QUERY, description = "Filter by the email that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "emailLike", required = false) String emailLike, @Parameter(in = ParameterIn.QUERY, description = "Filter for users which are members of the given group." ,schema=@Schema()) @Valid @RequestParam(value = "memberOfGroup", required = false) String memberOfGroup, @Parameter(in = ParameterIn.QUERY, description = "Filter for users which are members of the given tenant." ,schema=@Schema()) @Valid @RequestParam(value = "memberOfTenant", required = false) String memberOfTenant, @Parameter(in = ParameterIn.QUERY, description = "Only select Users that are potential starter for the given process definition." ,schema=@Schema()) @Valid @RequestParam(value = "potentialStarter", required = false) String potentialStarter);


    @Operation(summary = "Get Profile", description = "Retrieves a user's profile.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Execution with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user/{id}/profile",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserProfileDto> getUserProfile(@Parameter(in = ParameterIn.PATH, description = "The id of the user to retrieve.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get List", description = "Query for a list of users using a list of parameters. The size of the result set can be retrieved by using the Get User Count method. [Get User Count](https://docs.camunda.org/manual/7.17/reference/rest/user/get-query-count/) method.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserProfileDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<UserProfileDto>> getUsers(@Parameter(in = ParameterIn.QUERY, description = "Filter by user id" ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) String id, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of user ids." ,schema=@Schema()) @Valid @RequestParam(value = "idIn", required = false) String idIn, @Parameter(in = ParameterIn.QUERY, description = "Filter by the first name of the user. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "firstName", required = false) String firstName, @Parameter(in = ParameterIn.QUERY, description = "Filter by the first name that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "firstNameLike", required = false) String firstNameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the last name of the user. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "lastName", required = false) String lastName, @Parameter(in = ParameterIn.QUERY, description = "Filter by the last name that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "lastNameLike", required = false) String lastNameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the email of the user. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "email", required = false) String email, @Parameter(in = ParameterIn.QUERY, description = "Filter by the email that the parameter is a substring of." ,schema=@Schema()) @Valid @RequestParam(value = "emailLike", required = false) String emailLike, @Parameter(in = ParameterIn.QUERY, description = "Filter for users which are members of the given group." ,schema=@Schema()) @Valid @RequestParam(value = "memberOfGroup", required = false) String memberOfGroup, @Parameter(in = ParameterIn.QUERY, description = "Filter for users which are members of the given tenant." ,schema=@Schema()) @Valid @RequestParam(value = "memberOfTenant", required = false) String memberOfTenant, @Parameter(in = ParameterIn.QUERY, description = "Only select Users that are potential starter for the given process definition." ,schema=@Schema()) @Valid @RequestParam(value = "potentialStarter", required = false) String potentialStarter, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "userId", "firstName", "lastName", "email" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Unlock User", description = "Unlocks a user by id.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "403", description = "The user who performed the operation is not a Camunda admin user.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))),
        
        @ApiResponse(responseCode = "404", description = "User cannot be found. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user/{id}/unlock",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> unlockUser(@Parameter(in = ParameterIn.PATH, description = "The id of the user to be unlocked.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Update Credentials", description = "Updates a user's credentials (password)", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful. This method returns no content."),
        
        @ApiResponse(responseCode = "403", description = "Identity service is read-only (Cannot modify users / groups / memberships).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "400", description = "The authenticated user password does not match", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "404", description = "If the corresponding user cannot be found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "500", description = "The user could not be updated due to an internal server error. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user/{id}/credentials",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCredentials(@Parameter(in = ParameterIn.PATH, description = "The id of the user to be updated.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody UserCredentialsDto body);


    @Operation(summary = "Update User Profile", description = "Updates the profile information of an already existing user.", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful. This method returns no content."),
        
        @ApiResponse(responseCode = "403", description = "Identity service is read-only (Cannot modify users / groups / memberships).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "404", description = "If the user with the requested Id cannot be found.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))),
        
        @ApiResponse(responseCode = "500", description = "The user could not be updated due to an internal server error. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/user/{id}/profile",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateProfile(@Parameter(in = ParameterIn.PATH, description = "The id of the user.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody UserProfileDto body);

}

