package com.brunopacheco1.brunopacheco1.worms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
  private String message;
}

