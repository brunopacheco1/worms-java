package com.github.brunopacheco1.worms.domain;

public enum Direction {
  UP,
  DOWN,
  LEFT,
  RIGHT;

  public boolean isOpposite(Direction other) {
    switch (this) {
      case LEFT: return other == RIGHT;
      case RIGHT: return other == LEFT;
      case UP: return other == DOWN;
      case DOWN: return other == UP;
      default: throw new IllegalArgumentException();
    }
  }
}

