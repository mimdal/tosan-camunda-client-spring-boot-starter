/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.30).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.tosan.camunda.camundaclient.generated.api;

import com.tosan.camunda.camundaclient.generated.model.CountResultDto;
import com.tosan.camunda.camundaclient.generated.model.DeploymentDto;
import com.tosan.camunda.camundaclient.generated.model.DeploymentResourceDto;
import com.tosan.camunda.camundaclient.generated.model.DeploymentWithDefinitionsDto;
import com.tosan.camunda.camundaclient.generated.model.ExceptionDto;
import java.time.OffsetDateTime;
import com.tosan.camunda.camundaclient.generated.model.ParseExceptionDto;
import com.tosan.camunda.camundaclient.generated.model.RedeploymentDto;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")
@Validated
public interface DeploymentApi {

    Logger log = LoggerFactory.getLogger(DeploymentApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @Operation(summary = "Create", description = "Creates a deployment.  **Security Consideration**  Deployments can contain custom code in form of scripts or EL expressions to customize process behavior. This may be abused for remote execution of arbitrary code.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeploymentWithDefinitionsDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request. In case one of the bpmn resources cannot be parsed.  See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#parse-exceptions) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParseExceptionDto.class))) })
    @RequestMapping(value = "/deployment/create",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" }, 
        method = RequestMethod.POST)
    ResponseEntity<DeploymentWithDefinitionsDto> createDeployment(@RequestPart(value = "deployment-source") String deploymentSource,
                                                                  @RequestPart(value = "deploy-changed-only") Boolean deployChangedOnly,
                                                                  @RequestPart(value = "enable-duplicate-filtering") Boolean enableDuplicateFiltering,
                                                                  @RequestPart(value = "deployment-name") String deploymentName,
                                                                  @RequestPart(value = "deployment-activation-time") OffsetDateTime deploymentActivationTime,
                                                                  @RequestPart(value = "data") MultipartFile data);


    @Operation(summary = "Delete", description = "Deletes a deployment by id.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Request successful."),
        
        @ApiResponse(responseCode = "404", description = "A Deployment with the provided id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteDeployment(@Parameter(in = ParameterIn.PATH, description = "The id of the deployment to be deleted.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.QUERY, description = "`true`, if all process instances, historic process instances and jobs for this deployment should be deleted." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "cascade", required = false, defaultValue="false") Boolean cascade, @Parameter(in = ParameterIn.QUERY, description = "`true`, if only the built-in ExecutionListeners should be notified with the end event." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "skipCustomListeners", required = false, defaultValue="false") Boolean skipCustomListeners, @Parameter(in = ParameterIn.QUERY, description = "`true`, if all input/output mappings should not be invoked." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "skipIoMappings", required = false, defaultValue="false") Boolean skipIoMappings);


    @Operation(summary = "Get", description = "Retrieves a deployment by id, according to the `Deployment` interface of the engine.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeploymentDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Deployment with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<DeploymentDto> getDeployment(@Parameter(in = ParameterIn.PATH, description = "The id of the deployment.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get Resource", description = "Retrieves a deployment resource by resource id for the given deployment.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeploymentResourceDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Deployment Resource with given resource id or deployment id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/{id}/resources/{resourceId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<DeploymentResourceDto> getDeploymentResource(@Parameter(in = ParameterIn.PATH, description = "The id of the deployment", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The id of the deployment resource", required=true, schema=@Schema()) @PathVariable("resourceId") String resourceId);


    @Operation(summary = "Get Resource (Binary)", description = "Retrieves the binary content of a deployment resource for the given deployment by id.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful. The media type of the response depends on the filename.", content = @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = Resource.class))),
        
        @ApiResponse(responseCode = "400", description = "Deployment Resource with given resource id or deployment id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/{id}/resources/{resourceId}/data",
        produces = { "application/octet-stream", "*/*", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Resource> getDeploymentResourceData(@Parameter(in = ParameterIn.PATH, description = "The id of the deployment.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.PATH, description = "The id of the deployment resource.", required=true, schema=@Schema()) @PathVariable("resourceId") String resourceId);


    @Operation(summary = "Get Resources", description = "Retrieves all deployment resources of a given deployment.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DeploymentResourceDto.class)))),
        
        @ApiResponse(responseCode = "404", description = "Deployment resources for the given deployment do not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/{id}/resources",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<DeploymentResourceDto>> getDeploymentResources(@Parameter(in = ParameterIn.PATH, description = "The id of the deployment to retrieve the deployment resources for.", required=true, schema=@Schema()) @PathVariable("id") String id);


    @Operation(summary = "Get List", description = "Queries for deployments that fulfill given parameters. Parameters may be the properties of deployments, such as the id or name or a range of the deployment time. The size of the result set can be retrieved by using the [Get Deployment count](https://docs.camunda.org/manual/7.17/reference/rest/deployment/get-query-count/) method.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DeploymentDto.class)))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example if a `sortOrder` parameter is supplied, but no `sortBy`, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<DeploymentDto>> getDeployments(@Parameter(in = ParameterIn.QUERY, description = "Filter by deployment id" ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) String id, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment name. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "name", required = false) String name, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment name that the parameter is a substring of. The parameter can include the wildcard `%` to express like-strategy such as: starts with (`%`name), ends with (name`%`) or contains (`%`name`%`)." ,schema=@Schema()) @Valid @RequestParam(value = "nameLike", required = false) String nameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment source." ,schema=@Schema()) @Valid @RequestParam(value = "source", required = false) String source, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment source whereby source is equal to `null`." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "withoutSource", required = false, defaultValue="false") Boolean withoutSource, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids. A deployment must have one of the given tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include deployments which belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "withoutTenantId", required = false, defaultValue="false") Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Include deployments which belong to no tenant. Can be used in combination with `tenantIdIn`. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "includeDeploymentsWithoutTenantId", required = false, defaultValue="false") Boolean includeDeploymentsWithoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to all deployments after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "after", required = false) OffsetDateTime after, @Parameter(in = ParameterIn.QUERY, description = "Restricts to all deployments before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "before", required = false) OffsetDateTime before, @Parameter(in = ParameterIn.QUERY, description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter." ,schema=@Schema(allowableValues={ "id", "name", "deploymentTime", "tenantId" }
)) @Valid @RequestParam(value = "sortBy", required = false) String sortBy, @Parameter(in = ParameterIn.QUERY, description = "Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter." ,schema=@Schema(allowableValues={ "asc", "desc" }
)) @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the index of the first result to return." ,schema=@Schema()) @Valid @RequestParam(value = "firstResult", required = false) Integer firstResult, @Parameter(in = ParameterIn.QUERY, description = "Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left." ,schema=@Schema()) @Valid @RequestParam(value = "maxResults", required = false) Integer maxResults);


    @Operation(summary = "Get List Count", description = "Queries for the number of deployments that fulfill given parameters. Takes the same parameters as the [Get Deployments](https://docs.camunda.org/manual/7.17/reference/rest/deployment/get-query/) method.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CountResultDto.class))),
        
        @ApiResponse(responseCode = "400", description = "Returned if some of the query parameters are invalid, for example, if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/count",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CountResultDto> getDeploymentsCount(@Parameter(in = ParameterIn.QUERY, description = "Filter by deployment id" ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) String id, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment name. Exact match." ,schema=@Schema()) @Valid @RequestParam(value = "name", required = false) String name, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment name that the parameter is a substring of. The parameter can include the wildcard `%` to express like-strategy such as: starts with (`%`name), ends with (name`%`) or contains (`%`name`%`)." ,schema=@Schema()) @Valid @RequestParam(value = "nameLike", required = false) String nameLike, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment source." ,schema=@Schema()) @Valid @RequestParam(value = "source", required = false) String source, @Parameter(in = ParameterIn.QUERY, description = "Filter by the deployment source whereby source is equal to `null`." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "withoutSource", required = false, defaultValue="false") Boolean withoutSource, @Parameter(in = ParameterIn.QUERY, description = "Filter by a comma-separated list of tenant ids. A deployment must have one of the given tenant ids." ,schema=@Schema()) @Valid @RequestParam(value = "tenantIdIn", required = false) String tenantIdIn, @Parameter(in = ParameterIn.QUERY, description = "Only include deployments which belong to no tenant. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "withoutTenantId", required = false, defaultValue="false") Boolean withoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Include deployments which belong to no tenant. Can be used in combination with `tenantIdIn`. Value may only be `true`, as `false` is the default behavior." ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "includeDeploymentsWithoutTenantId", required = false, defaultValue="false") Boolean includeDeploymentsWithoutTenantId, @Parameter(in = ParameterIn.QUERY, description = "Restricts to all deployments after the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "after", required = false) OffsetDateTime after, @Parameter(in = ParameterIn.QUERY, description = "Restricts to all deployments before the given date. By [default](https://docs.camunda.org/manual/7.17/reference/rest/overview/date-format/), the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`." ,schema=@Schema()) @Valid @RequestParam(value = "before", required = false) OffsetDateTime before);


    @Operation(summary = "Get Registered Deployments", description = "Queries the registered deployment IDs for the current application.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))) })
    @RequestMapping(value = "/deployment/registered",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<String>> getRegisteredDeployments();


    @Operation(summary = "Redeploy", description = "Re-deploys an existing deployment.  The deployment resources to re-deploy can be restricted by using the properties `resourceIds` or `resourceNames`. If no deployment resources to re-deploy are passed then all existing resources of the given deployment are re-deployed.  **Warning**: Deployments can contain custom code in form of scripts or EL expressions to customize process behavior. This may be abused for remote execution of arbitrary code. See the section on [security considerations for custom code](https://docs.camunda.org/manual/7.17/user-guide/process-engine/securing-custom-code/) in the user guide for details.", tags={ "Deployment" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request successful.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeploymentWithDefinitionsDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Deployment or a deployment resource for the given deployment does not exist. See the [Introduction](https://docs.camunda.org/manual/7.17/reference/rest/overview/#error-handling) for the error response format.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))) })
    @RequestMapping(value = "/deployment/{id}/redeploy",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<DeploymentWithDefinitionsDto> redeploy(@Parameter(in = ParameterIn.PATH, description = "The id of the deployment to re-deploy.", required=true, schema=@Schema()) @PathVariable("id") String id, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody RedeploymentDto body);

}

