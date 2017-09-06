package com.dyh.DaftIdGenerator;

import com.dyh.DaftIdGenerator.core.Id;
import com.dyh.DaftIdGenerator.redis.RoundRobinRedisPool;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by dengyunhui on 2017/9/2.
 */
public class Test {
    public static final String LOGICAL_SHARD_ID_KEY = "daft-generator-logical-shard-id";
    public static final String SEQUENCE_KEY = "daft-generator-sequence";

    public static void main(String[]args){

        DaftJedis jedis = new DaftJedis("127.0.0.1:6379");
        /**
         * 逻辑分区id,每一个节点分配一个逻辑分区id，区间为[1,1023],保证每一个节点的逻辑分区id是唯一的，这样才可以防止重复的id
         */
        jedis.set(LOGICAL_SHARD_ID_KEY,"1");

        /**
         * 开始的序列号，因为序列号为[0,4095],所以这个值最大为4094，超过时会报错。一般不建议自己设置
         */
        //jedis.set(SEQUENCE_KEY,"4094");

        RoundRobinRedisPool redisPool = new RoundRobinRedisPool(Arrays.asList(jedis));
        DaftIdGenerator idGenerator = new DaftIdGenerator(redisPool,1);

        //生成一个Id
        Optional<Id> id = idGenerator.generateId();
        id.ifPresent(System.out::println);

        Optional<List<Id>> ids = idGenerator.generateIdBatch(10); // Get up to 10 IDs

        Optional<List<Id>> ids2 = idGenerator.generateIdBatch(); // Get up to 4096 IDs

        /*for (int i = 0; i < 10000; i++) {

        }*/

    }
}
