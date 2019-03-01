--------------PYTHON-------------------- из py_container

docker build --tag=py_image .

docker run -v "$(pwd)"/py_data:/app/data py_image


--------------JAVA---------------------- из java_container

docker build --tag=java_image .

docker run -v "$(pwd)"/java_data:/app/data java_image

---------------------Проверка кода заверщения---------------

echo $?

либо

docker inspect <container_id> --format='{{.State.ExitCode}}'


---------------------Exit Codes----------------------

0 - Успех
3 - Непримонтирован образ (code.* не найден)
4 - Неправильный ответ (результат кода не совпадает с out.txt)
