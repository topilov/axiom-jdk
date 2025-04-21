package me.func.demo;

import me.func.demo.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = DemoController.class)
public class ByteArrayDoSTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldThrowException_whenByteArrayRequestBodyExceedsMaxLength() throws Exception {
        assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(post("/upload")
                            .header("Content-Length", Integer.MAX_VALUE)
                            .content(new byte[1])
                            .contentType("application/octet-stream"));
        });
    }
}
