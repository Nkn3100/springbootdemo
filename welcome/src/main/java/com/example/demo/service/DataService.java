package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.DataDTO;
import com.example.demo.entity.Data;
import com.example.demo.repository.DataRepository;
@Transactional
@Service(value = "dataService")
public class DataService {
	@Autowired
	private DataRepository dataRepository;
	
	
//	 public List<Data> extractData(){
//		 Iterable<Data> datalist= dataRepository.findAll();
//		
//		 List<Data> list=new ArrayList<>();
//		
//		 for (Data d : datalist) {
//			 DataDTO dataDTO= new DataDTO();
//			 dataDTO.setName(d.getName());
//			 dataDTO.setEmail(d.getEmail());
//				list.add(dataDTO);
//			}
//		 return list;
//	 }
	 public List<Data> getdata(){
		 return (List<Data>) dataRepository.findAll();
	 }
	 public String addData(Data data) {
		 Data newData = new Data();
		 newData.setName(data.getName());
		 newData.setEmail(data.getEmail());
		 dataRepository.save(newData);
		 return newData.getName();
		 
	 }
	 public String editData(Data data) {
		 Optional<Data> ext=dataRepository.findById(data.getEmail());
		 ext.get().setName(data.getName());
	//	 ext.setName(data.getName());
	//	 dataRepository.save(ext.get());
		 return ext.get().getName();
	//	 if(data.getEmail()=)
	//	 Data newData = new Data();
		 
		 
	 }
	 public String deleteData(String email) {
		dataRepository.deleteById(email);
		return email;
		 
	 }
	
	
}