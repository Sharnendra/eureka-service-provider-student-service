package com.provider.eurekaserviceprovider.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.provider.eurekaserviceprovider.exception.ProductNotfoundException;
import com.provider.eurekaserviceprovider.modal.Student;

@RestController
public class StudentServiceController {
 
    private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
 
    static {
        schooDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        Student std = new Student("Sajal", "Class IV");
        lst.add(std);
        std = new Student("Lokesh", "Class V");
        lst.add(std);
        std=null;
        
        schooDB.put("abcschool", lst);
 
        lst = new ArrayList<Student>();
        std = new Student("Kajal", "Class III");
        lst.add(std);
        std=null;
        std = new Student("Sukesh", "Class VI");
        lst.add(std);
        std=null;
 
        schooDB.put("xyzschool", lst);
 
    }
 
    @RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);
        List<Student> studentList = schooDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            studentList.add(new Student("Not Found", "N/A"));
        }
        return studentList;
    }
    
    @RequestMapping(value = "/products/{schoolname}", method = RequestMethod.GET)
    public ResponseEntity<Object> updateProduct(@PathVariable String schoolname) { 
       List<Student> studentList = schooDB.get(schoolname);
       if(studentList == null)throw new ProductNotfoundException("Product Not Found");
       return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = "/products2/{schoolname}", method = RequestMethod.GET)
    public @ResponseBody List<Student> updateProduct2(@PathVariable String schoolname) { 
       List<Student> studentList = schooDB.get(schoolname);
       if(studentList == null)throw new ProductNotfoundException("Product Not Found");
       return studentList;
    }
    
    
   
}