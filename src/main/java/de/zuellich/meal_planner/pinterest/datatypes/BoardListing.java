package de.zuellich.meal_planner.pinterest.datatypes;
public class BoardListing {
  private Board board;
  private List<Pin> pins;
  public Board getBoard() {
    return board;
  }
  public void setBoard(Board board) {
    this.board = board;
  }
  public List<Pin> getPins() {
    return pins;
  }
  public void setPins(List<Pin> pins) {
    this.pins = pins;
  }
}
