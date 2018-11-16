package com.hwkp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.AdvEntity;
import com.hwkp.service.AdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "adv",produces = "text/html;charset=UTF-8")
public class AdvController {
    @Autowired
    private AdvService advService;

    ObjectMapper mapToJson = new ObjectMapper();
    JsonResult jsonResult = new JsonResult();

    @ResponseBody
    @RequestMapping(value="/addAdv", method = RequestMethod.POST)
    public String addAdv(String advObj)throws IOException {
        AdvEntity advEntity=mapToJson.readValue(advObj,AdvEntity.class);
        if(advEntity.getAdvertise()!=null){
            advService.save(advEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("添加成功");
            jsonResult.setData(advEntity);
        }else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("添加失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping(value = "/delAdv",method = RequestMethod.DELETE)
    public String delAdv(Integer id)throws IOException{
        AdvEntity advEntity=advService.findById(id);
        if(advEntity!=null){
            advService.delete(advEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("删除成功");
        }else{
            jsonResult.setStatus(500);
            jsonResult.setMessage("删除失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAdv",method = RequestMethod.POST)
    public String updateAdv(String advObj)throws IOException{
        AdvEntity advEntity=mapToJson.readValue(advObj,AdvEntity.class);

        if (this.advService.update(advEntity) != null) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("修改成功");
            jsonResult.setData(advEntity);

        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("修改失败");
        }

        return this.mapToJson.writeValueAsString(jsonResult);
    }

}
