package com.tosan.camunda.camundaclient.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * HistoricExternalTaskLogQueryDtoSorting
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-17T19:18:35.625055400+04:30[Asia/Tehran]")


public class HistoricExternalTaskLogQueryDtoSorting   {
  /**
   * Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter.
   */
  public enum SortByEnum {
    TIMESTAMP("timestamp"),
    
    EXTERNALTASKID("externalTaskId"),
    
    TOPICNAME("topicName"),
    
    WORKERID("workerId"),
    
    RETRIES("retries"),
    
    PRIORITY("priority"),
    
    ACTIVITYID("activityId"),
    
    ACTIVITYINSTANCEID("activityInstanceId"),
    
    EXECUTIONID("executionId"),
    
    PROCESSINSTANCEID("processInstanceId"),
    
    PROCESSDEFINITIONID("processDefinitionId"),
    
    PROCESSDEFINITIONKEY("processDefinitionKey"),
    
    TENANTID("tenantId");

    private String value;

    SortByEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SortByEnum fromValue(String text) {
      for (SortByEnum b : SortByEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("sortBy")
  private SortByEnum sortBy = null;

  /**
   * Sort the results in a given order. Values may be `asc` for ascending order or `desc` for descending order. Must be used in conjunction with the sortBy parameter.
   */
  public enum SortOrderEnum {
    ASC("asc"),
    
    DESC("desc");

    private String value;

    SortOrderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SortOrderEnum fromValue(String text) {
      for (SortOrderEnum b : SortOrderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("sortOrder")
  private SortOrderEnum sortOrder = null;

  public HistoricExternalTaskLogQueryDtoSorting sortBy(SortByEnum sortBy) {
    this.sortBy = sortBy;
    return this;
  }

  /**
   * Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter.
   * @return sortBy
   **/
  @Schema(description = "Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter.")
  
    public SortByEnum getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortByEnum sortBy) {
    this.sortBy = sortBy;
  }

  public HistoricExternalTaskLogQueryDtoSorting sortOrder(SortOrderEnum sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Sort the results in a given order. Values may be `asc` for ascending order or `desc` for descending order. Must be used in conjunction with the sortBy parameter.
   * @return sortOrder
   **/
  @Schema(description = "Sort the results in a given order. Values may be `asc` for ascending order or `desc` for descending order. Must be used in conjunction with the sortBy parameter.")
  
    public SortOrderEnum getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(SortOrderEnum sortOrder) {
    this.sortOrder = sortOrder;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoricExternalTaskLogQueryDtoSorting historicExternalTaskLogQueryDtoSorting = (HistoricExternalTaskLogQueryDtoSorting) o;
    return Objects.equals(this.sortBy, historicExternalTaskLogQueryDtoSorting.sortBy) &&
        Objects.equals(this.sortOrder, historicExternalTaskLogQueryDtoSorting.sortOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sortBy, sortOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoricExternalTaskLogQueryDtoSorting {\n");
    
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
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