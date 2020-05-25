import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "WebDav", urlPatterns = "/WebDav")
@MultipartConfig
public class WebDav extends HttpServlet {
    private Sardine sardine;
    private String URL;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String login = getServletContext().getInitParameter("login");
        String pswd = getServletContext().getInitParameter("password");
        URL = getServletContext().getInitParameter("url");
        sardine = SardineFactory.begin(login, pswd);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var folderName = request.getParameter("folderName");
        var file = request.getParameter("file");
        var type = request.getParameter("type");

        switch (type) {
            case "create-folder":
                this.sardine.createDirectory(URL + "/" + folderName);
                response.getWriter().write("Folder " + folderName + " was created");
                break;
            case "delete-folder":
                this.sardine.delete(URL + "/" + folderName);
                response.getWriter().write("Folder " + folderName + " was removed");
                break;
            case "create-file":
                Part partFile = request.getPart("file");
                var fileFullName = Paths.get(partFile.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = partFile.getInputStream();
                this.sardine.put(URL + "/" + fileFullName, fileContent);
                response.getWriter().write("File " + fileFullName + " was added");
                break;
            case "delete-file":
                this.sardine.delete(URL + "/" + file);
                response.getWriter().write("File " + file + " was deleted");
                break;
            case "copy-file":
                var origin = request.getParameter("orig");
                var destination = request.getParameter("dest");
                this.sardine.copy(URL + "/" + origin + "/" + file, URL + "/" + destination + "/" + file);
                response.getWriter().write("File " + file  +" was copied");
                break;
            case "download-file":
                InputStream inputStream = sardine.get(URL + "/" + file);
                BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);

                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment; filename=" + file);
                //response.setContentLength(inputStream.readAllBytes().length);
                int readBytes = 0;
                while ((readBytes = bufferedStream.read()) != -1) {
                    response.getWriter().write(readBytes);
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
