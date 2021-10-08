# Curvas_de_Bezier_Spline

Trazado de curvas usando Curvas de Bézier. Construya una aplicación en la que se
puedan marcar puntos con el ratón y se unan por múltiples curvas de Bézier de n = 4

para poder realizar el programa se utilizó la siguiente formula Bézier.
# (1-t)*P+t*Q

Donde t toma valores de 0 a 1.
Donde P y Q son puntos claves para poder llevar acabó la ejecución.

El método que se utilizo es recursivo, es decir para poder calcular P y Q cuando N es mayor a tres se tiene que aplicar la formula varias veces.

![image](https://user-images.githubusercontent.com/71307223/136616461-c9097f1f-cae1-4a9a-b731-aab3d9c10391.png)

# Resultados

En este caso nos pide marcar 4 puntos, por esta razón el programa funciona de la siguiente manera.

# Dos puntos
![image](https://user-images.githubusercontent.com/71307223/136616524-214fb969-6696-4ed9-a8af-637710bcc085.png)

# Tres puntos
![image](https://user-images.githubusercontent.com/71307223/136616549-e7889564-93bf-4914-858d-cd083a53699a.png)

# Cuatro puntos
![image](https://user-images.githubusercontent.com/71307223/136616586-e25351df-5532-4d8d-9f7c-a447441bb55c.png)
