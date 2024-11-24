<template>

<header>
    <nav class="navbar">
      <div class="logo">Ataques Cibernéticos</div>
    </nav>
    <h1 class="main-title">Subir dataset para Analisis</h1>
  </header>

  <!-- Contenedor general que agrupa los contenedores secundarios -->
  <div class="container-column">
    <!-- Contenedor del texto explicativo -->
    <section class="project-info">
<h2>¿Que es ciencia de datos?</h2>
<p>
  La <strong>Ciencia de Datos</strong> se enfoca en analizar grandes volúmenes de datos para extraer conocimiento 
    útil y patrones significativos. Esto se logra mediante modelos matemáticos como <strong>clustering</strong>,
    <strong>árboles de decisión</strong> y <strong>redes neuronales</strong>.
</p>
<p>
  En términos simples, que realiza nuestro sistema:
</p>
<p><strong>Recolección de datos:</strong> Obtener información estructurada (tablas, bases de datos).</p>
<p><strong>Limpieza y procesamiento: </strong>Preparar los datos eliminando errores, inconsistencias o información innecesaria.</p>
<p><strong>Análisis y modelado:</strong> Aplicar algoritmos y modelos matemáticos para descubrir patrones y realizar predicciones.</p>
<p><strong>Comunicación de resultados: </strong>Presentar los hallazgos a través de gráficos, informes y dashboards que sean comprensibles para la toma de decisiones.</p>

<P>¿Que modelos matematicos podra usar en su archivo?: </P>
<div class="tools">
  <div class="tool">
    <span class="tool-name">Clustering</span>
    <p>Clustering es una técnica de aprendizaje no supervisado que agrupa datos en categorías o clústeres basados en sus similitudes. 
      Esto es útil para segmentar clientes, analizar patrones de comportamiento y más.</p>
  </div>
  <div class="tool">
    <span class="tool-name">Arboles de Decisiones</span>
    <p>Un Árbol de Decisión es un modelo predictivo que utiliza una estructura jerárquica de decisiones y resultados posibles. 
      Es ideal para problemas de clasificación y regresión.</p>
  </div>
  <div class="tool">
    <span class="tool-name">Redes Neuronales</span>
    <p>Las Redes Neuronales son sistemas inspirados en el cerebro humano que utilizan múltiples capas para aprender patrones complejos en los datos. 
      Son esenciales en tareas como reconocimiento de imágenes y lenguaje.</p>
  </div>
</div>

</section>

    <!-- Contenedor de los videos de YouTube -->
    <div class="videos-container">
      <h2 class="videos-title">Videos Relacionados</h2>
      <div class="videos-row">
        <!-- Video 1 -->
        <div class="video-item">
          <h3 class="video-label">Clustering</h3>
          <iframe
            class="video-frame"
            src="https://www.youtube.com/embed/z0LX3sBSuXg"
            title="Video 1"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </div>
        <!-- Video 2 -->
        <div class="video-item">
          <h3 class="video-label">Árbol de Decisiones</h3>
          <iframe
            class="video-frame"
            src="https://www.youtube.com/embed/SrIvX3aqXtA"
            title="Video 2"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </div>
        <!-- Video 3 -->
        <div class="video-item">
          <h3 class="video-label">Redes Neuronales</h3>
          <iframe
            class="video-frame"
            src="https://www.youtube.com/embed/M6oDiCQCins"
            title="Video 3"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </div>
      </div>
    </div>
    <!-- Contenedor para la subida de archivo -->
    <div class="upload-container">
      <div class="upload-form">
        <label for="file-input" class="form-label">Seleccionar archivo CSV:</label>
        <input
          id="file-input"
          type="file"
          @change="handleFileUpload"
          accept=".csv"
          class="file-input"
        />
        <button :disabled="!file" class="upload-button" @click="analyzeDataset">Analizar Dataset</button>
        <p v-if="file" class="file-name">Archivo seleccionado: {{ file.name }}</p>
      </div>
    </div>
    
  </div>
  <footer>
    <p>&copy; 2024 Sistema de Información sobre Ataques Cibernéticos. Todos los derechos reservados.</p>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      file: null, // Archivo cargado por el usuario
    };
  },
  methods: {
    handleFileUpload(event) {
      const uploadedFile = event.target.files[0];
      if (uploadedFile && uploadedFile.type === "text/csv") {
        this.file = uploadedFile;
      } else {
        alert("Por favor, sube un archivo CSV válido.");
        this.file = null;
      }
    },
    async analyzeDataset() {
      if (!this.file) {
        alert("Primero carga un archivo antes de analizar.");
        return;
      }

      try {
        const formData = new FormData();
        formData.append("file", this.file);

        const response = await fetch("http://localhost:8080/analyze", {
          method: "POST",
          body: formData,
        });

        if (!response.ok) throw new Error("Error en el análisis");

        const results = await response.json();
        console.log(results)

         // Almacenar resultados en localStorage
        localStorage.setItem("analysisResults", JSON.stringify(results));

        // Navegar sin pasar parámetros
        this.$router.push({ name: "results" });
        } catch (error) {
          console.error("Error al analizar el archivo:", error);
          alert("Hubo un problema al procesar el archivo.");
        }
    },
  },
};
</script>

