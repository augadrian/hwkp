package com.hwkp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.ProductEntity;
import com.hwkp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "Product",produces = "text/html;charset=UTF-8")
public class productController {

  @Autowired
    private ProductService productService;

  ObjectMapper mapToJson = new ObjectMapper();
  JsonResult jsonResult = new JsonResult();

    @ResponseBody
    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(String productObj)throws IOException {
      ProductEntity productEntity=mapToJson.readValue(productObj,ProductEntity.class);
      if(productEntity.getCover()!=null){
        productService.save(productEntity);
        jsonResult.setStatus(200);
        jsonResult.setMessage("添加成功");
        jsonResult.setData(productEntity);
      }else {
        jsonResult.setStatus(500);
        jsonResult.setMessage("添加失败");
      }
      return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping(value = "/delProduct",method = RequestMethod.DELETE)
    public String delProduct(Integer id)throws IOException{
      ProductEntity productEntity=productService.findById(id);
      if(productEntity!=null){
        productService.delete(productEntity);
        jsonResult.setStatus(200);
        jsonResult.setMessage("删除成功");
      }else{
        jsonResult.setStatus(500);
        jsonResult.setMessage("删除失败");
      }
      return mapToJson.writeValueAsString(jsonResult);
    }

    @ResponseBody
    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    public String updateProduct(String productObj)throws IOException{
      ProductEntity productEntity=mapToJson.readValue(productObj,ProductEntity.class);

        if (this.productService.update(productEntity) != null) {
          jsonResult.setStatus(200);
          jsonResult.setMessage("修改成功");
          jsonResult.setData(productEntity);

        } else {
          jsonResult.setStatus(500);
          jsonResult.setMessage("修改失败");
        }

      return this.mapToJson.writeValueAsString(jsonResult);
    }


  @ResponseBody
  @RequestMapping(value = "/productList",method = RequestMethod.GET)
  public String productList(Integer pageNo, Integer pageSize)throws JsonProcessingException {
    Map<String, Object> jsonResult = new HashMap<>();
    try {
      List<ProductEntity> productEntityList = productService.findAll(pageNo, pageSize);
      Integer itemCount = productService.findAll(null, null).size();
      jsonResult.put("status", 200);
      jsonResult.put("pageNo", pageNo);
      jsonResult.put("pageSize", pageSize);
      jsonResult.put("itemCount", itemCount);
      jsonResult.put("message", "success");
      jsonResult.put("list", productEntityList);
    }catch (Exception e){
      e.printStackTrace();
      jsonResult.put("status", 500);
      jsonResult.put("message", "查询失败");
    }
    return this.mapToJson.writeValueAsString(jsonResult);
  }

}
