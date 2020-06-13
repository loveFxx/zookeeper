package com.client;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 100*1000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("conn");
            }
        });

        Stat stat = new Stat();
        zooKeeper.getData("/abc", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("abc");
            }
        },stat);
    }
}