<style scoped>
.file-upload {
  text-align: center;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.file-input {
  margin-bottom: 20px;
}

.results {
  margin-top: 30px;
  text-align: left;
}

section {
  margin-bottom: 20px;
}

.image-container {
  position: relative;
  max-width: 100%;
  margin: 20px auto;
  border: 1px solid #ccc;
  overflow: hidden;
}

.image-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  transition: transform 0.3s ease;
}

img {
  max-width: 100%;
  height: auto;
}

.zoom-controls {
  position: absolute;
  top: 10px;
  right: 10px;
  display: flex;
  gap: 5px;
}

.zoom-controls button {
  padding: 5px 10px;
  font-size: 14px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

.zoom-controls button:hover {
  background-color: #45a049;
}

h1,
h2,
h3 {
  color: #333;
}
body {
margin: 0;
font-family: 'Roboto', sans-serif;
background-color: var(white);
color: var(black);
}
.navbar {
display: flex;
justify-content: space-between;
align-items: center;
padding: 1rem 2rem;
background-color: var(--primary-color);
color: white;
box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
}
.file-upload {
text-align: center;
max-width: 900px;
margin: 0 auto;
padding: 20px;
}

.container-row {
display: flex;
flex-direction: column;
justify-content: space-between;
align-items: center;
gap: 20px;
}



.upload-container {
flex: 1;
 background-color: #a4b091;
}


.upload-form {
background-color: #a4b091;
padding: 24px;
border-radius: 5px;
box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}

.file-input {
margin-bottom: 9px;
font-size: 16px;
}

.upload-button {
padding: 7px 20px;
font-size: 16px;
background-color: #4CAF50;
color: white;
border: none;
border-radius: 4px;
cursor: pointer;
}

.upload-button:hover {
background-color: #45a049;
}

.file-name {
margin-top: 10px;
font-size: 14px;
color: #555;
}
.videos-container {
margin-top: 30px;
text-align: center;
}

.videos-title {
font-size: 20px;
margin-bottom: 20px;
color: #000000;
}

.videos-row {
display: flex;
justify-content: center;
gap: 20px; /* Espaciado entre los videos */
}

.video-item {
display: flex;
flex-direction: column;
align-items: center;
width: auto; /* Permite ajustar el tamaño según el iframe */
}

.video-label {
font-size: 16px;
margin-bottom: 10px;
color: #333;
text-align: center;
}

.video-frame {
width: 100%; /* Ajustar el ancho dinámicamente */
max-width: 560px; /* Tamaño máximo del video */
height: auto; /* Proporciones correctas */
border: none;
border-radius: 10px;
box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}


.text-container {
width: 95%; /* Reduce los márgenes laterales aumentando el ancho */
max-width: 1200px; /* Limita el ancho máximo */
margin: 0 auto; /* Centra el contenedor */
padding: 20px; /* Espaciado interno */
box-sizing: border-box; /* Asegura que el padding no afecte el ancho total */
}

.info-box {
background-color: #a4b091;
padding: 20px;
border-radius: 10px;
box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2); /* Agrega una sombra para destacar */
margin-bottom: 20px; /* Espaciado inferior para separarlo de otros contenedores */
}

.explanation-container {
display: flex;
flex-direction: row;
justify-content: space-between;
gap: 15px; /* Reduce el espacio entre los contenedores */
margin-top: 20px;
margin-bottom: 20px; /* Espaciado inferior para separación */
width: 95%; /* Ajusta el ancho para alinearlo con el texto */
max-width: 1200px; /* Limita el ancho máximo */
margin-left: auto; /* Centra horizontalmente */
margin-right: auto;
}

.explanation-item {
flex: 1;
background-color: #a4b091;
border: 1px solid #ccc;
border-radius: 10px;
padding: 15px;
text-align: left;
box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
margin-bottom: 20px; /* Espaciado inferior para separación */
}

.explanation-title {
font-size: 18px;
font-weight: bold;
color: #000000;
margin-bottom: 10px;
}

.explanation-text {
font-size: 14px;
color: #333;
line-height: 1.5;
}

.upload-container {
width: 95%; /* Ajusta el ancho para alinearlo con los otros contenedores */
max-width: 1200px; /* Limita el ancho máximo */
margin: 0 auto 20px auto; /* Centra y agrega espaciado inferior */
margin-top: 2rem;
}

.upload-form {
background-color:#a4b091;;
padding: 20px;
border-radius: 16px;
box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
text-align: center;
}
footer {
text-align: center;
padding: 1rem;
background-color: var(--primary-color);
color: white;
margin-top: 2rem;
}
</style>
