package com.rabbit.sender.rabbitmq.sender.rest

import com.rabbit.sender.rabbitmq.sender.rest.dto.SignInRequest
import com.rabbit.sender.rabbitmq.sender.rest.dto.SignUpRequest
import com.rabbit.sender.rabbitmq.sender.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserRest(
    private val userService: UserService
) {

    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody request: SignInRequest
    ): ResponseEntity<*> {
        userService.signIn(request)

        return ResponseEntity.ok("Success")
    }

    @PostMapping("/sign-up")
    fun signUp(
        @RequestBody request: SignUpRequest
    ): ResponseEntity<*> {
        userService.signUp(request)

        return ResponseEntity.ok("Success")
    }

}