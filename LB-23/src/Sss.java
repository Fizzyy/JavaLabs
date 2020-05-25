import helpers.FileHandler;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@WebServlet(name = "Sss", urlPatterns = "/Sss")
@MultipartConfig
public class Sss extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part partFile = request.getPart("file");
        var fileName = Paths.get(partFile.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = partFile.getInputStream();

        File file = new File(getServletContext().getInitParameter("doc-dir") + "/" + fileName);
        FileUtils.copyInputStreamToFile(fileContent, file);

        response.getWriter().write("File has been saved");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet:SSS");
        String dir = getServletContext().getInitParameter("doc-dir");
        System.out.println(dir);

        var fileName = request.getParameter("file");
        if (fileName != null && !fileName.isEmpty()) {
            var fileHandler = new FileHandler(dir);
            var foundFile = fileHandler.GetSelectedFile(fileName);

            if (foundFile != null) {
                response.setContentType("application/msword");
                response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setContentLength((int)foundFile.length());

                FileInputStream inputStream = new FileInputStream(foundFile);
                BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
                int readBytes = 0;
                while ((readBytes = bufferedStream.read()) != -1) {
                    response.getWriter().write(readBytes);
                }

            } else {
                response.getWriter().write("Unexpected error happened...");
            }
        }
    }
}
