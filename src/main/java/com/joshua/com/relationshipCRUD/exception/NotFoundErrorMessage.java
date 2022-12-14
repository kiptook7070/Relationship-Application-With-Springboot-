package com.joshua.com.relationshipCRUD.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
