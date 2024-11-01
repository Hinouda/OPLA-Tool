package br.otimizes.oplatool.core.wizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/pla")
@CrossOrigin(origins = "http://localhost:4200") // Ajuste o domínio conforme necessário
public class PLAController {

    @Autowired
    private PLAService plaService;

    @PostMapping("/upload")
    public PLAInfo uploadFile(@RequestParam("file") MultipartFile file) {
        return plaService.processarArquivo(file);
    }
}
