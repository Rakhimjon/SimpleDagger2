package uz.showme.simpledagger2.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by root on 3/10/18.
 */

public class Heroes {

    @Expose
    private List<Hero> elements;

    public List<Hero> getElements() {
        return elements;
    }

    public void setElements(List<Hero> elements) {
        this.elements = elements;
    }
}
