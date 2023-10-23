package databaseFirst.controller;

import databaseFirst.usuario.UsuariosEntity;
import databaseFirst.usuario.UsuariosEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("entrar")
public class AuthController {

    @Autowired
    private UsuariosEntityRepository repository;

    @PostMapping
    public Map<String, String> signIn(@RequestBody Map<String, String> request) {
        String cpf = request.get("cpf");
        String senha = request.get("senha");
        UsuariosEntity usuario = repository.findByCpfAndSenha(cpf, senha);

        if (usuario != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("cpf", cpf);
            data.put("senha", senha);

            String token = generateToken(data);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        }

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Usuário ou senha incorreta");

        return errorResponse;
    }

    private String generateToken(Map<String, Object> data) {
        String secretKey = "YOUR_SECRET_KEY";
        long expiresIn = 100000;
        return "YOUR_JWT_TOKEN";
    }
}
