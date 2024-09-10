package de.zuellich.meal_planner.pinterest.datatypes;
public class BoardList {
  @JsonProperty(value = "data")
  private List<Board> boards;
  public List<Board> getBoards() {
    return boards;
  }
  public void setBoards(List<Board> boards) {
    this.boards = boards;
  }
}
