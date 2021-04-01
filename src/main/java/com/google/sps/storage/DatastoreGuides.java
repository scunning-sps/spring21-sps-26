package com.google.sps.storage;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.sps.data.Guide;

public class DatastoreGuides {

    private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind("Guide");
    private final Query<Entity> query = Query.newEntityQueryBuilder().setKind("Guide").build();

    private FullEntity<IncompleteKey> toEntity(Guide guide){
        IncompleteKey key;
        if (guide.getId() < 0)
            key = keyFactory.newKey();
        else
            key = keyFactory.newKey(guide.getId());

        return Entity.newBuilder(key)
                .set("title", guide.getTitle())
                .set("description", guide.getDescription())
                .set("content", guide.getContent())
                .set("timestamp", guide.getTimestamp())
                .build();
    }

    private Guide toGuide(Entity entity){
        if (entity == null) return null;
        
        long id = entity.getKey().getId();
        String title = entity.getString("title");
        String description = entity.getString("description");
        String content = entity.getString("content");
        long timestamp = entity.getLong("timestamp");

        return new Guide(id, title, description, content, timestamp);
    }

    private List<Guide> listFromQueryResults(QueryResults<Entity> results){
        ArrayList<Guide> list = new ArrayList<>();

        while(results.hasNext()){
            list.add(toGuide(results.next()));
        }

        return list;
    }

    public Guide put(Guide guide){
        return toGuide(datastore.put(toEntity(guide)));
    }

    public List<Guide> queryAll(){
        return listFromQueryResults(datastore.run(query));
    }

    public Guide get(long id){
        return toGuide(datastore.get(keyFactory.newKey(id)));
    }
}