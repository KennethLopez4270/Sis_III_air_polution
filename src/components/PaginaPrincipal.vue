<template>
  <div class="pagina-contaminacion">
   <!-- Encabezado con título y barra -->
   <header class="encabezado">
     <div class="barra-superior"></div>
     <div class="contenido-encabezado">
       <div class="seccion-texto">
         <h1 class="animacion-deslizar">Contaminación del Aire</h1>
         <p class="animacion-desvanecer">"Comprendiendo y abordando la amenaza invisible"</p>
       </div>
       <div class="seccion-imagen">
         <img src="../assets/air.jpg" alt="Contaminación del Aire" />
       </div>
     </div>
     <div class="barra-inferior"></div>
   </header>

   <!-- Contenido principal -->
   <main>
     <section class="info-section">
 <h2 class="section-title">Información clave sobre la contaminación del aire</h2>
<div class="info-block">
 <div class="info-text">
   <h3 class="info-title">Causas principales</h3>
   <p>
     La contaminación del aire es principalmente causada por actividades humanas, como la quema de combustibles fósiles, el tráfico vehicular y la agricultura intensiva. Estas actividades liberan gases y partículas tóxicas que afectan el aire que respiramos.
   </p>
 </div>
 <div class="image-container">
   <img src="../assets/clim.jpg" alt="Causas de la contaminación" />
 </div>
</div>

<div class="divider"></div>

<div class="info-block reverse">
 <div class="image-container"> <img src="../assets/tos.jpg" alt="Impactos en la salud" /></div>

 <div class="info-text">
   <h3 class="info-title">Impactos en la salud</h3>
   <p>
     La exposición prolongada al aire contaminado puede causar enfermedades respiratorias, cardiovasculares e incluso neurológicas. Niños, ancianos y personas con condiciones preexistentes son los más vulnerables.
   </p>
 </div>
</div>

<div class="divider"></div>

<div class="info-block">
 <div class="info-text">
   <h3 class="info-title">Efectos ambientales</h3>
   <p>
     La contaminación del aire contribuye al cambio climático, la lluvia ácida y la destrucción de la capa de ozono, afectando ecosistemas, biodiversidad y la salud del planeta en general.
   </p>
 </div>
 <div class="image-container">
  <img src="../assets/city.jpg" alt="Efectos en el medio ambiente" /> 
 </div>
</div>

<div class="divider"></div>

<div class="info-block reverse">
 <div class="image-container"> <img src="../assets/ni.jpg" alt="Soluciones" /></div>
 
 <div class="info-text">
   <h3 class="info-title">Soluciones posibles</h3>
   <p>
     Reducir la contaminación del aire requiere acciones como usar transporte sostenible, energías renovables y políticas estrictas de control de emisiones. La educación es clave para crear conciencia y motivar el cambio.
   </p>
 </div>
</div>

</section>



     <!-- Sección de videos y archivos -->
     <section class="media-section">
 <h2>Videos & Resources</h2>
 <div class="media-columns">
   <div class="media">
     <iframe
 src="https://www.youtube.com/embed/aQeIL6SXpn4"
 frameborder="0"
 allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
 allowfullscreen
 title="What is air pollution?"
></iframe>

     <p>Que es la contaminacion del aire?</p>
   </div>
   <div class="media">
     <iframe
       src="https://www.youtube.com/embed/Fwcce8F32L8"
       frameborder="0"
       allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
       allowfullscreen
       title="Global efforts to combat pollution"
     ></iframe>
     <p>Esfuerzos mundiales para combatir la contaminación.</p>
   </div>
   <div class="media">
     <iframe
       src="https://www.youtube.com/embed/gKHP0YD8ZXQ"
       frameborder="0"
       allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
       allowfullscreen
       title="Impact of air pollution on ecosystems"
     ></iframe>
     <p>El impacto de la contaminacion al cuerpo humano</p>
   </div>
   <div class="media">
 <a href="https://www.esginnova.com/sostenibilidad/soluciones-innovadoras-para-reducir-la-contaminacion/" target="_blank">
   <img src=".. /assets/tex.jpg" alt="Vista previa de soluciones innovadoras para un aire más limpio" />
 </a>
 <p>Soluciones innovadoras para un aire más limpio.</p>
