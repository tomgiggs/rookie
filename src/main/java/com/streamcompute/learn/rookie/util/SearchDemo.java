package com.streamcompute.learn.rookie.util;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.script.ScriptEngineRegistry;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
//import org.elasticsearch.script.ScriptEngine;

public class SearchDemo {
    public static void main(String[] args) throws UnknownHostException {
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
                .setQuery(QueryBuilders.queryStringQuery("荣盛商业"))
//                .setQuery(QueryBuilders.termQuery("proj_name", "荣盛商业"))
                .setFrom(0).setSize(60).setExplain(true)
                .get();
        System.out.println(response.getHits());
        ArrayList records = new ArrayList();
        for(SearchHit hit : response.getHits().getHits()){
            System.out.println(hit.getSource());
            records.add(hit.getSource());
        }
        client.close();
        System.out.println(JSONObject.toJSONString(records));
        client.close();
    }
}
