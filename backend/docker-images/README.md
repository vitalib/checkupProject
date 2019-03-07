<h2>Python</h2> 
<i>из py_container</i>
<br/>
<p>docker build --tag=py_image . </p>
<p>docker run --rm -v "$(pwd)"/py_data:/app/data py_image</p>

<h2>Java</h2> 
<i>из java_container</i>
<br/>
<p>docker build --tag=java_image .</p>
<p>docker run --rm -v "$(pwd)"/java_data:/app/data java_image</p>

<h2>Js</h2> 
<i>из js_container</i>
<br/>
<p>docker build --tag=js_image . </p>
<p>docker run --rm -v "$(pwd)"/js_data:/app/data js_image</p>

<hr/>

<h2>Проверка кода заверщения</h2> 
<br/>
<p><b>echo $?</b></p>
<p>либо</p>
<p>docker inspect <i>container_id</i> --format='{{.State.ExitCode}}'</p>
  
<hr/>

<h2>Exit Codes</h2> 
<br/>
<p>0 - Успех</p>
<p>3 - Неправильный ответ (результат кода не совпадает с out.txt)</p>
<p>4 - Непримонтированы данные для проверки (code.* не найден)</p>
<p>5 - Build error (java)</p>
<p>6 - Runtime error</p>
<p>7 - Превышен лимит по времени</p>
<p>8 - Превышен лимит по памяти</p>




