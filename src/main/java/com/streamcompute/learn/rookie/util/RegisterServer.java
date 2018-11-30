package com.streamcompute.learn.rookie.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.alibaba.fastjson.JSONObject;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
//import org.apache.zookeeper.client.*;

public class RegisterServer {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String hostPort = "114.116.43.125:2181";
        String zpath = "/";
        List<String> zooChildren = new ArrayList<String>();
        ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
        zk.addAuthInfo("digest","user01:123456".getBytes());//设置认证信息
        zk.create("/javademo","this is a java code data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();

        Stat stat = new Stat();//获取节点创建修改信息
        if (zk != null) {
            try {

                zooChildren = zk.getChildren(zpath, false);
                byte[] data = zk.getData("/rookie0000000000",false,stat);
                System.out.println(stat.getCtime());
                String tmp = new String(data);
                System.out.println(tmp);//这个才是正确的内容
                System.out.println(String.valueOf(data));//这个会输出对象，不是字符串
//                System.out.println(Base64.getEncoder().encodeToString(data)); //这个输出NjY2Ng==
                System.out.println("Znodes of '/': ");
                for (String child: zooChildren) {
                    //print the children
                    System.out.println(child);
                }


            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void watchZk(){

    }
}
