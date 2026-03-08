package com.karimkhan.demo.service;

import com.karimkhan.demo.exception.ResourceNotFoundException;
import com.karimkhan.demo.model.MenuItem;
import com.karimkhan.demo.model.Restaurant;
import com.karimkhan.demo.repository.MenuItemRepository;
import com.karimkhan.demo.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItem addMenuItem(Long restaurantId, MenuItem menuItem) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        menuItem.setRestaurant(restaurant);
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getMenuByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));
    }
}