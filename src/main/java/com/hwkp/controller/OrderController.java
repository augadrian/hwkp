package com.hwkp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.OrderEntity;
import com.hwkp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "order",produces = "text/html;charset=UTF-8")
public class OrderController {
    @Autowired
    private OrderService orderService;

    ObjectMapper mapToJson = new ObjectMapper();
    JsonResult jsonResult = new JsonResult();

    @ResponseBody
    @RequestMapping(value="/addOrder", method = RequestMethod.POST)
    public String addOrder(String productObj)throws IOException {
        OrderEntity orderEntity=mapToJson.readValue(productObj,OrderEntity.class);
        if(orderEntity.getOrderId()!=null){
            orderService.save(orderEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("添加成功");
            jsonResult.setData(orderEntity);
        }else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("添加失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping(value = "/delOrder",method = RequestMethod.DELETE)
    public String delOrder(Integer id)throws IOException{
        OrderEntity orderEntity=orderService.findById(id);
        if(orderEntity!=null){
            orderService.delete(orderEntity);
            jsonResult.setStatus(200);
            jsonResult.setMessage("删除成功");
        }else{
            jsonResult.setStatus(500);
            jsonResult.setMessage("删除失败");
        }
        return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping(value = "/updateOrder",method = RequestMethod.POST)
    public String updateOrder(String orderObj)throws IOException{
        OrderEntity orderEntity=mapToJson.readValue(orderObj,OrderEntity.class);

        if (this.orderService.update(orderEntity) != null) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("修改成功");
            jsonResult.setData(orderEntity);

        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("修改失败");
        }

        return this.mapToJson.writeValueAsString(jsonResult);
    }

}
