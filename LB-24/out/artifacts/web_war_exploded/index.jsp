<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
      <form action="WebDav" method="post">
            <input type="hidden" name="type" value="create-folder" />
            <label>Folder name: <input type="text" name="folderName"/></label>
            <button type="submit">Create Folder</button>
      </form>

      <form action="WebDav" method="post">
          <input type="hidden" name="type" value="delete-folder" />
          <label>Folder name: <input type="text" name="folderName"/></label>
          <button type="submit">Remove Folder</button>
      </form>

      <form action="WebDav" method="post" enctype="multipart/form-data">
          <input type="hidden" name="type" value="create-file" />
          <label>File name: <input type="file" name="file"/></label>
          <button type="submit">Add file</button>
      </form>

      <form action="WebDav" method="post" enctype="multipart/form-data">
          <input type="hidden" name="type" value="download-file" />
          <label>File name: <input type="text" name="file"/></label>
          <button type="submit">Download file</button>
      </form>

      <form action="WebDav" method="post">
          <input type="hidden" name="type" value="delete-file" />
          <label>File name: <input type="text" name="file"/></label>
          <button type="submit">Delete file</button>
      </form>

      <form action="WebDav" method="post">
          <input type="hidden" name="type" value="copy-file" />
          <label>File name: <input type="text" name="file"/></label>
          <label>Origin: <input type="text" name="orig"/></label>
          <label>Destination: <input type="text" name="dest"/></label>
          <button type="submit">Copy file</button>
      </form>
  </body>
</html>