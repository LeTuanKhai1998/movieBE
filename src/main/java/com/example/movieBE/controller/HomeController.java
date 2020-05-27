package com.example.movieBE.controller;

import com.example.movieBE.controller.admin.CommentController;
import com.example.movieBE.controller.admin.CountryController;
import com.example.movieBE.controller.admin.GenreController;
import com.example.movieBE.controller.admin.MovieController;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.form.CommentForm;
import com.example.movieBE.form.CommentPostForm;
import com.example.movieBE.form.MovieByGenreForm;
import com.example.movieBE.form.SearchForm;
import com.example.movieBE.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/home")
class HomeController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     *
     */
    @Autowired
    HomeService homeService;

    @Autowired
    private MovieController movieController;

    @Autowired
    private GenreController genreController;

    @Autowired
    private CountryController countryController;

    @Autowired
    private CommentController commentController;

    /**
     * get Comment By MovieId
     *
     * @return
     */
    @RequestMapping(value = "/Search", method = RequestMethod.POST)
    public ResponseTemplate search(@RequestBody SearchForm form) {
        ResponseTemplate response = null;
        try {
            response = homeService.search(form);

        } catch (Exception e) {
            logger.error("search", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Comment By MovieId
     *
     * @return
     */
    @RequestMapping(value = "/PostComment", method = RequestMethod.POST)
    public ResponseTemplate postComment(@RequestBody CommentPostForm form) {
        return commentController.postComment(form);
    }

    /**
     * get Comment By MovieId
     *
     * @return
     */
    @RequestMapping(value = "/CommentByMovieId", method = RequestMethod.POST)
    public ResponseTemplate getCommentByMovieId(@RequestBody CommentForm form) {
        return commentController.getCommentByMovieId(form);
    }

    /**
     * get Movie by Genre slug
     *
     * @return
     */
    @RequestMapping(value = "/MovieByGenreSlug", method = RequestMethod.POST)
    public ResponseTemplate getMovieByGenreSlug(@RequestBody MovieByGenreForm form) {
        return movieController.getMovieByGenreSlug(form);
    }

    /**
     * get Movies
     *
     * @return
     */
    @RequestMapping(value = "/MostPopularMovie", method = RequestMethod.GET)
    public ResponseTemplate getMostPopularMovie(@RequestParam Integer number) {
        ResponseTemplate response = null;
        try {
            response = homeService.getMostPopularMovie(number, 6);

        } catch (Exception e) {
            logger.error("getMovie", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Movies
     *
     * @return
     */
    @RequestMapping(value = "/Movies", method = RequestMethod.GET)
    public ResponseTemplate getMovie(@RequestParam String type) {
        ResponseTemplate response = null;
        try {
            response = homeService.getMovie(type);

        } catch (Exception e) {
            logger.error("getMovie", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Movie by id
     *
     * @return
     */
    @RequestMapping(value = "/Movie", method = RequestMethod.GET)
    public ResponseTemplate getMovieById(@RequestParam Long id) {
        return movieController.getMovieById(id);
    }

    /**
     * get Movie by slug
     *
     * @return
     */
    @RequestMapping(value = "/MovieBySlug", method = RequestMethod.GET)
    public ResponseTemplate getMovieBySlug(@RequestParam String slug) {
        return movieController.getMovieBySlug(slug);
    }

    /**
     * get genre
     *
     * @return
     */
    @RequestMapping(value = "/Genres", method = RequestMethod.GET)
    public ResponseTemplate getGenres() {
        return genreController.getGenres();
    }

    /**
     * get country
     *
     * @return
     */
    @RequestMapping(value = "/Countrys", method = RequestMethod.GET)
    public ResponseTemplate getCountry() {
        return countryController.getCountryBanner();
    }

    /**
     * get country
     *
     * @return
     */
    @RequestMapping(value = "/Year", method = RequestMethod.GET)
    public ResponseTemplate getYear() {
        ResponseTemplate response = null;
        try {
            response = homeService.getYear();
        } catch (Exception e) {
            logger.error("getYear", e.getMessage());
            throw e;
        }
        return response;
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
