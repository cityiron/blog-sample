## custom-metrics

this demo is prometheus sample, based on:
- Java
- SpringBoot
- Druid
- JMX
- [jmx-exporter](https://github.com/prometheus/jmx_exporter)

## run in intellij

- the druid is for JMX sample from opensource. your must change application.yaml druid config for your self db.
- replace start VM options path for your self.

The VM options:
```
-javaagent:/Users/tc/Documents/workspace_2020/blog-sample/prometheus-jmx/agent/jmx_prometheus_javaagent-0.14.0.jar=8989:/Users/tc/Documents/workspace_2020/blog-sample/prometheus-jmx/agent/config.yml
```

Check that `http://127.0.0.1:8989/mertic` contains your metrics in prometheus format, like : `com_funnycode_pm_jmx_basic_Total{name="com.funnycode.pm.jmx.ApiCount",} 0.0`
