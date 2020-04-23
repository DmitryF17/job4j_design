package ru.job4j.template;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class TemplateTest {
    public TemplateTest() {
    }

    @Test
    public void templTest() {
        String temp = "I am ${name}, Who are ${subject}?";
        Map<String, Object> res = new HashMap();
        res.put("name", "Dmitrii");
        res.put("subject", "you");
        Assert.assertThat((new GeneratorR()).produce(temp, res), Is.is("I am Dmitrii, Who are you"));
    }

    @Test(
            expected = NoSuchElementException.class
    )
    public void whenNotKey() {
        String temp = "I am ${name}, Who are ${subject}?";
        Map<String, Object> res = new HashMap();
        res.put(null, "Oleg");
        (new GeneratorR()).produce(temp, res);
    }

    @Test(
            expected = IllegalArgumentException.class
    )
    public void whenNotTemp() {
        String temp = "I am , Who are ${subject}?";
        Map<String, Object> res = new HashMap();
        res.put("name", "Petr");
        res.put("subject", "you");
        (new GeneratorR()).produce(temp, res);
    }
}
