package com.cinemas.trailers.services;

import com.cinemas.trailers.exceptions.AlmacenExeption;
import com.cinemas.trailers.exceptions.FileNotFoundException;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AlmacenServicesImpl implements AlmacenServices {

    @Value("${storage.location}")
    private String storageLocation;

    @PostConstruct //indica que el metodo se ejecuta cada vez que haya una nueva instancia de la clase
    @Override
    public void iniciarAlmacenDeArchivos() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        }catch (IOException exception) {
            throw  new AlmacenExeption("Error al incializar la ubicacion en el almacen de archivos");

        }
    }

    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        if (archivo.isEmpty()) {
           throw new AlmacenExeption("No se puede almacenar un archivo vacio");
        }
        try {
            InputStream inputStream = archivo.getInputStream();
            Files.copy(inputStream, Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException exception) {
            throw new AlmacenExeption("Error almacenar archivo" + nombreArchivo,exception);
        }
        return nombreArchivo;
    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return Paths.get(storageLocation).resolve(nombreArchivo);
    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo) {
        try {
                Path archivo = cargarArchivo(nombreArchivo);
                Resource recurso = new UrlResource(archivo.toUri());

                if (recurso.exists() || recurso.isReadable()){
                    return recurso;
                }else {
                    throw new FileNotFoundException("No se pudo encontrar el archivo" + archivo);
                }
        }catch (MalformedURLException exception){
            throw  new FileNotFoundException("No se pudo encontrar el archivo" + nombreArchivo,exception);
        }

    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {

        Path archivo = cargarArchivo(nombreArchivo);

        try {

            FileSystemUtils.deleteRecursively(archivo);
        }catch (Exception exception){
            System.out.println(exception.getMessage());

        }
    }
}
