package com.bills.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.datastore.Entity;

@RestController
public class VisitorController {

  @Autowired
  VisitorDSDao visitorDSDao;

  @RequestMapping(value = "/visitor", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  @ResponseBody
  public Entity insertVisitor(@RequestBody Visitors visitors) {
    return visitorDSDao.createVisitor(visitors);
  }

}
