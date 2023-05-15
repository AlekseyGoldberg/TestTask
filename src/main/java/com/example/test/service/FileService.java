package com.example.test.service;

import com.example.test.config.AppConfig;
import com.example.test.dto.RequestDto;
import com.example.test.exception.FileExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;

@Service
@AllArgsConstructor
public class FileService {
    private AppConfig config;
    private ConcurrentSkipListSet<Long> uniqId;

    public void saveFile(RequestDto dto) {
        try {
            if (uniqId.contains(dto.getId()))
                throw new FileExistException("File with this id = " + dto.getId() + " exist");
            uniqId.add(dto.getId());
            FileOutputStream fos = new FileOutputStream(getNameFile(dto));
            fos.write(dto.getContent());
            fos.flush();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String getNameFile(RequestDto dto) {
        return String.format("%s%s%s", config.getPath(), dto.getId(), ".txt");
    }
}
