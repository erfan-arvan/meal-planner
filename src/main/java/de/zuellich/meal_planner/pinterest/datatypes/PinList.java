package de.zuellich.meal_planner.pinterest.datatypes;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PinList {
  @JsonProperty(value = "data")
  private List<Pin> pins;
  @JsonProperty(value = "page")
  private PagingInformation page;
  public List<Pin> getPins() {
    return pins;
  }
  public void setPins(List<Pin> pins) {
    this.pins = pins;
  }
  public PagingInformation getPage() {
    return page;
  }
  public void setPage(PagingInformation page) {
    this.page = page;
  }
}
