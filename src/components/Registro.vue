<template>
  <div class="register-container">
    <div class="register-card">
      <h1 class="register-title">Registro</h1>
      <form @submit.prevent="handleRegister">
        <div class="input-group">
          <label for="nombre">Nombre</label>
          <input
            type="text"
            id="nombre"
            v-model="nombre"
            placeholder="Nombre"
            required
          />
        </div>
        <div class="input-group">
          <label for="apellido">Apellido</label>
          <input
            type="text"
            id="apellido"
            v-model="apellido"
            placeholder="Apellido"
            required
          />
        </div>
        <div class="input-group">
          <label for="rol">Rol</label>
          <select id="rol" v-model="rol" required>
            <option value="" disabled>Selecciona</option>
            <option value="usuario">Usuario</option>
            <option value="admin">Administrador</option>
          </select>
        </div>
        <div class="input-group">
          <label for="username">Usuario</label>
          <input
            type="text"
            id="username"
            v-model="username"
            placeholder="Usuario"
            required
          />
        </div>
        <div class="input-group">
          <label for="correo">Correo</label>
          <input
            type="email"
            id="correo"
            v-model="correo"
            placeholder="Correo"
            required
          />
        </div>
        <div class="input-group">
          <label for="contrasenia">Contraseña</label>
          <input
            type="password"
            id="contrasenia"
            v-model="contrasenia"
            placeholder="Contraseña"
            required
          />
        </div>
        <button type="submit" class="register-button">Registrarse</button>
      </form>
      <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      <div v-if="successMessage" class="success-message">{{ successMessage }}</div>
      <div class="links">
        <a href="/" class="link">Inicio</a> | 
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
        const response = await axios.post("http://localhost:3002/registro", {
          Nombre: this.nombre,
          Apellido: this.apellido,
          Rol: this.rol,
          Username: this.username,
          Correo: this.correo,
          Contrasenia: this.contrasenia,
        });

        this.successMessage = "Usuario registrado exitosamente.";
        this.errorMessage = null;

        this.nombre = "";
        this.apellido = "";
        this.rol = "";
        this.username = "";
        this.correo = "";
        this.contrasenia = "";
      } catch (error) {
        this.errorMessage =
          error.response?.data?.error || "Error al conectar con el servidor.";
        this.successMessage = null;
      }
    },
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background: linear-gradient(105deg, #680148, #7db4b5);
  font-family: 'Arial', sans-serif;
  padding: 0 10px;
}

.register-card {
  background: white;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  text-align: center;
  width: 100%;
  max-width: 400px;
}

.register-title {
  margin-bottom: 1rem;
  font-size: 1.5rem;
  color: #333;
}

.input-group {
  margin-bottom: 1rem;
  text-align: left;
}

label {
  display: block;
  margin-bottom: 0.25rem;
  font-size: 0.9rem;
  font-weight: bold;
  color: #333;
}

input,
select {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 0.9rem;
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
  padding: 0.5rem;
  background: #4facfe;
  border: none;
  border-radius: 5px;
  color: white;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
}

.register-button:hover {
  background: #3a8bdf;
}

.error-message,
.success-message {
  margin-top: 1rem;
  font-size: 0.9rem;
  font-weight: bold;
}

.error-message {
  color: red;
}

.success-message {
  color: green;
}

.links {
  margin-top: 1rem;
}

.link {
  color: #4facfe;
  text-decoration: none;
  font-size: 0.9rem;
  font-weight: bold;
}

.link:hover {
  text-decoration: underline;
}
</style>
