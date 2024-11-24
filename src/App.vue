<template>
  <router-view />
</template>

<script>
export default {
  name: 'App',
};
</script>

<style>
/* Reinicio global para evitar desbordamientos */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box; /* Asegura que padding y bordes se incluyan en el ancho/alto */
}

body {
  margin: 0;
  padding: 0;
  min-height: 100vh;
  width: 100%; /* Asegura que ocupe todo el ancho */
  background-color: #242424; /* Fondo oscuro */
  font-family: Arial, sans-serif; /* Estilo de fuente general */
  overflow-x: hidden; /* Previene desbordamiento horizontal */
}

#app {
  margin: 0;
  padding: 0;
  width: 100%;
  min-height: 100vh; /* Ocupa toda la altura de la pantalla */
  display: flex;
  flex-direction: column; /* Asegura una disposición vertical */
}

/* Clase para el contenido principal */
.content {
  flex: 1;
  display: flex;
  justify-content: center; /* Centra horizontalmente */
  align-items: center; /* Centra verticalmente */
  width: 100%;
}

/* Botones, tarjetas u otros elementos */
button, img, .card {
  display: block;
  margin: 0 auto; /* Centrado automático */
  max-width: 100%; /* Asegura que no se desborde */
}

</style>
