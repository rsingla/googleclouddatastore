package com.bills.store;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Entity.Builder;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

@Service
public class VisitorDSDao {

  protected static final Logger logger = LoggerFactory.getLogger("visitor");

  @Autowired
  Datastore datastore;

  KeyFactory keyFactoryVisitor;

  public Entity createVisitor(Visitors visitor) {
    return datastore.put(createVisitorEntity(visitor));
  }

  private Entity createVisitorEntity(Visitors visitor) {
    UUID value = UUID.randomUUID();
    Key key = datastore.newKeyFactory().setKind("Visitors").newKey(value.toString());
    logger.debug("Key ", key);
    Builder builder = Entity.newBuilder(key);
    logger.debug("Builder ", builder);

    builder.set("id", value.toString());
    builder.set("visitor_id", value.toString());

    if(visitor.getBrowser() != null) {
      builder.set("browser", visitor.getBrowser());
    }
    if(visitor.getDevice() != null) {
      builder.set("device", visitor.getDevice());
    }
    if(visitor.getIpAddress() != null) {
      builder.set("ip_address", visitor.getIpAddress());
    }
    if(visitor.getOs() != null) {
      builder.set("os", visitor.getOs());
    }
    if(visitor.getScreenSize() != null) {
      builder.set("screen_size", visitor.getScreenSize());
    }
    if(visitor.getUserAgent() != null) {
      builder.set("user_agent", visitor.getUserAgent());
    }
    if(visitor.getCreatedAt() != null) {
      builder.set("created_at", visitor.getCreatedAt());
    }

    Entity entity = builder.build();

    logger.debug("Entity", entity);
    return entity;
  }

}
