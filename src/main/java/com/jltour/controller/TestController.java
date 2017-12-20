package com.jltour.controller;

import com.jltour.bean.Hotel;
import com.jltour.bean.TestModel;
import com.jltour.mappers.HotelMapper;
import com.jltour.service.GdMapService;
import com.jltour.service.TestService;
import com.jltour.utils.ExportExcelUtils;
import com.jltour.utils.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/9/29 0029.
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private GdMapService gdMapService;

    @RequestMapping("index")
    public Object test(){
        List<TestModel> testModels = testService.test();
        List<TestModel> mybaitesTest = testService.mybaitesTest();
        return MapUtils.generate(new String[]{"header","body"},new Object[]{"xxxxx",""});
    }


    @GetMapping("/exportCatalogue")
    public String exportCatalogue(){
        //获取所有省份集合
        List<Hotel> provinceNameList  = hotelMapper.selectProvinceNameList(100,500);
        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
            out = new FileOutputStream("F:\\导出数据\\test7.xlsx");
            int i =0;
            List<List<String>> data = new ArrayList<List<String>>();
            for (Hotel ht:provinceNameList){
                //String provinceName =  test("马鞍山");

               String provinceName =  test(ht.getCityName()+ht.getAddress());
                System.out.println(ht.getCityName());
                System.out.println("----------"+provinceName);

                int numCity = hotelMapper.selectCityNum(ht.getCityName());
                List rowData = new ArrayList();
                rowData.add(provinceName);
                rowData.add(ht.getCityName());
                rowData.add(numCity+"");
                rowData.add("1");
                data.add(rowData);
            }
            System.out.println("---------"+i);
            String[] headers = { "省份", "城市名称", "数量", "省内数量" };
            ExportExcelUtils eeu = new ExportExcelUtils();
            workbook = new HSSFWorkbook();
            eeu.exportExcel(workbook, 0, "首页", headers, data, out);
            //一次性写出
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sussess";
    }



    @GetMapping("/exportCatalogue2")
    public String exportCatalogue2(){
        //获取所有省份集合
        List<Hotel> provinceNameList  = hotelMapper.selectProvinceNameList(500,500);
        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
            out = new FileOutputStream("F:\\导出数据\\test2.xlsx");
            int i =0;
            List<List<String>> data = new ArrayList<List<String>>();
            for (Hotel ht:provinceNameList){

                String provinceName =  test(ht.getCityName()+ht.getAddress());

                System.out.println(ht.getCityName());
                System.out.println("----------"+provinceName);
                int numCity = hotelMapper.selectCityNum(ht.getCityName());
                List rowData = new ArrayList();
                rowData.add(provinceName);
                rowData.add(ht.getCityName());
                rowData.add(numCity+"");
                rowData.add("1");
                data.add(rowData);
            }
            System.out.println("---------"+i);
            String[] headers = { "省份", "城市名称", "数量", "省内数量" };
            ExportExcelUtils eeu = new ExportExcelUtils();
            workbook = new HSSFWorkbook();
            eeu.exportExcel(workbook, 0, "首页", headers, data, out);
            //一次性写出
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sussess";
    }




    @GetMapping("/exportCatalogue3")
    public String exportCatalogue3(){
        //获取所有省份集合
        List<Hotel> provinceNameList  = hotelMapper.selectProvinceNameList(1000,500);
        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
            out = new FileOutputStream("F:\\导出数据\\test3.xlsx");
            int i =0;
            List<List<String>> data = new ArrayList<List<String>>();
            for (Hotel ht:provinceNameList){

                String provinceName =  test(ht.getCityName()+ht.getAddress());
                System.out.println(ht.getCityName());
                System.out.println("----------"+provinceName);
                int numCity = hotelMapper.selectCityNum(ht.getCityName());
                List rowData = new ArrayList();
                rowData.add(provinceName);
                rowData.add(ht.getCityName());
                rowData.add(numCity+"");
                rowData.add("1");
                data.add(rowData);
            }
            System.out.println("---------"+i);
            String[] headers = { "省份", "城市名称", "数量", "省内数量" };
            ExportExcelUtils eeu = new ExportExcelUtils();
            workbook = new HSSFWorkbook();
            eeu.exportExcel(workbook, 0, "首页", headers, data, out);
            //一次性写出
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sussess";
    }


    @GetMapping("/exportCatalogue4")
    public String exportCatalogue4(){
        //获取所有省份集合
        List<Hotel> provinceNameList  = hotelMapper.selectProvinceNameList(1500,1000);
        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
            out = new FileOutputStream("F:\\导出数据\\test4.xlsx");
            int i =0;
            List<List<String>> data = new ArrayList<List<String>>();
            for (Hotel ht:provinceNameList){

                String provinceName =  test(ht.getCityName()+ht.getAddress());
                System.out.println("----------"+provinceName);
                System.out.println(ht.getCityName());
                int numCity = hotelMapper.selectCityNum(ht.getCityName());
                List rowData = new ArrayList();
                rowData.add(provinceName);
                rowData.add(ht.getCityName());
                rowData.add(numCity+"");
                rowData.add("1");
                data.add(rowData);
            }
            System.out.println("---------"+i);
            String[] headers = { "省份", "城市名称", "数量", "省内数量" };
            ExportExcelUtils eeu = new ExportExcelUtils();
            workbook = new HSSFWorkbook();
            eeu.exportExcel(workbook, 0, "首页", headers, data, out);
            //一次性写出
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sussess";
    }










    /**
     * osii
     * @return
     */
