package com.aiflirt.exeception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    LocalDateTime timestamp;
    String message;
    int status;
    String error;
    }
