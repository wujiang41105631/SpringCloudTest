Zuul 路由转发  
Zuul过滤器的关键特性有:
1. Type: 定义在请求执行过程中何时被执行;
2. Execution Order: 当存在多个过滤器时，用来指示执行的顺序，值越小就会越早执行;
3. Criteria: 执行的条件，即该过滤器何时会被触发;
4. Action: 具体的动作。  
过滤器之间并不会直接进行通信，而是通过RequestContext来共享信息，RequestContext是线程安全的。

```java
/**
 * Zuul Pre-Type Filter
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
public class PreTypeZuulFilter extends ZuulFilter {
    protected Logger logger = LoggerFactory.getLogger(PreTypeZuulFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE; // 过滤器有4中，PRE,ROUTING,POST,ERROR
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        this.logger.info("This is pre-type zuul filter.");
        return null;
    }
}
```


