<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Планн | Просмотр задачи</title>
        <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" type="image/x-icon">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="theme-color" content="#FF8F00">
    </head>
    <body style="background-color:#ebebeb;" >
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <h2>${task.title}</h2>
                    <div class="taskbody">${task.body}</div>
                    <h6>Подзадачи <span class="badge rounded-pill text-bg-dark">2/3</span></h6>
                    <!-- Subtasks -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDisabled" disabled>
                        <label class="form-check-label" for="flexCheckDisabled">
                            Подзадача не выполненая
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckCheckedDisabled" checked disabled>
                        <label class="form-check-label" for="flexCheckCheckedDisabled">
                            Подзадача выполненая
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckCheckedDisabled" checked disabled>
                        <label class="form-check-label" for="flexCheckCheckedDisabled">
                            Вторая подзадача выполненая
                        </label>
                    </div>
                    <!-- End Subtasks -->
                    <h5>Обсуждение:</h5>
                </div>
                <div class="col-sm-3">
                    <h2>Привет</h2>
                    <p>Параграф</p>
                </div>
                <!-- Начало треда-->
                <div class="row">
                    <div class="col-sm-9" style="background-color: #ebebeb;">
                        <div class="card-comment">
                            <div class="card-body-comment">
                                <span class="badge rounded-pill text-bg-dark">@Разработчик</span><h5 class="card-title-comment">Антон Деплоев</h5>
                                <p>Вопрос на повестку: Надо бы задеплоить все что не задеплоено.</p>
                                <p>Есть над чем задуматься: реплицированные с зарубежных источников, современные исследования объявлены нарушающими общечеловеческие нормы этики и морали. </p>
                                <button class="btn btn-dark position-relative" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Раскрыть тред<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">2</span>
                                </button>
                                <div class="accordion" id="accordionExample">
                                    <div class="accordion-item" style="background-color: inherit; border:none;">
                                        <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                            <div class="accordion-body">
                                                <div class="mb-3">
                                                    <label for="AddComment" class="form-label">Добавить комментарий</label>
                                                    <textarea class="form-control" id="AddComment" rows="3"></textarea>
                                                </div>
                                                <button class="btn btn-dark position-relative" type="button">Добавить</button>
                                                <!-- Начало комментария-->
                                                <div class="card-comment">
                                                    <div class="card-body-comment">
                                                        <span class="badge rounded-pill text-bg-dark">@Разработчик</span>
                                                        <h5 class="card-title-comment">Виктор Фронтендов:</h5>
                                                        <p>Это что за говно код!</p>
                                                        <p>Полная лажа источников, современные исследования объявлены нарушающими общечеловеческие нормы этики и морали. </p>
                                                    </div>
                                                </div>
                                                <!-- Конец комментария -->

                                                <!-- Начало комментария -->
                                                <div class="card-comment">
                                                    <div class="card-body-comment">
                                                        <span class="badge rounded-pill text-bg-dark">@Аналитик</span>
                                                        <h5 class="card-title-comment">Семен Полиморфизмович:</h5>
                                                        <p>Реально хрень, мы такое не согласовывали!</p>
                                                        <p>Полная лажа источников, современные исследования объявлены нарушающими общечеловеческие нормы этики и морали. </p>
                                                    </div>
                                                </div>
                                                <!-- Конец комментария -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Конец треда-->
                <!-- Начало треда-->
                <div class="row">
                    <div class="col-sm-9" style="background-color: #ebebeb;">
                        <div class="card-comment">
                            <div class="card-body-comment">
                                <span class="badge rounded-pill text-bg-dark">@Разработчик</span><h5 class="card-title-comment">Анастасия Гитхабовна</h5>
                                <p>Вопрос на повестку: Надо бы закоммитить все что не закоммичено.</p>
                                <p>Есть над чем задуматься: реплицированные с зарубежных источников, современные исследования объявлены нарушающими общечеловеческие нормы этики и морали. </p>
                                <button class="btn btn-dark position-relative" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                    Раскрыть тред<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">1</span>
                                </button>
                                <div class="accordion" id="accordionExample2">
                                    <div class="accordion-item" style="background-color: inherit; border:none;">
                                        <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample2">
                                            <div class="accordion-body">
                                                <div class="mb-3">
                                                    <label for="AddComment" class="form-label">Добавить комментарий</label>
                                                    <textarea class="form-control" id="AddComment" rows="3"></textarea>
                                                </div>
                                                <button class="btn btn-dark position-relative" type="button">Добавить</button>
                                                <!-- Начало комментария-->
                                                <div class="card-comment">
                                                    <div class="card-body-comment">
                                                        <span class="badge rounded-pill text-bg-dark">@Дизайнер</span>
                                                        <h5 class="card-title-comment">Сергей Инкапсуляпович:</h5>
                                                        <p>Это что за говно код!</p>
                                                        <p>Полная лажа источников, современные исследования объявлены нарушающими общечеловеческие нормы этики и морали. </p>
                                                    </div>
                                                </div>
                                                <!-- Конец комментария -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Конец треда-->
            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>