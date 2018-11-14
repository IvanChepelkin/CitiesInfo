package com.example.user.citiesinfo;

public interface ItemTouchHelperAdapter {

// вызывается, когда начинаем перетаскивать эл-т
    void onItemMove(int fromPosition, int toPosition);

// вызывваем метод, когда идёт смахивание эл-та
    void onItemDismiss(int position);
}
