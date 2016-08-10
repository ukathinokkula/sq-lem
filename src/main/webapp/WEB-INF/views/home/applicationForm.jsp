<%@ include file="/WEB-INF/views/includes/tags-utility.jsp"%>
<html>
<head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header-utility.jsp"%>
<!-- PAGE TITLE -->
    <div class="top-title-area">
        <div class="container">
            <h1 class="title-page">Fill out Application</h1>
        </div>
    </div>
    <!-- END PAGE TITLE -->
    
	<%@ include file="/WEB-INF/views/includes/searchPage.jsp"%>
	<!-- END SEARCH AREA -->
    
  
  <div class="gap"></div>
 
 <!-- POST A JOB --> 
 <div class="container">
 <form:form  class="appnitro" >
        <div class="row">
       
        <div class="span3 sidebar-left">
                <h4>Logo / Brand</h4>
                    <img src="#"  id="imagepreview"/>
                    
                <div class="gap gap-small"></div>	
                 <input type="file" name="file" id="imgInp" />
                   <div class="gap gap-small"></div>	
                <div class="gap gap-small"></div>
        </div>
      		 <div class="span5">
               
                  <ul >
                  <label class="description" for="element_1"> <spring:message code="label.listings.NameYourJob" /> </label>
             	   <input type="text" name="name"  class="element text medium"/>
             	   <form:errors path="name" class="error"/>
             	   </li>
              	   <label class="description" for="element_1"><spring:message code="label.listings.DescribeYourJob" /> </label>
              	 
              	  <input type="text" name="description"  class="element text medium"> 
              	   <form:errors path="description" class="error"/>
              	   </li>
              	   <input type="submit" value="Submit" class="btn btn-primary"/>
              	   </ul>
                 </div>
                </div>
     </form:form>
</div>
</body>
</html>
