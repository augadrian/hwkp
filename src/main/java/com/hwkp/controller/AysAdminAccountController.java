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
import java.util.Map;

@Controller
@RequestMapping(value = "adminAccount",produces = "text/html;charset=UTF-8")
public class AysAdminAccountController {

  @Autowired
    private SysAdminAccountService sysAdminAccountService;

  ObjectMapper mapToJson = new ObjectMapper();
  JsonResult jsonResult = new JsonResult();


  @ResponseBody
  @RequestMapping(value="/verifySysAdminAccount", method = RequestMethod.POST)
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

    @ResponseBody
    @RequestMapping(value="/addSysAdminAccount", method = RequestMethod.POST)
    public String addSysAdminAccount(String sysAdminAccountObj)throws IOException {
      SysAdminAccountEntity sysAdminAccountEntity=mapToJson.readValue(sysAdminAccountObj,SysAdminAccountEntity.class);
      if(sysAdminAccountEntity.getUserId()!=null){
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

    @ResponseBody
    @RequestMapping(value = "/delSysAdminAccount",method = RequestMethod.DELETE)
    public String delSysAdminAccount(Integer id)throws IOException{
      SysAdminAccountEntity sysAdminAccountEntity=sysAdminAccountService.findById(id);
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

    @ResponseBody
    @RequestMapping(value = "/updateSysAdminAccount",method = RequestMethod.POST)
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

}
