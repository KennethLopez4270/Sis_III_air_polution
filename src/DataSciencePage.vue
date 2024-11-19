<template>
<div class="data-science-page">
  <div class="content-wrapper">
    <h1 class="title">¿Qué es la Ciencia de Datos?</h1>
    <p class="description">
      La ciencia de datos es una disciplina que utiliza métodos científicos, algoritmos, procesos y sistemas para extraer conocimiento e ideas a partir de datos estructurados y no estructurados. Combina herramientas de matemáticas, estadísticas y programación para resolver problemas y generar conocimiento a partir de los datos.
    </p>



    

    <div class="upload-section">
      <h2>Sube tu archivo .xml</h2>
      <input type="file" class="file-input" @change="handleFileUpload" accept=".xml" />
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
display: flex;
justify-content: center;
align-items: center;
min-height: 100vh;
background: linear-gradient(135deg, #0075e1, #d9e7ff);
padding: 20px;
}

.content-wrapper {
max-width: 600px;
padding: 20px;
border-radius: 8px;
background-color: #ffffff;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
text-align: center;
}

.title {
font-size: 2rem;
color: #333;
margin-bottom: 16px;
}

.description {
font-size: 1rem;
color: #555;
line-height: 1.5;
margin-bottom: 24px;
}

.upload-section {
margin-top: 20px;
}

.file-input {
display: block;
margin: 0 auto;
padding: 10px;
border: 1px solid #ccc;
border-radius: 4px;
cursor: pointer;
font-size: 1rem;
}

.file-input:hover {
border-color: #888;
}

.upload-instructions {
font-size: 0.9rem;
color: #666;
margin-top: 8px;
}
</style>
