package dev.said.onlinemedclinic.configs;

import dev.said.onlinemedclinic.domains.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface ThreadSafeCollections {
    List<Integer> id = Collections.synchronizedList(new ArrayList<>());
    ConcurrentHashMap<Integer, Order> orderMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<Integer, Integer> weekMap = new ConcurrentHashMap<>();
}
