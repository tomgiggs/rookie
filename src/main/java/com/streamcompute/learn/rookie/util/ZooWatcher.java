package com.streamcompute.learn.rookie.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import java.util.concurrent.CountDownLatch;

public class ZooWatcher implements Watcher {
    private static CountDownLatch latch = new CountDownLatch(1);
    private CountDownLatch correctAuthZooKeeper = null;

    public ZooWatcher(CountDownLatch correctAuthZooKeeper) {
        this.correctAuthZooKeeper = correctAuthZooKeeper;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent == null ) return;
        String path = watchedEvent.getPath(); // 受影响的节点路径
        EventType enventType = watchedEvent.getType(); // 事件类型(一共有四种)
        KeeperState stat = watchedEvent.getState() ; // ZK状态(一共有四种)

        if(stat == KeeperState.SyncConnected){
            if(EventType.None == enventType){
                System.out.println(":连接zookeeper服务器成功");
                correctAuthZooKeeper.countDown();
            }
        }else if(KeeperState.Disconnected == stat){
            System.out.println(":连接zookeeper服务器失败");
        }else if(KeeperState.Expired == stat){
            System.out.println(":连接zookeeper服务器会话已经过期");
        }else if(KeeperState.AuthFailed == stat){
            System.out.println(":连接zookeeper服务器认证失败");
    }
        System.out.println("------------------------------------");

    }
}
