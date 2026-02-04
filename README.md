# Servlet Assignments

Simple Java Servlet project implementing two assignments:

- Assignment 1: Login Servlet
  - `login.html` contains a form (username + password) which POSTs to `/login`.
  - `LoginServlet` checks password length: if less than 8 characters it responds `Hello <username>, your password is weak. Try a strong one.` otherwise `Welcome <username>`.

- Assignment 2: Send Redirect
  - `redirect.html` contains an input and a `Fetch` button which POSTs to `/redirect`.
  - `RedirectServlet` redirects to Google search using the input value: `https://www.google.com/search?q=<encoded>`.

Run locally with the Jetty plugin (Maven):

```powershell
# From the project root
mvn jetty:run
```

Open http://localhost:8080/ in your browser and test the pages.

Notes:
- Requires Java 11+ and Maven.
- The project uses servlet annotations; no `web.xml` needed.
