package com.streamcompute.learn.rookie.controller;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class SearchController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getKeyword(@RequestParam(value = "keyword") String keyword) throws UnknownHostException {
//        Settings settings = Settings.builder()
//                .put("cluster.name", "myClusterName").build();
//        TransportClient client = new PreBuiltTransportClient(settings);
        Settings settings = Settings.builder()
                .put("cluster.name", "master001")
                .put("client.transport.sniff", true)
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddresses(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300));
        SearchResponse response = client.prepareSearch("project_info")
//                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setSearchType(SearchType.DEFAULT)
                .setQuery(QueryBuilders.queryStringQuery(keyword))
//                .setQuery(QueryBuilders.termQuery("proj_name", "荣盛商业"))
                .setFrom(0).setSize(10).setExplain(true)
                .get();
        System.out.println(response.getHits());
        ArrayList records = new ArrayList();
        for(SearchHit hit : response.getHits().getHits()){
            System.out.println(hit.getSource());
            records.add(hit.getSource());
        }
        client.close();
        return JSONObject.toJSONString(records);
    }
}