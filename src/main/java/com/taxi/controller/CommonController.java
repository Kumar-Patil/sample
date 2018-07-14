package com.taxi.controller;

import static com.taxi.controller.LoginController.LOG;
import com.taxi.domain.Countries;
import com.taxi.domain.OrderCategory;
import com.taxi.domain.OrderType;
import com.taxi.exception.FileNotFoundException;
import com.taxi.service.AccessTokenService;
import com.taxi.service.CabsService;
import com.taxi.service.CitiesService;
import com.taxi.service.CountriesService;
import com.taxi.service.OrderCategoryService;
import com.taxi.service.OrderTypeService;
import com.taxi.service.StateService;
import com.taxi.service.UserService;
import com.taxi.service.VendorsService;
import com.taxi.to.City;
import com.taxi.to.Response;
import com.taxi.to.State;
import com.taxi.to.VendorsTo;
import com.taxi.to.fileUpload;
import com.taxi.util.Constants;
import com.taxi.to.Status;
import com.taxi.util.Config;
import com.taxi.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/common")
@Api(value = "common")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class CommonController {

    @Autowired
    StateService stateService;

    @Autowired
    UserService userServices;

    @Autowired
    CountriesService countriesService;

    @Autowired
    CitiesService citiesService;

    @Autowired
    AccessTokenService accessTokenService;

    private static final String APPLICATION_PDF = "application/pdf";

    @Autowired
    OrderTypeService orderTypeService;

    @Autowired
    OrderCategoryService orderCategoryService;

    @Autowired
    VendorsService vendorsService;

    @Autowired
    CabsService cabsService;

    @ApiOperation(value = "Country List", notes = "Country List", response = Countries.class)
    @RequestMapping(value = "/countryList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> countryList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(countriesService.list(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "stateList List", notes = "stateList List", response = State.class)
    @RequestMapping(value = "/stateList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> stateList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(stateService.list(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "cityList List", notes = "cityList List", response = City.class)
    @RequestMapping(value = "/cityList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cityList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(citiesService.list(), HttpStatus.OK);

        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "roleList List", notes = "roleList List")
    @RequestMapping(value = "/roleList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> roleList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(Constants.roles(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> uploadFileHandler(@RequestParam("userId") long userId, @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "images");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String fileName = System.currentTimeMillis() + name;
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
                return new ResponseEntity<>(new fileUpload(fileName), HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>("You failed to upload " + name + " => " + e.getMessage(), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("You failed to upload " + name
                    + " because the file was empty.", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public @ResponseBody
    HttpEntity<byte[]> downloadB(@QueryParam("userId") long userId, @RequestParam("name") String name) throws IOException, FileNotFoundException {
        File file = getFile(name);
        byte[] document = FileCopyUtils.copyToByteArray(file);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
        header.set("Content-Disposition", "inline; filename=" + file.getName());
        header.setContentLength(document.length);
        return new HttpEntity<>(document, header);
    }

    private File getFile(String name) throws FileNotFoundException {
        String rootPath = System.getProperty("catalina.home");
        File file = new File(rootPath + File.separator + "images/" + name);
        if (!file.exists()) {
            throw new FileNotFoundException("file with path: " + file.getName() + " was not found.");
        }
        return file;
    }

    @ApiOperation(value = "orderTypes List", notes = "orderTypes List", response = OrderType.class)
    @RequestMapping(value = "/orderTypes", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> orderTypes(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(orderTypeService.list(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "orderCategory List", notes = "orderCategory List", response = OrderCategory.class)
    @RequestMapping(value = "/orderCategory", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> orderCategory(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(orderCategoryService.list(), HttpStatus.OK);

        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/fileHandler", method = RequestMethod.POST)
    public ResponseEntity<?> fileHandler(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Config config = new Config();
                String rootPath = config.getProperty("IMAGE_PATH");
                File dir = new File(rootPath + File.separator + "images");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);
                try (BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
                return new ResponseEntity<>(new fileUpload(fileName), HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>("You failed to upload " + "" + " => " + e.getMessage(), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("You failed to upload " + file.getOriginalFilename()
                    + " because the file was empty.", HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Get pop data", notes = "Get pop data", response = City.class)
    @RequestMapping(value = "/popData", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> allList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            Map m = new HashMap<Object, Object>();
            m.put("cityList", citiesService.list());
            m.put("statesList", stateService.list());
            m.put("countryList", countriesService.list());
            m.put("cabList", cabsService.list());
            m.put("statusList", Util.getStatusList());
            return new ResponseEntity<>(m, HttpStatus.OK);

        } catch (Exception e) {
            LOG.error("Exception occured in popData {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Vendor List", notes = "Vendor List", response = VendorsTo.class)
    @RequestMapping(value = "/vendorList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> vendorList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(vendorsService.list(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Exception occured in vendorList {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Get status List", notes = "Get status List", response = Status.class)
    @RequestMapping(value = "/statusList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> statusList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            List<Status> statusList = new ArrayList<>();
            statusList.add(new Status(1, "Active"));
            statusList.add(new Status(2, "InActive"));
            return new ResponseEntity<>(statusList, HttpStatus.OK);

        } catch (Exception e) {
            LOG.error("Exception occured in statusList {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