</div>

 </div>
</section>

   </main>
   <footer class="registro-inicio">
     <p>¿Eres nuevo? Regístrate o inicia sesión para acceder a más contenido.</p>
     <button @click="irARegistro" class="boton-accion">Regístrate/Inicia Sesión</button>
   </footer>
 </div>
 
</template>

<script>
export default {
 name: "AirPollutionInfo",
 mounted() {
   const infoBlocks = document.querySelectorAll(".info-block");
   infoBlocks.forEach((block, index) => {
     if (index % 2 !== 0) {
       block.classList.add("reverse"); // Agrega la clase a los bloques en posiciones impares
     }
   });

   const observer = new IntersectionObserver(
     (entries) => {
       entries.forEach((entry) => {
         if (entry.isIntersecting) {
           entry.target.classList.add("visible");
         }
       });
     },
     { threshold: 0.2 }
   );

   infoBlocks.forEach((block) => observer.observe(block));
 },
 methods: { // Aquí ahora está dentro del componente correctamente
   irARegistro() {
     this.$router.push("/registro");
   },
 },
};
</script>


<style scoped>
/* Importar fuentes */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&family=Playfair+Display:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Kodchasan:wght@400;700&family=Gruppo&family=Raleway:wght@400;700&display=swap');
/* General Styling */
body {
 margin: 0;
 font-family: 'Poppins', sans-serif;
 color: #000000;
 background-color: #e0eff1;
}

/* Encabezado */
.encabezado {
 position: relative;
 text-align: left;
 overflow: hidden;
}

