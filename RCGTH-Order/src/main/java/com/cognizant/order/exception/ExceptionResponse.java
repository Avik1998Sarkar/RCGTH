package com.cognizant.order.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	private LocalDateTime date;
	private String message;
	private String details;

}
