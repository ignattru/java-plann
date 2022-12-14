<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Планн | Список задач</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
    <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" type="image/x-icon">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.6.2"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js" integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J" crossorigin="anonymous"></script>
    <meta name="viewport" charset="utf-8" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="theme-color" content="#FF8F00">
</head>
<body style="background-color:#ebebeb;" >
<nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: #7556f3">
    <a class="navbar-brand" href="/">
        <img src="<c:url value="/resources/img/logo.svg" />" width="65" height="45" class="d-inline-block align-top" alt="">
    </a>
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">{Название компании}</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Настройки</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Редактор</a>
                    <a class="dropdown-item" href="#">Мета данные</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Инструкции</a>
                </div>
            </li>
            <li class="nav-item">
                <input type="button" class="nav-link btn btn-sm btn-outline-warning" value="Создать задачу" onclick="window.location.href = 'addNewTask' "/>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text" style="border: none; background-color: #957cf7;"><img src="<c:url value="/resources/img/search.svg" />"></div>
                </div>
                <input type="search" class="form-control" style="background-color: #d5caff; border: 1px solid #c1b1ff;" id="searchInput" placeholder="Поиск по задачам" aria-label="Search">
            </div>
        </form>
    </div>
</nav>
<div class="container-fluid" style="background-color: #7556f3; height: 19em;  padding-top: 5em;">
    <div class="card mb-3" style="max-width: 540px; border: none;">
        <div class="row no-gutters" style="background-color: #7556f3;clip-path: none;">
            <div class="col-md-4">
                <img src="<c:url value="/resources/img/logo.svg" />" style="height: 70%; width: 100%;"
                      class="card-img" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">Plann</h5>
                    <p class="card-text">Open-source трекер задач построенный на принципах матрицы Эйзенхауэра. С любовью к модульному пространству</p>
                    <p class="card-text"><small>Документация</small></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-9">
            <section class="tabs">
                <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="1-tab" data-toggle="tab" href="#a" role="tab" aria-controls="a" aria-selected="true" >Срочное и важное</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="2-tab" data-toggle="tab" href="#b" role="tab" aria-controls="b" aria-selected="false">Срочное и не важное</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="3-tab" data-toggle="tab" href="#c" role="tab" aria-controls="c" aria-selected="false">Не срочное но важное</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="4-tab" data-toggle="tab" href="#d" role="tab" aria-controls="d" aria-selected="false">Не срочное и не важное</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="a" role="tabpanel" aria-labelledby="1-tab">&nbsp;
                        <div class="container-fluid">
                            <div class="table-responsive">
                                <table class="table table-hover table-md" id="tasktable">
                                    <thead class="thead-light">
                                    <tr>
                                        <th> </th>
                                        <th>№</th>
                                        <th>Задача</th>
                                        <th>Создано</th>
                                        <th>Дедлайн</th>
                                        <th>Исполнитель</th>
                                        <th>Статус</th>
                                        <th>Удалить</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tasktable">
                                    <c:forEach var="task" items="${allTaskTab1}">
                                        <c:url var="updateButton" value="/updateInfo">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <c:url var="deleteButton" value="/deleteTask">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <tr>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${updateButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/edit.svg" />) #e9ecef no-repeat center;" /></a></td>
                                            <td>${task.id}</td>
                                            <td><span class="badge" style="font-size: 10px; background-color: #cbbdff;">@${task.taskTag.tagName}</span><br><a href="#" onClick="window.location.href = '${updateButton}'">${task.title}</a><br><span class="badge" style="font-size: 10px; background-color: #cbbdff;">2/5</span></td>
                                            <td width="110">${task.createdate}</td>
                                            <td width="110">${task.plandate}</td>
                                            <td width="110"><a href="#">${task.taskUser.fio}</a></td>
                                            <td width="110"><a href="#">${task.taskStatus.statusname}</a></td>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${deleteButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/delete.svg" />) #e9ecef no-repeat center;" /></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="b" role="tabpanel" aria-labelledby="2-tab">&nbsp;
                        <div class="container-fluid">
                            <div class="table-responsive">
                                <table class="table table-hover table-md" id="tasktable">
                                    <thead class="thead-light">
                                        <tr>
                                            <th> </th>
                                            <th>№</th>
                                            <th>Задача</th>
                                            <th>Создано</th>
                                            <th>Дедлайн</th>
                                            <th>Исполнитель</th>
                                            <th>Статус</th>
                                            <th>Удалить</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tasktable">
                                    <c:forEach var="task" items="${allTaskTab2}">
                                        <c:url var="updateButton" value="/updateInfo">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <c:url var="deleteButton" value="/deleteTask">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <tr>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${updateButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/edit.svg" />) #e9ecef no-repeat center;" /></a></td>
                                            <td>${task.id}</td>
                                            <td><span class="badge" style="font-size: 10px; background-color: #cbbdff;">@${task.taskTag.tagName}</span><br><a href="#" onClick="window.location.href = '${updateButton}'">${task.title}</a><br><span class="badge" style="font-size: 10px; background-color: #cbbdff;">2/5</span></td>
                                            <td width="110">${task.createdate}</td>
                                            <td width="110">${task.plandate}</td>
                                            <td width="110"><a href="#">${task.taskUser.fio}</a></td>
                                            <td width="110"><a href="#">${task.taskStatus.statusname}</a></td>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${deleteButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/delete.svg" />) #e9ecef no-repeat center;" /></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="c" role="tabpanel" aria-labelledby="3-tab">&nbsp;
                        <div class="container-fluid">
                            <div class="table-responsive">
                                <table class="table table-hover table-md" id="tasktable">
                                    <thead class="thead-light">
                                    <tr>
                                        <th> </th>
                                        <th>№</th>
                                        <th>Задача</th>
                                        <th>Создано</th>
                                        <th>Дедлайн</th>
                                        <th>Исполнитель</th>
                                        <th>Статус</th>
                                        <th>Удалить</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tasktable">
                                    <c:forEach var="task" items="${allTaskTab3}">
                                        <c:url var="updateButton" value="/updateInfo">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <c:url var="deleteButton" value="/deleteTask">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <tr>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${updateButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/edit.svg" />) #e9ecef no-repeat center;" /></a></td>
                                            <td>${task.id}</td>
                                            <td><span class="badge" style="font-size: 10px; background-color: #cbbdff;">@${task.taskTag.tagName}</span><br><a href="#" onClick="window.location.href = '${updateButton}'">${task.title}</a><br><span class="badge" style="font-size: 10px; background-color: #cbbdff;">2/5</span></td>
                                            <td width="110">${task.createdate}</td>
                                            <td width="110">${task.plandate}</td>
                                            <td width="110"><a href="#">${task.taskUser.fio}</a></td>
                                            <td width="110"><a href="#">${task.taskStatus.statusname}</a></td>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${deleteButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/delete.svg" />) #e9ecef no-repeat center;" /></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="d" role="tabpanel" aria-labelledby="4-tab">&nbsp;
                        <div class="container-fluid">
                            <div class="table-responsive">
                                <table class="table table-hover table-md" id="tasktable">
                                    <thead class="thead-light">
                                    <tr>
                                        <th> </th>
                                        <th>№</th>
                                        <th>Задача</th>
                                        <th>Создано</th>
                                        <th>Дедлайн</th>
                                        <th>Исполнитель</th>
                                        <th>Статус</th>
                                        <th>Удалить</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tasktable">
                                    <c:forEach var="task" items="${allTaskTab4}">
                                        <c:url var="updateButton" value="/updateInfo">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <c:url var="deleteButton" value="/deleteTask">
                                            <c:param name="taskId" value="${task.id}" />
                                        </c:url>
                                        <tr>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${updateButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/edit.svg" />) #e9ecef no-repeat center;" /></a></td>
                                            <td>${task.id}</td>
                                            <td><span class="badge" style="font-size: 10px; background-color: #cbbdff;">@${task.taskTag.tagName}</span><br><a href="#" onClick="window.location.href = '${updateButton}'">${task.title}</a><br><span class="badge" style="font-size: 10px; background-color: #cbbdff;">2/5</span></td>
                                            <td width="110">${task.createdate}</td>
                                            <td width="110">${task.plandate}</td>
                                            <td width="110"><a href="#">${task.taskUser.fio}</a></td>
                                            <td width="110"><a href="#">${task.taskStatus.statusname}</a></td>
                                            <td><a style="border-bottom: none;" href="#"><input type="button" onClick="window.location.href = '${deleteButton}'"  class="btn btn-warning btn-edit" style="background: url(<c:url value="/resources/img/delete.svg" />) #e9ecef no-repeat center;" /></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- Search -->
                                <script>
                                    $(document).ready(function(){
                                        $("#searchInput").on("keyup", function() {
                                            var value = $(this).val().toLowerCase();
                                            $("#tasktable tr").filter(function() {
                                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                            });
                                        });
                                    });
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <div class="col-sm-3">
            <h2>Объявление</h2>
            <p>Сегодня рабочий день до 15.00. Всех просим не задерживаться и закупиться подарками к субботе. Отдельная благодарность Дмитрию и Олегу за организацию праздника</p>
            <p>Не забудьте подготовить рабочие места к новому году, выключить приборы электропитания и закрыть шкафы</p>
            <hr />
            <p>Тут будет график созданных задач:</p>
            <canvas id="Chart1" ></canvas>
        </div>
    </div>

</body>
</html>