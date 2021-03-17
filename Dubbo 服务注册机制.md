# Dubbo 服务注册机制

## Dubbo所支持的注册中心

1.  Multicast 

   组网广播，只可以在局域网内使用，一般只是作为测试

2. Zookeeper (常用)

   是Apache Hadoop 的子项目，是一个树形的目录服务

3. Redis

4. Simple

5. 基于Dubbo 的服务实现(SimpleRegistryService)，不支持集群

## Redis注册中心

- 数据结构：如何存储服务的注册与订阅关系
- 状态更新：当服务状态改变，如何及时更新

### 数据结构：

redis 注册中心使用`Map`存储服务发布，订阅等信息：

```
key:map
	key:value
	key:value
	...
```



发布订阅：

```
/dubbo/{serviceName}/providers
    {providerUrl1}:{periodTimestamp}
    {providerUrl2}:{periodTimestamp}
    ...
```

订阅服务：

```
/dubbo/{serviceName}/consumers
    {consumerUrl1}:{periodTimestamp}
    {consumerUrl2}:{periodTimestamp}
    ...
```

