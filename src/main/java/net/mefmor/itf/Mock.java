package net.mefmor.itf;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Mock {
    @NotNull
    @Size(min=3, message="Name must be at least 5 characters long")
    private String name;
}
