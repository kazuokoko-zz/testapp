package com.pt15305ud.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	File save(MultipartFile file, String folder);

}
