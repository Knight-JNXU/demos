package test;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.TimeInterval;
import com.feilong.core.bean.ConvertUtil;
import com.feilong.core.date.DateExtensionUtil;
import com.feilong.core.lang.PartitionRunnableBuilder;
import com.feilong.core.lang.PartitionThreadEntity;
import com.feilong.core.lang.ThreadUtil;
import com.feilong.json.jsonlib.JsonUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月15日
 * @function : 测试 Collection中哪些是线程安全的
 */
public class CollectionThreadSafeTest{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionThreadSafeTest.class);
    
    
    

    /**
    * TestCollectionThreadSafeTest.
    */
    @Test
    public void testArrayList(){
        
    }
    
    @Test
    public void testExecuteTestUsePartitionRunnableBuilderParamsMap() throws InterruptedException{
        Date beginDate = new Date();
        List<Integer> list = ConvertUtil.toList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        final Map<Integer, Boolean> indexAndResultMap = Collections.synchronizedSortedMap(new TreeMap());

        ThreadUtil.execute(list, 2, null, new PartitionRunnableBuilder<Integer>(){

            @Override
            public Runnable build(
                            final List<Integer> perBatchList,
                            final PartitionThreadEntity partitionThreadEntity,
                            Map<String, ?> paramsMap){

                return new Runnable(){

                    @Override
                    public void run(){

                        int i = 0;
                        for (Integer integer : perBatchList){
                            //------

                            //模拟 do something

                            //---------
                            try{
                                Thread.sleep(1 * TimeInterval.MILLISECOND_PER_SECONDS);
                            }catch (InterruptedException e){
                                LOGGER.error("", e);
                            }

                            int indexInTotalList = getIndex(partitionThreadEntity, i);

                            //模拟 当值是 5 或者8 的时候 操作结果是false
                            boolean result = (integer == 5 || integer == 8) ? false : true;

                            indexAndResultMap.put(indexInTotalList, result);

                            i++;
                        }
                    }

                    private Integer getIndex(PartitionThreadEntity partitionThreadEntity,int i){
                        int batchNumber = partitionThreadEntity.getBatchNumber();
                        return batchNumber * partitionThreadEntity.getEachSize() + i;
                    }
                };
            }

        });

        LOGGER.debug(JsonUtil.format(indexAndResultMap));

        LOGGER.info("use time:{}", DateExtensionUtil.formatDuration(beginDate));
    }
}
