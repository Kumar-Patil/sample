package com.taxi.controller;

import com.taxi.RequestMapper.OnlineUserPushData;
import com.taxi.domain.User;
import com.taxi.domain.UserOnline;
import com.taxi.service.UserOnlineService;
import com.taxi.to.Response;
import com.taxi.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author santopat
 */
@Controller
@RequestMapping("/useronline")
@Api(value = "useronline")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class UserOnlineController {
    
    @Autowired
    UserOnlineService userOnlineService;
    
    @ApiOperation(value = "Push user online data", response = Response.class)
    @RequestMapping(value = "/push", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestParam("userId") long userId, @RequestBody OnlineUserPushData onlineUserPushData) {
        Response response = null;
        try {
            UserOnline online = new UserOnline();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

            User user = new User();
            user.setId(userId);
            online.setUser(user);
            online.setSource(onlineUserPushData.getSource());
            online.setDestination(onlineUserPushData.getDestination());
            //online.setUserOnlineId(userId);
            online.setCreatedAt(currentTimestamp);
            online.setUpdatedAt(currentTimestamp);
            online.setDestinationLat(onlineUserPushData.getDestinationLat());
            online.setDestinationLng(onlineUserPushData.getDestinationLng());
            online.setSourceLat(onlineUserPushData.getSourceLat());
            online.setSourceLng(onlineUserPushData.getSourceLng());
            online.setIsOnline(onlineUserPushData.getIsOnline());
            boolean isAdded = userOnlineService.update(online);
            if (isAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
