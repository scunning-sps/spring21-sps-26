package com.google.sps.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.sps.data.Guide;

public class DatastoreGuides {

    private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind("Guide");
    private final StructuredQuery.Builder<Entity> queryBuilder = Query.newEntityQueryBuilder().setKind("Guide");
    private final Query<Entity> queryAll;

    public DatastoreGuides(){
        queryAll = queryBuilder.build();
    }

    private FullEntity<IncompleteKey> toEntity(Guide guide){
        IncompleteKey key;
        if (guide.getId() < 0)
            key = keyFactory.newKey();
        else
            key = keyFactory.newKey(guide.getId());

        StringValue content = StringValue.newBuilder(guide.getContent()).setExcludeFromIndexes(true).build();
        return Entity.newBuilder(key)
                .set("title", guide.getTitle())
                .set("description", guide.getDescription())
                .set("content", content)
                .set("category", guide.getCategory())
                .set("timestamp", guide.getTimestamp())
                .build();
    }

    private Guide toGuide(Entity entity){
        long id = entity.getKey().getId();
        String title = entity.getString("title");
        String description = entity.getString("description");
        String content = entity.getString("content");
        String category = entity.getString("category");
        long timestamp = entity.getLong("timestamp");

        return new Guide(id, title, description, content, category, timestamp);
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

    public void delete(long id){
        datastore.delete(keyFactory.newKey(id));
    }

    public List<Guide> queryAll(){
        return listFromQueryResults(datastore.run(queryAll));
    }

    public List<Guide> queryByCategory(String category){
        Query<Entity> query = queryBuilder.setFilter(PropertyFilter.eq("category", category)).build();
        return listFromQueryResults(datastore.run(query));
    }

    public Optional<Guide> get(long id){
        Entity entity = datastore.get(keyFactory.newKey(id));
        return Optional.ofNullable(entity).map(this::toGuide);
    }
}