package template;

import org.junit.Test;
import ru.job4j.template.GeneratorR;
import ru.job4j.template.NameSubj;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TemplateTest {
    @Test
    public void templTest() {
        String temp = "I am ${name}, Who are ${subject}?";
        Map<String, Object> res = new HashMap<>();
        NameSubj o = new NameSubj("you");
        res.put("Dmitrii", o);
        assertThat(new GeneratorR().produce(temp, res), is("I am Dmitrii, Who are you"));
    }

    @Test(expected = NullPointerException.class)
    public void whenNotKey() {
        String temp = "I am ${name}, Who are ${subject}?";
        Map<String, Object> res = new HashMap<>();
        NameSubj o = new NameSubj("you");
        res.put(null, o);
        String result = new GeneratorR().produce(temp, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotTemp() {
        String temp = "I am , Who are ${subject}?";
        Map<String, Object> res = new HashMap<>();
        NameSubj o = new NameSubj("you");
        res.put("Dmitry", o);
        String result = new GeneratorR().produce(temp, res);
    }
}