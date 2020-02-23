package com.github.brunopacheco1.worms.domain;

public enum Difficulty {
  EASY(1000),
  MEDIUM(500),
  HARD(250);

  private final int tickRate;

  private Difficulty(int tickRate) {
    this.tickRate = tickRate;
  }

  public int getTickRate() {
    return tickRate;
  }
}
