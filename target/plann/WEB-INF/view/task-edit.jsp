<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Планн • Редактирование задачи</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css" />" />
        <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://cdn.ckeditor.com/ckeditor5/18.0.0/classic/ckeditor.js"></script>
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="theme-color" content="#FF8F00">
    </head>
    <body style="background-color:#ebebeb;">
        <div class="container" style="background-color: #7556f3; color: #fff;">
            <a href="./" class="btn btn-default navbar-btn" role="button">Закрыть</a>
        </div>
        <div class="container" style="background-color:#fbfbfb; box-shadow: 0 2px 10px 0 rgba(0,0,0,.03), 0 2px 20px 10px rgba(0,0,0,.02); padding-bottom: 10px; padding-top: 10px;" ;>
            <form:form action="saveTask" modelAttribute="task">
            <form:hidden path="id"/>
            <div class="row">
                <div class="col-sm-10" style="padding-right: 0px; padding-left: 0px;">
                    <div class="form-row">
                        <div class="form-group col-md-12">
                        <label>Заголовок:</label>
                        <form:input path="title" type="text" class="form-control" placeholder="Заголовок задачи"/>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label>Описание:</label>
                        <form:textarea path="body" id="editor" placeholder="Описание задачи" rows="3" class="form-control" />
                    </div>
                </div>
            </div>
                <div class="col-sm-2" style="padding-left: 0px; padding-right: 0px;">
                    <div class="form-row">
                        <div class="form-group col-md-12" style="padding-left: 0px;">
                        <label for="datetimepickerStart">Старт задачи:</label>
                            <div class="input-group date" id="datetimepickerStart">
                                <span class="input-group-addon datepickerbutton">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                <form:input path="createdate" type="text" class="form-control"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-remove2"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group col-md-12" style="padding-left: 0px;">
                        <label for="datetimepickerEnd">Дата исполнения:</label>
                            <div class="input-group date" id="datetimepickerEnd">
                                <span class="input-group-addon datepickerbutton">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                <form:input path="plandate" type="text" class="form-control" />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-remove2"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group col-md-12" style="padding-left: 0px;">
                        <label for="datetimepickerUpdate">Обновлено:</label>
                            <div class="input-group date" id="datetimepickerUpdate">
                                <span class="input-group-addon datepickerbutton">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                <form:input path="updatedate" type="text" class="form-control"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-remove2"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group col-md-12" style="padding-left: 0px;">
                        <label for="datetimepickerClose">Дата закрытия:</label>
                            <div class="input-group date" id="datetimepickerClose">
                                <span class="input-group-addon datepickerbutton">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                <form:input path="closedate" type="text" class="form-control" />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-remove2" ></span>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <div class="form-group col-md-12" style="padding-left: 0px;">
                            <label>Исполнитель:</label>
                            <spring:select path="makerid" class="form-control">
                                <c:forEach var="userList" items="${allUsers}">
                                    <spring:option value="${userList.id}">${userList.fio}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </div>
                    </div>
                        <div class="form-group">
                            <div class="form-group col-md-12" style="padding-left: 0px;">
                                <label>Важность</label>
                                <spring:select path="important" class="form-control">
                                    <spring:option value="1">Срочно и важно</spring:option>
                                    <spring:option value="2">Срочно и не важно</spring:option>
                                    <spring:option value="3">Не срочно но важно</spring:option>
                                    <spring:option value="4">Не срочно и не важно</spring:option>
                                </spring:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group col-md-12" style="padding-left: 0px;">
                                <label>Раздел:</label>
                                <spring:select path="tagId" class="form-control">
                                    <c:forEach var="taskTag" items="${allTaskTags}">
                                        <spring:option value="${taskTag.id}">${taskTag.tagName}</spring:option>
                                    </c:forEach>
                                </spring:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group col-md-12" style="padding-left: 0px;">
                                <label>Статус:</label>
                                <spring:select path="status" class="form-control">
                                    <c:forEach var="taskStatus" items="${allTaskStatus}">
                                        <spring:option value="${taskStatus.id}">${taskStatus.statusname}</spring:option>
                                    </c:forEach>
                                </spring:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group col-md-12" style="padding-left: 0px;">
                                <label>Родительская задача:</label>
                                <spring:select path="parentTask" class="form-control">
                                    <spring:option value="0">Не выбрано</spring:option>
                                    <c:forEach var="task" items="${allTask}">
                                        <spring:option value="${task.id}">${task.title}</spring:option>
                                    </c:forEach>
                                </spring:select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-warning" style="background-color: #7556f3; border-color: #bdadff; color: #fff;">Сохранить</button>
            </form:form>
        </div>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/moment-with-locales.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
        <script type="text/javascript">
    $(function () {
        $('#datetimepickerStart').datetimepicker({
            locale: 'ru',
            stepping:10,
            format: 'YYYY-MM-DD',
            defaultDate: moment(),
            daysOfWeekDisabled:[0,6]
        });

        $('#datetimepickerEnd').datetimepicker({
            locale: 'ru',
            stepping:10,
            format: 'YYYY-MM-DD',
            defaultDate: moment(),
            daysOfWeekDisabled:[0,6]
        });
        $('#datetimepickerUpdate').datetimepicker({
            locale: 'ru',
            stepping:10,
            format: 'YYYY-MM-DD',
            defaultDate: moment(),
            daysOfWeekDisabled:[0,6]
        });
        $('#datetimepickerClose').datetimepicker({
            locale: 'ru',
            stepping:10,
            format: 'YYYY-MM-DD',
            defaultDate: moment(),
            daysOfWeekDisabled:[0,6]
        });
    });

    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .catch( error => {
        console.error( error );
    } );
</script>
    </body>
</html>