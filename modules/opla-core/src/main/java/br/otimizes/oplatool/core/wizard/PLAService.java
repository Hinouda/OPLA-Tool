package br.otimizes.oplatool.core.wizard;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class PLAService {

    private final LeitorPLA leitorPLA = new LeitorPLA();

    public PLAInfo processarArquivo(MultipartFile file) {
        try {
            // Salva o arquivo temporariamente no servidor
            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);

            // Processa o arquivo com o LeitorPLA
            PLAInfo plaInfo = leitorPLA.processarArquivoEntrada(tempFile.getAbsolutePath());

            // Exclui o arquivo temporário
            tempFile.delete();

            return plaInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}