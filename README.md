# Grab-red-envelopes
并发编程实战--抢红包  Concurrent programming practice - grab red envelopes

需求分析  
1，在并发高的情况下，怎样保证线程安全、保证红包金额正确性？同步、加锁  
2，设置红包总额，红包个数，抢红包人数（一般不用，但这是模拟）  
3，抢红包要同时开始  

技术栈：多线程+synchronized+CountDownLatch

红包拆分算法：  
1，红包金额=红包总额/红包个数  
2，最后一个红包=最后剩余的金额   

怎么实现随机金额？  