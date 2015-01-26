package com.restui;

import java.io.File;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

// this is a trunk copy. thanks

@Path("/university")
public class UniversityRESTWS {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLUniversityInfo() {
		return "<html>" + "<head>" + "<title>Insert title here</title>"
				+ "</head>" + "<body>" + " This is my University" + "</body>"
				+ "</html>";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainUniversityInfo() {
		return "Hi, responce from getPlainUniversityInfo: Plain/text";
	}

	@GET
	@Path("{studentRollNo1}/{studentRollNo2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMultiRollNo(
			@PathParam("studentRollNo1") String studentRollNo1,
			@PathParam("studentRollNo2") String studentRollNo2) {
		return "Use of path param for two parameter : " + studentRollNo1
				+ " And " + studentRollNo2;
	}

	// Request:
	// http://localhost:8080/restexample1/rest/university/queryparam?studentRollNo1=2323&studentRollNo2=454545
	@GET
	@Path("queryparam")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMultiRollNoQueryParam(
			@QueryParam("studentRollNo1") String studentRollNo1,
			@QueryParam("studentRollNo2") String studentRollNo2) {
		return "Use of query param for two parameter : " + studentRollNo1
				+ " And " + studentRollNo2;
	}

	// Request:
	// http://localhost:8080/restexample1/rest/university/matrixparam;studentRollNo1=111;studentRollNo2=222
	// http://localhost:8080/restexample1/rest/university/matrixparam/studentRollNo1=111;studentRollNo2=222
	@GET
	@Path("matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMultiRollNoMartrixParam(
			@MatrixParam("studentRollNo1") String studentRollNo1,
			@MatrixParam("studentRollNo2") String studentRollNo2) {
		return "Use of matrix param for two parameter : " + studentRollNo1
				+ " And " + studentRollNo2;
	}

	// Request: submit a form
	@POST
	@Path("/formparam")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMultiRollNoFormParam(
			@FormParam("studentName") String studentName,
			@FormParam("studentRollNo") String studentRollNo) {
		return "Use of form param for two parameter- student name : "
				+ studentName + " And Roll no: " + studentRollNo;
	}
	
	// Request: http://localhost:8080/restexample1/rest/university/getmyfile
		@GET
		@Path("/getmyfile")
		@Produces(MediaType.TEXT_PLAIN)
		public Response getFile() {
			File myfile = new File("E:\\java_concepts\\java_concepts\\webservice\\rest\\restexample1\\src\\main\\webapp\\demofile");
			ResponseBuilder res = Response.ok(myfile);
			//note: if do not set content then file just display on browser and not download.
			res.header("Content-Disposition", "attachment; filename=demo.txt");
			return res.build();
		}

	@POST
	@Path("rollno/{studentRollNumber}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentRollNumber(
			@PathParam("studentRollNumber") String studentRollNumber) {
		return "Student Roll Number Updated for : " + studentRollNumber;
	}
}
