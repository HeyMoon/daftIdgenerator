package com.dyh.DaftIdGenerator.core;

import java.util.List;
import java.util.Optional;

/**
 * Created by dengyunhui on 2017/9/2.
 */
public interface IdGenerator {

    Optional<Id> generateId();


    Optional<List<Id>> generateIdBatch();


    Optional<List<Id>> generateIdBatch(final long batchSize);
}
