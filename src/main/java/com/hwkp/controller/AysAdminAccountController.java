package com.hwkp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.SysAdminAccountEntity;
import com.hwkp.service.SysAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "Product",produces = "text/html;charset=UTF-8")
public class AysAdminAccountController {

  @Autowired
    private SysAdminAccountService sysAdminAccountService;

  ObjectMapper mapToJson = new ObjectMapper();
  JsonResult jsonResult = new JsonResult();

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
