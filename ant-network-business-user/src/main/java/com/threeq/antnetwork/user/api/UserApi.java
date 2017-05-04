package com.threeq.antnetwork.user.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.threeq.antnetwork.user.domain.model.User;
import com.threeq.antnetwork.user.domain.valueobject.UserVO;
import com.threeq.network.core.model.Entity;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Date 2017/4/22
 * @User three
 */
@RestController
@RequestMapping("/v1/user")
public class UserApi {

    protected Logger logger = Logger.getLogger(UserApi.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultUsers")
    public ResponseEntity<Collection<User>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("user-service findByName() invoked:{} for {} ", "userService", name));
        name = name.trim().toLowerCase();
        Collection<User> users;
        try {
            // TODO users = userService.findByName(name);
            users = new ArrayList<>();
            users.add(new User());
            users.add(new User());
            users.add(new User());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return users.size() > 0 ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Fetch users with the given id. <code>http://.../v1/users/{id}</code> will
     * return user with given id.
     *
     * @param id
     * @return A non-null, non-empty collection of users.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultUser")
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        logger.info(String.format("user-service findById() invoked:{} for {} ", "userService", id));
        id = id.trim();
        Entity user;
        try {
            // TODO user = userService.findById(id);
            user = new User();
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> add(@RequestBody UserVO userVO) {
        logger.info(String.format("user-service add() invoked: %s for %s", "userService", userVO.getName()));
        System.out.println(userVO);
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        try {
            // TODO userService.add(user);
            logger.info("添加服务");
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised add Booking REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    /**
     * Fallback method
     *
     * @param input
     * @return
     */
    public ResponseEntity<Entity> defaultUser(String input) {
        logger.warning("Fallback method for user-service is being used.");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Fallback method
     *
     * @param input
     * @return
     */
    public ResponseEntity<Collection<User>> defaultUsers(String input) {
        logger.warning("Fallback method for user-service is being used.");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
