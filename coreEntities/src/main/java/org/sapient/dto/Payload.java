package org.sapient.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Payload<K,V> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Map<K,V> items = new HashMap<K,V>();
    
    public Object getObject(String itemName) 
    {
        return items.get(itemName);
    }
    
    public void putObject(K key,V value) 
    {
        items.put(key, value);
    }
    
    @Override
    public String toString() 
    {
        return "Payload [items=" + items + "]";
    }
}
