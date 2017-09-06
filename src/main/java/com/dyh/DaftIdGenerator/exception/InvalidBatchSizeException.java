package com.dyh.DaftIdGenerator.exception;

/**
 * Created by dengyunhui on 2017/9/2.
 *
 * Exception thrown if the requested ID batch size is not within the minimum and maximum bounds.
 */
public class InvalidBatchSizeException extends RuntimeException {
  public InvalidBatchSizeException(final String message) {
    super(message);
  }
}
