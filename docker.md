创建docker 私有仓库
~~~shell script
docker pull registry
docker run ‐di ‐‐name=registry ‐p 5000:5000 registry
~~~
打开http://ip:5000/v2/_catalog查看到{"repositories":[]} 表示私有仓库搭建成功并且内容为空
> 修改daemon.json
 ~~~shell script
vi /etc/docker/daemon.json
### 添加以下内容，保存退出。(此步用于让 docker信任私有仓库地址)
{"insecure-registries":["ip:5000"]}
重启docker服务

systemctl start docker.service
~~~

### 使用Docker Maven插件构建镜像到私有厂库
~~~shell script
##修改宿主机的docker配置，让其可以远程访问
vi /lib/systemd/system/docker.service
### 其中ExecStart=后添加配置 -H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock
### 刷新配置，重启服务
systemctl daemon-reload
systemctl restart docker
docker start registry
~~~
[docker maven plugin地址](https://github.com/spotify/docker-maven-plugin)

配置参考tensquare_config pom.xml
执行命令
~~~shell script
mvn clean package docker:build -DpushImage
~~~