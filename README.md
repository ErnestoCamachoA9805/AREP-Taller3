# AREP-Taller3
> ## Autor:
>> Ernesto Camacho Arroyave
> ## Requisitos :
>> - Java 1.8
>> - Maven 
>
> ## Desarrollo 
>> Usando POJOS se hizo la declaracion de 2 anotaciones @RequestMapping y @Component junto con esto a partir del directorio en donde se hace inicio de la aplicacion se recojen los los directorios y archivos dentro de esta para identificar cuales de ellos con componentes para el servidor web, luego de esto se idenfica que funciones dentro de esta pueden ser tomadas como solicitudes, estos request pueden ser usados con la url localhost:35000/do/[mapping]
>> 
>> Sin embargo el servidor cae tan pronto llega un reguest de un servicio que no identifica.
>>
>> Para correr en la maquina local basta usar el comando:
>>> - mvn exec:java -D"exec.mainClass"="edu.escuelaing.Taller.WebApp" 

