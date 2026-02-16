import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deptName = request.getParameter("deptName");
        String countStr = request.getParameter("studentCount");
        String action = request.getParameter("action");

        int studentCount = 0;
        if (countStr != null && !countStr.trim().isEmpty()) {
            try {
                studentCount = Integer.parseInt(countStr.trim());
            } catch (NumberFormatException e) {
                studentCount = 0;
            }
        }

        ServiceClass service = new ServiceClass();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><style>");
        out.println("table { border-collapse: collapse; width: 60%; }");
        out.println("th, td { border: 1px solid #333; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style></head><body>");

        out.println("<h2>Action: " + action + "</h2>");

        switch (action) {

            case "Insert":
                if (service.insertDB(deptName, studentCount)) {
                    out.println("<p>Inserted successfully.</p>");
                } else {
                    out.println("<p>Insertion failed.</p>");
                }
                break;

            case "View":
                List<String> departments = service.viewDB();
                if (departments.isEmpty()) {
                    out.println("<p>No data found.</p>");
                } else {
                    out.println("<table>");
                    out.println("<tr><th>Department Name</th><th>Number of Students</th></tr>");

                    for (String row : departments) {
                        // Expect format: "Department: CSE, Students: 120"
                        String[] parts = row.split(", Students: ");
                        String dName = parts[0].replace("Department: ", "");
                        String dCount = parts.length > 1 ? parts[1] : "";

                        out.println("<tr><td>" + dName + "</td><td>" + dCount + "</td></tr>");
                    }
                    out.println("</table>");
                }
                break;

            case "Update":
                if (service.updateDB(deptName, studentCount)) {
                    out.println("<p>Updated successfully.</p>");
                } else {
                    out.println("<p>Update failed. Department not found?</p>");
                }
                break;

            case "Delete":
                if (service.deleteDB(deptName)) {
                    out.println("<p>Deleted successfully.</p>");
                } else {
                    out.println("<p>Delete failed. Department not found?</p>");
                }
                break;

            default:
                out.println("<p>Unknown action.</p>");
        }

        out.println("</body></html>");
    }
}