.barra-superior,
.barra-inferior {
 height: 25px;
 background: linear-gradient(to right, #7db4b5, #e0eff1);
 z-index: 10;
 position: relative;
}

.contenido-encabezado {
 display: flex;
 justify-content: space-between;
 align-items: center;
 position: relative;
 z-index: 5;
}

.seccion-texto h1 {
 font-size: 4rem;
 font-family: 'Kodchasan', sans-serif;
 color: #680148;
 animation: slide-in 1.5s ease-out;
}

.seccion-texto p {
 font-size: 1.5rem;
 color: #4e8586;
 font-family: 'Poppins', sans-serif;
 animation: fade-in 2s ease-in;
 margin-left: 60px;
}

.seccion-imagen {
 position: relative;
 width: 70%;
 height: 500px;
 overflow: hidden;
}

.seccion-imagen img {
 width: 100%;
 height: 100%;
 object-fit: cover;
 margin: 0;
 padding: 0;
}

.seccion-imagen::after {
 content: "";
 position: absolute;
 top: 0;
 left: 0;
 width: 100%;
 height: 100%;
 background: linear-gradient(to right, rgba(255, 255, 255, 1), rgba(255, 255, 255, 0));
 z-index: 2;
 pointer-events: none;
}

/* Animaciones */
@keyframes fade-in {
 from {
   opacity: 0;
 }
 to {
   opacity: 1;
 }
}

@keyframes slide-in {
 from {
   transform: translateX(-50px);
   opacity: 0;
 }
 to {
   transform: translateX(0);
   opacity: 1;
 }
}

/* Sección de Información */
.seccion-informacion {
 display: flex;
 justify-content: space-around;
 margin: 40px 0;
 padding: 0 20px;
}

.informacion img {
 max-width: 100%;
 height: auto;
}

.informacion p {
 font-size: 1rem;
 color: #000000;
}

/* Registro/Inicio de sesión */
.registro-inicio {
 top: 50%;
 left: 50%;
 transform: translate(40%, -10%);
 max-width: 50%;
 height: auto;
 background-color: #87005c;
 color: #ffffff;
 text-align: center;
 padding: 20px 0;
 font-family: 'Kodchasan', sans-serif;
 font-weight: 500;
 margin: 50px;
 border-radius: 8px;
}

.boton-accion {
 background-color: #98d8d9;
 color: #000000;
 align-items: center;
 font-family: 'Kodchasan', sans-serif;
 padding: 10px 20px;
 border: none;
 border-radius: 5px;
 cursor: pointer;
 font-size: 1rem;
 transition: transform 0.3s ease;
}

.boton-accion:hover {
 transform: scale(1.1);
 background-color: #7db4b5;
}
/* Media Section */
.media-section {
 background-color: #ffffff;
 padding: 20px;
 border-radius: 10px;
 box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.media-section h2 {
 text-align: center;
 color: #680148;
 margin-bottom: 20px;
 font-family: 'Kodchasan', sans-serif;
 font-size: 2vw;
}

.media-columns {
 display: grid;
 grid-template-columns: repeat(4, 1fr);
 gap: 20px;
}

.media {
 text-align: center;
}

.media iframe {
 width: 100%;
 height: 200px;
 border: none;
}

.media p {
 margin-top: 10px;
 font-family: 'Poppins', sans-serif;
 color: #000000;
}
.info-section {
 padding: 30px;
 background-color: #edfcfe;
 border-radius: 10px;
 box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.section-title {
 text-align: center;
 font-family: 'Kodchasan', sans-serif;
 font-weight: 500;
 font-size: 2.5rem;
 color: #680148;
 margin-bottom: 20px;
}

.info-block {
 display: flex;
 align-items: center;
 margin-bottom: 30px;
 opacity: 0;
 transform: translateY(20px);
 transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}
.info-block.visible {
 opacity: 1;
 transform: translateY(0);
}
.info-block.reverse {
 flex-direction: row-reverse; /* Invierte el orden de los elementos */
}


.info-block img {
 width: 40%;
 height: auto;
 object-fit: cover;
 box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2), 0 4px 6px rgba(0, 0, 0, 0.15); /* Sombra suave */
 transition: transform 0.3s ease, box-shadow 0.3s ease; /* Animación al pasar el mouse */
}

.info-text {
 width: 55%;
 padding: 0 20px;
 font-family: 'Poppins', sans-serif;
}

.info-title {
 font-size: 1.5rem;
 color: #508b8c;
 font-family: 'Kodchasan', sans-serif;
 margin-bottom: 10px;
 line-height: 1.5;
 font-weight: 400;
}

.info-text p {
 font-size: 1rem;
 color: #000000;
 line-height: 1.6;
 margin-left: 50px;
 margin-right: 50px;
}

.divider {
 width: 80%;
 height: 2px;
 background: linear-gradient(to right, #7db4b5, #680148);
 margin: 20px auto;
 border-radius: 1px;
}
.info-block:nth-child(odd) {
 flex-direction: row;
}

.info-block:nth-child(even) {
 flex-direction: row-reverse;
}
.image-container {
 flex: 1; /* Ajusta el contenedor a una proporción relativa */
 display: flex;
 justify-content: center;
 align-items: center;
 overflow: hidden;
 max-width: 40%; /* Limita el ancho del contenedor */
 height: 300px; /* Define una altura fija para uniformidad */
}

.image-container img {
 width: 100%; /* Escala la imagen al 100% del ancho del contenedor */
 height: 100%; /* Escala la imagen al 100% de la altura del contenedor */
 object-fit: cover; /* Asegura que la imagen se recorte para llenar el contenedor */
 box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2), 0 4px 6px rgba(0, 0, 0, 0.15); /* Sombra suave */
 transition: transform 0.3s ease, box-shadow 0.3s ease; /* Animación al pasar el mouse */
 
}

.image-container img:hover {
 transform: scale(1.05); /* Efecto de zoom suave */
 box-shadow: 0 12px 20px rgba(0, 0, 0, 0.3), 0 6px 10px rgba(0, 0, 0, 0.25); /* Sombra más intensa */
}


</style>