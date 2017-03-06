package com.bills.store;

import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "visitor_id", "browser", "os", "created_at", "updated_at", "device", "screen_size", "ip_address" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Visitors extends ResourceSupport {

  @JsonProperty("mongo_id")
  private String mongoId;

  // Unique visitor
  @JsonProperty("visitor_id")
  private String visitorId;

  @JsonProperty("browser")
  private String browser;

  @JsonProperty("os")
  private String os;

  @JsonProperty("user_agent")
  private String userAgent;

  // @ApiObjectField(name = "created_at" , description =
  // "Date added on first visit", required = true)
  @JsonProperty("created_at")
  private String createdAt;

  // @ApiObjectField(name = "updated_at" , description =
  // "Date updated on return visits", required = true)
  @JsonProperty("updated_at")
  private String updatedAt;

  @JsonProperty("device")
  private String device;

  @JsonProperty("screen_size")
  private String screenSize;

  @JsonProperty("ip_address")
  private String ipAddress;

  @JsonProperty("additional_properties")
  private Map<String, String> additionalProperties;

  /**
   * @return The browser
   */
  @JsonProperty("browser")
  public String getBrowser() {
    return browser;
  }

  /**
   * @param browser The browser
   */
  @JsonProperty("browser")
  public void setBrowser(String browser) {
    this.browser = browser;
  }

  /**
   * @return The os
   */
  @JsonProperty("os")
  public String getOs() {
    return os;
  }

  /**
   * @param os The os
   */
  @JsonProperty("os")
  public void setOs(String os) {
    this.os = os;
  }

  /**
   * @return The userAgent
   */
  public String getUserAgent() {
    return userAgent;
  }

  /**
   * @param userAgent The userAgent
   */

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  /**
   * @return The createdAt
   */
  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * @param createdAt The created_at
   */
  @JsonProperty("created_at")
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return The updatedAt
   */
  @JsonProperty("updated_at")
  public String getUpdatedAt() {
    return updatedAt;
  }

  /**
   * @param updatedAt The updated_at
   */
  @JsonProperty("updated_at")
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * @return The device
   */
  @JsonProperty("device")
  public String getDevice() {
    return device;
  }

  /**
   * @param device The device
   */
  @JsonProperty("device")
  public void setDevice(String device) {
    this.device = device;
  }

  /**
   * @return The screenSize
   */
  @JsonProperty("screen_size")
  public String getScreenSize() {
    return screenSize;
  }

  /**
   * @param screenSize The screen_size
   */
  @JsonProperty("screen_size")
  public void setScreenSize(String screenSize) {
    this.screenSize = screenSize;
  }

  /**
   * @return The ipAddress
   */
  @JsonProperty("ip_address")
  public String getIpAddress() {
    return ipAddress;
  }

  /**
   * @param ipAddress The ip_address
   */
  @JsonProperty("ip_address")
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * @return the visitorId
   */
  public String getVisitorId() {
    return visitorId;
  }

  /**
   * @param visitorId the visitorId to set
   */
  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }

  /**
   * @param additionalProperties the additionalProperties to set
   */
  public void setAdditionalProperties(Map<String, String> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  public Map<String, String> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @Override
  public String toString() {
    return "Visitors [mongoId=" + mongoId + ", visitorId=" + visitorId + ", browser=" + browser + ", os=" + os
        + ", userAgent=" + userAgent + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", device=" + device
        + ", screenSize=" + screenSize + ", ipAddress=" + ipAddress + ", additionalProperties=" + additionalProperties
        + "]";
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(browser).append(os).append(createdAt).append(updatedAt).append(device)
        .append(screenSize).append(ipAddress).append(visitorId).append(userAgent).append(additionalProperties)
        .toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if(other == this) {
      return true;
    }
    if((other instanceof Visitors) == false) {
      return false;
    }
    Visitors rhs = ((Visitors) other);
    return new EqualsBuilder().append(browser, rhs.browser).append(os, rhs.os).append(createdAt, rhs.createdAt)
        .append(updatedAt, rhs.updatedAt).append(device, rhs.device).append(screenSize, rhs.screenSize)
        .append(ipAddress, rhs.ipAddress).append(visitorId, rhs.visitorId).append(userAgent, rhs.userAgent)
        .append(additionalProperties, rhs.additionalProperties).isEquals();
  }

  public String getUUIDDataForLink(String uuid) {
    return uuid;
  }

  public static void main(String[] args) {
    Visitors visitors = new Visitors();
    System.out.println(JsonParserUtil.seralizeObject(visitors, Visitors.class));
  }

}
