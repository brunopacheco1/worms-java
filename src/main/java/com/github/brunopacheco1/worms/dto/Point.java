package com.github.brunopacheco1.worms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Point {
  private int x;
  private int y;
}
