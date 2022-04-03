package dev.saariselka.inlol.dto;

import java.util.List;

public class PerkStyleDto {
    private String description;
    private List<PerkStyleSelectionDto> selections;
    private int style;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PerkStyleSelectionDto> getSelections() {
        return selections;
    }

    public void setSelections(List<PerkStyleSelectionDto> selections) {
        this.selections = selections;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
