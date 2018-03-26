package ssm.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/10/27
 */
public class SaveFile extends AbstractCommon{
    public String save(HttpServletRequest request,String filePath)throws Exception{
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        ServletContext servletContext=request.getSession().getServletContext();
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null) {
                    filePath=filePath+file.getOriginalFilename();
                    file.transferTo(new File(filePath));
                }
            }
        }
        return filePath;
    }
}
