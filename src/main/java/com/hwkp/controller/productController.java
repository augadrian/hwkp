package com.hwkp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwkp.common.JsonResult;
import com.hwkp.entity.ProductEntity;
import com.hwkp.service.ProductService;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
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

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public String addProduct(String productObj)throws IOException {
      ProductEntity productEntity=mapToJson.readValue(productObj,ProductEntity.class);
      productEntity.setProOriginalPrice(new BigDecimal(0));
      productEntity.setExpressFee(new BigDecimal(0));
      productEntity.setIsActive(1);
      productEntity.setModifiedUser("");
      productEntity.setCreatedTime(String.valueOf(1));
      productEntity.setModifiedTime(String.valueOf(1));
      productEntity.setCreatedUser("");
//      productEntity.setProIntroduction("");
      productEntity.setProductId("");
      productEntity.setProName("");
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

    @RequestMapping(value = "/delProduct",method = RequestMethod.POST)
    @ResponseBody
    public String delProduct( String  productId)throws IOException{
      ProductEntity productEntity=productService.findByProductId(productId);
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

    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    @ResponseBody
    public String updateProduct(String productObj)throws Exception{

//      JSONObject jsonObject = JSONObject.fromObject(productObj);
//       String proIntroduction=jsonObject.getString("proIntroduction");
//         jsonObject.remove("proIntroduction");
//         String newProductObj=jsonObject.toString();
      ProductEntity productEntity=mapToJson.readValue(productObj,ProductEntity.class);
        //JSONObject jsonObject=productEntity.getProIntroduction();
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


  @RequestMapping(value = "/productList",method = RequestMethod.GET)
  @ResponseBody
  public String productList( Integer pageNo, Integer pageSize)throws JsonProcessingException {
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
