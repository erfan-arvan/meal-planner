package de.zuellich.meal_planner.pinterest.datatypes;
public class BoardRequest {
  @JsonProperty(value = "data")
  private Board board;
  public Board getBoard() {
    return board;
  }
  public void setBoard(Board board) {
    this.board = board;
  }
}
