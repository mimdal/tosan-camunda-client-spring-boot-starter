package com.tosan.camunda.camundaclient.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * A JSON object corresponding to the &#x60;Resource&#x60; interface in the engine. Its properties are as follows:
 */
@Schema(description = "A JSON object corresponding to the `Resource` interface in the engine. Its properties are as follows:")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")


public class DeploymentResourceDto   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("deploymentId")
  private String deploymentId = null;

  public DeploymentResourceDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the deployment resource.
   * @return id
   **/
  @Schema(description = "The id of the deployment resource.")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DeploymentResourceDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the deployment resource
   * @return name
   **/
  @Schema(description = "The name of the deployment resource")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeploymentResourceDto deploymentId(String deploymentId) {
    this.deploymentId = deploymentId;
    return this;
  }

  /**
   * The id of the deployment.
   * @return deploymentId
   **/
  @Schema(description = "The id of the deployment.")
  
    public String getDeploymentId() {
    return deploymentId;
  }

  public void setDeploymentId(String deploymentId) {
    this.deploymentId = deploymentId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentResourceDto deploymentResourceDto = (DeploymentResourceDto) o;
    return Objects.equals(this.id, deploymentResourceDto.id) &&
        Objects.equals(this.name, deploymentResourceDto.name) &&
        Objects.equals(this.deploymentId, deploymentResourceDto.deploymentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, deploymentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentResourceDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    deploymentId: ").append(toIndentedString(deploymentId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
