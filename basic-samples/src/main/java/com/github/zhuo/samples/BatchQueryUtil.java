package com.github.zhuo.samples;

//import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

/**
 * @description: 批量查询数据工具类
 * @author: zhuo
 */
//@Component
public class BatchQueryUtil {

    /**
     * 分批查询处理数据
     * @param batchSize 每批大小
     * @param queryFunction 查询函数 (offset, limit) -> List<T>
     * @param processFunction 处理函数
     */
    public <T> void batchProcess(int batchSize,
                                 BatchQueryFunction<T> queryFunction,
                                 Consumer<List<T>> processFunction) {
        long offset = 0;
        List<T> batchData;

        do {
            // 查询一批数据
            batchData = queryFunction.query(offset, batchSize);

            if (batchData != null && !batchData.isEmpty()) {
                // 处理这批数据
                processFunction.accept(batchData);

                // 更新偏移量
                offset += batchData.size();

                // 添加延迟避免对数据库造成太大压力
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } while (batchData != null && !batchData.isEmpty() && batchData.size() == batchSize);
    }

    @FunctionalInterface
    public interface BatchQueryFunction<T> {
        List<T> query(long offset, int limit);
    }
}
