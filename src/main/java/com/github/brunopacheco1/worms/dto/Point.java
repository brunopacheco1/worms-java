package com.github.brunopacheco1.worms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Point {
  private int x;
  private int y;
}
