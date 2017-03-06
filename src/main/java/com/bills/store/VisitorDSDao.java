package com.bills.store;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

@Service
public class VisitorDSDao {

  @Autowired
  Datastore datastore;

  KeyFactory keyFactoryVisitor;

  public Entity createUser(Visitors visitor) {
    return datastore.put(createUserEntity(visitor));
  }

  private Entity createUserEntity(Visitors visitor) {
    UUID value = UUID.randomUUID();
    Key key = datastore.newKeyFactory().setKind("Visitors").newKey(value.toString());
    return Entity.newBuilder(key).set("browser", visitor.getBrowser()).set("device", visitor.getDevice())
        .set("ip_address", visitor.getIpAddress()).set("OS", visitor.getOs())
        .set("screen_size", visitor.getScreenSize()).set("user_agent", visitor.getUserAgent())
        .set("created_at", visitor.getCreatedAt()).build();
  }

}
