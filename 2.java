letException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<Book> books = new ArrayList<>();
            books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
            books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
            books.add(new Book("1984", "George Orwell"));
            books.add(new Book("Pride and Prejudice", "Jane Austen"));
            books.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
            
            // Get the sorting type from the form
            String sortType = request.getParameter("sortType");
            
            // Sort books based on the selected criteria
            if (sortType.equals("title")) {
                Collections.sort(books, Comparator.comparing(Book::getTitle));
            } else if (sortType.equals("author")) {
                Collections.sort(books, Comparator.comparing(Book::getAuthor));
            }
            
            // Display sorted books
            out.println("<html><head><title>Sorted Books</title></head><body>");
            out.println("<h2>Sorted Books</h2>");
            out.println("<ul>");
            books.forEach((book) -> {
                out.println("<li>" + book.getTitle() + " by " + book.getAuthor() + "</li>");
            });
            out.println("</ul>");
            out.println("</body></html>");
        }
    }
}

class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
        
        
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
}
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() 
{
        return "Short description";
}
    // </editor-fold>
