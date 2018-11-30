package com.hwkp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.SysAdminAccountEntity;
import com.hwkp.service.SysAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "adminAccount",produces = "text/html;charset=UTF-8")
public class AysAdminAccountController {

  @Autowired
    private SysAdminAccountService sysAdminAccountService;

  ObjectMapper mapToJson = new ObjectMapper();
  JsonResult jsonResult = new JsonResult();


  @RequestMapping(value="/verifySysAdminAccount", method = RequestMethod.POST)
  @ResponseBody
  public  String login( @RequestBody SysAdminAccountEntity sysAdminAccountEntity) throws  IOException{
   SysAdminAccountEntity sysAdminAccountEntity1=sysAdminAccountService.verifyAdmin(sysAdminAccountEntity.getAccount(),sysAdminAccountEntity.getPassword());
     if(sysAdminAccountEntity1!=null){
       jsonResult.setData(sysAdminAccountEntity1);
       jsonResult.setMessage("success");
       jsonResult.setStatus(200);

     }
     else{
       jsonResult.setMessage("fail");
       jsonResult.setStatus(500);

     }
    return mapToJson.writeValueAsString(jsonResult);
  }

    @RequestMapping(value="/addSysAdminAccount", method = RequestMethod.POST)
    @ResponseBody
    public String addSysAdminAccount(String sysAdminAccountObj)throws IOException {
      SysAdminAccountEntity sysAdminAccountEntity=mapToJson.readValue(sysAdminAccountObj,SysAdminAccountEntity.class);
      sysAdminAccountEntity.setCreatedTime("");
      sysAdminAccountEntity.setCreatedUser("");
      sysAdminAccountEntity.setHeadUrl("");
      sysAdminAccountEntity.setIsActive(1);
      sysAdminAccountEntity.setIsBanded(0);
      sysAdminAccountEntity.setLastLoginTime("");
      sysAdminAccountEntity.setModifiedTime(String.valueOf(0));
      sysAdminAccountEntity.setModifiedUser("");
      sysAdminAccountEntity.setPermission(1);
      sysAdminAccountEntity.setUserId("");
      sysAdminAccountEntity.setWxOpenid("");
      sysAdminAccountEntity.setUserName("");
      if(sysAdminAccountEntity.getAccount()!=null){
        sysAdminAccountService.save(sysAdminAccountEntity);
        jsonResult.setStatus(200);
        jsonResult.setMessage("添加成功");
        jsonResult.setData(sysAdminAccountEntity);
      }else {
        jsonResult.setStatus(500);
        jsonResult.setMessage("添加失败");

      }
      return mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/delSysAdminAccount",method = RequestMethod.POST)
    @ResponseBody
    public String delSysAdminAccount(String userId)throws IOException{
      SysAdminAccountEntity sysAdminAccountEntity=sysAdminAccountService.findByUserId(userId);
      if(sysAdminAccountEntity!=null){
        sysAdminAccountService.delete(sysAdminAccountEntity);
        jsonResult.setStatus(200);
        jsonResult.setMessage("删除成功");
      }else{
        jsonResult.setStatus(500);
        jsonResult.setMessage("删除失败");
      }
      return mapToJson.writeValueAsString(jsonResult);
    }

    @RequestMapping(value = "/updateSysAdminAccount",method = RequestMethod.POST)
    @ResponseBody
    public String updateSysAdminAccount(String sysAdminAccountObj)throws IOException{
      SysAdminAccountEntity sysAdminAccountEntity=mapToJson.readValue(sysAdminAccountObj,SysAdminAccountEntity.class);

        if (this.sysAdminAccountService.update(sysAdminAccountEntity) != null) {
          jsonResult.setStatus(200);
          jsonResult.setMessage("修改成功");
          jsonResult.setData(sysAdminAccountEntity);

        } else {
          jsonResult.setStatus(500);
          jsonResult.setMessage("修改失败");
        }

      return this.mapToJson.writeValueAsString(jsonResult);
    }
  @RequestMapping(value = "/sysAdminAccountList",method = RequestMethod.GET)
  @ResponseBody
  public String sysAdminAccountList(Integer pageNo, Integer pageSize)throws IOException{
    Map<String, Object> jsonResult = new HashMap<>();
    try {
      List<SysAdminAccountEntity> orderEntityList = sysAdminAccountService.findAll(pageNo, pageSize);
      Integer itemCount = sysAdminAccountService.findAll(null, null).size();
      jsonResult.put("status", 200);
      jsonResult.put("pageNo", pageNo);
      jsonResult.put("pageSize", pageSize);
      jsonResult.put("itemCount", itemCount);
      jsonResult.put("message", "success");
      jsonResult.put("list", orderEntityList);
    }catch (Exception e){
      e.printStackTrace();
      jsonResult.put("status", 500);
      jsonResult.put("message", "查询失败");
    }
    return this.mapToJson.writeValueAsString(jsonResult);
  }
}
