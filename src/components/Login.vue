<template>
  <div class="login-container">
    <div class="login-card">
      <h1 class="login-title">Iniciar Sesión</h1>
      <form @submit.prevent="handleLogin">
        <div class="input-group">
          <label for="email">Correo</label>
          <input
            type="email"
            id="email"
            v-model="email"
            placeholder="Introduce tu correo"
            required
          />
        </div>
        <div class="input-group">
          <label for="password">Contraseña</label>
          <div class="password-container">
            <input
              :type="showPassword ? 'text' : 'password'"
              id="password"
              v-model="password"
              placeholder="Introduce tu contraseña"
              required
            />
            <button
              type="button"
              class="toggle-password"
              @click="togglePasswordVisibility"
            >
              {{ showPassword ? "Ocultar" : "Mostrar" }}
            </button>
          </div>
        </div>
        <button type="submit" class="login-button">Ingresar</button>
      </form>
      <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      <div class="link-container">
        <p>¿No tienes cuenta? <a href="/auth/registro">Regístrate aquí</a></p>
        <p><a href="/">Volver al inicio</a></p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      email: "",
      password: "",
      showPassword: false,
      errorMessage: null,
    };
  },
  methods: {
    togglePasswordVisibility() {
      this.showPassword = !this.showPassword;
    },
    async handleLogin() {
      try {
        // Realizar la solicitud al endpoint de login
        const response = await axios.post("http://localhost:3002/login", {
          Correo: this.email,
          Contrasenia: this.password,
        });

        // Almacenar el token en el localStorage
        localStorage.setItem("authToken", response.data.token);

        // Redirigir al usuario o mostrar un mensaje de éxito
        alert("Inicio de sesión exitoso");
        this.$router.push("/weka/ciencia-datos"); // Ajusta la ruta según tu proyecto
      } catch (error) {
        // Manejar errores y mostrar mensajes al usuario
        if (error.response && error.response.data) {
          this.errorMessage = error.response.data.error;
        } else {
          this.errorMessage = "Error al conectar con el servidor";
        }
      }
    },
  },
};
</script>

<style scoped>
/* Estilo general */
.login-container {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background: linear-gradient(105deg, #680148, #7db4b5);
  font-family: "Arial", sans-serif;
  padding: 0 20px;
}

.login-card {
  background: white;
  padding: 3rem;
  border-radius: 10px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
  text-align: center;
  width: 100%;
  max-width: 500px;
}

.login-title {
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

input {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1rem;
  outline: none;
  transition: all 0.3s ease;
}

input:focus {
  border-color: #4facfe;
  box-shadow: 0 0 5px rgba(79, 172, 254, 0.5);
}

.password-container {
  position: relative;
}

.toggle-password {
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
  background: none;
  border: none;
  font-size: 0.9rem;
  color: #4facfe;
  cursor: pointer;
}

.toggle-password:hover {
  text-decoration: underline;
}

.login-button {
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

.login-button:hover {
  background: #3a8bdf;
}

.error-message {
  margin-top: 1rem;
  color: red;
  font-weight: bold;
}

.link-container {
  margin-top: 1.5rem;
  font-size: 0.9rem;
  color: #333;
}

.link-container a {
  color: #4facfe;
  text-decoration: none;
  font-weight: bold;
}

.link-container a:hover {
  text-decoration: underline;
}
</style>
