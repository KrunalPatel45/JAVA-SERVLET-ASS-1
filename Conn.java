
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(urlPatterns = {"/Conn"})
public class Conn extends HttpServlet {


    
   
   
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
          res.setContentType("text/html"); 
       PrintWriter out = res.getWriter(); 
        String nm = req.getParameter("fnm");
        String usnm = req.getParameter("unm");
        String pa = req.getParameter("pas");
        String adr = req.getParameter("ad");
        String qua = req.getParameter("qua");
        String py = req.getParameter("yp");
        
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
            String sql = "INSERT INTO reg values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,nm);
            st.setString(2, usnm);
            st.setString(3, pa);
            st.setString(4, adr);
            st.setString(5, qua);
            st.setString(6, py);
            int i=st.executeUpdate();  
            if(i>0)  
                out.print("You are successfully registered...");  
            

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }
    
    
}

