package com.roma.kai.model.request;

import com.google.gson.annotations.SerializedName;

public class SelectHabitRequest {
    @SerializedName("habito_catalogo_id")
    private String habitoCatalogoId;

    public SelectHabitRequest(String habitoCatalogoId) {
        this.habitoCatalogoId = habitoCatalogoId;
    }

    public String getHabitoCatalogoId() {
        return habitoCatalogoId;
    }

    public void setHabitoCatalogoId(String habitoCatalogoId) {
        this.habitoCatalogoId = habitoCatalogoId;
    }
}
