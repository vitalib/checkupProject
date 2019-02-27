--------------PYTHON-----------------------

docker build --tag=py_image .

docker run -v "$(pwd)"/py_data:/app py_image


--------------JAVA-----------------------

docker build --tag=java_image .

docker run -v "$(pwd)"/java_data:/app java_image

---------------------Проверка кода заверщения---------------

echo $?

либо

docker inspect <container_id> --format='{{.State.ExitCode}}'


---------------------Exit Codes----------------------

0 - Успех
3 - Непримонтирован образ (code.* не найден)
4 - Неправильный ответ (результат кода не совпадает с out.txt)
