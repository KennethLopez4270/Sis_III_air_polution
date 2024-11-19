<template>
  <div class="data-science-page">
    <div class="content-wrapper">
      <h1 class="title">¿Qué es la Ciencia de Datos?</h1>
      <p class="description">
        La ciencia de datos es un campo interdisciplinario que se encarga de extraer conocimiento y obtener información a partir de grandes conjuntos de datos. Se apoya en diversas disciplinas, como la estadística, la programación, el análisis de datos y el aprendizaje automático, para identificar patrones, realizar predicciones y tomar decisiones basadas en datos. En un mundo impulsado por la información, la ciencia de datos desempeña un papel fundamental en la solución de problemas complejos y en la creación de soluciones innovadoras que mejoran la vida de las personas y optimizan procesos.
      </p>
      <p class="description">
        En términos prácticos, la ciencia de datos abarca todo el proceso de trabajar con datos, desde la recolección y limpieza de los datos hasta el análisis y visualización. Los científicos de datos utilizan una combinación de técnicas y herramientas para comprender y resolver problemas. Entre estas herramientas destacan los lenguajes de programación como Python y R, bibliotecas especializadas, plataformas de computación en la nube, y técnicas de modelado estadístico.
      </p>
      <p class="description">
        Algunos ejemplos de aplicaciones de la ciencia de datos incluyen la predicción del comportamiento del cliente en el marketing, el análisis de grandes volúmenes de datos médicos para diagnosticar enfermedades, el desarrollo de sistemas de recomendación como los que utilizan plataformas de streaming, y la optimización de procesos empresariales mediante modelos predictivos. Todo esto hace de la ciencia de datos una disciplina clave en la era de la información.
      </p>

      <!-- Sección para subir el archivo -->
      <div class="upload-section">
        <h2>Sube tu archivo .csv</h2>
        <label for="file-upload" class="upload-btn">Selecciona un archivo</label>
        <input 
          type="file" 
          id="file-upload" 
          class="file-input" 
          @change="handleFileUpload" 
          accept=".csv" 
          hidden
        />
        <p class="upload-instructions">Selecciona un archivo con extensión .xml y súbelo para continuar.</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DataSciencePage",
  data() {
    return {
      file: null
    };
  },
  methods: {
    handleFileUpload(event) {
      this.file = event.target.files[0];
      if (this.file && this.file.name.endsWith(".xml")) {
        alert(`Archivo ${this.file.name} subido exitosamente.`);
        this.$router.push('/weka-connection'); 
      } else {
        alert("Por favor, sube un archivo con extensión .xml.");
      }
    }
  }
};
</script>

<style scoped>
.data-science-page {
  padding: 2rem;
  color: #fff;
  background-color: #0075e1;
  text-align: left;
}

.content-wrapper {
  max-width: 800px;
  margin: 0 auto;
  background: rgba(0, 117, 225, 0.8);
  padding: 1.5rem;
  border-radius: 10px;
}

.title {
  font-size: 2rem;
  margin-bottom: 1rem;
}

.description {
  margin-bottom: 1rem;
  font-size: 1.1rem;
  line-height: 1.6;
}

.upload-section {
  margin-top: 2rem;
}

.upload-btn {
  display: inline-block;
  background-color: #000; 
  color: #fff; 
  padding: 10px 20px;
  border-radius: 5px;
  font-size: 1.1rem;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.3s ease;
}

.upload-btn:hover {
  background-color: #333; 
  transform: translateY(-2px);
}

.upload-btn:active {
  transform: translateY(0);
}

.file-input {
  display: none; 
}

.upload-instructions {
  margin-top: 0.5rem;
  font-size: 0.9rem;
  color: #d9e7ff;
}
</style>
