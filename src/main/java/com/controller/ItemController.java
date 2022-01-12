package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.BoughtItems;
import com.model.Item;
import com.repo.BoughtItemsRepo;
import com.repo.ItemRepo;


@RestController
@RequestMapping(value = "/admin")
@CrossOrigin(origins="*",maxAge=3600)
public class ItemController {
	
	
	
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	BoughtItemsRepo boughtRepo;
	
	
	@PutMapping(value = "/addItem" , produces="application/json")
	public ResponseEntity<?> addItem(@RequestBody Item item){
		try {
			itemRepo.save(item);
			return new ResponseEntity<String>("Added",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("not Added",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping(value = "/deleteItem")
	public ResponseEntity<?> deleteItem(@RequestParam int id){
		try {
		
			itemRepo.deleteById(id);
			return new ResponseEntity<String>("deleted",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("not deleted",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/editItem")
	public ResponseEntity<?> editItem(@RequestBody Item item){
		try {
		int id=item.getId();
		
			Item itemA=itemRepo.findById(id).get();
			itemA.setPrice(item.getPrice());
			itemA.setDescription(item.getDescription());
			itemA.setTitle(item.getTitle());
			itemA.setImage(item.getImage());
			itemRepo.save(itemA);
			return new ResponseEntity<String>("updated",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("not updated",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getAllItems")
	public ResponseEntity<?> getAllItems() {

	try {
		return new ResponseEntity<List<Item>>(itemRepo.findAll(),HttpStatus.OK);
	}catch (Exception e) {
		return new ResponseEntity<String>("no Items found",HttpStatus.BAD_REQUEST);

	}

	}
	@PostMapping(value = "/buyItem" , produces="application/json")
	public ResponseEntity<?> buyItems(@RequestBody Item item){
		Item itemToBuy=item;
		int itemId=itemToBuy.getId();
		System.out.println(item);
		try {
			if(boughtRepo.findById(itemId).isPresent()) {
				BoughtItems itemToUpdate=boughtRepo.findById(itemId).get();
						int numsOfOrder=itemToUpdate.getNums();
						itemToUpdate.setNums(numsOfOrder +1 );
							boughtRepo.save(itemToUpdate);
						
				}
				else {
					
					BoughtItems itemNewBuy=new BoughtItems();
						itemNewBuy.setId(item.getId());
						itemNewBuy.setTitle(item.getTitle());
						itemNewBuy.setDescription(item.getDescription());
						itemNewBuy.setPrice(item.getPrice());
						itemNewBuy.setImage(item.getImage());
						System.out.println(itemNewBuy);
					boughtRepo.save(itemNewBuy);
				}
			
			return new ResponseEntity<String>("Item added",HttpStatus.OK);
			}
		catch (Exception e) {
			return new ResponseEntity<String>("Error ",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/getAllBoughtItems")
	public ResponseEntity<?> getAllBoughtItems() {

	try {
		return new ResponseEntity<List<BoughtItems>>(boughtRepo.findAll(),HttpStatus.OK);
	}catch (Exception e) {
		return new ResponseEntity<String>("no Items found",HttpStatus.BAD_REQUEST);

	}

	}
	@GetMapping(value = "/getStats")
	public ResponseEntity<?> getStatsOrderedItems(){
		try {
			return new ResponseEntity<List<BoughtItems>>(boughtRepo.findAllByOrderByNumsDesc(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("no Items found",HttpStatus.BAD_REQUEST);
		}
		
	}
	


}
