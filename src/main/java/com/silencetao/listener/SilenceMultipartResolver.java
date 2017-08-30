package com.silencetao.listener;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class SilenceMultipartResolver extends CommonsMultipartResolver {

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        
        String sign = request.getParameter("sign");
        SilenceProgressListener progressListener = new SilenceProgressListener(request.getSession(), sign);
        fileUpload.setProgressListener(progressListener);
        
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        } catch (SizeLimitExceededException e) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), e);
        } catch (FileUploadException e) {
            throw new MultipartException("Could not parse multipart servlet request", e);
        }
    }
}
