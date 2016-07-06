package controllers;

import models.BlogPost;
import models.Course;
import play.data.Form;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Date;
import java.util.List;

public class CourseController extends Controller {

    public Result list() {
        return ok(Json.toJson(Course.find.findList()));
    }


    public Result addCourse() {
        Form<CourseForm> courseForm = Form.form(CourseForm.class).bindFromRequest();

        if (courseForm.hasErrors()) {
            return badRequest(courseForm.errorsAsJson());
        } else {
            Date now = new Date();
            Course course = new Course();

            course.setCreatedAt(now);
            course.setUpdatedAt(now);
            course.setContent(courseForm.get().content);
            course.setParentId(courseForm.get().parentId);
            course.setTitle(courseForm.get().title);
            course.setType(courseForm.get().type);

            course.save();
        }
        return ok(ApplicationController.buildJsonResponse("success", "course added successfully"));
    }

    public static class CourseForm {

        @Constraints.Required
        @Constraints.MaxLength(2)
        public Integer type;

        public String title;

        public String content;

        public Integer parentId;

    }

}
