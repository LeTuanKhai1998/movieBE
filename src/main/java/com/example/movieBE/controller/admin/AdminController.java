package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.GenreDto;
import com.example.movieBE.dto.MovieDto;
import com.example.movieBE.dto.RestResponseDTO;
import com.example.movieBE.entity.UserEntity;
import com.example.movieBE.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin/user")
class AdminController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(AdminController.class);

    /**
     *
     */
    @Autowired
    AdminService adminService;


    /**
     * get list movie
     *
     * @return
     */
    @RequestMapping(value = "/Movie", method = RequestMethod.GET)
    public RestResponseDTO<List<MovieDto>> getMovie() {
        RestResponseDTO<List<MovieDto>> responseDTO = new RestResponseDTO<>();
        List<MovieDto> movieDtoList = new ArrayList<>();
        try {
            movieDtoList = adminService.getMovie();

        } catch (Exception e) {
            logger.error("MyGroupCatalogUser_Preparation", e.getMessage());
            throw e;
        }
        responseDTO.setData(movieDtoList);
        return responseDTO;
    }


    /**
     * get list genre
     *
     * @return
     */
    @RequestMapping(value = "/Genre", method = RequestMethod.GET)
    public RestResponseDTO<List<GenreDto>> getGenre() {
        RestResponseDTO<List<GenreDto>> responseDTO = new RestResponseDTO<>();
        List<GenreDto> genreDtoList = new ArrayList<>();
        try {
            genreDtoList = adminService.getGenre();

        } catch (Exception e) {
            logger.error("MyGroupCatalogUser_Preparation", e.getMessage());
            throw e;
        }
        responseDTO.setData(genreDtoList);
        return responseDTO;
    }

    /**
     * get list genre
     *
     * @return
     */
    @RequestMapping(value = "/Genre", method = RequestMethod.DELETE)
    public RestResponseDTO<String> deleteGenre(@RequestParam Long id) {
        RestResponseDTO<String> responseDTO = new RestResponseDTO<>();
        String message;
        try {
            message = adminService.deleteGenre(id);

        } catch (Exception e) {
            logger.error("MyGroupCatalogUser_Preparation", e.getMessage());
            throw e;
        }
        responseDTO.setData(message);
        return responseDTO;
    }

//
//    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
//    public Contact findContact(@PathVariable("id") long id) {
//        Contact contact = contactService.getOne(id);
//        if (contact == null) {
//            ResponseEntity.notFound().build();
//        }
//        return contact;
//    }
//
//    //    @RequestMapping(value = "/products",
////            method = RequestMethod.POST)
////    public ResponseEntity<Contact> createProduct(
////            @RequestBody Contact contact,
////            UriComponentsBuilder builder) {
////        contactService.save(contact);
////        HttpHeaders headers = new HttpHeaders();
////        headers.setLocation(builder.path("/products/{id}")
////                .buildAndExpand(contact.getId()).toUri());
////        return new ResponseEntity<>(contact, HttpStatus.CREATED);
////    }
//    @RequestMapping(value = "/contact/", method = RequestMethod.POST)
//    public Contact saveContact(@Valid @RequestBody Contact contact) {
//        return contactService.save(contact);
//    }
//
//    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") Long contactId,
//                                                 @Valid @RequestBody Contact contactForm) {
//        Contact contact = contactService.getOne(contactId);
//        if (contact == null) {
//            return ResponseEntity.notFound().build();
//        }
//        contact.setName(contactForm.getName());
//        contact.setAge(contactForm.getAge());
//
//        Contact updatedContact = contactService.save(contact);
//        return ResponseEntity.ok(updatedContact);
//    }
//
//    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Contact> deleteContact(@PathVariable(value = "id") Long id) {
//        Contact contact = contactService.getOne(id);
//        if (contact == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        contactService.delete(contact);
//        return ResponseEntity.ok().build();
//    }
}
