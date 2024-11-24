<template>
    <div class="register-container">
      <div class="register-card">
        <h1 class="register-title">Registro de Usuario</h1>
        <form @submit.prevent="handleRegister">
          <div class="input-group">
            <label for="nombre">Nombre</label>
            <input
              type="text"
              id="nombre"
              v-model="nombre"
              placeholder="Introduce tu nombre"
              required
            />
          </div>
          <div class="input-group">
            <label for="apellido">Apellido</label>
            <input
              type="text"
              id="apellido"
              v-model="apellido"
              placeholder="Introduce tu apellido"
              required
            />
          </div>
          <div class="input-group">
            <label for="rol">Rol</label>
            <select id="rol" v-model="rol" required>
              <option value="" disabled>Selecciona un rol</option>
              <option value="usuario">Usuario</option>
              <option value="admin">Administrador</option>
            </select>
          </div>
          <div class="input-group">
            <label for="username">Nombre de Usuario</label>
            <input
              type="text"
              id="username"
              v-model="username"
              placeholder="Introduce un nombre de usuario"
              required
            />
          </div>
          <div class="input-group">
            <label for="correo">Correo</label>
            <input
              type="email"
              id="correo"
              v-model="correo"
              placeholder="Introduce tu correo"
              required
            />
          </div>
          <div class="input-group">
            <label for="contrasenia">Contraseña</label>
            <input
              type="password"
              id="contrasenia"
              v-model="contrasenia"
              placeholder="Introduce tu contraseña"
              required
            />
          </div>
          <button type="submit" class="register-button">Registrarse</button>
        </form>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
        <div v-if="successMessage" class="success-message">{{ successMessage }}</div>
        <div class="links">
          <a href="/" class="link">Volver al inicio</a> | 
          <router-link to="/auth/login" class="link">Iniciar Sesión</router-link>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    data() {
      return {
        nombre: "",
        apellido: "",
        rol: "",
        username: "",
        correo: "",
        contrasenia: "",
        errorMessage: null,
        successMessage: null,
      };
    },
    methods: {
      async handleRegister() {
        try {
          // Realizar la solicitud al endpoint de registro
          const response = await axios.post("http://localhost:3002/registro", {
            Nombre: this.nombre,
            Apellido: this.apellido,
            Rol: this.rol,
            Username: this.username,
            Correo: this.correo,
            Contrasenia: this.contrasenia,
          });
  
          // Mostrar mensaje de éxito
          this.successMessage = "Usuario registrado exitosamente.";
          this.errorMessage = null;
  
          // Limpiar los campos del formulario
          this.nombre = "";
          this.apellido = "";
          this.rol = "";
          this.username = "";
          this.correo = "";
          this.contrasenia = "";
        } catch (error) {
          // Manejar errores y mostrar mensajes al usuario
          if (error.response && error.response.data) {
            this.errorMessage = error.response.data.error;
          } else {
            this.errorMessage = "Error al conectar con el servidor.";
          }
          this.successMessage = null;
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Estilos similares al login */
  .register-container {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background: linear-gradient(105deg, #680148, #7db4b5);
    font-family: 'Arial', sans-serif;
    padding: 0 20px;
  }
  
  .register-card {
    background: white;
    padding: 3rem;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
    text-align: center;
    width: 100%;
    max-width: 500px;
  }
  
  .register-title {
    margin-bottom: 1.5rem;
    font-size: 1.8rem;
    color: #333;
  }
  
  .input-group {
    margin-bottom: 1.5rem;
    text-align: left;
  }
  
  label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: bold;
    color: #333;
  }
  
  input,
  select {
    width: 100%;
    padding: 0.75rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
    outline: none;
    transition: all 0.3s ease;
  }
  
  input:focus,
  select:focus {
    border-color: #4facfe;
    box-shadow: 0 0 5px rgba(79, 172, 254, 0.5);
  }
  
  .register-button {
    width: 100%;
    padding: 0.75rem;
    background: #4facfe;
    border: none;
    border-radius: 5px;
    color: white;
    font-size: 1.1rem;
    font-weight: bold;
    cursor: pointer;
    transition: all 0.3s ease;
  }
  
  .register-button:hover {
    background: #3a8bdf;
  }
  
  .error-message {
    margin-top: 1rem;
    color: red;
    font-weight: bold;
  }
  
  .success-message {
    margin-top: 1rem;
    color: green;
    font-weight: bold;
  }
  
  .links {
    margin-top: 1rem;
  }
  
  .link {
    color: #4facfe;
    text-decoration: none;
    font-weight: bold;
  }
  
  .link:hover {
    text-decoration: underline;
  }
  </style>
  