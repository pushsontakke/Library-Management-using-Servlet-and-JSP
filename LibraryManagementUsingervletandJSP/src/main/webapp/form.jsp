<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Library Management | Servlet &amp; JSP</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>
  <style>
    button{
        width: 30%;
        margin: 0 35%;
    }
  </style>
  <body>
    <div class="container">
      <h2 class="text-center">Book Details</h2>
      <form action="book-add" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label"
            >Enter your book name:</label
          >
          <input
            type="text"
            name="book-name"
            placeholder="Book Name"
            class="form-control"
            id="book-name"
            required
          />
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label"
            >Enter your book's author name:</label
          >
          <input
            type="text"
            name="author-name"
            placeholder="Enter Book Author Name"
            class="form-control"
            id="author-name"
            required
          />
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label"
            >Enter book's ISBN number (if available)</label
          >
          <input
            type="text"
            name="isbn"
            placeholder="ISBN Number"
            class="form-control"
            id="isbn"
          />
        </div>
        <button type="submit" class="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  </body>
</html>
