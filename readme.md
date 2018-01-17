### 背景
楼主在使用第三方服务接口的时候，一开始使用最基础的 .properties + @Value，那么当 参数数量、参数key变化 之后，**发送请求、拼接参数的业务层代码**
要做相应的修改比较麻烦，需要修改 .properties、修改 @Value 注入，修改参数拼接（楼主那个代码还有多次参数拼接），在经过架构师指导后
改成了 .properties + com.feilong.net.entity.HttpRequest 之后，当 参数数量、参数key变化 之后，**基本上不用对业务层代码做改动**



### BaseSpring 模板
https://github.com/Knight-JNXU/SpringStudy/tree/BaseSpring
