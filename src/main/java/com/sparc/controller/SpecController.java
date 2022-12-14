package com.sparc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.entity.Specialization;
import com.sparc.response.ApiMessageResponse;
import com.sparc.service.ISpecService;

@RestController
@RequestMapping("/api/spec")
public class SpecController {

	@Autowired
	private ISpecService specService;

	// @PostMapping("/save")
	@PostMapping(value = { "/save", "/saveSpec" })
	// @RequestMapping(method = RequestMethod.POST,value ={"/save","/saveSpec"})
	public String saveSpec(@RequestBody Specialization spec) {
		String msg = specService.saveSpec(spec);
		return msg;
	}

	/*
	 * @PostMapping("/saveSpec")
	 * 
	 * public String saveSpec(@RequestBody SpecRequest request) { String
	 * msg=specService.saveSpec(request); return msg; }
	 */
	@PostMapping("/saveAllSpecData")
	public ResponseEntity<?> saveAllSpecData(@RequestBody List<Specialization> specList) {
		String message = specService.saveAllSpecData(specList);
		if (message.equals("success"))
			return new ResponseEntity<>(new ApiMessageResponse(message), HttpStatus.OK);
		else
			return new ResponseEntity<>(new ApiMessageResponse("Problem In Execution"), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAllSpecData")
	public ResponseEntity<?> getAllSpecData() {
		List<Specialization> specData = specService.getAllSpecData();
		if (specData.size() != 0)
			return ResponseEntity.ok(specData);
		else
			return new ResponseEntity<>(new ApiMessageResponse("no Data Available"), HttpStatus.NOT_FOUND);
	}

	/*
	 * @GetMapping("/getSpecDataById/{docId}") public ResponseEntity<?>
	 * getSpecDataById(@PathVariable Long docId) { Specialization spec =
	 * specService.getSpecDataById(docId); if (spec != null) return
	 * ResponseEntity.ok(spec); else return new ResponseEntity<>(new
	 * ApiMessageResponse("Invalid Id"), HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */

	@GetMapping("/getSpecDataById/{specId}")
	public ResponseEntity<?> getSpecDataById(@PathVariable(name = "specId") Long id) {
		Specialization spec = specService.getSpecDataById(id);
		if (spec != null)
			return ResponseEntity.ok(spec);
		else
			return new ResponseEntity<>(new ApiMessageResponse("Invalid Id"), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getSpecDataByIdUsingRP")
	public ResponseEntity<?> getSpecDataByIdUsingRP(
			@RequestParam(name = "specId", required = false, defaultValue = "2") Long id) {
		Specialization spec = specService.getSpecDataByIdUsingRP(id);
		if (spec != null)
			return ResponseEntity.ok(spec);
		else
			return new ResponseEntity<>(new ApiMessageResponse("Invalid Id"), HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateSpecDataBySpecId")
	public ResponseEntity<?> updateSpecDataBySpecId(@RequestBody Specialization spec) {
		String message = specService.updateSpecDataBySpecId(spec);
		if (message.equals("success"))
			return new ResponseEntity<>(new ApiMessageResponse(message), HttpStatus.OK);
		else if (message.equals("invalidId"))
			return new ResponseEntity<>(new ApiMessageResponse("InvalidId"), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(new ApiMessageResponse("Problem In Execution"), HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/deleteSpecDataById/{id}")
	public ResponseEntity<?> deleteSpecDataById(@PathVariable Long id) {
		String message = specService.deleteSpecDataById(id);
		if (message.equals("success"))
			return new ResponseEntity<>(new ApiMessageResponse(message), HttpStatus.OK);
		else if (message.equals("invalidId"))
			return new ResponseEntity<>(new ApiMessageResponse("InvalidId"), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(new ApiMessageResponse("Problem In Execution"), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllSpecBySpecCode/{specCode}")
	public ResponseEntity<?>getAllSpecBySpecCode(@PathVariable String specCode){
		List<Specialization>data=specService.getAllSpecBySpecCode(specCode);
		if(data.size()!=0)
			return ResponseEntity.ok(data);
		else
			return new ResponseEntity<>(new ApiMessageResponse("InvalidId"), HttpStatus.NOT_FOUND);
	}
	
	

}
