package com.karimkhan.demo.controller;

import com.karimkhan.demo.model.MenuItem;
import com.karimkhan.demo.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{restaurantId}/menu")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public MenuItem addMenuItem(@PathVariable Long restaurantId, @RequestBody MenuItem menuItem) {
        return menuItemService.addMenuItem(restaurantId, menuItem);
    }

    @GetMapping
    public List<MenuItem> getMenu(@PathVariable Long restaurantId) {
        return menuItemService.getMenuByRestaurant(restaurantId);
    }

    @GetMapping("/{menuItemId}")
    public MenuItem getMenuItem(@PathVariable Long restaurantId, @PathVariable Long menuItemId) {
        return menuItemService.getMenuItemById(menuItemId);
    }
}