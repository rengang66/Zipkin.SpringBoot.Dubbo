## 172--zipkin-springboot-dubbo

Zipkin.SpringBoot.Dubbo

基于zipkin调用链封装starter实现springmvc、dubbo、restTemplate等实现全链路跟踪 。


实现思路
1、过滤器实现思路
所有调用链数据都通过过滤器实现埋点并收集、同一条链共享一个traceId、每个节点有唯一的spanId。
2、共享传递方式
rpc调用：通过隐式传参、dubbo有提供spi在rpc调用之前塞到请求中。参考：dubbo系列六、SPI扩展Filter隐式传参
http调用：通过servlet过滤器、在请求前放入requestHead中传递、resTemplate也是如此。
redis和DB等调用：原理相似，可以通过aop在调用前后拦截。

启动步骤：
10--启动zookeeper
20--启动zipkin-server
30--启动springboot-zipkin0
40--启动springboot-zipkin1


zipkin-server的管理Web
http://127.0.0.1:9411/

通过调用其中一个服务springboot-zipkin0，达到服务之间的调用。该服务会调用springboot-zipkin1和springboot-zipkin2。
http://127.0.0.1:8082/test
