~~~powershell
docker pull daocloud.io/library/elasticsearch:6.6.2
~~~

```powershell
docker run -di --name=tensquare_elasticsearch -p 9200:9200 -p 9300:9300 daocloud.io/library/elasticsearch:6.6.2
```

> 如果启动报错:( **max virtual memory areas vm.max_map_count [65530] likely too low, increase to at least [262144]** )
>
> ~~~powershell
> vim /etc/sysctl.conf
> vm.max_map_count=655360
> sysctl ‐p
> #然后重新启动容器
> ~~~
>
>  
