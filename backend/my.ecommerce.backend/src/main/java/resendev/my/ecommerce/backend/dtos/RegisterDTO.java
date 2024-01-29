package resendev.my.ecommerce.backend.dtos;

public record RegisterDTO(
        Long id,
        String firstName,
        String lastName,
        String username,
        String email,
        String password,
        String passwordConfirm
) {
}
