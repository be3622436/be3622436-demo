package com.example.kracedemo.controller.api.v1;

import com.example.kracedemo.entity.Response;
import com.example.kracedemo.entity.mysql.User;
import com.example.kracedemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public User findById(@Parameter(description = "id of user to be searched") @PathVariable long id) {
        return userService.findById(id);
    }

    @Operation(summary = "Deleted a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public Response delete(@Parameter(description = "id of user to be Deleted") @PathVariable long id) {
        userService.delete(id);
        String message = String.format("user id='%d' was deleted", id);
        return new Response(200, message);
    }

    @ResponseBody
    @PostMapping("/generateRandomUsers/{count}")
    public Response generateRandomUsers(@PathVariable long count) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String randUsername = UUID.randomUUID().toString().replace("-", "");
            String randPassword = UUID.randomUUID().toString().replace("-", "");
            User user = new User(randUsername, randPassword);
            userList.add(user);
        }
        userService.insertUserList(userList);
        return new Response(200, "generateRandomUsers success");
    }
}