/*    @GetMapping("/exportCatalogue")
    public String exportCatalogue(){
        //获取所有省份集合
        List<Hotel> provinceNameList  = hotelMapper.selectProvinceNameList();

        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
                 out = new FileOutputStream("F:\\导出数据\\test5.xlsx");

                int i =0;
                List<List<String>> data = new ArrayList<List<String>>();
                for (Hotel ht:provinceNameList){
                    System.out.println(ht.getCityName());
                    int numCity = hotelMapper.selectCityNum(ht.getCityName());
                    int numPro =hotelMapper.selectProvinceNum(ht.getProvinceName());
                    i = i+numPro;
                    List rowData = new ArrayList();
                    rowData.add(ht.getProvinceName());
                    rowData.add(ht.getCityName());
                    rowData.add(numCity+"");
                    rowData.add(numPro+"");
                    data.add(rowData);
                }

            System.out.println("---------"+i);
            String[] headers = { "省份", "城市名称", "数量", "省内数量" };
            ExportExcelUtils eeu = new ExportExcelUtils();
            workbook = new HSSFWorkbook();

            eeu.exportExcel(workbook, 0, "首页", headers, data, out);

            //一次性写出
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sussess";
    }*/




/*    @GetMapping("/export")
    public String export(){
       List<Hotel> hotelList = hotelMapper.selectHomeByCityGroupHotel();
        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
            out = new FileOutputStream("F:\\导出数据\\test2.xlsx");
            Map<Integer,List<List<String>>> map = new HashMap<Integer,List<List<String>>>();

            for(int i=0;i<hotelList.size();i++){
                Hotel hotel = hotelList.get(i);
                System.out.println("---------"+hotel.getCityCode());
                List<Hotel> hoteldetailInfo = hotelMapper.selectHotelInfoByCitycode(hotel.getCityCode());

                List<List<String>> data = new ArrayList<List<String>>();
                for (Hotel ht:hoteldetailInfo){
                    List rowData = new ArrayList();
                    rowData.add(ht.getHotelName());
                    rowData.add(ht.getCityName());
                    rowData.add(ht.getAddress());
                    data.add(rowData);
                }
                map.put(i,data);
            }

            String[] headers = { "酒店名称", "城市名称", "地址"  };
            ExportExcelUtils eeu = new ExportExcelUtils();
            workbook = new HSSFWorkbook();

            for(int i=0;i<hotelList.size();i++){
                Hotel hotel = hotelList.get(i);
                String cityName = hotel.getCityName();
                //刚果的国家代码重复  CD/CG
                if(hotel.getCityCode().equals("CG")){
                    cityName = hotel.getCityName()+"2";
                }

                List<List<String>> datamap = map.get(i);
                eeu.exportExcel(workbook, i, cityName, headers, datamap, out);
            }

            //一次性写出
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sussess";
    }*/

    public String test(String address) {
        String map = gdMapService.getLatitudeAndlongitude(address);
        return map;
    }

}
