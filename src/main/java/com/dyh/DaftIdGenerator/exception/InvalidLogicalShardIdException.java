package com.dyh.DaftIdGenerator.exception;

/**
 * Created by dengyunhui on 2017/9/2.
 *
 * Exception thrown if the logical shard ID assigned to a Redis node is not within the minimum and maximum bounds, or is
 * not set.
 */
public class InvalidLogicalShardIdException extends RuntimeException {
  public InvalidLogicalShardIdException(final String message) {
    super(message);
  }
}
